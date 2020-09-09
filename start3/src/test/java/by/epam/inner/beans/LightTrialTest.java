package by.epam.inner.beans;

import org.junit.Assert;
import org.junit.Test;

public class LightTrialTest {

    @Test
    public void isAccountNull() {
        LightTrial trial = new LightTrial(null, 1, 1);
        Assert.assertNull(trial.getAccount());
    }

    @Test
    public void isAccountEmpty() {
        LightTrial trial = new LightTrial("", 1, 1);
        Assert.assertEquals("", trial.getAccount());
    }

    @Test
    public void isAccountNotEmpty() {
        LightTrial trial = new LightTrial("test", 1, 1);
        Assert.assertNotNull(trial.getAccount());
    }

    @Test
    public void isMark1Negative() {
        LightTrial trial = new LightTrial("test", -1, 1);
        Assert.assertEquals(-1, trial.getMark1());
    }

    @Test
    public void isMark1Positive() {
        LightTrial trial = new LightTrial("test", 1, 1);
        Assert.assertEquals(1, trial.getMark1());
    }

    @Test
    public void isMark2Negative() {
        LightTrial trial = new LightTrial("test", -1, -1);
        Assert.assertEquals(-1, trial.getMark2());
    }

    @Test
    public void isMark2Positive() {
        LightTrial trial = new LightTrial("test", 1, 1);
        Assert.assertEquals(1, trial.getMark2());
    }

    @Test
    public void isTrialPassed() {
        LightTrial trial = new LightTrial("account", 80, 50);
        Assert.assertTrue(trial.isPassed());
    }

    @Test
    public void isTrialUnPassed() {
        LightTrial trial = new LightTrial("account", 30, 50);
        Assert.assertFalse(trial.isPassed());
    }

    @Test
    public void isCopy() {
        LightTrial trial = new LightTrial("account", 30, 50);
        Assert.assertEquals(trial.getCopy(), trial);
    }
}