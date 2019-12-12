package src.mua.op.operator;

import src.mua.Expr;
import src.mua.dataType.MUAObject;
import src.mua.dataType.Word;
import src.mua.dataType.Number;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;
import src.mua.utils.TransUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Gt extends Expr {

    @Override
    public String getOpName() {
        return "gt";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        MUAObject x = arglist.get(0);
        MUAObject y = arglist.get(1);
        if (x instanceof Number && y instanceof Number) {
            Number a = (Number) x;
            Number b = (Number) y;
            return new Word(a.getValue() > (b.getValue()));
        }
        else {
            Word a = (Word) x;
            Word b = (Word) y;
            String p1 = a.toString();
            String p2 = b.toString();
            //in this case if the string is match to the number format we need to translate auto
            if (TransUtil.translate(p1)!=999999999 && TransUtil.translate(p2)!=999999999){
                return new Word (TransUtil.translate(p1) > TransUtil.translate(p2));
            }
            return new Word(a.toString().compareTo(b.toString()) > 0);
        }
    }


    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Word.class,
            Word.class
    ));

    public int getArgNum() {
        return argtypes.size();
    }
}
