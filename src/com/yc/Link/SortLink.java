package com.yc.Link;
/**
 * 有序链表
 * @author 29226
 *
 */
public class SortLink {
	
	private Link first;//头结点
	
	//constructor
	public SortLink() {
		first=null;
	}
	
	//移除元素只支持从头部开始移除
	public Link remove() {
		
			Link temp=first;
			
			first=first.getNext();
			return temp;
		
		
	}
	//展示链表元素
	public void display() {
		System.out.print("List -->last:");
		Link current=first;
		while(current!=null) {
			System.out.print("-->"+current.getIdate());
			current=current.getNext();
		}
		System.out.println("");
	}
	//插入元素
	public void insert(int key ) {
		Link newLink=new Link(key);
		Link previo=null;//前一个位置的结点
		Link courrent=first;//当前位置的结点
		//寻找插入位置    
		//跳出循环的courent为要插入的结点位置的前一个结点
		while(courrent!=null && courrent.getIdate()<key) {
			previo=courrent;
			courrent=courrent.getNext();
		}
		//插入的位置为头结点（即链表表头的时候）
		if(previo==null) {
			//直接插入头结点
			first=newLink;
		}else {
			//当插入的位置其他位置的时候
			
			previo.setNext(newLink);
		}
		newLink.setNext(courrent);
		
	}
	
	//测试
	public static void main(String[] args) {
		SortLink sort=new SortLink();
		
		sort.insert(8);
		sort.insert(5);
		sort.display();
		sort.insert(1);
		sort.insert(4);
		
		sort.display();
		
	}
}
