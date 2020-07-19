package com.yc.Pljq.sort;

import java.util.Random;

/**
 * 
 * 
 * 
 *快速排序    算法复杂度 0（NlogN）
 * @author 29226
 *
 */
public class quikSort {
	
	public int [] MyArray; //排序的数组
	public int elem;		//元素指针
	
	//构造函数初始化数组 
	public quikSort(int max) {
		elem=0;
		if(max<1) {
			max=10;
		}
		MyArray=new int [max] ;
	}
	//元素的插入方法
	public void insert(int value) {
		MyArray[elem++]=value;
	}
	//查看元素的方法
	public void display() {
		for(int i=0;i<elem;i++) {
			System.out.print(MyArray[i]+" ");
		}
		System.out.println();
	}
	//快速排序
	
	public void quickSort() {
		RequikSort(0,elem-1);//从下标0到数组最后一个元素排序
	}
	/**
	 * 排序的方法
	 * @param left  开始位置
	 * @param right  结束位置
 	 */
	public void RequikSort(int left, int right) {
		if(left>=right) {
			return;
		}
		//每次取最右边的为枢纽
		int pivot=MyArray[right];
		//按照枢纽划分好比枢纽值大的放在枢纽的右边小的放在左边
		int partition=PatitionIt(left,right,pivot);
		RequikSort(left,partition-1 );//左边递归调用
		RequikSort(partition+1,right);//右边递归调用
		
	}
	/**
	 * 根据枢纽值划分
	 * @param left  起点
	 * @param right 终点
	 * @param pivot 枢纽值
	 * @return
	 */
	public int PatitionIt(int left, int right, int pivot) {
		int leftPrt=left-1;  //左边开始的的指针
		int rightPrt=right; //右边开始的指针
		while(true) {
			 //左边的指针一直向右边走直到找到一个比枢纽值大的才停下
			while(MyArray[++leftPrt]<pivot) {
				;
			}
			//右边的指针不断向前走遇到小于枢纽值才停下否则继续
			while(rightPrt>0 && MyArray[--rightPrt]>pivot) {
				;
			}
			//两前后指针相遇话说明结束了
			if(leftPrt>=rightPrt) {
				break;
			}else {
				//左右指针找到的两个位置为错误的需要交换位置
				swap(leftPrt,rightPrt);
			}
		}
		//结束循环，将所选的枢纽值放在中间的位置
		swap(leftPrt,right);
		//返回中间值的位置
		return leftPrt;
	}
	//交换的方法
	public void swap(int key1, int key2) {
		int temp=MyArray[key1];
		MyArray[ key1]=MyArray[key2];
		MyArray[key2]=temp;
	}
	//测试
	
	public static void main(String [] args) {
		quikSort qs=new quikSort(10);
		Random r=new Random();
		
		//随机生成10个数
		for(int i=1;i<=10;i++) {
			int value=(r.nextInt(10))*99;
			qs.insert(value);
		}
		System.out.println("排序前");
		qs.display();
		qs.quickSort();
		
		System.out.println("排序后");
		qs.display();
		
	}
}
