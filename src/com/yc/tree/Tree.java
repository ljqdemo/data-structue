package com.yc.tree;
/**
 * 二搜索叉树类
 * @author 29226
 *
 */

public class Tree {
	
	public Node root;//根节点
	
	//构造函数
	public Tree(Node root) {
		this.root=root;
	}
	//查找结点
	public Node find(int key) {
		Node current=root;
		while(current.IData!=key) {
			if(current.IData>key) {
				//要找值比当前小则在左子树
				current=current.leftChild;
			}else {
				//否则在右子树
				current=current.rightChild;
			}if(current==null) {
				//没有找到
				return null;
			}
			
		}
		return current;
	}
	//插入的方法
		public void insert(Node elem) {
			if(root==null) {
				root=elem;
			}else {
				Node current=root;//当前结点初始化为根节点使得每次的插入都从根节点开始扫描
				Node parent;//父节点
				while(true) {
					parent=current;
					if(current.IData>elem.IData) {
						current=current.leftChild;
						//要插入的位置在左子树
						if(current==null) {
							//左子树为空直接插入
							parent.leftChild=elem;
							return ;
						}
					}else {
						current=current.rightChild;
						//要插入的位置在右子树
						if(current==null) {
							//右子树为空直接插入
							parent.rightChild=elem;
							return ;
						}
					}
				}
			}
		}
		//删除结点
		public void delete( int key ) {
			Node current=root;
			Node parent;
			//寻找到要删除的结点
			while(true) {
				parent=current;
				//要找的结点在当前结点的左边
				if(current!=null&&key<current.IData) {
					current=current.leftChild;
					//找到该结点
					if(current.IData==key) {
						//要删除的结点为非叶子结点
						/**
						 * 当前的结点是非叶子结点的情况比较复杂
						 * a：当前左右子树都存在
						 * 	1，当前结点的左子树或者右子树是非叶子结点/ 不是非叶子结点
						 * 	2，当前结点的左子树和右子树均为非叶子节点
						 * 	3，当前结点的左子树和右子树均为叶子节点
						 * b:只存在左子树或者右子树
						 */
						if(current.leftChild!=null&&current.rightChild!=null) {
							//当前结点的左子树和右子树均为非叶子结点
							if(!isLeaf(current.leftChild)&&!isLeaf(current.rightChild)) {
								/**（画一个图一目了然）
								 * 只要当前结点的右子树存在左孩子就将左孩子放在上出当前结点上
								 * 
								 * 如果不存在左孩子，就将当前结点的右子树放在当前结点上
								 * 
								 */
								if(current.rightChild.leftChild!=null) {
									//左孩子不为空将左孩子放在当前位置
									Node temp=current.rightChild.leftChild;
									temp.leftChild=current.leftChild;
									current.rightChild.leftChild=null;
									parent.leftChild=temp;
									temp=null;
									System.gc();//调用GC回收垃圾空间
									return;
									
								}else {
									//左孩子为空 直接将当前结点的左子树放在当前结点位置
									Node temp=current.rightChild;
									temp.leftChild=current.leftChild;
									parent.leftChild=temp;
									temp=null;
									System.gc();//调用GC回收垃圾空间
									return;
									}
							}else {
									//如果当前的右子树为非叶子结点左子树为叶子结点
									if(!isLeaf(current.rightChild)){
										Node temp=current.leftChild;
										temp.rightChild=current.rightChild;
										parent.leftChild=temp;
										temp=null;
										System.gc();
										return;
									}else {
										/**
										 * 当前结点的左右子树都为叶子结点;将右子树放入当前位置
										 * 当前的左子树为非叶子结点右子树为叶子结点
										 */
										Node temp=current.rightChild;
										temp.leftChild= current.leftChild;
										parent.leftChild=temp;
										temp=null;
										System.gc();
										return;
									}
									
									
							}
						}
						//当前结点只有左子树
						if (current.leftChild!=null&&current.rightChild==null){
								parent.leftChild=current.leftChild;
								current=null;
								System.gc();
								return;
						}
						//当前结点只有右子树
						if (current.leftChild==null&&current.rightChild==null){
								parent.leftChild=current.rightChild;
								current=null;
								System.gc();
								return;
						}
						else {
							//删除的为叶子结点
							parent.leftChild=null;
							System.gc();//调用GC回收垃圾空间
							return;
						}
					}
				}
				//要找的结点在当前结点的右边（与左边的一样 Crtrl+C）
				else {
					current=current.rightChild;//改了这个地方
					//找到该结点
					if(current.IData==key) {
						//要删除的结点为非叶子结点
						/**
						 * 当前的结点是非叶子结点的情况比较复杂
						 * a：当前左右子树都存在
						 * 	1，当前结点的左子树或者右子树是非叶子结点/ 不是非叶子结点
						 * 	2，当前结点的左子树和右子树均为非叶子节点
						 * 	3，当前结点的左子树和右子树均为叶子节点
						 * b:只存在左子树或者右子树
						 */
						if(current.leftChild!=null&&current.rightChild!=null) {
							//当前结点的左子树和右子树均为非叶子结点
							if(!isLeaf(current.leftChild)&&!isLeaf(current.rightChild)) {
								/**（画一个图一目了然）
								 * 只要当前结点的右子树存在左孩子就将左孩子放在上出当前结点上
								 * 
								 * 如果不存在左孩子，就将当前结点的右子树放在当前结点上
								 * 
								 */
								if(current.rightChild.leftChild!=null) {
									//左孩子不为空将左孩子放在当前位置
									Node temp=current.rightChild.leftChild;
									temp.leftChild=current.leftChild;
									current.rightChild.leftChild=null;
									parent.leftChild=temp;
									temp=null;
									System.gc();//调用GC回收垃圾空间
									return;
									
								}else {
									//左孩子为空 直接将当前结点的左子树放在当前结点位置
									Node temp=current.rightChild;
									temp.leftChild=current.leftChild;
									parent.leftChild=temp;
									temp=null;
									System.gc();//调用GC回收垃圾空间
									return;
									}
							}else {
									//当前结点的左右子树都为叶子结点
									Node temp=current.leftChild;
									temp.leftChild= current.leftChild;
									parent.leftChild=temp;
									temp=null;
									System.gc();
									return;
									
							}
						}
						//当前结点只有左子树
						if (current.leftChild!=null&&current.rightChild==null){
								parent.leftChild=current.leftChild;
								current=null;
								System.gc();
								return;
						}
						//当前结点只有右子树
						if (current.leftChild==null&&current.rightChild==null){
								parent.leftChild=current.rightChild;
								current=null;
								System.gc();
								return;
						}
						else {
							//删除的为叶子结点
							parent.leftChild=null;
							System.gc();//调用GC回收垃圾空间
							return;
						}
					}
				}
			}
		}
		//判断是否为叶子结点
	public boolean isLeaf(Node node) {
		if(node.leftChild!=null||node.rightChild!=null) {
			return false;
		}else {
			return true;
		}
		
	}	
		//遍历方法(中序)
		public void display(Node root) {
			if(root!=null) {
				display(root.leftChild);//遍历左边	
				System.out.print(root.IData+" ");
				display(root.rightChild);//遍历右边
			}
			
			
		}
		//先序遍历
		public void pdisplay(Node root) {
			if(root!=null) {
				System.out.print(root.IData+" ");
				pdisplay(root.leftChild);//遍历左边	
				pdisplay(root.rightChild);//遍历右边
			}
			
		}
		
		//先序遍历
		public void fdisplay(Node root) {
			if(root!=null) {
				fdisplay(root.leftChild);//遍历左边	
				fdisplay(root.rightChild);//遍历右边
				System.out.print(root.IData+" ");
			}
			
		}
}
