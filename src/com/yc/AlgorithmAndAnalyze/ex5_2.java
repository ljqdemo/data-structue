package com.yc.AlgorithmAndAnalyze;

/**
 * @auther LJQ
 * @create 2020 - 07-05-15:06
 */
public class ex5_2 {
    /**
     * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
     * �����������һ��n����̨���ܹ��ж����������������ÿ������������ô��

     */
    public static int p[]=new int [100]; //��ռ� p[x]��ʾ��ǰ��һ�黹��2��:1 2
    
    
    public static int tot=0;
    /**
     *
     * @param n  n��
     *
     *@param t ��ǰ�µڼ���
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
            //ȡ2
              p[t]=2;
        find(n,t+1,sum+2);
            //ȡ1
          p[t]=1;
       find(n,t+1,sum+1);

    }

    public static void main(String[] args) {
        find(6,0,0);
        System.out.println("����"+tot+"������");
    }
}
