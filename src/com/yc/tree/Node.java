package com.yc.tree;
/**
 * 数的结点类
 * @author 29226
 *
 */
public class Node {
	public  Node leftChild;//左孩子
	public Node rightChild;//右孩子
	//数据
	public int  IData;
	public String SData;
	
	@Override
	public String toString() {
		return "Node [leftChild=" + leftChild + ", rightChild=" + rightChild + ", IData=" + IData + ", SData=" + SData
				+ "]";
	} 
	
}
