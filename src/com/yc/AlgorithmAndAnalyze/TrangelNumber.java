package com.yc.AlgorithmAndAnalyze;

public class TrangelNumber {
	
	
	//寻找三角数数字递归算法
	public static int fund(int i) {
		if(i==1) {
			return 1;
			
		}else {
			return fund(i-1)+i;
		}
		
	} 
	//递归求阶乘
	
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}else {
			return factorial(n-1)*n;
		}
		
	}
	
	//递归的折半查找 （设当前的数组为升序的排列)1 2 3 4 5 6 
	public static int RecFind(int low,int up,int key,int [] arr) {
		int ioc ;//中间指针
		ioc=(low+up)/2;
		//找到了
		if(arr[ioc]==key) {
			return ioc;
		}
		//没找到
		if(low==up) {
			return -1;
		}else {
			if(arr[ioc]>key) {
				//当前的数比key大 要找的key在当前的数的前面
				return RecFind(low,ioc-1,key,arr);
			}else {
				//要找的key在后面
				return RecFind(ioc+1,up,key,arr);
			}
		}
		
	}
	
		//测试
	public static void main(String []srg) {
		System.out.println("第一个："+fund(1));
		System.out.println("第二个："+fund(2));
		System.out.println("第二个："+fund(3));
		System.out.println("第二个："+fund(10));
		System.out.println("第二个："+fund(6));
		System.out.println("===========阶乘===========");
		System.out.println("1的阶乘："+factorial(1));
		System.out.println("2的阶乘："+factorial(2));
		System.out.println("3的阶乘："+factorial(3));
		System.out.println("4的阶乘："+factorial(4));
		System.out.println("===========折半查找===========");
		int arr[] = {1,2,3,4,5,6};
		int index=RecFind(0,5,1,arr);
		System.out.println("要找的数在："+index);
	}
}
