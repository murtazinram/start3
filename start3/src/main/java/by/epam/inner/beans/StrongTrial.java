package by.epam.inner.beans;

public class StrongTrial extends Trial {
    public StrongTrial(String account, int mark1, int mark2) {
        super(account, mark1, mark2);
    }

    public StrongTrial(StrongTrial strongTrial) {
        this(strongTrial.getAccount(), strongTrial.getMark1(), strongTrial.getMark2());
    }

    public StrongTrial() {
    }

    @Override
    public StrongTrial getCopy() {
        return new StrongTrial(this);
    }

    @Override
    public boolean isPassed() {
        return ((getMark1() / 2 + getMark2()) >= Trial.PASS_OF_MARKS_SUM);
    }
}
