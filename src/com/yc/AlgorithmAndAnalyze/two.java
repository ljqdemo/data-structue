package com.yc.AlgorithmAndAnalyze;

import java.util.Scanner;

public class two {

	public static int JumpFloor(int target) {
	       int sum=0;
	       int  f1=1;
	       int  f2=2;
	       if(target==0) {
	    	   return 0;
	       }
	       else if(target==1) {
	    	   return 1;
	       }
	       else if(target==2) {
	    	   return 2;
	       }
	       else {
	       for(int i=2;i<target;i++)
	       {
	    	   sum=f1+f2;
	    	   f1=f2;
	    	   f2=sum;
	       }
	       return sum;
	       }
	    }
		public static void main(String[] args) {
			Scanner s= new Scanner(System.in);
			System.out.println("输入台阶数:");
			int t=s.nextInt();
			System.out.println("共"+(JumpFloor(t))+"种方法");

		}
}
