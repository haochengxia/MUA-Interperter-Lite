package src.mua.interpreter;


import src.mua.exception.MUAException;
import src.mua.exception.SyntaxException;
import src.mua.dataType.*;

import java.util.ArrayList;
import java.util.Scanner;



public class Interpreter {

    public final static String pOne = ">>> ";
    public final static String pTwo = "... ";
    public Interpreter() {
        this.global = new Scope();

        //System.out.println("[MUA Interpreter v2.00 release on 12/12/2019]");
        //System.out.println("[Copyright @Haocheng Xia]");
    }


    public static String getLine(boolean verbose) throws Exception {
        Scanner input = new Scanner(System.in);
        promptOne(verbose);
        String line = getLineWithoutComment();
        while (line.trim().equals("")) {
            promptOne(verbose);
            line = getLineWithoutComment();
        }
        while (true) {
            boolean inWord = false;
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '"')
                    inWord = true;
                else if (Character.isWhitespace(line.charAt(i))
                        || (count > 0 && line.charAt(i) == ']'))
                    inWord = false;
                if (line.charAt(i) == '[' && !inWord) {
                    count++;
                }
                else if (line.charAt(i) == ']' && !inWord) {
                    count--;
                }
                if (count < 0) {
                    throw new SyntaxException("Unpaired ']'");
                }
            }
            if (count != 0) {
                promptTwo(verbose);
                String temp = getLineWithoutComment();
                line += " " + temp;
                continue;
            }
            else
                break;
        }
        return line;

    }

    public void evalLine(String line) throws Exception {
        ArrayList<String> tokens = parseToken(line);
        ArrayList<MUAObject> objlist = parseObj(tokens, global);
        if (objlist.size() != 1) {
            throw new SyntaxException("Invalid syntax: more than one object per line");
        }
        else {
            MUAObject obj = objlist.get(0);
            if (obj instanceof Expr) {
                MUAObject ret = ((Expr)obj).eval(global);
                if (! (ret instanceof None)) {
                    System.out.println(ret);
                }
            }
            else {
                System.out.println(obj);
            }
        }
    }
    private static  String getLineWithoutComment() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int i = line.indexOf("//");
        if (i != -1) {
            line = line.substring(0, i);
        }
        return line;
    }

    public void next()  {
        try {
            String line = getLine(true);
            evalLine(line);
        }
        catch (MUAException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void promptOne(boolean verbose) {
        if (verbose)
            System.out.print(pOne);
    }
    public static void promptTwo(boolean verbose) {
        if (verbose)
            System.out.print(pTwo);
    }


    private Scope global = new Scope();
}