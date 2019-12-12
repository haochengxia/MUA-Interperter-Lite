package src.mua;

import src.mua.exception.SyntaxException;
import src.mua.utils.ArgUtil;
import src.mua.dataType.*;
import src.mua.interpreter.Scope;

import java.util.ArrayList;

/**
 * @Member: argList
 * @Method: eval
 * getOpName
 * getArgNum
 * setArgList
 * getTypeString
 * getValue
 * toString
 **/


abstract public class Expr extends MUAObject {

    protected ArrayList<MUAObject> argList = new ArrayList<>();

    @Override
    public String getTypeString() {
        return "expr";
    }

    abstract public String getOpName();

    public MUAObject eval(Scope scope) throws Exception {
        ArgUtil.evalAll(argList, scope);
        for (MUAObject obj : argList) {
            if (obj instanceof None)
                throw new SyntaxException("no return value");

        }
        return new None();
    }

    public void setArgList(ArrayList<MUAObject> argList) {
        this.argList = argList;
    }

    abstract public int getArgNum();


    @Override
    public Expr getValue() {
        return this;
    }

    @Override
    public String toString() {
        String tmp = getOpName();
        for (MUAObject arg : argList) {
            tmp += " " + arg.toString();
        }
        return tmp;
    }
}