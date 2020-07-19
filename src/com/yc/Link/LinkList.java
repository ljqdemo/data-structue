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

//�ж������Ƿ�Ϊ��
   public boolean isEmpty() {
	   return (FistLink==null);
   }
   //��ͷ�ڵ��������
   public void insertFirst(int i,double d) {
	   Link newLink=new Link(i,d);
	   newLink.setNext(FistLink);;
	   FistLink=newLink;
   }
   //��ͷ�ڵ�ɾ���ڵ�
   public Link deleteLink() {
	   Link dlinke=FistLink;
	   FistLink=FistLink.getNext();
	   return dlinke;
   }
   //����ı���
   public void show() {
	   Link temp=FistLink;
	   while(temp!=null) {
		   System.out.println(temp.getIdate());
		   temp=temp.getNext(); 
	   }
	   
   }
   //��ѯ������ 
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
   //ɾ���ڵ㷵��ɾ���Ľڵ�
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
