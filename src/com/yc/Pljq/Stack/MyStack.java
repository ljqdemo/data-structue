package com.yc.Pljq.Stack;

public class MyStack {
	
	private char[] CharArrary;//char数组存放数据
	private int top;//顶部指针
	private  int defulateSize=127;
	
	//构造函数初始化栈的大小 和顶部指针位置
	public MyStack(int size) {
		if(size<0) {
			CharArrary=new char[defulateSize];
		}else {
			CharArrary=new char[size];
		}
		top=-1;
	}
	//判断栈是否为空的函数
	public boolean isEmplty() {
		return (top==-1); 
	}
	//出栈
	public char pop() {
		if(!isEmplty()) {
			return CharArrary[top--];
		}else {
			return ' ';	
		}
	}
	//入栈
	public void push(char ch) {
		if(top>=CharArrary.length) {
			//此处就不做扩容和异常抛出异常
			char [] temp=new char[CharArrary.length*2];
			for(int i=0;i<CharArrary.length;i++) {
				temp[i]=CharArrary[i];
			}
			CharArrary =temp;
			//垃圾回收
			System.gc();
			System.runFinalization();
		}
		CharArrary[++top]=ch;
		
	}
	//查看顶部元素
	public char peek() {
		return CharArrary[top];
	}
	
}
