package com.yc.Pljq.sort;

import java.util.Random;

/**
 * 
 * 
 * 
 *��������    �㷨���Ӷ� 0��NlogN��
 * @author 29226
 *
 */
public class quikSort {
	
	public int [] MyArray; //���������
	public int elem;		//Ԫ��ָ��
	
	//���캯����ʼ������ 
	public quikSort(int max) {
		elem=0;
		if(max<1) {
			max=10;
		}
		MyArray=new int [max] ;
	}
	//Ԫ�صĲ��뷽��
	public void insert(int value) {
		MyArray[elem++]=value;
	}
	//�鿴Ԫ�صķ���
	public void display() {
		for(int i=0;i<elem;i++) {
			System.out.print(MyArray[i]+" ");
		}
		System.out.println();
	}
	//��������
	
	public void quickSort() {
		RequikSort(0,elem-1);//���±�0���������һ��Ԫ������
	}
	/**
	 * ����ķ���
	 * @param left  ��ʼλ��
	 * @param right  ����λ��
 	 */
	public void RequikSort(int left, int right) {
		if(left>=right) {
			return;
		}
		//ÿ��ȡ���ұߵ�Ϊ��Ŧ
		int pivot=MyArray[right];
		//������Ŧ���ֺñ���Ŧֵ��ķ�����Ŧ���ұ�С�ķ������
		int partition=PatitionIt(left,right,pivot);
		RequikSort(left,partition-1 );//��ߵݹ����
		RequikSort(partition+1,right);//�ұߵݹ����
		
	}
	/**
	 * ������Ŧֵ����
	 * @param left  ���
	 * @param right �յ�
	 * @param pivot ��Ŧֵ
	 * @return
	 */
	public int PatitionIt(int left, int right, int pivot) {
		int leftPrt=left-1;  //��߿�ʼ�ĵ�ָ��
		int rightPrt=right; //�ұ߿�ʼ��ָ��
		while(true) {
			 //��ߵ�ָ��һֱ���ұ���ֱ���ҵ�һ������Ŧֵ��Ĳ�ͣ��
			while(MyArray[++leftPrt]<pivot) {
				;
			}
			//�ұߵ�ָ�벻����ǰ������С����Ŧֵ��ͣ�·������
			while(rightPrt>0 && MyArray[--rightPrt]>pivot) {
				;
			}
			//��ǰ��ָ��������˵��������
			if(leftPrt>=rightPrt) {
				break;
			}else {
				//����ָ���ҵ�������λ��Ϊ�������Ҫ����λ��
				swap(leftPrt,rightPrt);
			}
		}
		//����ѭ��������ѡ����Ŧֵ�����м��λ��
		swap(leftPrt,right);
		//�����м�ֵ��λ��
		return leftPrt;
	}
	//�����ķ���
	public void swap(int key1, int key2) {
		int temp=MyArray[key1];
		MyArray[ key1]=MyArray[key2];
		MyArray[key2]=temp;
	}
	//����
	
	public static void main(String [] args) {
		quikSort qs=new quikSort(10);
		Random r=new Random();
		
		//�������10����
		for(int i=1;i<=10;i++) {
			int value=(r.nextInt(10))*99;
			qs.insert(value);
		}
		System.out.println("����ǰ");
		qs.display();
		qs.quickSort();
		
		System.out.println("�����");
		qs.display();
		
	}
}
