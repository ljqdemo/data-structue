package com.yc.AlgorithmAndAnalyze;

/**
 * @auther LJQ
 * @create 2020 - 07-05-15:06
 */
public class ex5_2 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法，并输出每种跳法具体怎么跳

     */
    public static int p[]=new int [100]; //解空间 p[x]表示当前条一遍还是2步:1 2
    
    
    public static int tot=0;
    /**
     *
     * @param n  n阶
     *
     *@param t 当前事第几次
     */
    public static void  find(int n,int t,int sum){
        if(t>n-1||sum>n-1){
            if (sum==n) {
                for(int i=0;i<n;i++){
                    if(p[i]==1){
                        System.out.print(1+"-> "); 
                    }if (p[i]==2){
                        System.out.print(2+"-> "); 
                    }
                }
                System.out.println();
                tot++;
            }

            return ;
        }
            //取2
              p[t]=2;
        find(n,t+1,sum+2);
            //取1
          p[t]=1;
       find(n,t+1,sum+1);

    }

    public static void main(String[] args) {
        find(6,0,0);
        System.out.println("共有"+tot+"种跳法");
    }
}
