package com.yc.AlgorithmAndAnalyze;

/**
 * ��̬�滮���0-1��������
 * @author 29226
 *
 */
public class Knapsack0And1 {

	
	public static int []flag=new int [9];
	/**
	 *    f[i,j]=max{f[i-1,j-weght[i]]+value[i], f[i-1,j]} 
	 * @param weight   ��Ʒ����
	 * @param value    ��Ʒ��ֵ
	 * @param knapsack  ��������
	 */
	public static int[][] get0_1knapsack(int [] weight,int [] value,int knapsack) {
		//������̬�滮�ı�
		int [][] chart=new int [weight.length][knapsack+1];
		for(int i=1, n=weight.length;i<n;++i) {
			for(int j=1;j<=knapsack;++j) {
				if(j<weight[i]) {
					//����װ���µ�ǰ����Ʒ
					chart[i][j]=chart[i-1][j];
					
				}else {
					/**
					 * ��װ�µڵ�ǰ��Ʒ ��ʱ������ѡ��װ�ºͲ�װ�� 
					 * װ�£�chart[i-1][j-weight[i]]+value[i]
					 *��װ�£�chart[i-1][j]
					 */
					chart[i][j]=Math.max(chart[i-1][j-weight[i]]+value[i],chart[i-1][j]) ;
					
				}
			}
			
		}
		
		return chart;
		
	}
	//����
	public static void main(String[] args) {
		int [] weight= {0 , 2 , 3 , 4 , 5};
		
		int []  value= {0 , 3 , 4 , 5 , 6};
		int knapsack=8;
		int chart[][]=get0_1knapsack(weight,value,knapsack);
		
		
		System.out.println("���ֵΪ��"+chart[chart.length-1][chart[0].length-1]);
		
		int i=chart.length-1;
		int j=chart[0].length-1;
		while(i>0) {
			if(chart[i][j]==chart[i-1][j] ){ 
				flag[i]=0;
			}else {
				flag[i]=0;
				System.out.println("����"+i);
				j-=weight[i];
			}
			i--;
		}
	}

}
