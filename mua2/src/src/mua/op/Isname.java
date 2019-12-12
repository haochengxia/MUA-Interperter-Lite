package src.mua.op;

import src.mua.Expr;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Isname extends Expr {

    @Override
    public String getOpName() {
        return "isname";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Word obj = (Word)arglist.get(0);
        return new Word(scope.hasName(obj));
    }

    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Word.class
    ));
    public int getArgNum() {
        return argtypes.size();
    }
}
