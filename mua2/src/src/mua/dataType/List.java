package src.mua.dataType;

import java.util.ArrayList;

public class List extends MUAObject {
    /**
     * @Member: value
     * @Method: List
     * getTypeString
     * getValue
     * toString
     **/

    private ArrayList<MUAObject> value;

    public List(ArrayList<MUAObject> list) {
        this.value = list;
    }

    @Override
    public String toString() {
        String content = "";
        boolean first = true;
        for (MUAObject v : value) {
            content += (first ? "" : " ") + v.toString();
            first = false;
        }
        return "[" + content + "]";
    }

    @Override
    public String getTypeString() {
        return "list";
    }

    @Override
    public ArrayList<MUAObject> getValue() {
        return value;
    }


}