package by.epam.inner.exception;

public class WrongArgumentsException extends IllegalArgumentException {
    private final Object object;

    public WrongArgumentsException(String s, Object object) {
        super(s);
        this.object = object;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " =>> " + object;
    }
}