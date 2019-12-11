package src.mua.exception;

public class SyntaxException extends MUAException {
    public SyntaxException(String s) {
        super(s);
    }
    @Override
    public String getMessage() {
        return "SyntaxError: " + super.getMessage();
    }
}