package src.mua.utils;


import src.mua.Expr;
import src.mua.dataType.List;
import src.mua.dataType.MUAObject;
import src.mua.interpreter.Scope;

import java.util.ArrayList;

public class RunningUtil {
    public static MUAObject runList(Scope scope, List l) throws Exception {
        ArrayList<String> tokens = new ArrayList<>();
        for (MUAObject token : l.getValue()) {
            tokens.add(token.toString());
        }
        ArrayList<MUAObject> objlist = parseObj(tokens, scope);
        for (MUAObject obj : objlist) {
            if (obj instanceof Expr) {
                ((Expr)obj).eval(scope);
            }
            if (scope.getStopFlag()) {
                return scope.getReturnValue();
            }
        }
        return scope.getReturnValue();
    }
}