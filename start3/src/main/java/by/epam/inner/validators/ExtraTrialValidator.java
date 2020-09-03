package by.epam.inner.validators;

import by.epam.inner.beans.ExtraTrial;
import by.epam.inner.exception.WrongArgumentsException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ExtraTrialValidator extends TrialValidator {
    private int SIZE_ARGS = 4;
    private final ExtraTrial extraTrial;

    public ExtraTrialValidator(ExtraTrial extraTrial) {
        super(extraTrial);
        this.extraTrial = extraTrial;
    }

    @Override
    protected void setFields(JsonObject args) {
        super.setFields(args);
        this.extraTrial.setMark3(checkMark(args.get("mark3").getAsInt()));
    }

    @Override
    public ExtraTrial getValidTrial(JsonElement element) {
        JsonObject args = element.getAsJsonObject();
        if (args.size() < SIZE_ARGS) {
            throw new WrongArgumentsException("too less args on: ", args);
        }
        setFields(args);
        return extraTrial.getCopy();
    }
}
