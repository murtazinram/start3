package by.epam.inner.beans;


import org.junit.Assert;
import org.junit.Test;

public class TrialTest {

    @Test
    public void isAccountNull() {
        Trial trial = new Trial(null, 1, 1);
        Assert.assertNull(trial.getAccount());
    }

    @Test
    public void isAccountEmpty() {
        Trial trial = new Trial("", 1, 1);
        Assert.assertEquals("", trial.getAccount());
    }

    @Test
    public void isAccountNotEmpty() {
        Trial trial = new Trial("test", 1, 1);
        Assert.assertNotNull(trial.getAccount());
    }

    @Test
    public void isMark1Negative() {
        Trial trial = new Trial("test", -1, 1);
        Assert.assertEquals(-1, trial.getMark1());
    }

    @Test
    public void isMark1Positive() {
        Trial trial = new Trial("test", 1, 1);
        Assert.assertEquals(1, trial.getMark1());
    }

    @Test
    public void isMark2Negative() {
        Trial trial = new Trial("test", -1, -1);
        Assert.assertEquals(-1, trial.getMark2());
    }

    @Test
    public void isMark2Positive() {
        Trial trial = new Trial("test", 1, 1);
        Assert.assertEquals(1, trial.getMark2());
    }

    @Test
    public void isTrialPassed() {
        Trial trial = new Trial("account", 50, 50);
        Assert.assertTrue(trial.isPassed());
    }

    @Test
    public void isTrialUnPassed() {
        Trial trial = new Trial("account", 30, 50);
        Assert.assertFalse(trial.isPassed());
    }

    @Test
    public void isCopy() {
        Trial trial = new Trial("account", 30, 50);
        Assert.assertEquals(trial.getCopy(), trial);
    }
}