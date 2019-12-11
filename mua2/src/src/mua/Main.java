package src.mua;

import  src.mua.interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        while (true) {
            interpreter.next();
        }

    }
}
