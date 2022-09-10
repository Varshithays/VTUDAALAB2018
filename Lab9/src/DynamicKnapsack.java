/*6a knapsack dynamic */
import java.util.Scanner;
public class DynamicKnapsack {
    int n,m,p[],w[],v[][],x[];

    DynamicKnapsack(int size,int max) {
        n=size;
        m=max;
        w = new int[n + 1];
        v = new int[n + 1][max + 1];
        p = new int[n + 1];
        x=new int[n+1];
    }
    void read(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the weights in decreasing order of v/w: ");
        for(int i=1; i<=n;i++)
            w[i]=in.nextInt();

        System.out.println("Enter the profit in decreasing order of v/m: ");
        for(int i=1;i<=n;i++)
            p[i]=in.nextInt();
    }

    void knap()
    {
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                if(i==0||j==0)
                    v[i][j] = 0;
                else if (w[i] > j)
                    v[i][j] = v[i - 1][j];

                else {
                   if((v[i - 1][j])>(v[i-1][j-w[i]]+p[i]))
                        v[i][j]=v[i-1][j];

                    else
                        v[i][j] = v[i - 1][j - w[i]] + p[i];
                }
            }
        }
        int j=m;
        for(int i=1;i<=n;i++)
        {
            if(v[i][j]==v[i-1][j])
                x[i]=0;
            else
            {
                x[i]=1;
                j=j-w[i];
            }
        }
    }

    void display(){
        System.out.println("profit is "+v[n][m]);
        for(int i=1;i<=n;i++)
            System.out.println(x[i]+"\t");
           System.out.println();
    }
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter no item :");
        int num=in.nextInt();
        System.out.println("Enter capacity: ");
        int max=in.nextInt();
        DynamicKnapsack a=new DynamicKnapsack(num,max);
        a.read();
        a.knap();
        a.display();
    }
}

