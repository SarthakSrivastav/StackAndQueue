import java.io.FileReader;
import java.io.IOException;
public class BalancedParentheses {
    static int TOS = -1;
    static char[] stack = new char[50];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        FileReader r = new FileReader("D:\\LibraryManagementSystem\\StudentsRecors.txt");
        int i = r.read();
        boolean notNull = true;
        while (i >= 0) {
            Character ch = (char) i;
            if (ch.equals('(') || ch.equals('{') || ch.equals('[')) {
                push(ch);
            } else if ((ch.equals(')') || ch.equals('}') || ch.equals(']'))) {
                if (notNull) {
                    notNull = pop(ch);
                } else break;
            }
            i = r.read();
        }
        if (TOS != -1 || count != 0 || !notNull) System.out.println("Unbalanced Parentheses!!!");
        else System.out.println("Balanced Parentheses!!!");
    }

    public static void push(char ch) {
        TOS++;
        stack[TOS] = ch;
    }

    public static boolean pop(Character ch) {
        count++;
        if (TOS != -1) {
            if (ch == ')')
                ch = '(';
            if (ch == '}')
                ch = '{';
            if (ch == ']')
                ch = '[';
            if (ch.equals(stack[TOS])) {
                TOS--;
                count--;
                return true;
            } else return false;
        } else return false;
    }
}