package com.yc.Pljq.Stack;

public class IntoPostTest {

	public static void main(String[] args) {
		InToPost itp=new InToPost("A*(B+C)");
		String last=itp.doTran();
		System.out.println(last);

	}

}
