package src.mua.op.wordList;


import src.mua.Expression;
import src.mua.dataType.None;
import src.mua.dataType.Number;
import src.mua.dataType.Object;
import src.mua.interpreter.NameSpace;
import src.mua.utils.ArgumentUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * wait added in 12/27/2019
 */

public class First extends Expression {

    public static final int firstArg = 0;
    public static final int secondArg = 1;
    public static final int thirdArg = 2;

    public static final int firstObj = 0;
    public static final int secondObj = 1;
    public static final int thirdObj = 2;

    @Override
    public String getOpName() {
        return "first";
    }

    @Override
    public Object calculate(NameSpace nameSpace) throws Exception {
        super.calculate(nameSpace);
        ArgumentUtil.argCheck(getOpName(), argTypes, argList);
        Object obj = (Object) argList.get(firstArg);
        if (obj instanceof src.mua.dataType.List) {
            src.mua.dataType.List l = (src.mua.dataType.List)obj;
            if (l.getValue().size() == 0) {
                Exception e = new Exception();
                e.printStackTrace();
            }
            return l.getValue().get(0);
        }
        else {
            src.mua.dataType.Word w = ( src.mua.dataType.Word)obj;
            if (w.getValue().length() == 0) {
                Exception e = new Exception();
                e.printStackTrace();
            }
            return new src.mua.dataType.Word(w.getValue().substring(0, 1));
        }

    }

    // no parameters
    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            src.mua.dataType.Object.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}
