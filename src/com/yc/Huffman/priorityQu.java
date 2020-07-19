package com.yc.Huffman;
/**
 * ���ȼ�����
 * ������õ�����������ķ�ʽ��ʵ�����ȼ�����
 * ���Ż��ķ�ʽ��ʵ���Բ�������������ʵ�����ȼ�������Ϊ�����������鶼���������������ʵ���滻
 * �����ܻ���ӵĺ�(�����˴����Ľ�������)
 * 
 * @author 29226
 *
 */
public class priorityQu {
	public int maxsize;
	public Node[] quArray;
	public int nitem;//Ԫ��ָ��
	//��ʼ��
	public priorityQu(int size) {
		maxsize=size;
		quArray=new Node[maxsize];
		nitem=0;
	}
	
	//��ӵķ���
	public void insert(Node node) {
		int j=0;
		if(nitem==0) {
			//����û��Ԫ��ֱ�Ӽ����һ��Ԫ��
			quArray[nitem++]=node;
		}else {
			//Ҫ�����λ���ڶ����м�
			for(j=nitem-1;j>=0;--j) {
				if(node.priority>quArray[j].priority) {
					quArray[j+1]=quArray[j];
				}else {
					//�ҵ���Ҫ�����λ��
					break;
				}
			}
			//��Ϊ����Ҫ�����λ�õ�ʱ��j �Ѿ�ָ����ǰ��һ��Ԫ��
			//Ҫ�����λ����j�ĺ���һ����λ��
			quArray[j+1]=node;
			++nitem;
		}
	}
	//�Ƴ�Ԫ�صķ���(ÿ���Ƴ��Ķ�����Сֵ)
	public Node remove() {
		Node temp=quArray[--nitem];
		quArray[nitem]=null;
		return temp;
	}
	//�����Ƿ�Ϊ��
	public boolean isEmpty() {
		if(nitem==0) {
			return true;
			
		}else {
			return false;
		}
	}
	//����Ԫ�ظ���
	public int size() {
		return nitem;
	}
	
}
