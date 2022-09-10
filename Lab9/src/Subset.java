/*SUM of SUbsets*/
import java.util.Scanner;

class SubSet
{
    static int c;
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter no of elements ");
        int n=s.nextInt();
        int sum=0;
        System.out.println("Enter elements ");//Input the elements and calculate the sum of them
        int w[]=new int[n];
        for(int i=0;i<n;i++)
        {	w[i]=s.nextInt();
            sum+=w[i];
        }
        int x[]=new int[n];

        System.out.println("Enter the requried sum : ");
        int d= s.nextInt();
        c=0;//count  var
        //calculation of sum,already done in above input loop
        //Check if sum is smaller than the requried sum or if the first element itself is greater than the sum
        if(sum<d || w[0]>d)
            System.out.println("NO SOLUTION");//then no possible sol exists
        else //Else call the function
            subset(0,0,sum,x,w,d);
        if(c==n-1)//if there is no solution even after all reursions
            System.out.println("NO SOLUTION");
    }
    static void subset(int cs,int k,int r,int x[],int w[],int d)
    {
        x[k]=1;//Pick k'th element
        c++;
        //If current sum + next element = requried solution we Print out the w[i] for which x[i]=1;
        if(cs + w[k]==d)
        {
            System.out.println("Solution");
            for(int i=0;i<=k;i++)
            {
                if(x[i]==1)
                    System.out.println(w[i]);
            }
        }
        //If current sum + next-next(k+1)'th element is less than requried sum then we include the next element(k) and recurse with k+1
        else if(cs+w[k]+w[k+1]<=d)
        {
            subset(cs+w[k],k+1,r-w[k],x,w,d);
        }
        //If including next element(k) from remaining excedes req sum but the next-next(k+1)th element can be included not to exceed req sum
        if(cs+r-w[k]>=d && cs+w[k+1]<=d)
        {
            x[k]=0;//Then exculde the selected , next element(k)
            subset(cs,k+1,r-w[k],x,w,d);//recurse without adding w[k] to cs
        }
    }
}
