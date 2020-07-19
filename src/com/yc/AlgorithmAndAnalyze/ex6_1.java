package com.yc.AlgorithmAndAnalyze;

import java.util.Scanner;

public class ex6_1 {
	static int n;// �ʺ����
	static long sum;// ��ǰ�������
	static int[] x;
	public static void BackTrack(int t) {
		if (t > n) {
				sum++;
		} else {
				for (int i = 1; i <= n; i++) {
					x[t] = i;
					if (Place(t))
						BackTrack(t + 1);
			}
		}
	}
	
	
	public static boolean Place(int k) {
		for (int j = 1; j < k; j++)
			if ((Math.abs(k - j) == Math.abs(x[j] - x[k])) || (x[j] == x[k]))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		// ����ʺ�ĸ���
		System.out.println("����ʺ�ĸ���:");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			if (str != null) {
				n = Integer.parseInt(str);
				sum = 0;
				x = new int[n + 1];
				for (int i = 0; i <= n; i++)
					x[i] = 0;
				BackTrack(1);
				System.out.println("�����:"+sum);
			} else {
				System.out.println("��������ȷ������~");
			}
		}
	}
}
