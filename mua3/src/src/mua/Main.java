package src.mua;

import  src.mua.interpreter.Interpreter;

import java.util.Scanner;

/** current version file structure
 *
 * src
 *     └─mua
 *         │  Expression.java
 *         │  Function.java
 *         │  Main.java
 *         │
 *         ├─dataType
 *         │      Bool.java
 *         │      List.java
 *         │      None.java
 *         │      Number.java
 *         │      Object.java
 *         │      Word.java
 *         │
 *         ├─interpreter
 *         │      Interpreter.java
 *         │      NameSpace.java
 *         │
 *         ├─op
 *         │  ├─additional
 *         │  │      Exit.java
 *         │  │
 *         │  ├─basic
 *         │  │      Erase.java
 *         │  │      Isname.java
 *         │  │      Make.java
 *         │  │      Print.java
 *         │  │      Read.java
 *         │  │      Readlist.java
 *         │  │      Repeat.java
 *         │  │      Thing.java
 *         │  │
 *         │  ├─func
 *         │  │      Export.java
 *         │  │      Output.java
 *         │  │      Stop.java
 *         │  │
 *         │  ├─judge
 *         │  │      If.java
 *         │  │      Isbool.java
 *         │  │      Isempty.java
 *         │  │      Islist.java
 *         │  │      Isnumber.java
 *         │  │      Isword.java
 *         │  │
 *         │  └─operator
 *         │          Add.java
 *         │          And.java
 *         │          Div.java
 *         │          Eq.java
 *         │          Gt.java
 *         │          Lt.java
 *         │          Mod.java
 *         │          Mul.java
 *         │          Not.java
 *         │          Or.java
 *         │          Sub.java
 *         │
 *         └─utils
 *                 ArgumentUtil.java
 *                 ParserUtil.java
 *                 RunTimeUtil.java
 *                 TransUtil.java
 */


public class Main {
    public static void main(String[] args) {
        //System.out.println("***MUA Interpreter v2.00 release on 12/12/2019***");
        //System.out.println("***Copyright@Haocheng Xia (appreciate the help of senior LZX)***");
        Interpreter interpreter = new Interpreter();
        Scanner LineStarch=new Scanner(System.in);
        while (true) {
            if (!LineStarch.hasNextLine()) break;
            String line = LineStarch.nextLine();
            //System.out.println(line);
            interpreter.next(line,LineStarch);
        }
    }
}
