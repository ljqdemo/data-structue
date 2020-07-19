package com.yc.AlgorithmAndAnalyze;

/**
 * 动态规划解决0-1背包问题
 * @author 29226
 *
 */
public class Knapsack0And1 {

	
	public static int []flag=new int [9];
	/**
	 *    f[i,j]=max{f[i-1,j-weght[i]]+value[i], f[i-1,j]} 
	 * @param weight   物品重量
	 * @param value    物品价值
	 * @param knapsack  背包容量
	 */
	public static int[][] get0_1knapsack(int [] weight,int [] value,int knapsack) {
		//构建动态规划的表
		int [][] chart=new int [weight.length][knapsack+1];
		for(int i=1, n=weight.length;i<n;++i) {
			for(int j=1;j<=knapsack;++j) {
				if(j<weight[i]) {
					//背包装不下当前的物品
					chart[i][j]=chart[i-1][j];
					
				}else {
					/**
					 * 能装下第当前物品 此时有两种选择，装下和不装下 
					 * 装下：chart[i-1][j-weight[i]]+value[i]
					 *不装下：chart[i-1][j]
					 */
					chart[i][j]=Math.max(chart[i-1][j-weight[i]]+value[i],chart[i-1][j]) ;
					
				}
			}
			
		}
		
		return chart;
		
	}
	//测试
	public static void main(String[] args) {
		int [] weight= {0 , 2 , 3 , 4 , 5};
		
		int []  value= {0 , 3 , 4 , 5 , 6};
		int knapsack=8;
		int chart[][]=get0_1knapsack(weight,value,knapsack);
		
		
		System.out.println("最大值为："+chart[chart.length-1][chart[0].length-1]);
		
		int i=chart.length-1;
		int j=chart[0].length-1;
		while(i>0) {
			if(chart[i][j]==chart[i-1][j] ){ 
				flag[i]=0;
			}else {
				flag[i]=0;
				System.out.println("拿了"+i);
				j-=weight[i];
			}
			i--;
		}
	}

}
