package com.yc.tree;
/**
 * ���Ľ����
 * @author 29226
 *
 */
public class Node {
	public  Node leftChild;//����
	public Node rightChild;//�Һ���
	//����
	public int  IData;
	public String SData;
	
	@Override
	public String toString() {
		return "Node [leftChild=" + leftChild + ", rightChild=" + rightChild + ", IData=" + IData + ", SData=" + SData
				+ "]";
	} 
	
}
