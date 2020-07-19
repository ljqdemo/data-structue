package com.yc.Pljq.sort;

public class insertSortTest {
	
	/**
	 * 插入排序就是将 序列先分成两组 即有序和待排序的
	 * 默认第一个时有序的  然后将后面没有序的依次比较  插入前面的有序 序列中
	 * 算法复杂度分析
	 * 
	 * 算法复杂度 O(n^2)
	 * 好的情况 n个数事先有序 只要比较1+2+3+...+n-1 交换0次
	 * 
	 * 
	 * 
	 * @param nums
	 */
	//博客上的插入排序
	public static void insertionSort(int[] nums) {

	    if (nums == null || nums.length < 2) {
	        return;
	    }

	    for(int i = 1; i < nums.length; i++) {
	        for(int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
	            swap(nums, j, j + 1);
	        }
	    }

	}
	public static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	//插入排序算法（my ）
	public static int[] insertSort(int[] arr) {
	
		//最外层循环遍历数组 因为默认第一个有序所有下标从1开始
		for(int i=1;i<arr.length;i++) {
			
			//刚开始j=i-1表示有序的队列中的最后一个
			for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--) {
				  int temp=0;
				  temp=arr[j+1];
				  arr[j+1]=arr[j];
				  arr[j]=temp;
				  //打印
				  for(int k=0;k<arr.length;k++) {
						System.out.print(arr[k]+"->");
					}
				  System.out.println();
			}
			
		}
		
		return arr;
	}
	
	//相关 博客地址 https://www.jianshu.com/p/d2cf77f78b3e
	public static void main(String [] arg) {
		int [] arrt= {1,2,9,4,0};
		//insertionSort(arrt);
		insertSort(arrt);
		for(int i=0;i<arrt.length;i++) {
			System.out.print(arrt[i]+"->");
		}
		
		
		
		
	}

}
