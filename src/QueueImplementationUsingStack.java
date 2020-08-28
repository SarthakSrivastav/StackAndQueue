import java.util.Scanner;
public class QueueImplementationUsingStack {
    static Scanner input = new Scanner(System.in);
    static int TOS=-1;
    static int rear=-1;
    static int front=-1;
    static int[] stack1;
    static int[] stack2;
    public static void main(String[] args) {
        System.out.println("Enter Size Of Queue:");
        int size=input.nextInt();
        stack1=new int[size];
        stack2=new int[size];
        boolean end = true;
        while (end){
            System.out.println("Enter Your Choice!!!");
            switch (input.nextInt()){
                case 1:Menu();
                break;
                case 2:push();
                break;
                case 3:Enqueue();
                break;
                case 4:Dequeue();
                break;
                case 5:Display();
                break;
                case 6:end=false;
                break;
                default:
                    System.out.println("Invalid Input!!!");
            }
        }
    }
    public static void Menu(){
        System.out.println("Press\n" +
                "1.Menu\n" +
                "2.Push\n" +
                "3.Enqueue\n" +
                "4.Dequeue\n" +
                "5.Display\n" +
                "6.False");
    }
    public static void push(){
        if (TOS!=stack1.length-1&&rear!= stack2.length-1){
            System.out.println("Enter Element To Insert Into Stack!!!");
            TOS++;
            stack1[TOS]=input.nextInt();
        }else System.out.println("Stack OverFlow!!!");
    }
    public static void Enqueue(){
        if (TOS==-1)
         System.out.println("Please Perform Push Operation or Dequeue Operation Before Enqueue!!!");
        else {
            if (rear==stack2.length-1)
                System.out.println("Queue OverFlow!!!");
            else {
                if (front == -1 && rear == -1) {
                    front = 0;
                    rear++;
                    System.out.println("Element "+stack1[TOS]+" Successfully Entered Into Queue...");
                    stack2[rear] = stack1[TOS];
                    TOS--;
                } else {
                    rear++;
                    System.out.println("Element "+stack1[TOS]+" Successfully Entered Into Queue!!!");
                    stack2[rear] = stack1[TOS];
                    TOS--;
                }
            }
        }
    }
    public static void Dequeue(){
        if (rear==-1)
            System.out.println("Queue UnderFlow!!!");
        else if (rear==front){
            System.out.println(stack2[front]+" Is Successfully Removed From Queue!!!");
            rear=-1;
            front=-1;
        }
        else{
            System.out.println(stack2[front]+" Is Successfully Removed From Queue!!!");
            front++;
        }
    }
    public static void Display(){
        if (rear!=-1){
            System.out.print("Elements Present In Queue Is: ");
            for (int i=front;i<=rear;i++){
                System.out.print(stack2[i]+" ");
            }
            System.out.println();
        }else System.out.println("Queue Is Empty Please Perform Enqueue Operation Before Displaying The Queue!!!");
    }
}