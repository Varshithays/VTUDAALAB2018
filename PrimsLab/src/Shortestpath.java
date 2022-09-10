/*7 DJ */
import java.util.Scanner;
class Shortestpath {
    int visited[];
    int source;
    int cost[][];
    int near[];
    int n;
    int u=0,v=0;
    int d[];

    Shortestpath(int size){
        n=size;
        near=new int[n+1];
        visited=new int[n+1];
        cost=new int[n+1][n+1];
        d=new int[n+1];
    }
    void read()
    {
        Scanner in = new Scanner(System.in);
        {
            System.out.println("Enter the source vertex: ");
            source = in.nextInt();
            System.out.println("Enter the cost adj matrix: ");
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    cost[i][j]=in.nextInt();
                }
            }
        }
    }
    void display(){
        for(int v=1;v<=n;v++){
            int i=v;
            do{
                System.out.print(v);
                System.out.print("<--");
                i=near[i];
            }while(i!=source);
            System.out.println(source+"\t cost is "+d[v]);
        }
    }
    void dijktra()
    {
        for(int i=1;i<=n;i++){
            d[i]=cost[source][i];
            near[i]=source;
            visited[i]=0;
        }
        visited[source]=1;
        for(int k=1;k<=n-2;k++)
        {
            int min=9999;
            for(int i=1;i<=n;i++){
                if(visited[i]==0 && d[i]<min){
                    min=d[i];
                    u=i;
                }
            }
            visited[u]=1;
            for(int v=1;v<=n;v++)
            {
                if(visited[v]== 0 && d[u]+cost[u][v] < d[v])
                {
                    d[v]=d[u]+cost[u][v];
                    near[v]=u;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in) ;

        System.out.println("Enter the size of matrix: ");
        int n=in.nextInt();
        Shortestpath a= new Shortestpath(n);
        a.read();
        a.dijktra();
        a.display();

    }
}
/*
5,1
0 4 2 999 8
999 0 999 4 5
999 999 0 999 999
999 999 1 0 3
999 999 999 999 0

1<--1	 cost is 0
2<--1	 cost is 4
3<--1	 cost is 2
4<--2<--1   cost is 8
5<--1	 cost is 8
 */
