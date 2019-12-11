package src.mua.exception;

public class ArithmeticException extends MUAException {

    public ArithmeticException(String s) {
        super(s);
    }

    public String getMessage() {
        return "Arithmetic Error: " + super.getMessage();
    }
}