package com.yc.Link;

public class LinkList {
   private Link FistLink;

public LinkList() {
	FistLink=null;
}

public Link getLink() {
	return FistLink;
}

public void setLink(Link Link) {
	Link = Link;
}

//判断链表是否为空
   public boolean isEmpty() {
	   return (FistLink==null);
   }
   //在头节点插入数据
   public void insertFirst(int i,double d) {
	   Link newLink=new Link(i,d);
	   newLink.setNext(FistLink);;
	   FistLink=newLink;
   }
   //从头节点删除节点
   public Link deleteLink() {
	   Link dlinke=FistLink;
	   FistLink=FistLink.getNext();
	   return dlinke;
   }
   //链表的遍历
   public void show() {
	   Link temp=FistLink;
	   while(temp!=null) {
		   System.out.println(temp.getIdate());
		   temp=temp.getNext(); 
	   }
	   
   }
   //查询单链表 
   public Link query(int key ) {
	   Link temp=FistLink;
	   while(key!=temp.getIdate()) {
		   if(temp.getNext()==null) {
			   return null;
		   }else {
			 temp=temp.getNext();  
		   }
	   }
	return temp;
	   
   }
   //删除节点返回删除的节点
   public Link delect(int key) {
	   Link temp2=FistLink;
	   Link temp=FistLink;
	   while(temp.getIdate()!=key) {
		   if(temp.getNext()==null) {
			   return null;
		   }else {
			   temp2=temp;
			   temp=temp.getNext();
		   }
	   }
	   if(FistLink==temp) {
		   FistLink=FistLink.getNext();
	   }else {
		  temp2.setNext(temp.getNext());
	   }
	return temp;
   }
   
}
