package src.mua.op;


import src.mua.Expr;
import src.mua.dataType.MUAObject;
import src.mua.dataType.None;
import src.mua.dataType.Word;
import src.mua.exception.SyntaxException;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Make extends Expr {


    @Override
    public String getOpName() {
        return "make";
    }

    @Override
    public None eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Word word = (Word) arglist.get(0);
        if (!Character.isLetter(word.getValue().charAt(0)))
            throw new SyntaxException("<word> in make must start with a letter");
        MUAObject value = arglist.get(1);
        scope.addName(word, value);
        // function enclosing scope

        return new None();
    }


    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Word.class,
            MUAObject.class
    ));

    public int getArgNum() {
        return argtypes.size();
    }
}
