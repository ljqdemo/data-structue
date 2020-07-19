package com.yc.Pljq.Stack;
/**
 * 中缀==》转后缀表达式的类
 * @author DELL
 *
 */
public class InToPost {
	//栈对象
	private MyStack myStack;
	private String input;//输入变量
	private String output="";//输出变量
	
	
	public String Result () {
		return output;
	}
	
	
	//通过构造函数实现初始化
	public InToPost(String str) {
		this.input=str;
		this.myStack=new MyStack(str.length());
		
	}
	//前缀转后缀编码算法
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
			case '(': //如果时（里面的优先级肯定时比前面高 所以直接push进入栈
				myStack.push(ch);
				break;	
			case ')':
				gotparen(ch);//匹配到）一直向前走将前面的操作符号下弹出直到找到（
				break;
			default:
				output+=ch;
				break;
			}
		}
		//将剩余元素弹出
		while(!myStack.isEmplty()) {
			output+=myStack.pop();
		}
		return output;
		
	}
	//读到）
	private void gotparen(char ch) {
		while(!myStack.isEmplty()) {
			char chx=myStack.pop();
			//当匹配到其对应的（的时候可以直接将其弹出
			if(chx=='(') {
				break;
			}else {
				output+=chx;
			}
		}
		
	}
	/**
	 * 
	 * @param ch 此参数表示当前的元素
	 * @param i 表示运算符的优先级
	 */
	private void gotOper(char ch, int pre1) {
		while(!myStack.isEmplty()) {
			char topElem=myStack.pop();
			
			
			if(topElem=='(') {
				myStack.push(topElem);
				break;
			}else {
				
				int pre2=0;//取出元素的优先级
				
				if(topElem=='+'||ch=='-') {
					pre2=1;
				}else if(topElem=='*'||ch=='/') {
					pre2=2;
				}
				//当前元素符的优先级高于栈顶元素
				if(pre2<pre1) {
				myStack.push(topElem);
				break;
				}else {
					//当前优先级别小于等于栈的里元素的优先级
					output+=topElem;
				}
				
			}
			
		}
		myStack.push(ch);//将当前操作符元素加入栈
	}
	
	
	

}
