package com.yc.tree;
/**
 * ������������
 * @author 29226
 *
 */

public class Tree {
	
	public Node root;//���ڵ�
	
	//���캯��
	public Tree(Node root) {
		this.root=root;
	}
	//���ҽ��
	public Node find(int key) {
		Node current=root;
		while(current.IData!=key) {
			if(current.IData>key) {
				//Ҫ��ֵ�ȵ�ǰС����������
				current=current.leftChild;
			}else {
				//������������
				current=current.rightChild;
			}if(current==null) {
				//û���ҵ�
				return null;
			}
			
		}
		return current;
	}
	//����ķ���
		public void insert(Node elem) {
			if(root==null) {
				root=elem;
			}else {
				Node current=root;//��ǰ����ʼ��Ϊ���ڵ�ʹ��ÿ�εĲ��붼�Ӹ��ڵ㿪ʼɨ��
				Node parent;//���ڵ�
				while(true) {
					parent=current;
					if(current.IData>elem.IData) {
						current=current.leftChild;
						//Ҫ�����λ����������
						if(current==null) {
							//������Ϊ��ֱ�Ӳ���
							parent.leftChild=elem;
							return ;
						}
					}else {
						current=current.rightChild;
						//Ҫ�����λ����������
						if(current==null) {
							//������Ϊ��ֱ�Ӳ���
							parent.rightChild=elem;
							return ;
						}
					}
				}
			}
		}
		//ɾ�����
		public void delete( int key ) {
			Node current=root;
			Node parent;
			//Ѱ�ҵ�Ҫɾ���Ľ��
			while(true) {
				parent=current;
				//Ҫ�ҵĽ���ڵ�ǰ�������
				if(current!=null&&key<current.IData) {
					current=current.leftChild;
					//�ҵ��ý��
					if(current.IData==key) {
						//Ҫɾ���Ľ��Ϊ��Ҷ�ӽ��
						/**
						 * ��ǰ�Ľ���Ƿ�Ҷ�ӽ�������Ƚϸ���
						 * a����ǰ��������������
						 * 	1����ǰ���������������������Ƿ�Ҷ�ӽ��/ ���Ƿ�Ҷ�ӽ��
						 * 	2����ǰ��������������������Ϊ��Ҷ�ӽڵ�
						 * 	3����ǰ��������������������ΪҶ�ӽڵ�
						 * b:ֻ��������������������
						 */
						if(current.leftChild!=null&&current.rightChild!=null) {
							//��ǰ��������������������Ϊ��Ҷ�ӽ��
							if(!isLeaf(current.leftChild)&&!isLeaf(current.rightChild)) {
								/**����һ��ͼһĿ��Ȼ��
								 * ֻҪ��ǰ�����������������Ӿͽ����ӷ����ϳ���ǰ�����
								 * 
								 * ������������ӣ��ͽ���ǰ�������������ڵ�ǰ�����
								 * 
								 */
								if(current.rightChild.leftChild!=null) {
									//���Ӳ�Ϊ�ս����ӷ��ڵ�ǰλ��
									Node temp=current.rightChild.leftChild;
									temp.leftChild=current.leftChild;
									current.rightChild.leftChild=null;
									parent.leftChild=temp;
									temp=null;
									System.gc();//����GC���������ռ�
									return;
									
								}else {
									//����Ϊ�� ֱ�ӽ���ǰ�������������ڵ�ǰ���λ��
									Node temp=current.rightChild;
									temp.leftChild=current.leftChild;
									parent.leftChild=temp;
									temp=null;
									System.gc();//����GC���������ռ�
									return;
									}
							}else {
									//�����ǰ��������Ϊ��Ҷ�ӽ��������ΪҶ�ӽ��
									if(!isLeaf(current.rightChild)){
										Node temp=current.leftChild;
										temp.rightChild=current.rightChild;
										parent.leftChild=temp;
										temp=null;
										System.gc();
										return;
									}else {
										/**
										 * ��ǰ��������������ΪҶ�ӽ��;�����������뵱ǰλ��
										 * ��ǰ��������Ϊ��Ҷ�ӽ��������ΪҶ�ӽ��
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
						//��ǰ���ֻ��������
						if (current.leftChild!=null&&current.rightChild==null){
								parent.leftChild=current.leftChild;
								current=null;
								System.gc();
								return;
						}
						//��ǰ���ֻ��������
						if (current.leftChild==null&&current.rightChild==null){
								parent.leftChild=current.rightChild;
								current=null;
								System.gc();
								return;
						}
						else {
							//ɾ����ΪҶ�ӽ��
							parent.leftChild=null;
							System.gc();//����GC���������ռ�
							return;
						}
					}
				}
				//Ҫ�ҵĽ���ڵ�ǰ�����ұߣ�����ߵ�һ�� Crtrl+C��
				else {
					current=current.rightChild;//��������ط�
					//�ҵ��ý��
					if(current.IData==key) {
						//Ҫɾ���Ľ��Ϊ��Ҷ�ӽ��
						/**
						 * ��ǰ�Ľ���Ƿ�Ҷ�ӽ�������Ƚϸ���
						 * a����ǰ��������������
						 * 	1����ǰ���������������������Ƿ�Ҷ�ӽ��/ ���Ƿ�Ҷ�ӽ��
						 * 	2����ǰ��������������������Ϊ��Ҷ�ӽڵ�
						 * 	3����ǰ��������������������ΪҶ�ӽڵ�
						 * b:ֻ��������������������
						 */
						if(current.leftChild!=null&&current.rightChild!=null) {
							//��ǰ��������������������Ϊ��Ҷ�ӽ��
							if(!isLeaf(current.leftChild)&&!isLeaf(current.rightChild)) {
								/**����һ��ͼһĿ��Ȼ��
								 * ֻҪ��ǰ�����������������Ӿͽ����ӷ����ϳ���ǰ�����
								 * 
								 * ������������ӣ��ͽ���ǰ�������������ڵ�ǰ�����
								 * 
								 */
								if(current.rightChild.leftChild!=null) {
									//���Ӳ�Ϊ�ս����ӷ��ڵ�ǰλ��
									Node temp=current.rightChild.leftChild;
									temp.leftChild=current.leftChild;
									current.rightChild.leftChild=null;
									parent.leftChild=temp;
									temp=null;
									System.gc();//����GC���������ռ�
									return;
									
								}else {
									//����Ϊ�� ֱ�ӽ���ǰ�������������ڵ�ǰ���λ��
									Node temp=current.rightChild;
									temp.leftChild=current.leftChild;
									parent.leftChild=temp;
									temp=null;
									System.gc();//����GC���������ռ�
									return;
									}
							}else {
									//��ǰ��������������ΪҶ�ӽ��
									Node temp=current.leftChild;
									temp.leftChild= current.leftChild;
									parent.leftChild=temp;
									temp=null;
									System.gc();
									return;
									
							}
						}
						//��ǰ���ֻ��������
						if (current.leftChild!=null&&current.rightChild==null){
								parent.leftChild=current.leftChild;
								current=null;
								System.gc();
								return;
						}
						//��ǰ���ֻ��������
						if (current.leftChild==null&&current.rightChild==null){
								parent.leftChild=current.rightChild;
								current=null;
								System.gc();
								return;
						}
						else {
							//ɾ����ΪҶ�ӽ��
							parent.leftChild=null;
							System.gc();//����GC���������ռ�
							return;
						}
					}
				}
			}
		}
		//�ж��Ƿ�ΪҶ�ӽ��
	public boolean isLeaf(Node node) {
		if(node.leftChild!=null||node.rightChild!=null) {
			return false;
		}else {
			return true;
		}
		
	}	
		//��������(����)
		public void display(Node root) {
			if(root!=null) {
				display(root.leftChild);//�������	
				System.out.print(root.IData+" ");
				display(root.rightChild);//�����ұ�
			}
			
			
		}
		//�������
		public void pdisplay(Node root) {
			if(root!=null) {
				System.out.print(root.IData+" ");
				pdisplay(root.leftChild);//�������	
				pdisplay(root.rightChild);//�����ұ�
			}
			
		}
		
		//�������
		public void fdisplay(Node root) {
			if(root!=null) {
				fdisplay(root.leftChild);//�������	
				fdisplay(root.rightChild);//�����ұ�
				System.out.print(root.IData+" ");
			}
			
		}
}
