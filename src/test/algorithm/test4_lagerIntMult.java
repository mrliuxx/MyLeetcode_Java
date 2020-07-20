package test.algorithm;

import java.util.Scanner;

//ʵ��(ʮ����)�������˵ݹ��㷨����
public class test4_lagerIntMult {
	final static int m = 10; // ����Ϊʮ���Ƽ���

	public static void main(String[] args) {
		System.out.println("������Ҫ�����������ͬλ����������");
		Scanner scanner = new Scanner(System.in);
		String onenum = scanner.next();
		String twonum = scanner.next();
		int n1 = onenum.length(); // ���ȱ�ʾ����λ��
		int n2 = twonum.length(); // ���ȱ�ʾ����λ��

		try {
			long one = Long.parseLong(onenum);// 1011
			long two = Long.parseLong(twonum);// 1101
			int n = 0; // n��ʾ��������λ����
			if (one < 0) {
				n1 = n1 - 1; // ��oneΪ�������򳤶ȼ�ȥһλ����λ��ʾλ��
			}
			if (two < 0) {
				n2 = n2 - 1; // ��oneΪ�������򳤶ȼ�ȥһλ����λ��ʾλ��
			}

			if (one == 0 || two == 0) { // ��one��two��0�����ٽ�������
				System.out.println("�Բ������������������");
			} else if (n1 == n2) { // ��one��twoλ����ȲŽ�������
				n = n1; // n��ʾλ����

				// ��ȡʱ�������¼�㷨����ʱ��
				long start = System.currentTimeMillis();
				System.out.println("������Ϊ��" + Mult(one, two, n, m));
				long end = System.currentTimeMillis();
				System.out.println("�㷨ִ��ʱ��Ϊ��" + (end - start) + "���룡");
			} else {
				System.out.println("�Բ������������������");
			}
		} catch (NumberFormatException e) {
			System.out.println("�Բ������������������");
			System.out.println(e.getMessage());
		}
	}

	// ��������
	public static long Mult(long a, long b, int n, int m) {
		// a,bȡ�����Լ�����ֵ
		long sign1 = 1, sign2 = 1; // a,b�ķ��ţ���+1��-1����
		if (a < 0) {
			sign1 = -1;
			a = a * sign1; // ��aΪ������ȡa�ľ���ֵ
		}
		if (b < 0) {
			sign2 = -1;
			b = b * sign2; // ��aΪ������ȡa�ľ���ֵS
		}
		long sign = sign1 * sign2; // ��ʾ�˻��ķ��š�

		if (n == 1) { // ���λ��nΪ1����ɷ��ؾ���ֵ
			if (a == 1 && b == 1) {
				return sign;
			}
			return 0;
		} else {
			long A = a / (long) Math.pow(m, n / 2);
			long B = a % (long) Math.pow(m, n / 2);
			long C = b / (long) Math.pow(m, n / 2);
			long D = b % (long) Math.pow(m, n / 2);
			System.out.println("A=" + A);
			System.out.println("B=" + B);
			System.out.println("C=" + C);
			System.out.println("D=" + D);
			System.out.println("******************");

			// ��ϵ��
			long m1 = Mult(A, C, n / 2, m);
			long m2 = Mult(A - C, D - B, n / 2, m);
			long m3 = Mult(B, D, n / 2, m);
			// ���ݹ�ʽ
			return sign * (m1 * (long) Math.pow(m, n) + (m1 + m2 + m3) * (long) Math.pow(m, n / 2) + m3);
		}
	}

}
