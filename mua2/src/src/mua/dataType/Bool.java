package src.mua.dataType;

public class Bool extends MUAObject {
    // ctor
    public Bool(boolean b) {
        this.value = b;
    }

    @Override
    public String getTypeString() {
        return "bool";
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value)
            return "true";
        else
            return "false";
    }

    // data members
    private boolean value;
}
