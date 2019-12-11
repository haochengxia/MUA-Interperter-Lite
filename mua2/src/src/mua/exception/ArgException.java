package src.mua.exception;

public class ArgException extends MUAException {

    public ArgException(String s) {
        super(s);
    }

    public String getMessage() {
        return "Argument Error: " + super.getMessage();
    }
}