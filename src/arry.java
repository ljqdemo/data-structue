
public class arry {
	private long [] a;
	private int index;
	private long max;//���ֵ
	//���캯��
public arry(int max) {
	a=new long [max];
	index=0;
}

//��ȡ���ֵ
public long getMax() {
	for(int i=0;i<a.length;i++) {
		if(a[i]<a[i+1]) {
			max=a[i+1];
		}else {
			max=a[i];
		}	
	}
	return max;
}
//�������Ԫ��
	public void add(long s) {
		if(index<a.length) {
			a[index]=s;
			index++;
		}else {
			//�����������
			long temp []=new long[a.length*2];
			for(int i=0;i<a.length;i++) {
				temp[i]=a[i];
			}
			a=temp;
			a[index]=s;
			index++;
		}	
	}
//����
	public long[]getArry(){
		return a;
	}
	//��ȡ�����С
	public int getSize() {
		return a.length;
	}
	//ɾ����������
	public long[] deletDate(long date) {
		for(int i=0;i<a.length;i++) {
			if(date==a[i]) {
				for(int j=i;j<a.length-1;j++) {
					a[j]=a[j+1];
				}
				long []b=new long [a.length-1];
				for(int k=0;k<a.length-1;k++) {
					b[k]=a[k];
				}
				return b;
			}
		}
		return null;
		
	}
	//�۰����(bug��������ʱ�����ѭ��)
	public int find(long date) {
		int start=0;
		int end=a.length;
		int h=(start+end)/2;
		while(true) {
			if(a[h]==date) {
				return h;
			}else if(a[h]>date) {
				start=h;
				h=(start+end)/2;
			}else {
				end=h;
				h=(start+end)/2;
			}
			
		}
	
	}
	//ѡ������4,2,3,6,0
	public void insetSort(long a[]) {
		long min;
		int index = 0;
		for(int i=0;i<a.length-1;i++) {
			min=a[i];
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]&&a[j]<=min) {
					 min =a[j];	
					index=j;
				}else {
					index=i;
				}
			}
			a[index]=a[i];
			a[i]=min;
			System.out.println(a[i]);
		}
	} 
	
}
