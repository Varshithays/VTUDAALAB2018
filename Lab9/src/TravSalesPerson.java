/*10a Travelling sales person */

/*
Traveling Sales Person Problem using Dynamic Programming
========================================================
Exapmple Graph:
==============
			0, 10, 15, 20
                       10, 0, 35, 25
                        15, 35, 0, 30
                        20, 25, 30, 0

Example output:
==============
No of vertices
4
Enter cost matrix
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0
1
2
4
3
Cost=80
========================================================
*/
import java.util.Scanner;
public class TravSalesPerson {
    static int MAX = 100;
    static final int infinity = 999;
    public static void main(String args[]) {
        int cost = infinity;
        int c[][] = new int[MAX][MAX]; // cost matrix
        int tour[] = new int[MAX]; // optimal tour
        int n; // max. cities
        System.out.println("Travelling Salesman Problem using DynamicProgramming\n");
        System.out.println("Enter number of cities: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        System.out.println("Enter Cost matrix:\n");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                c[i][j] =in.nextInt();
                if (c[i][j] == 0)
                    c[i][j] = 999;
            }
        for (int i = 0; i < n; i++)
            tour[i] = i;
        cost = tspdp(c, tour, 0, n);
// print tour cost and tour
        System.out.println("Minimum Tour Cost: " + cost);
        System.out.println("\nTour:");
        for (int i = 0; i < n; i++) {
            System.out.print(tour[i] + " -> ");
        }
        System.out.println(tour[0] + "\n");
    }
    static int tspdp(int c[][], int tour[], int start, int n) {
        int i, j, k;
        int temp[] = new int[MAX];
        int mintour[] = new int[MAX];
        int mincost;
        int cost;
        if (start == n - 2)
            return c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0];
        mincost = infinity;
        for (i = start + 1; i < n; i++)
        {
            for (j = 0; j < n; j++)
                temp[j] = tour[j];

            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];
            if (c[tour[start]][tour[i]] + (cost = tspdp(c, temp, start + 1, n)) < mincost) {
                mincost = c[tour[start]][tour[i]] + cost;
                for (k = 0; k < n; k++)
                    mintour[k] = temp[k];
            }
        }
        for (i = 0; i < n; i++)
            tour[i] = mintour[i];
        return mincost;
    }
}

