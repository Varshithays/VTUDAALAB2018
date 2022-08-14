 import java.util.Scanner;
 class Dijstkras {
    int visited[];
    int source;
    int cost[][];
    int near[];
    int n;
    int u=0,v=0;
    int d[];

    Dijstkras(int size){
        n=size;
        near=new int[n+1];
        visited=new int[n+1];
        cost=new int[n+1][n+1];
        d=new int[n+1];
    }
    void read()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the source vertex: ");
        source = in.nextInt();
        System.out.println("Enter the cost adj matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=in.nextInt();
            }
        }
    }
    void display(){
        for(int v=1;v<=n;v++){
            int i=v;
            do{
                System.out.println(v);
                System.out.print("<--");
                i=near[i];
            }while(i!=source);{
                System.out.println(source+"\tcost is:"+d[v]);
                //System.out.println();
            }
        }
    }
    void dijktra(){
        int i;
        for(i=1;i<=n;i++){
            d[i]=cost[source][i];
            near[i]=source;
            visited[i]=0;
        }
        visited[source]=1;
        for(int k=1;k<=n-2;k++){
            int min=9999;
            for(i=1;i<=n;i++){
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
    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter the size of matrix");
        int n=in.nextInt();
        Dijstkras a=new Dijstkras(n);
        a.read();
        a.dijktra();
        a.display();
    }
}
