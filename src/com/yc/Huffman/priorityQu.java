package com.yc.Huffman;
/**
 * 优先级队列
 * 这里采用的是有序数组的方式来实现优先级队列
 * 更优化的方式其实可以采用有序链表来实现优先级队列因为大多的有序数组都可以用有序队列来实现替换
 * 且性能会更加的好(减少了大量的交换次数)
 * 
 * @author 29226
 *
 */
public class priorityQu {
	public int maxsize;
	public Node[] quArray;
	public int nitem;//元素指针
	//初始化
	public priorityQu(int size) {
		maxsize=size;
		quArray=new Node[maxsize];
		nitem=0;
	}
	
	//入队的方法
	public void insert(Node node) {
		int j=0;
		if(nitem==0) {
			//队列没有元素直接加入第一个元素
			quArray[nitem++]=node;
		}else {
			//要插入的位置在队列中间
			for(j=nitem-1;j>=0;--j) {
				if(node.priority>quArray[j].priority) {
					quArray[j+1]=quArray[j];
				}else {
					//找到了要插入的位置
					break;
				}
			}
			//因为到了要插入的位置的时候j 已经指向了前面一个元素
			//要插入的位置在j的后面一个的位置
			quArray[j+1]=node;
			++nitem;
		}
	}
	//移除元素的方法(每次移除的都是最小值)
	public Node remove() {
		Node temp=quArray[--nitem];
		quArray[nitem]=null;
		return temp;
	}
	//队列是否为空
	public boolean isEmpty() {
		if(nitem==0) {
			return true;
			
		}else {
			return false;
		}
	}
	//返回元素个数
	public int size() {
		return nitem;
	}
	
}
