package by.epam.inner.validators;

import by.epam.inner.beans.Trial;
import by.epam.inner.exception.WrongArgumentsException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Objects;

public class TrialValidator {
    private static final int SIZE_ARGS = 3;
    private final Trial trial;

    public TrialValidator(Trial trial) {
        this.trial = trial;
    }

    private String checkAccount(JsonObject args) {
        JsonElement account = args.get("account");
        if (Objects.isNull(account) || account.isJsonNull() || account.getAsString().isEmpty()) {
            throw new WrongArgumentsException("account can`t be null or empty", account);
        }
        return account.getAsString();
    }

    public Trial getValidTrial(JsonObject jsonObject) {
        checkArgsAndSet(jsonObject, SIZE_ARGS, trial);
        return trial.getCopy();
    }

    protected void checkArgsAndSet(JsonObject jsonObject, int SIZE_ARGS, Trial trial) {
        if (jsonObject.size() < SIZE_ARGS) {
            throw new WrongArgumentsException("too less jsonObject on: ", jsonObject);
        }
        setFields(jsonObject, trial);
    }

    protected void setFields(JsonObject jsonObject, Trial trial) {
        trial.setAccount(checkAccount(jsonObject));
        trial.setMark1(checkMark(jsonObject.get("mark1").getAsInt()));
        trial.setMark2(checkMark(jsonObject.get("mark2").getAsInt()));
    }

    protected int checkMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new WrongArgumentsException("mark less than 0 or more 100", mark);
        }
        return mark;
    }
}
