import java.util.Scanner;
public class StackImplementation {
    static Scanner input = new Scanner(System.in);
    static int TOS = -1;
    static int[] stack;
     public static void main(String[] args) {
         boolean star=true;
         System.out.println("Enter the size of the stack:");
         int size = input.nextInt();
         stack =new int[size];
         System.out.println("Press 1 to see the Menu");
         while (star){
             System.out.println("**********Enter your Choice**********");
             int choice = input.nextInt();
             switch (choice){
                 case 1:menu();break;
                 case 2:push();break;
                 case 3:pop();break;
                 case 4:display();break;
                 case 5:search();break;
                 case 6:peek();break;
                 case 7:star=false;break;
                 default:
                     System.out.println("Invalid input please try again!!!");
             }
         }
    }
    public static void menu(){
        System.out.println("Enter your choice:\n" +
                "1. Menu\n" +
                "2. Push\n" +
                "3. Pop\n" +
                "4. To Display The Stack\n" +
                "5. To Search\n" +
                "6. Peek\n" +
                "7. For Exit");
    }
    public static void push(){
             if (TOS != stack.length - 1) {
                 TOS++;
                 System.out.println("Enter the value to insert into the stack.");
                 stack[TOS] = input.nextInt();
             } else System.out.println("Stack Overflow!!!");
    }
    public static void pop(){
         if (TOS!=-1){
             TOS--;
             System.out.println("Top Of The Stack Is Removed Successfully!!!");
         }
         else System.out.println("Stack Underflow!!!");
    }
    public static void display(){
         if (TOS!=-1) {
             System.out.print("Elements present in stack: ");
             for (int i = 0; i <= TOS; i++) {
                 System.out.print(stack[i] + " ");
             }
             System.out.println();
         }else System.out.println("Stack Is Empty!!!");
    }
    public static void peek(){
       if (TOS!=-1) System.out.println("Top Element of Stack is "+stack[TOS]);
        System.out.println("Stack Is Empty!!!");
    }
    public static void search(){
         if (TOS!=-1) {
             boolean found = true;
             int count = 0;
             System.out.println("Enter Element To Search In Stack");
             int toSearch = input.nextInt();
             for (int i = TOS; i >= 0; i--) {
                 count++;
                 if (stack[i] == toSearch) {
                     found = false;
                     System.out.println(toSearch + " is found at OffSet " + count);
                     break;
                 }
             }
             if (found) System.out.println("Sorry " + toSearch + " is not found in Stack !!!");
         }else System.out.println("Stack Is Empty!!!");
    }
}