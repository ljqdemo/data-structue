package com.yc.AlgorithmAndAnalyze;

public class TrangelNumber {
	
	
	//Ѱ�����������ֵݹ��㷨
	public static int fund(int i) {
		if(i==1) {
			return 1;
			
		}else {
			return fund(i-1)+i;
		}
		
	} 
	//�ݹ���׳�
	
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}else {
			return factorial(n-1)*n;
		}
		
	}
	
	//�ݹ���۰���� ���赱ǰ������Ϊ���������)1 2 3 4 5 6 
	public static int RecFind(int low,int up,int key,int [] arr) {
		int ioc ;//�м�ָ��
		ioc=(low+up)/2;
		//�ҵ���
		if(arr[ioc]==key) {
			return ioc;
		}
		//û�ҵ�
		if(low==up) {
			return -1;
		}else {
			if(arr[ioc]>key) {
				//��ǰ������key�� Ҫ�ҵ�key�ڵ�ǰ������ǰ��
				return RecFind(low,ioc-1,key,arr);
			}else {
				//Ҫ�ҵ�key�ں���
				return RecFind(ioc+1,up,key,arr);
			}
		}
		
	}
	
		//����
	public static void main(String []srg) {
		System.out.println("��һ����"+fund(1));
		System.out.println("�ڶ�����"+fund(2));
		System.out.println("�ڶ�����"+fund(3));
		System.out.println("�ڶ�����"+fund(10));
		System.out.println("�ڶ�����"+fund(6));
		System.out.println("===========�׳�===========");
		System.out.println("1�Ľ׳ˣ�"+factorial(1));
		System.out.println("2�Ľ׳ˣ�"+factorial(2));
		System.out.println("3�Ľ׳ˣ�"+factorial(3));
		System.out.println("4�Ľ׳ˣ�"+factorial(4));
		System.out.println("===========�۰����===========");
		int arr[] = {1,2,3,4,5,6};
		int index=RecFind(0,5,1,arr);
		System.out.println("Ҫ�ҵ����ڣ�"+index);
	}
}
