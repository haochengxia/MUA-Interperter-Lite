package src.mua.op;


import src.mua.Expr;
import src.mua.dataType.None;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.Arrays;

import java.util.ArrayList;

public class Erase extends Expr {

    @Override
    public String getOpName() {
        return "erase";
    }

    @Override
    public None eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Word word = (Word) arglist.get(0);
        scope.removeName(word);
        return new None();
    }

    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Word.class
    ));

    @Override
    public int getArgNum() {
        return argtypes.size();
    }
}
