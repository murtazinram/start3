package by.epam.inner.beans;

public class LightTrial extends Trial {
    private static final int FIRST_TEST_PASS_MARK = 55;
    private static final int SECOND_TEST_PASS_MARK = 45;

    public LightTrial(String account, int mark1, int mark2) {
        super(account, mark1, mark2);
    }

    public LightTrial(LightTrial lightTrial) {
        this(lightTrial.getAccount(), lightTrial.getMark1(), lightTrial.getMark2());
    }

    public LightTrial() {
    }

    @Override
    public LightTrial getCopy() {
        return new LightTrial(this);
    }

    @Override
    public boolean isPassed() {
        return getMark1() >= FIRST_TEST_PASS_MARK && getMark2() >= SECOND_TEST_PASS_MARK;
    }
}
