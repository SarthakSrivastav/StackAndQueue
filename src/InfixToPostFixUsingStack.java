import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class InfixToPostFixUsingStack {
    static Scanner input = new Scanner(System.in);
    static char[] stack;
    static char[] problem;
    static ArrayList AL = new ArrayList();
    static int TOS = -1;
    public static void main(String[] args) {
        System.out.println("Enter the Equation:");
        String str = input.nextLine();
        stack = new char[str.length()];
        problem = new char[str.length()];
//        converting string to character array********************
        for (int i = 0; i < problem.length; i++) {
            problem[i] = str.charAt(i);
        }
        for (int i = 0; i < problem.length; i++) {
            if (problem[i] == '(' || problem[i] == '+' || problem[i] == '-' || problem[i] == '/' || problem[i] == '*' ||problem[i]=='^'|| problem[i] == ')') {
                push(problem[i]);
            } else {
                AL.add(problem[i]);
            }
        }
        System.out.println("Result:");
        Iterator itr = AL.listIterator();
        while (itr.hasNext()){
            char ch = (char)itr.next();
            System.out.print(ch);
        }
    }
    public static void push(char operator) {
        if (TOS!=stack.length-1) {
            if (operator=='('){
                TOS++;
                stack[TOS]=operator;
            }
//            For '+' and '-' *********************************
            else if ((operator=='+'||operator=='-')&&stack[TOS]!='('){
                boolean found = true;
                while(found){
                    pop();
                    if (stack[TOS]=='(')
                        found=false;
                }
                TOS++;
                stack[TOS]=operator;
            }
            else if ((operator=='+'||operator=='-')&&(stack[TOS]=='(')){
                TOS++;
                stack[TOS]=operator;
            }
//            For '*' and '/' *******************************
            else if ((operator=='*'||operator=='/')&&(stack[TOS]=='+'||stack[TOS]=='-'||stack[TOS]=='(')){
                TOS++;
                stack[TOS]=operator;
            }
            else if ((operator=='*'||operator=='/')&&(stack[TOS]=='*'||stack[TOS]=='/'||stack[TOS]=='^')){
                boolean found = true;
                while (found){
                    pop();
                    if (stack[TOS]=='+'||stack[TOS]=='-'||stack[TOS]=='(')
                        found = false;
                }
                TOS++;
                stack[TOS]=operator;
            }
//            FOr '^'  *********************
            else if (operator=='^'&&(stack[TOS]=='+'||stack[TOS]=='-'||stack[TOS]=='*'||stack[TOS]=='/'||stack[TOS]=='(')){
                TOS++;
                stack[TOS]=operator;
            }
            else if (operator=='^' && stack[TOS]=='^'){
                boolean found=true;
                while (found){
                    pop();
                    if (stack[TOS]=='+'||stack[TOS]=='-'||stack[TOS]=='*'||stack[TOS]=='/'||stack[TOS]=='(')
                        found=false;
                }
            }
//            For ')' **********************
            else if (operator==')'){
                boolean found = true;
                while (found) {
                    if (stack[TOS]=='(') {
                        found = false;
                    }
                    pop();
                }
            }
        }
        else System.out.println("Stack Overflow");
    }
    public static void pop() {
        if (TOS!=-1){
//            For '+' , '-' ,'*' , '/' *********************
            if (stack[TOS]!='(') {
                AL.add(stack[TOS]);
            }
            TOS--;
        }
        else System.out.println("Stack underflow!!!");
    }
}