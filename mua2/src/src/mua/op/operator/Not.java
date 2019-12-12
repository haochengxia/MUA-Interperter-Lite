package src.mua.op.operator;


/*

 */
import src.mua.Expr;
import src.mua.dataType.Bool;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Not extends Expr {

    @Override
    public String getOpName() {
        return "not";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argTypes, argList);
        Bool a = (Bool) argList.get(0);
        return new Word(!a.getValue());
    }


    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Bool.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}
