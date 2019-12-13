package src.mua.op.operator;

import src.mua.*;
import src.mua.dataType.Word;
import src.mua.dataType.Number;
import src.mua.dataType.MUAObject;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;



public class Add extends Expr {
    public static final int firstArg = 0;
    public static final int secondArg = 1;
    public static final int thirdArg = 2;

    public static final int firstObj = 0;
    public static final int secondObj = 1;
    public static final int thirdObj = 2;

    @Override
    public String getOpName() {
        return "add";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argTypes, argList);
        Number a = (Number) argList.get(firstArg);
        Number b = (Number) argList.get(secondArg);
        return new Word(a.getValue() + b.getValue());
    }


    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Number.class,
            Number.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}
