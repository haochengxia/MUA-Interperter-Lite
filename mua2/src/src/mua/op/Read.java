package src.mua.op;


import src.mua.Expr;
import src.mua.dataType.MUAObject;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Read extends Expr {

    @Override
    public MUAObject eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Scanner input = new Scanner(System.in);
        String token = input.next();
//        String line = Interpreter.getLine(false);
//        ArrayList<String> tokens = ParserUtil.parseToken(line);
//        MUAObject obj =  ParserUtil.parseObj(tokens, scope).get(0);
//        if (!(obj instanceof Word) && !(obj instanceof Number))
//            throw new InputError("input is not a number or word");
        return new Word(token);
    }
    @Override
    public String getOpName() {
        return "read";
    }

    static final private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
    ));
    public int getArgNum() {
        return argtypes.size();
    }
}
