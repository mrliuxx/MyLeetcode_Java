package test.algorithm.firstExam;

import java.util.Scanner;

public class Two_Qpl {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();
			String[] str = new String[count];

			for (int i = 0; i < str.length; i++) {
				str[i] = scanner.next();
			}
			perm(str, 0, str.length - 1);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	// ȫ����������begin��end��Ԫ��
	public static void perm(String[] num, int begin, int end) {
		if (begin == end) {
			String tostr = "";
			for (int i = 0; i <= end; i++) {
				tostr = tostr + num[i] + " ";
			}
			System.out.println(tostr);
		} else {
			for (int i = begin; i <= end; i++) {
				swap(num, begin, i);
				perm(num, begin + 1, end);
				swap(num, begin, i);
			}
		}
	}

	// ����������n,mλԪ�ص�λ��
	public static void swap(String[] num, int n, int m) {
		String temp = num[n];
		num[n] = num[m];
		num[m] = temp;
	}

}
