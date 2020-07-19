package com.yc.Pljq.Stack;
/**
 * ��׺==��ת��׺���ʽ����
 * @author DELL
 *
 */
public class InToPost {
	//ջ����
	private MyStack myStack;
	private String input;//�������
	private String output="";//�������
	
	
	public String Result () {
		return output;
	}
	
	
	//ͨ�����캯��ʵ�ֳ�ʼ��
	public InToPost(String str) {
		this.input=str;
		this.myStack=new MyStack(str.length());
		
	}
	//ǰ׺ת��׺�����㷨
	public String doTran() {
		for(int i=0;i<input.length();i++) {
			char ch=input.charAt(i);
			
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch,1);
				break;
			case '*':
			case '/':
				gotOper(ch,2);
				break;
			case '(': //���ʱ����������ȼ��϶�ʱ��ǰ��� ����ֱ��push����ջ
				myStack.push(ch);
				break;	
			case ')':
				gotparen(ch);//ƥ�䵽��һֱ��ǰ�߽�ǰ��Ĳ��������µ���ֱ���ҵ���
				break;
			default:
				output+=ch;
				break;
			}
		}
		//��ʣ��Ԫ�ص���
		while(!myStack.isEmplty()) {
			output+=myStack.pop();
		}
		return output;
		
	}
	//������
	private void gotparen(char ch) {
		while(!myStack.isEmplty()) {
			char chx=myStack.pop();
			//��ƥ�䵽���Ӧ�ģ���ʱ�����ֱ�ӽ��䵯��
			if(chx=='(') {
				break;
			}else {
				output+=chx;
			}
		}
		
	}
	/**
	 * 
	 * @param ch �˲�����ʾ��ǰ��Ԫ��
	 * @param i ��ʾ����������ȼ�
	 */
	private void gotOper(char ch, int pre1) {
		while(!myStack.isEmplty()) {
			char topElem=myStack.pop();
			
			
			if(topElem=='(') {
				myStack.push(topElem);
				break;
			}else {
				
				int pre2=0;//ȡ��Ԫ�ص����ȼ�
				
				if(topElem=='+'||ch=='-') {
					pre2=1;
				}else if(topElem=='*'||ch=='/') {
					pre2=2;
				}
				//��ǰԪ�ط������ȼ�����ջ��Ԫ��
				if(pre2<pre1) {
				myStack.push(topElem);
				break;
				}else {
					//��ǰ���ȼ���С�ڵ���ջ����Ԫ�ص����ȼ�
					output+=topElem;
				}
				
			}
			
		}
		myStack.push(ch);//����ǰ������Ԫ�ؼ���ջ
	}
	
	
	

}
