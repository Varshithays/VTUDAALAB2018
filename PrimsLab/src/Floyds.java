/*10b FLoyd's */
import java.util.Scanner;
public class Floyds {
    int n,c[][],d[][];
    Floyds(int n){
        this.n=n;
        c=new int[n+1][n+1];
        d=new int[n+1][n+1];
    }
    void floyds()
    {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                d[i][j] = c[i][j];
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    if ((d[i][j]>d[i][k] + d[k][j]) ){
                        d[i][j] = d[i][k] + d[k][j];}
                    else{
                        d[i][j]=d[i][j];
                    }
                }
            }
        }
    }


    void read(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Cost Matrix (999 for infinity) \n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[i][j] = in.nextInt();
            }
        }

    }
    void display()
    {
        System.out.println("The All Pair Shortest Path Matrix is:\n");
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                System.out.print(d[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the size of matrix: ");
        int n=in.nextInt();
        Floyds a = new Floyds(n);
        a.read();
        a.floyds();
        a.display();
    }
}
/*//4
 * 0
999
3
999
2
0
999
999
999
7
0
1
6
999
999
0
 */