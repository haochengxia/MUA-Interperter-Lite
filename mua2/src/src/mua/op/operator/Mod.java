package src.mua.op.operator;

import src.mua.Expr;
import src.mua.dataType.Word;
import src.mua.dataType.Number;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;
import src.mua.exception.ArithmeticException;

import java.util.ArrayList;
import java.util.Arrays;

public class Mod extends Expr {
    @Override
    public String getOpName() {
        return "gt";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Number a = (Number) arglist.get(0);
        Number b = (Number) arglist.get(1);
        if (b.getValue() < 1e-7)
            throw new ArithmeticException("Divide by zero");
        return new Word(a.getValue() % b.getValue());
    }

    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Number.class,
            Number.class
    ));

    public int getArgNum() {
        return argtypes.size();
    }
}
