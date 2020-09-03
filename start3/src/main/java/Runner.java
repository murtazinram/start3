import by.epam.inner.beans.Trial;
import by.epam.inner.factory.TrialFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    //    src/main/resources/example.json
    public static void main(String[] args) {
//        1. Create the List implementation from a json file. Use Gson library to parse it and to identify trial
//        entities.
        try (FileReader reader = new FileReader(args[0])) {

            Type type = new TypeToken<List<JsonObject>>() {
            }.getType();
            //create
            List<Trial> trialList = getTrials(new Gson().fromJson(reader, type));
            ToIntFunction<Trial> sumOfMark1andMark2 = value -> value.getMark1() + value.getMark2();
//            2. Print the collection content (one element per line).
            trialList.forEach(LOGGER::info);

//            3. Print the number of passed trials
            printTheNumberOfPassedTrials(trialList);

//            4. Sort the collection by the sum of first and second marks.
            sortTheCollectionByTheSumOfFirstAndSecondMarks(trialList, sumOfMark1andMark2);

//            5. Print sums of first and second marks from the collection (one sum per line).
            printSumsOfFirstAndSecondMarksFromTheCollection(trialList, sumOfMark1andMark2);

//            6. Create a new collection from unpassed trials,
//            clear all marks and print this collection.
//            Check whether all trials are failed (the result type is boolean).
            List<Trial> unpassedTrials = createANewCollectionFromUnpassedTrials(trialList);
            checkWhetherAllTrialsAreFailed(unpassedTrials);
//            7. Create a numeric array from sums of first and second marks of sorted collection(see item 4) and print
//            it in the format: sum[0], sum[1], … , sum[sum.length - 1]
            createANumericArray(trialList, sumOfMark1andMark2);
        } catch (IOException e) {
            LOGGER.error("file not found or other exception", e);
        }
    }

    private static void printSumsOfFirstAndSecondMarksFromTheCollection(List<Trial> trialList, ToIntFunction<Trial> sumOfMark1andMark2) {
        trialList.forEach(trial -> LOGGER.info(sumOfMark1andMark2.applyAsInt(trial)));
    }

    private static void createANumericArray(List<Trial> trialList, ToIntFunction<Trial> sumOfMark1andMark2) {
        int[] numericArray = trialList.stream().mapToInt(sumOfMark1andMark2).toArray();
        LOGGER.info(Arrays.stream(numericArray).boxed().map(String::valueOf).
                collect(Collectors.joining(", ")));
    }

    private static void checkWhetherAllTrialsAreFailed(List<Trial> unpassedTrials) {
        LOGGER.info("Check whether all trials are failed: " + unpassedTrials.stream()
                .noneMatch(Trial::isPassed));
    }

    private static List<Trial> createANewCollectionFromUnpassedTrials(List<Trial> trialList) {
        return trialList.stream()
                .filter(trial -> !trial.isPassed())
                .map(Trial::getCopy)
                .peek(Trial::clearMarks)
                .peek(LOGGER::info)
                .collect(Collectors.toList());
    }

    private static void sortTheCollectionByTheSumOfFirstAndSecondMarks(List<Trial> trialList, ToIntFunction<Trial> sumOfMark1andMark2) {
        trialList.sort(Comparator.comparingInt(sumOfMark1andMark2));
    }

    private static void printTheNumberOfPassedTrials(List<Trial> trialList) {
        LOGGER.info(trialList.stream().filter(Trial::isPassed).count());
    }

    private static List<Trial> getTrials(List<JsonObject> jsonObjects) {
        return jsonObjects.stream()
                .map(TrialFactory::getTrial)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
