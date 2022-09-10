import java.util.StringTokenizer;
import java.util.Scanner;

class Customer {
    String Name;
     String DOB;
    Customer(String n, String d)
    {
        Name=n;
        DOB=d;
    }
    public String toString()
    {
        String returnValue=Name;
        StringTokenizer tokenizer= new StringTokenizer(DOB,"/");
        System.out.println("The Customer details are ");
        while(tokenizer.hasMoreTokens())
        {
            returnValue=returnValue+","+tokenizer.nextToken();
        }
        return returnValue;
    }
    void print(){
        System.out.println(toString());
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter customer name");
        String n=scanner.next();
        System.out.println("Enter Date (dd/mm/yyyy)");
        String d=scanner.next();
        Customer a= new Customer(n,d);
        a.print();
    }
}