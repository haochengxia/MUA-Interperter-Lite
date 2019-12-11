package src.mua.exception;

public class TypeException extends MUAException {

    public TypeException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "TypeError: " + super.getMessage();
    }
}