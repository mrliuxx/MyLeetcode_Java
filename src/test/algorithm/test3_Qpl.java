package test.algorithm;

import java.util.Scanner;

//ʵ����n���ַ���ȡm��ȫ����(����)�ĵݹ��㷨
public class test3_Qpl {
	// ����������n,mλԪ�ص�λ��
	public static void swap(String[] num, int n, int m) {
		String temp = num[n];
		num[n] = num[m];
		num[m] = temp;
	}

	// ȫ����������begin��end��Ԫ��
	public static void perm(String[] num, int begin, int end) {
		// perm(R)=(r);
		if (begin == end) { // ��n==1ʱֻʣһ��endԪ�أ���һ���������������ݹ�
			String tostr = "result: "; // ���endԪ��ǰ��Ԫ��(��ǰ׺Ԫ��)�ټ���endԪ��
			for (int i = 0; i <= end; i++) {
				tostr = tostr + num[i] + " ";
			}
			System.out.println(tostr);
		}
		// perm(R)��(r1)perm(R1)��(r2)perm(R2)...(rn)perm(Rn)���;
		// Rn=R-{rn},��ԭ����ȥ��rn���Ԫ�غ������;
		else { // ��n>1ʱ�����ж��Ԫ�ش�����
			for (int i = begin; i <= end; i++) { // �����һ���ݹ鼴ֻ��һ��endԪ�ص������ǰ�����ݹ飬
				swap(num, begin, i);
				perm(num, begin + 1, end);
				swap(num, begin, i); // ÿ�ν���׺Ԫ�����������ǰ��һ��Ԫ�أ��ٴεݹ�
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("�����������������鳤��(����Ҫ̫��,���Ϊ1-5)ʵ�ֵݹ��㷨��");
		Scanner scanner = new Scanner(System.in);

		String count = scanner.next();

		try {
			int number = Integer.parseInt(count);

			if (number > 0 && number < 6) {
				System.out.println("������������������(Ԫ�ؿ������ַ�������)��");
				String[] str = new String[number];
				String tostring = "������������Ϊ��";
				for (int i = 0; i < number; i++) {
					str[i] = scanner.next();
					tostring = tostring + str[i] + " ";
				}
				System.out.println(tostring); // ����������е�����
				System.out.println("*************************");

				perm(str, 0, str.length - 1); // ȫ������������,��n==m;
			} else {
				System.out.println("�Բ���������Ĳ����Ϲ���");
			}
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			e.getMessage();
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			e2.getMessage();
		}
	}
}
