////Program********************
//import java.util.Scanner;
//public class StackExample {
//    static Scanner input = new Scanner(System.in);
//    static int[] stack;
//    static int[] tempstack;
//    static int TOS=-1;
//    static  int tempTOS=-1;
//    static int count=0;
//    public static void main(String[] args) {
//        boolean star = true;
//        System.out.println("Enter the size of the stack:");
//        int size = input.nextInt();
//        stack = new int[size];
//        tempstack = new int[size];
//        while (star) {
//            System.out.println("Enter your Choice");
//            int choice = input.nextInt();
//            switch (choice) {
//                case 1:push();break;
//                case 2:star=false;break;
//                default:
//                    System.out.println("Invalid input");
//            }
//        }
//        System.out.println("Minimum element in the stack = "+tempstack[tempTOS]);
//        while(stack[TOS]!=tempstack[tempTOS]){
//            TOS--;
//            count++;
//        }
//        System.out.println("Elements deleted from the stack to reach "+tempstack[tempTOS]+" is ="+count);
//    }
//    public static void push(){
//        if (TOS != stack.length - 1) {
//            TOS++;
//            System.out.println("Enter the value to insert into the stack.");
//            int value=input.nextInt();
//            stack[TOS] = value;
//            if (tempTOS==-1) {
//                tempTOS++;
//                tempstack[TOS] = value;
//            }else {
//                if (value<tempstack[tempTOS]){
//                    tempTOS++;
//                    tempstack[tempTOS]=value;
//                }
//            }
//        } else System.out.println("Stack Overflow!!!");
//    }
//}
