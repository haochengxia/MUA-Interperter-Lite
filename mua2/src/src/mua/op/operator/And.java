package src.mua.op.operator;

import src.mua.Expr;
import src.mua.dataType.Bool;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class And extends Expr {
    @Override
    public String getOpName() {
        return "and";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argTypes, argList);
        Bool a = (Bool) argList.get(0);
        Bool b = (Bool) argList.get(1);
        return new Word(a.getValue() && b.getValue());
    }


    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Bool.class,
            Bool.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}
