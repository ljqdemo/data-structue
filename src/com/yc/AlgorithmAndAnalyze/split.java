package com.yc.AlgorithmAndAnalyze;

//���������󻮷������ݹ��㷨
public class split {
	/**
	 * 	
	 * @param n �����ֵ�����
	 * @param max ���ļ���
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
		//�����ļ���Ϊһ��ʱ����߱����ֵ�����Ϊ1ʱ��ֻ��һ�ֻ��ֵķ�ʽ ��ȫΪһ
		if(n==1||max==1) {
			return 1;
		}
		//���ļ���Ϊ0��ʱ�򻮷ַ�ʽҲֻ��һ�� �� n
		if(max==0) {
			return 1;
		}
		//��max=n ��ʱ�� Ϊsp(n,max-1)+sp(n,0) 
		if(max==n) {
			return sp(n,max-1)+1;
		}
		//����ж�
		if(max>n) {
			return sp(n,n);
		}
		//����Ϊn>max�����
		return sp(n,max-1)+sp(n-max,max);
			
	}
	
	public static void main(String[] args) {
		System.out.println("6������������"+sp(6,6));
		Integer s=new Integer(1);
	
	}

}
