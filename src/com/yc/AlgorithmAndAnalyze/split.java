package com.yc.AlgorithmAndAnalyze;

//整数划分求划分总数递归算法
public class split {
	/**
	 * 	
	 * @param n 被划分的整数
	 * @param max 最大的加数
	 * @return
	 * 6(6+0)    					p(6,0)
	 * 5+1							p(1,5)
	 * 4+2 4+1+1					p(2,4)
	 * 3+3 3+2+1 3+2+1+1  			p(3,3)
	 * 2+2+2 2+2+1+1 2+1+1+1+1  	p(4,2)
	 * 1+1+1+1+1+1   				p(5,1)
	 * 
	 * 
	 * 
	 */
	public static int sp(int n,int max) {
		//当最大的加数为一的时候或者被划分的整数为1时都只有一种划分的方式 即全为一
		if(n==1||max==1) {
			return 1;
		}
		//最大的加数为0的时候划分方式也只有一种 即 n
		if(max==0) {
			return 1;
		}
		//当max=n 的时候 为sp(n,max-1)+sp(n,0) 
		if(max==n) {
			return sp(n,max-1)+1;
		}
		//溢出判断
		if(max>n) {
			return sp(n,n);
		}
		//这是为n>max的情况
		return sp(n,max-1)+sp(n-max,max);
			
	}
	
	public static void main(String[] args) {
		System.out.println("6的整数划分数"+sp(6,6));
		Integer s=new Integer(1);
	
	}

}
