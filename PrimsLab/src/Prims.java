/* 9 Prims */

import java.util.Scanner;
public class Prims {
    int cost[][], near[],n,mincost,d[],t[][];
    Prims(int size){
        n=size;
        cost=new int[n+1][n+1];
        near=new int[n+1];
        t=new int[n-1][2];
        d=new int[n+1];
    }
    void read(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter cost adj matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1; j<=n;j++){
                cost[i][j]=in.nextInt();
            }
        }
    }
    void prims()
    {
        int min=9999;
        int k=0;
        int  l=0;
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(cost[i][j]<min){
                    min=cost[i][j];
                    k=i;
                    l=j;
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(cost[i][k] < cost[i][l])
                near[i]=k;
            else
                near[i]=l;
            d[i]=cost[i][near[i]];
        }
        near[k] = near[l] = 0;
        mincost = cost[k][l];
        t[0][0]=k;
        t[0][1]=l;
        for(int i=1;i<=n-2;i++)
        {
            min=999;
            int j=1;
            for(int v=1;v<=n;v++){
                if(d[v]<min && near[v]!=0)
                {
                    min=d[v];
                    j=v;
                }
            }
            t[i][0]=j;
            t[i][1]=near[j];
            mincost=mincost+d[j];
            near[j]=0;
            for(int v=1; v<n;v++){
                if(near[v]!=0 && d[v]>cost[v][j]){
                    near[v]=j;
                    d[v]=cost[v][j];
                }
            }
        }

    }
    void print(){
        System.out.println("The edges of Minimum Cost Spanning Tree are:");
        for(int i=0;i<=n-2;i++){
            System.out.print(t[i][0]+",");
            System.out.print(t[i][1]);
            System.out.println();
        }
        System.out.println("mincost is "+mincost);
    }
    public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    System.out.println("Enter size: ");
    int n = in.nextInt();
    Prims a = new Prims(n);
    a.read();
    a.prims();
    a.print();
    }
}
/*6
0 10 999 30 999 999
10 0 50 999 40 25
999 50 0 999 35 15
30 999 999 0 999 20
999 40 35 999 0 55
999 25 15 20 55 0
 */