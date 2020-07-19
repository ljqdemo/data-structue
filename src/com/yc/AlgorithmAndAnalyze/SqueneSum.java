package com.yc.AlgorithmAndAnalyze;

public class SqueneSum {
	/**
	 * 求最大字段和
	 * 1 -1 2 2 3-3 4 -4 
	 * 划分子问题
	 * 1     dp[0]            dp[1]           dp[0]=Max{dp[1]+1,ar[i]}
	 * 1 -1                  -1              状态转化方程 ===>dp[i]=Max{dp[i+1]+ar[i],ar[i]}
	 * 1 -1 2                -1 2
	 * 1 -1 2 2 		     -1 2 2 
	 * 1 -1 2 2 3            -1 2 2 3
	 * 1 -1 2 2 3-3          -1 2 2 3-3         .....
	 * 1 -1 2 2 3-3 4        -1 2 2 3-3 4
	 * 1 -1 2 2 3-3 4 -4     -1 2 2 3-3 4 -4 
	 * @param args
	 */

	//递归函数
	public static int  dp( int index,int[] arr) {
		if(index<0||index>arr.length) {
			return -8888888;
		}
			if(index==arr.length-1) {
				return arr[index];
				
			}else {
				if(arr[index]>arr[index]+dp(index+1,arr)) {
					return arr[index];
				}
				return arr[index]+dp(index+1,arr);
			}
		
			
	}
	
	public static void main(String[] args) {
		
		int [] arr= {1, -1 ,2 ,2 ,3,-3 ,4 ,-4 };
		int max=0;
		int maxflage=0;
		for(int i=0;i<arr.length;i++) {
			if(max<dp(i,arr)) {
				max=dp(i,arr);
				maxflage=i;
				//System.out.println(max);
			}
		}
		int temp=0;
		 for(int i=maxflage;i<arr.length;i++) {
			 if(temp>0) {
				temp= max-arr[maxflage];
				System.out.print(temp);
			 }
			
		 }
		System.out.println("Max:"+max);
	}

}
