package test.algorithm.firstExam;

import java.util.Scanner;

public class Five_HebingSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();
			int[] numlist = new int[count];

			for (int i = 0; i < numlist.length; i++) {
				numlist[i] = scanner.nextInt();
			}
			HebingSort(numlist, 0, numlist.length - 1);
			// System.out.println(ToString(numlist));
			ToString(numlist);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	// �ϲ�����ݹ��㷨
	public static void HebingSort(int[] num, int lef, int rig) {
		if (lef < rig) {
			int num2[] = new int[num.length];
			int m = (lef + rig) / 2;
			HebingSort(num, lef, m);
			HebingSort(num, m + 1, rig);
			HeBing(num, num2, lef, m, rig);
			Copy(num, num2, lef, rig);
		}
	}

	public static void HeBing(int[] num, int[] num2, int lef, int mid, int rig) {
		// �ϲ�num[lef:mid]��num[mid+1:rig]��num2[lef:rig]
		int i = lef, j = mid + 1, k = lef;

		while ((i <= mid) && (j <= rig)) {
			if (num[i] <= num[j]) {
				num2[k++] = num[i++];
			} else {
				num2[k++] = num[j++];
			}
		}
		if (i > mid) {
			for (int q = j; q <= rig; q++) {
				num2[k++] = num[q];
			}
		} else {
			for (int q = i; q <= mid; q++) {
				num2[k++] = num[q];
			}
		}
	}

	public static void Copy(int[] num, int[] num2, int lef, int rig) {
		// Ĭ��num��num2�����鳤��һ�£����Բ��������ݴ���ֱ�Ӹ���Ԫ��
		for (int i = lef; i <= rig; i++) {
			num[i] = num2[i];
		}
	}

	public static void ToString(int[] num) {
		// String str="";
		// for (int i = 0; i < num.length; i++) {
		// str+=num[i]+" ";
		// }
		// return str;
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
