package src.mua.op;

import src.mua.Expr;
import src.mua.dataType.List;
import src.mua.dataType.Number;
import src.mua.dataType.None;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

import static src.mua.utils.RunUtil.runList;

public class Repeat extends Expr {
    @Override
    public String getOpName() {
        return "repeat";
    }

    @Override
    public None eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Number n = (Number)arglist.get(0);
        List l = (List)arglist.get(1);
        for (int i = 0; i < n.getValue(); i++) {
            runList(scope, l);
        }
        return new None();
    }

    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Number.class,
            List.class
    ));

    public int getArgNum() {
        return argtypes.size();

    }
}
