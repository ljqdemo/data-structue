package com.yc.Huffman;
/**
 * �����
 * @author 29226
 *
 */

public class Node {
	public int priority;//���ȼ�(���ֵ�Ƶ��)
	public String data;//����
	public Node leftchild;
	public Node rightchild;
	@Override
	public String toString() {
		return "Node [priority=" + priority + ", data=" + data + ", leftchild=" + leftchild + ", rightchild="
				+ rightchild + "]";
	}
	

}
