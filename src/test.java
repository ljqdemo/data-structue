
public class test {

	public static void main(String[] args) {
		arry  ar=new arry(2);
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);
		
		long [] b=ar.deletDate(4);
		System.out.println("���鳤��"+b.length);
		
		  for(int i=0;i<b.length;i++) { 
		  System.out.println(b[i]+" " );
		  System.out.println("���鳤��"+b.length);
		  }
		  int index=ar.find(3);
		  System.out.println("�����ţ�"+index);
		long [] a= {4,2,3,6,0};
		ar.insetSort(a);
		System.out.println("ѡ�������Ľ��");
		for(int index1=0;index1<a.length;index1++) {
			System.out.print(a[index1]+" ");
		}
	}

}
