/* 12. Hamiltonian cycle */

import java.util.Scanner;
public class Hamiltonian {

    int G[][];
    int x[];
    int n;
    Hamiltonian(int n){
        this.n=n;
        G = new int[n + 1][n + 1];
        x = new int[n + 1];
        x[1]=1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the size: ");
        int n = in.nextInt();
        Hamiltonian a= new Hamiltonian(n);
        a.read();
        System.out.println("\t\t\tHamiltonian Cycle");
        a.HamiltonianMethod(2);
    }

    void read() {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter tha adj matrix \n");
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++) {

                G[j][i] = G[i][j] = in.nextInt();
            }
        }
    }

    void HamiltonianMethod(int k) {
        do {
            NextValue(k, G, x, n);
            if (x[k] == 0)
                return;
            if (k == n) {
                System.out.println("Cycle");
                for (int i = 1; i <= k; i++)

                    System.out.print(x[i] + " ");
                System.out.print(1);
                System.out.println();
            } else{
                HamiltonianMethod(k + 1);
            }
        }while(true);
    }

    void NextValue(int k, int G[][], int x[], int n)
    {
        while (true)
        {
            x[k] = (x[k] + 1) % (n + 1);
            if (x[k] == 0)
                return;
            if (G[x[k - 1]][x[k]] != 0)
            {
                int j;
                for (j = 1; j < k; j++)
                {
                    if (x[k] == x[j])
                        break;
                }
                if (j == k)
                    if ((k < n) || ((k == n) && G[x[n]][x[1]] != 0))
                    {
                        return;
                    }
            }
        }
    }
}
/*4
0 1 1 1
1 0 1 1
1 1 0 1
1 1 1 0
//8
0 1 1 0 0 0 1 0
1 0 1 0 0 0 0 1
1 1 0 1 0 1 0 0
0 0 1 0 1 0 0 0
0 0 0 1 0 1 0 0
0 0 1 0 1 0 1 0
1 0 0 0 0 1 0 1
0 1 0 0 0 0 1 0
 */