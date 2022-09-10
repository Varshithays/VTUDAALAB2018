/*3a Exception */

import java.util.Scanner;
class Exception3a {

    public static void main(String[] args){
        int a,b,c;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        a= in.nextInt();
        System.out.println("Enter the value of b: ");
        b=in.nextInt();
        try{
            c=a/b;
            System.out.println("the result is "+ c);
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
    }
}

