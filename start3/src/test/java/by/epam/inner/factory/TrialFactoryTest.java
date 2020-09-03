package by.epam.inner.factory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrialFactoryTest {
    public static final Gson GSON = new Gson();

    @Test
    public void getEmptyArgs() {
        String obj = "{ \"class\": \"Trial\", \"args\": {} }";
        JsonObject jsonObject = GSON.fromJson(obj, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getTrial() {
        String obj = "{ \"class\": \"Trial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(obj, JsonObject.class);
        assertTrue(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getStrongTrial() {
        String obj = "{ \"class\": \"StrongTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(obj, JsonObject.class);
        assertTrue(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getLightTrial() {
        String obj = "{ \"class\": \"LightTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(obj, JsonObject.class);
        assertTrue(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getExtraTrial() {
        String obj = "{ \"class\": \"ExtraTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1, \"mark3\": 1} }";
        JsonObject jsonObject = GSON.fromJson(obj, JsonObject.class);
        assertTrue(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getBadClassName() {
        String json = "{ \"class\": \"Tri\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getEmptyClassName() {
        String json = "{ \"class\": \"\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getBadAccount() {
        String json = "{ \"class\": \"ExtraTrial\", \"args\": { \"\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getNullAccount() {
        String json = "{ \"class\": \"ExtraTrial\", \"args\": { \"null\": \"test\", \"mark1\": 1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getNegativeMark1() {
        String json = "{ \"class\": \"LightTrial\", \"args\": { \"account\": \"test\", \"mark1\": -1, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getOverConditionMark1() {
        String json = "{ \"class\": \"LightTrial\", \"args\": { \"account\": \"test\", \"mark1\": 101, \"mark2\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getNegativeMark2() {
        String json = "{ \"class\": \"StrongTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": -1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getOverConditionMark2() {
        String json = "{ \"class\": \"LightTrial\", \"args\": { \"account\": \"test\", \"mark1\": 11, \"mark2\": 110 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getNegativeMark3() {
        String json = "{ \"class\": \"ExtraTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1, \"mark3\": -1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getOverConditionMark3() {
        String json = "{ \"class\": \"ExtraTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1, \"mark3\": 150 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertFalse(TrialFactory.getTrial(jsonObject).isPresent());
    }

    @Test
    public void getExtraFields() {
        String json = "{ \"class\": \"ExtraTrial\", \"args\": { \"account\": \"test\", \"mark1\": 1, \"mark2\": 1, \"mark3\": 1, \"mark4\": 1 } }";
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
        assertTrue(TrialFactory.getTrial(jsonObject).isPresent());
    }
}