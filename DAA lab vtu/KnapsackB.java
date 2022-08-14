import java.util.Scanner;
class KnapsackB{
    int N;
   int sum=0;
    int M;
    int w[];
    int p[];
    int x[];
    KnapsackB(int n){
        N=n+1;
        p=new int[n+1];
        w=new int[n+1];
        x=new int[n+1];
    }
    void knap()
    {
        int Rc=M;
        for(int i=1;i<N;i++){
            x[i]=0;
        }
        for(int i=1;i<N;i++){
        if(w[i]<=Rc)
        {
            x[i]=1;
            Rc=Rc-w[i];
        }
    }
        
    }
    void read()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the maximaum capacity: ");
        M=in.nextInt();
        System.out.println("Enter the profit of each object:");
        for(int i=1;i<N;i++)
        {
            p[i]=in.nextInt();
        }
        System.out.println("Enter the weights: ");
        for(int i=1;i<N;i++)
        {
            w[i]=in.nextInt();
        }
    }
    void display(){
        System.out.println("The profit is : ");
        for(int i=1; i<N;i++){
            sum=sum+p[i]*x[i];
        }
        System.out.println(sum);
        System.out.println("solution vector  is : ");
        for(int i=1;i<N;i++){
            System.out.println(x[i]);
        }
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in) ;
        System.out.println("Enter the no elements: ");
        int N = in.nextInt();
        KnapsackB a = new KnapsackB(N);
        a.read();
        a.knap();
        a.display();
        
    }
    
}
