package by.epam.inner.beans;

public class ExtraTrial extends Trial {
    private static final int PASS_MARK_TEST = 50;
    private int mark3;

    public ExtraTrial(String account, int mark1, int mark2, int mark3) {
        super(account, mark1, mark2);
        this.mark3 = mark3;
    }

    public ExtraTrial(ExtraTrial extraTrial) {
        this(extraTrial.getAccount(), extraTrial.getMark1(), extraTrial.getMark2(), extraTrial.getMark3());
    }

    public ExtraTrial() {
    }

    @Override
    public ExtraTrial getCopy() {
        return new ExtraTrial(this);
    }

    @Override
    public boolean isPassed() {
        return mark3 > PASS_MARK_TEST && super.isPassed();
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + mark3;
    }

    @Override
    public void clearMarks() {
        this.mark3 = 0;
        super.clearMarks();
    }
}
