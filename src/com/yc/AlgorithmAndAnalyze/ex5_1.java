package com.yc.AlgorithmAndAnalyze;

/**
 * @auther LJQ
 * @create 2020 - 07-05-14:07
 */
public class ex5_1 {
    /**
     * .����n��������wi��һ��������m��
     * ����n�����������ҳ�һ���Ӽ���ʹ���Ӽ��е�������֮�͵���m

     */
    public static int x[]=new int [1000]; //x[i]// ��ʾ��i��Ԫ��ȡ���߲�ȡ:0 1

    /**
     * ��֦����
     * @param t
     * @param n
     * @param sum
     * @return
     */
    public static int getLastSum(int numbers[],int t,int n,int sum){
            int result=0;
        for(int i=t;i<numbers.length;i++){
                    result+=numbers[i];
        }
        return result+sum;

    }

    public static void finsub(int numbers[],int m,int n,int sum,int t){

        if(t>n-1){
            if(sum==m){
                for(int i=0;i<n;i++){
                    if(x[i]==0){
                        System.out.print(numbers[i]+" " );
                    }
                }
                System.out.println();
            }
            return;
        }else{
            //��ȡ�����
            x[t]=1;

            finsub( numbers, m, n, sum, t+1);
            //0��ʾȡ�����
            x[t]=0;
            if(getLastSum(numbers,t,n,sum)>m)
                finsub( numbers, m, n, sum+numbers[t], t+1);
        }

    }
    public static void main(String[] args) {
        int [] wi={1,4,9,5,7,3,6,8,12};
        finsub(wi,9,9,0,0);
    }
}
