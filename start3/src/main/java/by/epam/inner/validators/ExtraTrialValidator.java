package by.epam.inner.validators;

import by.epam.inner.beans.ExtraTrial;
import by.epam.inner.beans.Trial;
import com.google.gson.JsonObject;

public class ExtraTrialValidator extends TrialValidator {
    private static final int SIZE_ARGS = 4;
    private final ExtraTrial extraTrial;

    public ExtraTrialValidator(ExtraTrial extraTrial) {
        super(extraTrial);
        this.extraTrial = extraTrial;
    }

    @Override
    public Trial getValidTrial(JsonObject jsonObject) {
        checkArgsAndSet(jsonObject, SIZE_ARGS, extraTrial);
        return extraTrial.getCopy();
    }

    @Override
    protected void setFields(JsonObject jsonObject, Trial trial) {
        super.setFields(jsonObject, trial);
        extraTrial.setMark3(checkMark(jsonObject.get("mark3").getAsInt()));
    }

}
