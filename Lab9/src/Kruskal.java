/* 8 Kruskals */

import java.util.Scanner;
public class Kruskal{
    int n,cost[][],u,v,mincost,parent[];
    Kruskal(int size){
        n=size;
        cost = new int[n+1][n+1];
        parent=new int[n+1];
    }
    void read(){
        Scanner in =new Scanner(System.in);
        System.out.println("enter cost matrix: ");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                cost[i][j] = in.nextInt();
            }
        }
        for(int i=1;i<=n;i++)
            parent[i]=-1;

    }
    void kruskal(){
        int ne=1;
        while(ne<n)
        {
            int min=999;
            for(int i=1;i<=n;i++)
            {
                for(int j=i+1;j<=n;j++)
                {
                    if(min>cost[i][j])
                    {
                        min=cost[i][j];
                        u=i;v=j;
                    }
                }
            }
            if(min==999){
                System.out.println("No spanning tree");
                System.exit(0);
            }
            int a=find(u);
            int b=find(v);
            if(a!=b)
            {
                ne=ne+1;
                System.out.println(u+"-->"+v);
                mincost=mincost+cost[u][v];
                union(a,b);
            }
            cost[u][v]=cost[v][u]=999;
        }
        System.out.println("minimum cost is: "+mincost);
    }
    void union(int i,int j){
        if(i<j)
            parent[j]=i;
        else
            parent[i]=j;
    }
    int find(int i){
        while(parent[i]>=0)
        {
            i=parent[i];
        }
        return i;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("enter size: ");
        int n=in.nextInt();
        Kruskal a=new Kruskal(n);
        a.read();
        a.kruskal();
    }
}
/*enter size:
7
enter cost matrix:
0 28 999 999 999 10 999
28 0 16 999 999 999 14
999 16 0 12 999 999 999
999 999 12 0 22 999 18
999 999 999 22 0 25 24
10 999 25 999 25 0 999
999 14 24 18 24 999 0
1-->6
3-->4
2-->7
2-->3
4-->5
5-->6
minimum cost is: 99
*/