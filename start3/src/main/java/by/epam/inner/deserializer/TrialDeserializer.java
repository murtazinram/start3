package by.epam.inner.deserializer;

import by.epam.inner.beans.ExtraTrial;
import by.epam.inner.beans.LightTrial;
import by.epam.inner.beans.StrongTrial;
import by.epam.inner.beans.Trial;
import by.epam.inner.exception.WrongArgumentsException;
import by.epam.inner.validators.ExtraTrialValidator;
import by.epam.inner.validators.TrialValidator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.Optional;

public class TrialDeserializer implements JsonDeserializer<Optional<Trial>> {
    private static final Logger LOGGER = Logger.getLogger(TrialDeserializer.class);

    @Override
    public Optional<Trial> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            String[] arr = type.getTypeName().split("\\.");
            String trialKind = arr[arr.length - 1]
                    .replaceAll("([a-z])([A-Z]+)", "$1_$2")
                    .toUpperCase();
            return Optional.of(TrialKind.valueOf(trialKind).getTrial(jsonElement));
        } catch (WrongArgumentsException e) {
            LOGGER.error("Error line => " + jsonElement, e);
            return Optional.empty();
        }
    }

    private enum TrialKind {
        TRIAL(new TrialValidator(new Trial())),
        STRONG_TRIAL(new TrialValidator(new StrongTrial())),
        LIGHT_TRIAL(new TrialValidator(new LightTrial())),
        EXTRA_TRIAL(new ExtraTrialValidator(new ExtraTrial()));
        private final TrialValidator validator;

        TrialKind(TrialValidator validator) {
            this.validator = validator;
        }

        Trial getTrial(JsonElement element) {
            return validator.getValidTrial(element);
        }
    }
}
