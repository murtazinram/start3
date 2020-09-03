package by.epam.inner.factory;

import by.epam.inner.beans.ExtraTrial;
import by.epam.inner.beans.LightTrial;
import by.epam.inner.beans.StrongTrial;
import by.epam.inner.beans.Trial;
import by.epam.inner.deserializer.TrialDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.Optional;

public class TrialFactory {
    private static final Logger LOGGER = Logger.getLogger(TrialFactory.class);
    private static final TrialDeserializer TRIAL_DESERIALIZER = new TrialDeserializer();
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Trial.class, TRIAL_DESERIALIZER)
            .registerTypeAdapter(LightTrial.class, TRIAL_DESERIALIZER)
            .registerTypeAdapter(StrongTrial.class, TRIAL_DESERIALIZER)
            .registerTypeAdapter(ExtraTrial.class, TRIAL_DESERIALIZER)
            .create();

    private TrialFactory() {
    }

    public static Optional<Trial> getTrial(JsonObject jsonObject) {
        try {
            String nameClass = jsonObject.get("class").getAsString();
            JsonObject args = jsonObject.get("args").getAsJsonObject();
            Type classType = Class.forName("by.epam.inner.beans." + nameClass);
            getExtraFields(jsonObject, nameClass, args);
            return GSON.fromJson(args, classType);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Error line in factory => " + jsonObject, e);
            return Optional.empty();
        }
    }

    public static void getExtraFields(JsonObject jsonObject, String nameClass, JsonObject args) {
        if (args.size() > 4 && nameClass.equals("ExtraTrial")) {
            LOGGER.warn("Extra fields => " + jsonObject);
        }
        if (args.size() > 3 && !nameClass.equals("ExtraTrial")) {
            LOGGER.warn("Extra fields =>" + jsonObject);
        }
    }
}
