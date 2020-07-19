package com.yc.Huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈夫曼树
 * @author 29226
 *
 */
public class HuffmanTree {
	public Node root;//头结点
	public Map<String ,String > codes=new HashMap<>();//用于存放编码的
	//通过构造函数生成HuffmanTree
	public HuffmanTree(priorityQu qu) {
		//每次从队列中取出两个元素（小的）结点生成一个新的结点
		Node t;
		while(qu.size()>1) {
			Node left=qu.remove();
			Node right=qu.remove();
			Node parent=new Node();
			parent.priority=left.priority+right.priority;
			parent.leftchild=left;
			parent.rightchild=right;
			//parent.data=left.data+"和"+right.data+"的合成树";
			qu.insert(parent);//将新的结点插入队列
			root=parent;
		}
		
	}
	
	//编码（其实就是在先序遍历的时候加已记录路径）
	public void findAllLeaf(Node node,String suffx) {
		if(node !=null) {
			//如果没有左右子树则说明是叶子结点了要将记录的编码存放到map中
			if(node.leftchild==null&&node.rightchild==null) {
				codes.put(node.data,suffx);
			}
			//向左边走记录值加0
			findAllLeaf(node.leftchild,suffx+"0");
			//向右边走记录值加1
			findAllLeaf(node.rightchild,suffx+"1");
		}
	}
	
	
	//前序遍历算法
	public void prodisplay(Node node ) {
		if(node!=null) {
		
			System.out.print(node.data+" ");
			prodisplay(node.leftchild);
			prodisplay(node.rightchild);
		}
		
	}
	//中序遍历算法
	public void display(Node node ) {
		if(node!=null) {
			display(node.leftchild);
			if(node.data!=null) {
				System.out.print(node.data+" ");
			}else {
				System.out.print(" ");
			}
			
			display(node.rightchild);
		}
		
	}
	//后序遍历算法
		public void fdisplay(Node node ) {
			if(node==null) {
				return;
			}
			fdisplay(node.leftchild);
			fdisplay(node.rightchild);
			if(node.data!=null) {
				System.out.print(node.data+" ");
			}else {
				System.out.print(" ");
			}
		}
}
