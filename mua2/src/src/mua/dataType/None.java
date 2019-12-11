package src.mua.dataType;

public class None extends MUAObject {
    public None() {
    }

    @Override
    public String getTypeString() {
        return "none";
    }

    @Override
    public None getValue() {
        return this;
    }

    @Override
    public String toString() {
        return "None";
    }

}