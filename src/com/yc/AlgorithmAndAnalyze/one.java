package com.yc.AlgorithmAndAnalyze;

public class one {
    static int M,n;
    static int[] w=new int[100];
    static int[] x=new int[100];
    public static void SumOfSub(int s, int k, int r)
    {
        int i;
        x[k]=1;
        if(s+w[k]==M) //子集找到
        {
            System.out.print("answer:");
            for(i=1; i<=k; i++)
                if(x[i]==1) System.out.print(w[i]+" ");
            System.out.println("");
        }else if(s+w[k]+w[k+1]<=M)
            SumOfSub(s+w[k], k+1, r-w[k]);
         
        if(s+r-w[k]>=M && s+w[k+1]<=M)
        {
            x[k]=0;
            SumOfSub(s, k+1, r-w[k]);
        }
    }
public static void main(String arg[])
    {
        int s,k,r;
        n=4;
        w[1]=7;
        w[2]=11;
        w[3]=13;
        w[4]=24;
        M=31;
        s=0;
        k=1;
        r=55;
        SumOfSub(s, k, r);
    }
 
}