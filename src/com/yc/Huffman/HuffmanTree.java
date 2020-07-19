package com.yc.Huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������
 * @author 29226
 *
 */
public class HuffmanTree {
	public Node root;//ͷ���
	public Map<String ,String > codes=new HashMap<>();//���ڴ�ű����
	//ͨ�����캯������HuffmanTree
	public HuffmanTree(priorityQu qu) {
		//ÿ�δӶ�����ȡ������Ԫ�أ�С�ģ��������һ���µĽ��
		Node t;
		while(qu.size()>1) {
			Node left=qu.remove();
			Node right=qu.remove();
			Node parent=new Node();
			parent.priority=left.priority+right.priority;
			parent.leftchild=left;
			parent.rightchild=right;
			//parent.data=left.data+"��"+right.data+"�ĺϳ���";
			qu.insert(parent);//���µĽ��������
			root=parent;
		}
		
	}
	
	//���루��ʵ���������������ʱ����Ѽ�¼·����
	public void findAllLeaf(Node node,String suffx) {
		if(node !=null) {
			//���û������������˵����Ҷ�ӽ����Ҫ����¼�ı����ŵ�map��
			if(node.leftchild==null&&node.rightchild==null) {
				codes.put(node.data,suffx);
			}
			//������߼�¼ֵ��0
			findAllLeaf(node.leftchild,suffx+"0");
			//���ұ��߼�¼ֵ��1
			findAllLeaf(node.rightchild,suffx+"1");
		}
	}
	
	
	//ǰ������㷨
	public void prodisplay(Node node ) {
		if(node!=null) {
		
			System.out.print(node.data+" ");
			prodisplay(node.leftchild);
			prodisplay(node.rightchild);
		}
		
	}
	//��������㷨
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
	//��������㷨
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
