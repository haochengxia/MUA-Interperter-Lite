package src.mua.interpreter;
import src.mua.exception.*;
import java.util.HashMap;
import src.mua.dataType.*;

public class Scope {
    public enum Type {
        GLOBAL,
        FUNCTION
    }

    // by default create a global scope
    public Scope() {
        this("global", Type.GLOBAL, null);

    }

    // create a function scope
    public Scope(String name, Type type, Scope enclosing) {
        this.scopeName = name;
        this.scopeType = type;
        this.enclosingScope = enclosing;
    }


    public String getScopeName() {
        return scopeName;
    }

    public Type getScopeType() {
        return scopeType;
    }

    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public void addName(Word name, MUAObject value) {
        scope.put(name.getValue(), value);
        if (value.enclosingScope == null) {
            value.enclosingScope = this;
        }
    }

    public MUAObject getName(Word name) throws NameException {
        MUAObject ret = scope.get(name.toString());
        if (ret == null) {
            if (enclosingScope == null) {
                throw new NameException("name '" + name.getValue() + "' not found");
            }
            else
                return enclosingScope.getName(name);
        }
        return ret;

    }

    public void removeName(Word name) throws NameException {
        MUAObject succeed = scope.remove(name.getValue());
        if (succeed == null) {
            throw new NameException("name '" + name.getValue() + "' not found");
        }
    }

    public boolean hasName(Word name) {
        return scope.containsKey(name.getValue());
    }

    public void setReturnValue(MUAObject o) {
        returnValue = o;
    }

    public MUAObject getReturnValue() {
        return returnValue;
    }

    private String scopeName = "global";
    private Type scopeType = Type.GLOBAL;
    private Scope enclosingScope = null;
    private MUAObject returnValue = new None();

    public boolean getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    private boolean stopFlag = false;
    private HashMap<String, MUAObject> scope = new HashMap<>();
}