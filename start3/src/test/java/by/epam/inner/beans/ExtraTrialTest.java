package by.epam.inner.beans;

import org.junit.Assert;
import org.junit.Test;

public class ExtraTrialTest {

    @Test
    public void isAccountNull() {
        ExtraTrial trial = new ExtraTrial(null, 1, 1, 1);
        Assert.assertNull(trial.getAccount());
    }

    @Test
    public void isAccountEmpty() {
        ExtraTrial trial = new ExtraTrial("", 1, 1, 1);
        Assert.assertEquals("", trial.getAccount());
    }

    @Test
    public void isAccountNotEmpty() {
        ExtraTrial trial = new ExtraTrial("test", 1, 1, 1);
        Assert.assertNotNull(trial.getAccount());
    }

    @Test
    public void isMark1Negative() {
        ExtraTrial trial = new ExtraTrial("test", -1, 1, 1);
        Assert.assertEquals(-1, trial.getMark1());
    }

    @Test
    public void isMark1Positive() {
        ExtraTrial trial = new ExtraTrial("test", 1, 1, 1);
        Assert.assertEquals(1, trial.getMark1());
    }

    @Test
    public void isMark2Negative() {
        ExtraTrial trial = new ExtraTrial("test", -1, -1, 1);
        Assert.assertEquals(-1, trial.getMark2());
    }

    @Test
    public void isMark2Positive() {
        ExtraTrial trial = new ExtraTrial("test", 1, 1, 1);
        Assert.assertEquals(1, trial.getMark2());
    }

    @Test
    public void isMark3Negative() {
        ExtraTrial trial = new ExtraTrial("test", -1, 1, -1);
        Assert.assertEquals(-1, trial.getMark1());
    }

    @Test
    public void isMark3Positive() {
        ExtraTrial trial = new ExtraTrial("test", 1, 1, 1);
        Assert.assertEquals(1, trial.getMark1());
    }

    @Test
    public void isTrialPassed() {
        ExtraTrial trial = new ExtraTrial("account", 80, 50, 80);
        Assert.assertTrue(trial.isPassed());
    }

    @Test
    public void isTrialUnPassed() {
        ExtraTrial trial = new ExtraTrial("account", 30, 50, 26);
        Assert.assertFalse(trial.isPassed());
    }

    @Test
    public void isCopy() {
        ExtraTrial trial = new ExtraTrial("account", 30, 50, 70);
        Assert.assertEquals(trial.getCopy(), trial);
    }

}