package com.yc.Link;
/**
 * ��������
 * @author 29226
 *
 */
public class SortLink {
	
	private Link first;//ͷ���
	
	//constructor
	public SortLink() {
		first=null;
	}
	
	//�Ƴ�Ԫ��ֻ֧�ִ�ͷ����ʼ�Ƴ�
	public Link remove() {
		
			Link temp=first;
			
			first=first.getNext();
			return temp;
		
		
	}
	//չʾ����Ԫ��
	public void display() {
		System.out.print("List -->last:");
		Link current=first;
		while(current!=null) {
			System.out.print("-->"+current.getIdate());
			current=current.getNext();
		}
		System.out.println("");
	}
	//����Ԫ��
	public void insert(int key ) {
		Link newLink=new Link(key);
		Link previo=null;//ǰһ��λ�õĽ��
		Link courrent=first;//��ǰλ�õĽ��
		//Ѱ�Ҳ���λ��    
		//����ѭ����courentΪҪ����Ľ��λ�õ�ǰһ�����
		while(courrent!=null && courrent.getIdate()<key) {
			previo=courrent;
			courrent=courrent.getNext();
		}
		//�����λ��Ϊͷ��㣨�������ͷ��ʱ��
		if(previo==null) {
			//ֱ�Ӳ���ͷ���
			first=newLink;
		}else {
			//�������λ������λ�õ�ʱ��
			
			previo.setNext(newLink);
		}
		newLink.setNext(courrent);
		
	}
	
	//����
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
