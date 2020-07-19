package com.yc.Pljq.sort;
/***
 * �鲢����
 * @author 29226
 * 
 * ʱ�临�Ӷ� O(N*logN)
 *
 */

public class DArray {
	
	private int [] arry;//���������
	private int elem;//���鵱ǰλ�õ�����
	
	public DArray(int max) {
		arry =new int[max];//��������
		elem=0;//��ʼ��λ��
	}
	
	//�������в���Ԫ�صķ���
	public void insert(int key) {
		arry[elem]=key;
		elem++;
	}
	//�鿴��ǰ����ķ���
	public void display() {
		for(int i=0;i<elem;i++) {
			System.out.print("->"+arry[i]);
		}
		System.out.println();
	}
	
	public void mergeSort() {
		int [] workspace=new int [elem];//����һ����ԭ����ͬ��С������
		RemergeSort(workspace,0,elem-1);//��ʼ�鲢
	}
	//��
	private void RemergeSort(int[] workspace, int left, int right) {
		if(left==right) {
			return ;
		}else {
			//
			int mind=(left+right)/2;
			//��ߵݹ����
			RemergeSort(workspace,left,mind);
			//�ұߵݹ����
			RemergeSort(workspace,mind+1,right);
			//�ϲ���������������
			Merger(workspace,left,mind+1,right);
		}
		
		
		
		
	}
	//��
	/**
	 * 
	 * @param workspace ��ʱ����ռ�
	 * @param left      ��߷���Ŀ�ʼ
	 * @param i			mind+1���ұ�����Ŀ�ʼ��
	 * @param right     �ұ߽���
	 */
	private void Merger(int[] workspace, int left, int i, int right) {
		int j=0;//��ʱ�������ָ��
		int low=left;//��ߵ�ָ��(ԭ�������м�����Ԫ�ص�ƫ����)
		int mind=i-1;//�м�λ��
		int n=right-low+1;//�����ܹ��ж�����
		
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
		//��ߴ��ڶ����ұ�
		while(left<=mind) {
			workspace[j++]=arry[left++];
		}
		//�ұ߶������
		while(i<=right) {
			workspace[j++]=arry[i++];
		}
		//������õ����鿽����ԭ������ȥ
		for(j=0;j<n;j++) {
			if(low+j==10) {
				System.out.println(low+"--"+j );
			}
			arry[low+j]=workspace[j];
		}
		
		
	}
	
	//����
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
