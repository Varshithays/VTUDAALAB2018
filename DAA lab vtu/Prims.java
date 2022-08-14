import java.util.Scanner;
class Prims {
    int n,mincost=0;
    int cost[][];
    int d[];
    int t[][];
    int k,l;
    int v;
    Prims(int size){
        n=size;
        cost=new int[n+1][n+1];
        d=new int[n+1];
        t=new int[n-1][2];
    }

    void read(){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the cost adj matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=in.nextInt();
            }
        }
    }
    void display(){
        System.out.println("the edge selected:  ");
        for(int i=0;i<n-1;i++){
            System.out.println(t[i][0]+",");
            System.out.println(t[i][i]);
            System.out.println();
        }
    }
    /**
     * 
     */
    void prims(){
        int min;
        k=0;l=0;
        for( int i=1; i<n;i++){
             for(int j=1;j<n;j++){
                if(cost[i][j] >=i min){
                    min=cost[i][j];
                    k=i;l=j;
                    for(int i=1;i<n;i++){
                        
                    }
                }
             }
        }
    }
    public static void mian(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the size of matrix: ");
        int n = in.nextInt();
    }

}
