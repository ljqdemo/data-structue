package com.yc.tree;

public class TreeApp {
	
	public static void main(String[] args) {
		Node root=new Node();
		root.IData=8;
		Tree tree=new Tree(root );
		for(int i=0;i<4;++i) {
			Node node=new Node();
			node.IData=4+i*2;
			tree.insert(node);
		}
		Node n=new Node();
		n.IData=3;
		tree.insert(n);
		
		System.out.println("======�������=====");
		tree.pdisplay(root);
		System.out.println();
		System.out.println("=======�������======");
		tree.display(root);
		System.out.println();
		System.out.println("======�������=====");
		tree.fdisplay(root);
		System.out.println();
		System.out.println("=======ɾ�� 4===========");
		tree.delete(4);
		
		System.out.println("======ɾ������������=====");
		tree.pdisplay(root);
	}

}
