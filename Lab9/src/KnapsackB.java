/*6b Greedy knapsack */

import java.util.Scanner;
class KnapsackB{
    int n;
    int sum=0;
    int  M;
    int w[];
   int p[];
   int x[];
    KnapsackB(int size){
        n=size;
        p=new int[n+1];
        w=new int[n+1];
        x=new int[n+1];
    }
    void knap()
    {
      int Rc=M;
        for(int i=1;i<=n;i++){
            x[i]=0;
        }
        for(int i=1;i<=n;i++){
            if(w[i]<=Rc)
            {
                x[i]=1;
                Rc=Rc-w[i];
            }
            else{
                Rc=Rc/w[i];
            }
        }

    }
    void read()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the maximaum capacity: ");
        M=in.nextInt();
        System.out.println("Enter the profit of each object:");
        for(int i=1;i<=n;i++)
        {
            p[i]=in.nextInt();
        }
        System.out.println("Enter the weights: ");
        for(int i=1;i<=n;i++)
        {
            w[i]=in.nextInt();
        }
    }
    void display(){
        System.out.println("The profit is : ");
        for(int i=1; i<=n;i++)
        {
            sum+=p[i] * x[i];
        }
        System.out.println(sum);
        System.out.println("solution vector  is : ");
        for(int i=1;i<=n;i++)
        {
            System.out.println(x[i]);
        }
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in) ;
        System.out.println("Enter the no elements: ");
        int num = in.nextInt();
        KnapsackB a = new KnapsackB(num);
        a.read();
        a.knap();
        a.display();

    }

}
/*Enter the no elements:
3
Enter the maximaum capacity:
20
Enter the profit of each object:
24
15
25
Enter the weights:
15
10
18
The profit is :
24
solution vector  is :
1
0
0*/