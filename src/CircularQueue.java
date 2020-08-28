import java.util.Scanner;
public class CircularQueue {
    static Scanner input = new Scanner(System.in);
    static int[] cQueue;
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {
        System.out.println("Enter size of Queue:");
        cQueue = new int[input.nextInt()];
        boolean exit = true;
        while (exit) {
            System.out.println("Enter Your Choice:");
            switch (input.nextInt()) {
                case 1:Menu();break;
                case 2:enqueue();break;
                case 3:dequeue();break;
                case 4:display();break;
                case 5:exit=false;break;
                default:
                    System.out.println("Invalid Input");
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
    public static void enqueue() {
        if (rear == front - 1)
            System.out.println("Queue OverFlow!!!");
        else {
            if (front == -1 && rear == -1) {
                front++;
                rear++;
                System.out.println("Enter Element To Insert Into Queue:");
                cQueue[rear] = input.nextInt();
                System.out.println("Element Successfully Added!!!");
            }
            else    {
                rear++;
                System.out.println("Enter Element To Insert Into Queue:");
                cQueue[rear]=input.nextInt();
                System.out.println("Element Successfully Added!!!");
                if (rear== cQueue.length-1)
                    rear=-1;
            }
        }
    }
    public static void dequeue(){
        if (front==-1)
            System.out.println("Queue UnderFlow!!!");
        else if (front==rear){
            System.out.println("Element "+cQueue[front]+" is removed successfully!");
            front=-1;
            rear=-1;
        }
        else if (front== cQueue.length-1) {
            System.out.println("Element " + cQueue[front] + " is removed successfully!!");
            front = 0;
        }
        else {
            System.out.println("Element "+cQueue[front]+" is removed successfully!!!");
            front++;
        }
    }
    public static void display(){
        if (front!=-1) {
            if (front <= rear) {
                for (int i = front; i <= rear; i++)
                    System.out.print(cQueue[i] + " ");
                System.out.println();
            } else {
                for (int i = front; i < cQueue.length; i++)
                    System.out.print(cQueue[i] + " ");
                for (int i = 0; i <= rear; i++)
                    System.out.print(cQueue[i] + " ");
                System.out.println();
            }
        }else System.out.println("Queue Is Empty!!!");
    }
}