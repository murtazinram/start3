package by.epam.inner.beans;

import org.junit.Assert;
import org.junit.Test;

public class StrongTrialTest {

    @Test
    public void isAccountNull() {
        StrongTrial trial = new StrongTrial(null, 1, 1);
        Assert.assertNull(trial.getAccount());
    }

    @Test
    public void isAccountEmpty() {
        StrongTrial trial = new StrongTrial("", 1, 1);
        Assert.assertEquals("", trial.getAccount());
    }

    @Test
    public void isAccountNotEmpty() {
        StrongTrial trial = new StrongTrial("test", 1, 1);
        Assert.assertNotNull(trial.getAccount());
    }

    @Test
    public void isMark1Negative() {
        StrongTrial trial = new StrongTrial("test", -1, 1);
        Assert.assertEquals(-1, trial.getMark1());
    }

    @Test
    public void isMark1Positive() {
        StrongTrial trial = new StrongTrial("test", 1, 1);
        Assert.assertEquals(1, trial.getMark1());
    }

    @Test
    public void isMark2Negative() {
        StrongTrial trial = new StrongTrial("test", -1, -1);
        Assert.assertEquals(-1, trial.getMark2());
    }

    @Test
    public void isMark2Positive() {
        StrongTrial trial = new StrongTrial("test", 1, 1);
        Assert.assertEquals(1, trial.getMark2());
    }

    @Test
    public void isTrialPassed() {
        StrongTrial trial = new StrongTrial("account", 80, 50);
        Assert.assertTrue(trial.isPassed());
    }

    @Test
    public void isTrialUnPassed() {
        StrongTrial trial = new StrongTrial("account", 30, 50);
        Assert.assertFalse(trial.isPassed());
    }

    @Test
    public void isCopy() {
        StrongTrial trial = new StrongTrial("account", 30, 50);
        Assert.assertEquals(trial.getCopy(), trial);
    }
}