package com.yc.Pljq.sort;

public class insertSortTest {
	
	/**
	 * ����������ǽ� �����ȷֳ����� ������ʹ������
	 * Ĭ�ϵ�һ��ʱ�����  Ȼ�󽫺���û��������αȽ�  ����ǰ������� ������
	 * �㷨���Ӷȷ���
	 * 
	 * �㷨���Ӷ� O(n^2)
	 * �õ���� n������������ ֻҪ�Ƚ�1+2+3+...+n-1 ����0��
	 * 
	 * 
	 * 
	 * @param nums
	 */
	//�����ϵĲ�������
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
	
	//���������㷨��my ��
	public static int[] insertSort(int[] arr) {
	
		//�����ѭ���������� ��ΪĬ�ϵ�һ�����������±��1��ʼ
		for(int i=1;i<arr.length;i++) {
			
			//�տ�ʼj=i-1��ʾ����Ķ����е����һ��
			for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--) {
				  int temp=0;
				  temp=arr[j+1];
				  arr[j+1]=arr[j];
				  arr[j]=temp;
				  //��ӡ
				  for(int k=0;k<arr.length;k++) {
						System.out.print(arr[k]+"->");
					}
				  System.out.println();
			}
			
		}
		
		return arr;
	}
	
	//��� ���͵�ַ https://www.jianshu.com/p/d2cf77f78b3e
	public static void main(String [] arg) {
		int [] arrt= {1,2,9,4,0};
		//insertionSort(arrt);
		insertSort(arrt);
		for(int i=0;i<arrt.length;i++) {
			System.out.print(arrt[i]+"->");
		}
		
		
		
		
	}

}
