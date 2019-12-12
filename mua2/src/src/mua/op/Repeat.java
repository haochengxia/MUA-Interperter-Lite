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

/**
 * @Method: eval
 * getOpName
 * getArgNum
 **/

public class Repeat extends Expr {

    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Number.class,
            List.class
    ));

    @Override
    public String getOpName() {
        return "repeat";
    }

    @Override
    public None eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argTypes, argList);
        Number n = (Number)argList.get(0);
        List l = (List)argList.get(1);
        for (int i = 0; i < n.getValue(); i++) {
            runList(scope, l);
        }
        return new None();
    }

    public int getArgNum() {
        return argTypes.size();

    }
}
