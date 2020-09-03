package by.epam.inner.validators;

import by.epam.inner.beans.Trial;
import by.epam.inner.exception.WrongArgumentsException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Objects;

public class TrialValidator {
    private int SIZE_ARGS = 3;
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

    public Trial getValidTrial(JsonElement element) {
        JsonObject args = element.getAsJsonObject();
        if (args.size() < SIZE_ARGS) {
            throw new WrongArgumentsException("too less args on: ", args);
        }
        setFields(args);
        return trial.getCopy();
    }

    protected void setFields(JsonObject args) {
        trial.setAccount(checkAccount(args));
        trial.setMark1(checkMark(args.get("mark1").getAsInt()));
        trial.setMark2(checkMark(args.get("mark2").getAsInt()));
    }

    protected int checkMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new WrongArgumentsException("mark less than 0 or more 100", mark);
        }
        return mark;
    }
}
