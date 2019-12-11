package src.mua.exception;

public class NameException extends MUAException {
    public NameException(String text) {
        super(text);
    }
    @Override
    public String getMessage() {
        return "NameError: " + super.getMessage();
    }
}