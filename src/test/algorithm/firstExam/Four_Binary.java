package test.algorithm.firstExam;

import java.util.Arrays;
import java.util.Scanner;

public class Four_Binary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();
			int[] numlist = new int[count];

			for (int i = 0; i < numlist.length; i++) {
				numlist[i] = scanner.nextInt();
			}
			Arrays.sort(numlist);

			int key = scanner.nextInt();
			int result = binary(numlist, key, 0, numlist.length - 1);
			if (result == -1) {
				System.out.println(key + "����������");
				key = scanner.nextInt();
				result = binary(numlist, key, 0, numlist.length - 1);
			} else {
				System.out.println(result);
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	// ���ֲ��ҵݹ�
	public static int binary(int[] a, int key, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		if (a[mid] == key) {
			return mid;
		} else if (a[mid] < key) {
			return binary(a, key, mid + 1, right);
		} else {
			return binary(a, key, left, mid - 1);
		}
	}
}
