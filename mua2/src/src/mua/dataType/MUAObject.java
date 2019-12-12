package src.mua.dataType;

import src.mua.interpreter.Scope;

abstract public class MUAObject {
    /**
     * @Member: enclosingScope
     * @Method: getTypeString
     * getValue
     * toString
     **/

    public Scope enclosingScope = null;

    abstract public String getTypeString();

    abstract public Object getValue();

    @Override
    abstract public String toString();

}