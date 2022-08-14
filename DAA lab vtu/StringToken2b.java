 import java.util.Scanner;
 import java.util.StringTokenizer;
 class Customer{
    String name;
    String DOB;
    Customer(String n,String d){
        name=n;
        DOB=d;
    }
public String toString()
{
    String  returnvalue = name;
    StringTokenizer = new StringTokenizer(DOB , "/");
    System.out.println("the customer details are: ");
    while(tokenizer.hasMoreTokens()){
        returnvalue=returnvalue=","+tokenizer.nextToken();
    }
    return returnvalue;
    }
    void print(){
        System.out.println(toString());
    }
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("enter the name ");
        String n =in.nextLine();
        System.out.println("enter the DOB ");
        String d =in.nextLine();
       Customer a = new Customer(n,d);
        a.print();
    }
}
