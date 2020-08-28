import java.util.Scanner;
public class QueueImplementation {
    static  Scanner input = new Scanner(System.in);
    static int[] queue;
    static int front=-1;
    static int rear=-1;
    public static void main(String[] args) {
        System.out.println("Enter Size Of Queue:");
        int size=input.nextInt();
        queue=new int[size];
        boolean go=true;
        while (go){
            System.out.println("Enter your choice:");
            int choice=input.nextInt();
            switch (choice){
                case 1: Menu();break;
                case 2:Enqueue();break;
                case 3:Dequeue();break;
                case 4:Display();break;
                case 5:go=false;break;
                default:System.out.println("Wrong Input");
            }
        }
    }
    public static void Menu(){
        System.out.println("Press\n" +
                "1.Menu\n" +
                "2.Enqueue\n" +
                "3.Dequeue\n" +
                "4.Display\n" +
                "5.Exit\n");
    }
    public static void Enqueue(){
        if (rear==queue.length-1){
            System.out.println("Queue overflow!!!");
        }
        else{
            if (rear==-1&&front==-1){
                front++;
                rear++;
                System.out.println("Enter Element To Insert in Queue!!!");
                queue[rear]=input.nextInt();
            }else {
                rear++;
                System.out.println("Enter Element To Insert in Queue...");
                queue[rear]=input.nextInt();
            }
        }
    }
    public static void Dequeue() {
            if (front==-1)
                System.out.println("Queue Underflow!!!");
            else if (front==rear){
                rear=-1;
                front=-1;
                System.out.println("Element Is Removed Successfully!!!");
            }
            else
            {
                front++;
                System.out.println("Element Is Removed Successfully...");
            }
    }
    public static void Display(){
        if (front!=-1) {
            for (int i = front; i <=rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
        else
        {
            System.out.println("Queue is Empty!!!");
        }
    }
}