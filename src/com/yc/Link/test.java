package com.yc.Link;

public class test {

	public static void main(String[] args) {
		
		
		LinkList linklist=new LinkList();
		linklist.insertFirst(22, 5);
		linklist.insertFirst(23, 5);
		linklist.insertFirst(24, 5);
		//linklist.deleteLink();
		Link reslut=linklist.query(23);
		System.out.println("idate is "+""+reslut.getIdate());
		linklist.show();
		reslut =linklist.delect(23);
		System.out.println("delect idate is "+""+reslut.getIdate());
		linklist.show();
	}

}
