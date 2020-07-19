package com.yc.java;

/**
 * @auther LJQ
 * @create 2020 - 07-05-11:11
 */
public class MaxNumber {

    //返回�?大数
    public static  int getMax(int [] numbers){

        String result="";
        int i=0;
        while (i+1<numbers.length) {
            String s1=numbers[i]+""+numbers[i+1];
            String s2=numbers[i+1]+""+numbers[i];
            int result1=Integer.parseInt(s1);
            int  result2 = Integer.parseInt(s2);
            //返回�?大�??
            if(result1>result2){
                result+= s1;
            }else{
                result+=s2;
            }
            i=i+2;
            if(i+3>numbers.length&&i+2<numbers.length){
                result+=numbers[i+2];
                break;
            }
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {

        int []s={12,123};
       System.out.println(getMax(s));

    }
}
