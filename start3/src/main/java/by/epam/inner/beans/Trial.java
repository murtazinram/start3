package by.epam.inner.beans;

public class Trial {
    public static final int PASS_OF_MARKS_SUM = 90;
    private String account;
    private int mark1;
    private int mark2;

    public Trial(String account, int mark1, int mark2) {
        this.account = account;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public Trial(Trial trial) {
        this(trial.getAccount(), trial.getMark1(), trial.getMark2());
    }

    public Trial() {

    }

    public Trial getCopy() {
        return new Trial(this);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    protected String fieldToString() {
        return account + ";" + mark1 + ";" + mark2;
    }

    @Override
    public String toString() {
        return fieldToString() + ";" + isPassed();
    }

    public boolean isPassed() {
        return getMark1() + getMark2() >= PASS_OF_MARKS_SUM;
    }

    public void clearMarks() {
        this.mark1 = 0;
        this.mark2 = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trial)) return false;

        Trial trial = (Trial) o;

        if (getMark1() != trial.getMark1()) return false;
        if (getMark2() != trial.getMark2()) return false;
        return getAccount() != null ? getAccount().equals(trial.getAccount()) : trial.getAccount() == null;
    }

    @Override
    public int hashCode() {
        int result = getAccount() != null ? getAccount().hashCode() : 0;
        result = 31 * result + getMark1();
        result = 31 * result + getMark2();
        return result;
    }
}
