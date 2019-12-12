package src.mua.op.judge;


import src.mua.Expr;
import src.mua.dataType.Bool;
import src.mua.dataType.MUAObject;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Method: eval
 * getOpName
 * getArgNum
 **/

public class Isbool extends Expr {

    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(MUAObject.class));

    @Override
    public String getOpName() {
        return "isbool";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argTypes, argList);
        MUAObject obj = (MUAObject) argList.get(0);
        if (ArgUtil.typeCast(Bool.class, obj) == null) {
            return new Word(false);
        } else
            return new Word(true);
    }

    public int getArgNum() {
        return argTypes.size();
    }
}
