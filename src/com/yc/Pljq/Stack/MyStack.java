package com.yc.Pljq.Stack;

public class MyStack {
	
	private char[] CharArrary;//char����������
	private int top;//����ָ��
	private  int defulateSize=127;
	
	//���캯����ʼ��ջ�Ĵ�С �Ͷ���ָ��λ��
	public MyStack(int size) {
		if(size<0) {
			CharArrary=new char[defulateSize];
		}else {
			CharArrary=new char[size];
		}
		top=-1;
	}
	//�ж�ջ�Ƿ�Ϊ�յĺ���
	public boolean isEmplty() {
		return (top==-1); 
	}
	//��ջ
	public char pop() {
		if(!isEmplty()) {
			return CharArrary[top--];
		}else {
			return ' ';	
		}
	}
	//��ջ
	public void push(char ch) {
		if(top>=CharArrary.length) {
			//�˴��Ͳ������ݺ��쳣�׳��쳣
			char [] temp=new char[CharArrary.length*2];
			for(int i=0;i<CharArrary.length;i++) {
				temp[i]=CharArrary[i];
			}
			CharArrary =temp;
			//��������
			System.gc();
			System.runFinalization();
		}
		CharArrary[++top]=ch;
		
	}
	//�鿴����Ԫ��
	public char peek() {
		return CharArrary[top];
	}
	
}
