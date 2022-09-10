/* 1b. Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and Display() methods to demonstrate its working.
 */
import java.util.Scanner;

class Stack
{
    int arr[];
    int top, max;

    Stack(int size){
        max = size;
        arr = new int[size];
        top = -1;
    }

    void push(int i) {
        if (top == max - 1)
            System.out.println("Stack Overflow");
        else
            arr[++top] = i;
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            int element = arr[top--];
            System.out.println("Popped Element:  " + element);
        }
    }

    void display() {
        System.out.print("\nStack = ");
        if (top == -1) {
            System.out.print("Empty\n");
            return;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Size of Integer Stack ");
        int n = scan.nextInt();

        Stack stk = new Stack(n);

        char ch;
        for(;;)
        {
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. display");
            System.out.println("4. Exit");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter element to push");
                    stk.push(scan.nextInt());
                    break;

                case 2:
                    stk.pop();
                    break;

                case 3:
                    stk.display();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;

            }

        }
    }
}