package test.algorithm.firstExam;

import java.util.Scanner;

public class Six_QuickSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();
			int[] numlist = new int[count];

			for (int i = 0; i < numlist.length; i++) {
				numlist[i] = scanner.nextInt();
			}
			QuickSort(numlist, 0, numlist.length - 1);
			System.out.println(ToString(numlist));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String ToString(int[] num) {
		String str = "";
		for (int i = 0; i < num.length; i++) {
			str += num[i] + " ";
		}
		return str;
	}

	// ��������
	public static void QuickSort(int[] num, int lef, int rig) {
		if (lef < rig) {
			int q = Partition(num, lef, rig);

			QuickSort(num, lef, q - 1); // ����������
			QuickSort(num, q + 1, rig); // ���Ұ������
		}
	}

	public static int Partition(int[] num, int lef, int rig) {
		// ��ʼ�ͽ����±�
		int i = lef, j = rig;
		// ѡ���һ��Ԫ��Ϊ��׼Ԫ��
		int vot = num[i];
		// ѭ���������� i=j
		while (i != j) {
			// ���������ұȻ�׼Ԫ��С�ģ���Ĳ���ֱ����һ��
			while (i < j && vot <= num[j])
				j--;
			// �ҵ���ֵ֮���� i<j����� ��jΪ�±��ֵ������i����i++
			if (i < j)
				num[i++] = num[j];
			// ���������ұȻ�׼Ԫ�ش�ģ�С�Ĳ���ֱ����һ��
			while (i < j && vot >= num[i]) {
				i++;
			}
			if (i < j)
				num[j--] = num[i];
		}
		num[i] = vot;
		return i;
	}

	// public static int[] number;
	// public static int Partition(int p, int r) {
	// int i = p, j = r + 1;
	// int x = number[p];
	// while (true) {
	// while (number[++i] < x && i < r) ;
	// while (number[--j] > x) ;
	// if (i >= j)
	// break;
	// int temp = number[i];
	// number[i] = number[j];
	// number[j] = temp;
	// }
	// number[p] = number[j];
	// number[j] = x;
	// return j;
	// }

}
