package src.mua.op.other;


import src.mua.Expression;
import src.mua.dataType.List;
import src.mua.dataType.None;
import src.mua.dataType.Word;
import src.mua.interpreter.NameSpace;
import src.mua.utils.ArgumentUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static src.mua.utils.RunTimeUtil.runList;

/**
 * save added in 12/27/2019
 */
public class Save extends Expression {


    public static final int firstArg = 0;
    public static final int secondArg = 1;
    public static final int thirdArg = 2;

    public static final int firstObj = 0;
    public static final int secondObj = 1;
    public static final int thirdObj = 2;

    @Override
    public String getOpName() {
        return "save";
    }

    @Override
    public None calculate(NameSpace nameSpace) throws Exception {
        super.calculate(nameSpace);
        ArgumentUtil.argCheck(getOpName(), argTypes, argList);

        Word word = (Word)argList.get(firstArg);
        File file = new File(word.getValue());
        try {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream((new FileOutputStream(file)));
            outputStream.writeObject(nameSpace);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new None();
    }

    // no parameters
    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Word.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}
