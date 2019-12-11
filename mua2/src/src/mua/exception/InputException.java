package src.mua.exception;

public class InputException extends MUAException {
    public InputException(String s) {
        super(s);
    }

    public String getMessage() {
        return "Input Error: " + super.getMessage();
    }
}
