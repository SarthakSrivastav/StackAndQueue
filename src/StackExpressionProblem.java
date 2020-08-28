import java.util.Scanner;
public class StackExpressionProblem {
    static Scanner input = new Scanner(System.in);
    static int[] stack;
    static int TOS = -1;
    static String[] problem;
    public static void main(String[] args) {
        System.out.println("Enter Size Of Your Problem:");
        int size = input.nextInt();
        problem = new String[size];
        stack=new int[size];
        System.out.println("Enter Your Problem with space separated Mathematical Equation:");
        for (int i = 0; i < problem.length; i++)
            problem[i] = input.next();
        for (int i = 0; i < problem.length; i++) {
            if (problem[i].equals("+") || problem[i].equals("-") || problem[i].equals("*")
                || problem[i].equals("/") || problem[i].equals("%")) {
                calculation(problem[i]);
            }
            else push(Integer.valueOf(problem[i]));
        }
       if (TOS==0)
           System.out.println("Result = "+stack[TOS]);
       else System.out.println("Wrong Expression Please check your Expression!!!.....");
    }

    public static void push(int element) {
        if (TOS !=stack.length-1 ) {
            TOS++;
            stack[TOS]=element;
        } else System.out.println("Stack Overflow!!!");
    }

    public static void calculation(String operator) {
        int operand1 = pop();
        int operand2 = pop();
        if (operand1 != -1 && operand2 != -1) {
            switch (operator) {
                case "+": push((operand2 + operand1));break;
                case "-": push((operand2 - operand1));break;
                case "*": push((operand2 * operand1));break;
                case "/": push((operand2 / operand1));break;
                case "%": push((operand2 % operand1));break;
            }
        } else{
            System.out.println("Wrong Expression Please check your Expression!!!");
           System.exit(0);
        }
    }

    public static int pop() {
        if (TOS != -1) {
            TOS--;
            return stack[TOS+1];
        } else {
            System.out.println("Stack Underflow!!!");
            return -1;
        }
    }
}