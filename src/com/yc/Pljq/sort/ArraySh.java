package com.yc.Pljq.sort;
/**
 * 希尔排序
 * @author 29226
 *
 */
public class ArraySh {
	public int[] MyArray;//排序数组
	public int elem;
	//初始化排序数组
	public ArraySh(int max) {
		if(max<0) {
			max=100;
		}
		MyArray =new int [max];
		
	}
	public ArraySh(int [] array) {
		
		MyArray =new int [array.length];
		MyArray=array;
		
	}
	//数组插入
	public void insert(int value) {
		MyArray[elem++]=value;
	}
	//查看
	public void display() {
		for(int i=0,n=MyArray.length;i<n;i++) {
			System.out.print(MyArray[i]+" ");
		}
		System.out.println();
	}
	//希尔排序
	public void ShellSort() {
		int h=1;//间隔（增量）
		//找出最大的增量
		while(h<=elem/3) {
			h=h*3+1;
		}
		int temp;
		int outer;//后置指针
		int inner;//前置指针
		//按照增量值去交换比较
		while(h>=1) {
			//控制躺数
			for(outer=h;outer<elem;outer++) {
				temp=MyArray[outer];
				inner=outer;
				//按照增量在分组的内部比较交换
				while(inner>h-1 && MyArray[inner-h]>=temp) {
					MyArray[inner]=MyArray[inner-h];
					inner-=h;
				}
				MyArray[inner]=temp;
				//display();
			}
			h=(h+1)/3;
		
		}
		
	}
	
	//测试
	public static void main(String [] rgs) {
		ArraySh sh=new ArraySh(10);
		sh.insert(6);
		sh.insert(2);
		sh.insert(7);
		sh.insert(4);
		sh.insert(8);
		sh.insert(3);
		sh.insert(10);
		sh.insert(9);
		sh.insert(5);
		sh.insert(1);
		sh.display();
		sh.ShellSort();
		sh.display();
		
	}
	
	
}
