package src.mua.op.judge;

import src.mua.Expr;
import src.mua.dataType.Bool;
import src.mua.dataType.List;
import src.mua.dataType.None;
import src.mua.dataType.MUAObject;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;
import src.mua.utils.RunUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Method: eval
 * getOpName
 * getArgNum
 **/

public class If extends Expr {

    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Bool.class,
            List.class,
            List.class
    ));

    @Override
    public String getOpName() {
        return "if";
    }

    @Override
    public None eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, argList);
        /** get three para **/
        Bool cond = (Bool) argList.get(0);
        List listA = (List) argList.get(1);
        List listB = (List) argList.get(2);
        if (cond.getValue()) {
            RunUtil.runList(scope, listA);
        }
        else {
            RunUtil.runList(scope, listB);
        }

        return new None();

    }

    public int getArgNum() {
        return argtypes.size();
    }
}