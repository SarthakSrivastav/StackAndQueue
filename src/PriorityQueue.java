import java.util.Scanner;
public class PriorityQueue {
    static Scanner input = new Scanner(System.in);
    static int[] queue;
    static int front = -1;
    static int rear = -1;
    static String choice;
    public static void main(String[] args) {
        System.out.println("Enter The Size Of The Queue:");
        queue = new int[input.nextInt()];
        boolean exit = false;
        System.out.println("Enter Your Priority:\n" +
                "A.For Ascending Order\n" +
                "D.For Descending Order");
         choice = input.next();
        if (choice.equals("A") || choice.equals("D")) {
            while (!exit) {
                System.out.println("Enter Your Choice from 1 to 5:");
                switch (input.nextInt()) {
                    case 1:menu();break;
                    case 2: Enqueue();break;
                    case 3: Dqueue();break;
                    case 4: display();break;
                    case 5: exit = true;break;
                    default:
                        System.out.println("Invalid Input...");
                }
            }
        } else System.out.println("Invalid Input Please Select Either 'A' or 'D'");
    }
    public static void menu(){
        System.out.println("Press\n" +
                "1.Menu\n" +
                "2.Enqueue\n" +
                "3.Dequeue\n" +
                "4.Display\n" +
                "5.Exit");
    }
    public static void Enqueue() {
        if (rear != queue.length - 1) {
            if (front == -1 && rear == -1) {
                front++;
                rear++;
                System.out.println("Enter Element To Insert Into Queue:");
                queue[rear] = input.nextInt();
            } else {
                rear++;
                System.out.println("Enter Element To Insert Into Queue:");
                queue[rear] = input.nextInt();
                int min, temp;
                for (int i = front; i <= rear; i++) {
                    min = i;
                    for (int j = i + 1; j <= rear; j++) {
                        if (choice.equals("A")) {
                            if (queue[j] < queue[min])
                                min = j;
                        }
                        if (choice.equals("D")) {
                            if (queue[j] > queue[min])
                                min = j;
                        }
                    }
                    temp = queue[i];
                    queue[i] = queue[min];
                    queue[min] = temp;
                }
            }

        } else System.out.println("Queue Overflow!!!");
    }
    public static void Dqueue() {
        if (front != -1 && rear != -1) {
            if (front == rear) {
                System.out.println(queue[front] + " is removed successfully!");
                front = -1;
                rear = -1;
            } else {
                System.out.println(queue[front] + " is removed successfully!");
                front++;
            }
        } else System.out.println("Queue Underflow!!!");
    }
    public static void display() {
        if (front != -1 && rear != -1) {
            for (int i = front; i <= rear; i++)
                System.out.print(queue[i] + " ");
            System.out.println();
        } else System.out.println("Queue Is Empty!");
    }
}