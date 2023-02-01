package parentheses;

import java.util.*;
import java.io.*;

/**
 *
 * @author PRINCE_REX
 */
public class Parentheses {

    static void push(Stack<String> s, String a) {
        s.push(a);
    }

    static String pop(Stack<String> s) {
        return (String) s.pop();
    }

    public static void main(String[] args) throws IOException {
        Stack<String> s = new Stack<String>();

        System.out.println("Enter The Parentheses :- ");
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        String D = R.readLine();
        String[] Data = D.split("");

        for (String Data0 : Data) {
            boolean control=true;
            if (Data0.equals("{") || Data0.equals("[") || Data0.equals("(")) {
                push(s, Data0);
                System.out.print("Input :- " + Data0 + "\t");
                System.out.println(s);
            }

            if (Data0.equals("}") || Data0.equals("]") || Data0.equals(")")) {
                String v = pop(s);
                System.out.print("Input :- " + Data0 + "\t");
                switch (v) {
                    case "{":
                        if (Data0.equals("}") ) {
                            System.out.println(s);
                        } else {
                            System.out.println("\n\nFalse");
                            control=false;
                        }   break;
                    case "[":
                        if ( Data0.equals("]") ) {
                            System.out.println(s);
                        } else {;
                            System.out.println("\n\nFalse");
                            control=false;
                        }   break;
                    case "(":
                        if (Data0.equals(")")) {
                            System.out.println(s);
                        } else {
                            System.out.println("\n\nFalse");
                            control=false;
                        }   break;
                    default:
                        break;
                }if(control!=true){break;}
            }
        }
        if(s.isEmpty()){
            System.out.println("True");
        }

    }
}
