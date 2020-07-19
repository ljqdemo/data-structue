package com.yc.Pljq.sort;
/**
 * ϣ������
 * @author 29226
 *
 */
public class ArraySh {
	public int[] MyArray;//��������
	public int elem;
	//��ʼ����������
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
	//�������
	public void insert(int value) {
		MyArray[elem++]=value;
	}
	//�鿴
	public void display() {
		for(int i=0,n=MyArray.length;i<n;i++) {
			System.out.print(MyArray[i]+" ");
		}
		System.out.println();
	}
	//ϣ������
	public void ShellSort() {
		int h=1;//�����������
		//�ҳ���������
		while(h<=elem/3) {
			h=h*3+1;
		}
		int temp;
		int outer;//����ָ��
		int inner;//ǰ��ָ��
		//��������ֵȥ�����Ƚ�
		while(h>=1) {
			//��������
			for(outer=h;outer<elem;outer++) {
				temp=MyArray[outer];
				inner=outer;
				//���������ڷ�����ڲ��ȽϽ���
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
	
	//����
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
