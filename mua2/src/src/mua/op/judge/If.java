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

public class If  extends Expr {

    @Override
    public String getOpName() {
        return "if";
    }

    @Override
    public None eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Bool cond = (Bool) arglist.get(0);
        List listA = (List) arglist.get(1);
        List listB = (List) arglist.get(2);
        if (cond.getValue()) {
            RunUtil.runList(scope, listA);
        }
        else {
            RunUtil.runList(scope, listB);
        }

        return new None();

    }

    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Bool.class,
            List.class,
            List.class
    ));
    public int getArgNum() {
        return argtypes.size();
    }
}