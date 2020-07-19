package com.yc.Huffman;
/**
 * 结点类
 * @author 29226
 *
 */

public class Node {
	public int priority;//优先级(出现的频率)
	public String data;//数据
	public Node leftchild;
	public Node rightchild;
	@Override
	public String toString() {
		return "Node [priority=" + priority + ", data=" + data + ", leftchild=" + leftchild + ", rightchild="
				+ rightchild + "]";
	}
	

}
