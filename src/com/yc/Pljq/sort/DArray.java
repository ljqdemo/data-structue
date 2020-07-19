package com.yc.Pljq.sort;
/***
 * 归并排序
 * @author 29226
 * 
 * 时间复杂度 O(N*logN)
 *
 */

public class DArray {
	
	private int [] arry;//排序的数组
	private int elem;//数组当前位置的索引
	
	public DArray(int max) {
		arry =new int[max];//创建数组
		elem=0;//初始化位置
	}
	
	//向数组中插入元素的方法
	public void insert(int key) {
		arry[elem]=key;
		elem++;
	}
	//查看当前数组的方法
	public void display() {
		for(int i=0;i<elem;i++) {
			System.out.print("->"+arry[i]);
		}
		System.out.println();
	}
	
	public void mergeSort() {
		int [] workspace=new int [elem];//创建一个与原数相同大小的数组
		RemergeSort(workspace,0,elem-1);//开始归并
	}
	//分
	private void RemergeSort(int[] workspace, int left, int right) {
		if(left==right) {
			return ;
		}else {
			//
			int mind=(left+right)/2;
			//左边递归分治
			RemergeSort(workspace,left,mind);
			//右边递归分治
			RemergeSort(workspace,mind+1,right);
			//合并排序后的左右两边
			Merger(workspace,left,mind+1,right);
		}
		
		
		
		
	}
	//治
	/**
	 * 
	 * @param workspace 临时数组空间
	 * @param left      左边分组的开始
	 * @param i			mind+1（右边数组的开始）
	 * @param right     右边结束
	 */
	private void Merger(int[] workspace, int left, int i, int right) {
		int j=0;//临时的数组的指针
		int low=left;//左边的指针(原数组与中间数组元素的偏移量)
		int mind=i-1;//中间位置
		int n=right-low+1;//此组总共有多少数
		
		while(left<=mind && i<=right) {
			if(arry[left]<arry[i]) {
				workspace[j]=arry[left];
				j++;
				left++;
			}else {
				workspace[j]=arry[i];
				j++;
				i++;
			}
			
		}
		//左边大于多于右边
		while(left<=mind) {
			workspace[j++]=arry[left++];
		}
		//右边多余左边
		while(i<=right) {
			workspace[j++]=arry[i++];
		}
		//将排序好的数组拷贝到原数组中去
		for(j=0;j<n;j++) {
			if(low+j==10) {
				System.out.println(low+"--"+j );
			}
			arry[low+j]=workspace[j];
		}
		
		
	}
	
	//测试
		public static void main(String[] args) {
			DArray d=new DArray(10);
			d.insert(1);
			d.insert(8);
			d.insert(5);
			d.insert(6);
			d.insert(2);
			d.insert(4);
			d.insert(3);
			d.display();
			d.mergeSort();
			d.display();
		}
	

}
