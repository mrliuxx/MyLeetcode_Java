package test.algorithm;

import java.util.Arrays;
import java.util.Scanner;

//ʵ�ֶ��ֲ��ҵķǵݹ��Լ��ݹ��㷨
public class test4_binary {
	// ���ֲ��ҷǵݹ�
	public static int binaryNotRecursion(int[] a, int key, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (a[mid] == key) { // ��λmidԪ�ص���keyֵ���򷵻�keyֵ�±�mid
				return mid;
			} else if (a[mid] < key) { // ��λmidԪ��С��keyֵ����keyֵһ������һ�룻��Χleft��mid+1���ҷ�Χ����
				left = mid + 1;
			} else {
				right = mid - 1; // ��λmidԪ�ش���keyֵ����keyֵһ������һ�룻��Χ���䣬�ҷ�Χright��mid-1
			}
		}
		return -1;
	}

	// ���ֲ��ҵݹ�
	public static int binaryRecursion(int[] a, int key, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		if (a[mid] == key) { // ��λmidԪ�ص���keyֵ���򷵻�keyֵ�±�mid
			return mid;
		} else if (a[mid] < key) { // ��λmidԪ��С��keyֵ����keyֵһ������һ�룻��Χleft��mid+1���ҷ�Χ����
			return binaryRecursion(a, key, mid + 1, right);
		} else { // ��λmidԪ�ش���keyֵ����keyֵһ������һ�룻��Χ���䣬�ҷ�Χright��mid-1
			return binaryRecursion(a, key, left, mid - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("������һ����������ȷ��������Ԫ�ظ���(����ʮΪ��)��");
		Scanner scanner = new Scanner(System.in);

		String countstr = scanner.next();
		try {
			int count = Integer.parseInt(countstr);

			int[] numlist = new int[count];
			System.out.println("������һ��������");
			for (int i = 0; i < count; i++) {
				String num = scanner.next();
				numlist[i] = Integer.parseInt(num);
			}

			Arrays.sort(numlist);
			String toString = "numlist[ ";
			for (int i = 0; i < count; i++) {
				toString += numlist[i] + " ";
			}
			System.out.println("�������������飺" + toString + "]");
			System.out.println("*********************************");

			System.out.println("������һ��Ҫ���ҵ�����");
			String number = scanner.next();
			int key = Integer.parseInt(number);

			int n = binaryNotRecursion(numlist, key, 0, count);
			if (n != -1) {
				System.out.println("���Ƕ��ֲ��ҷǵݹ��㷨�Ľ������һ���ؼ���" + key + "λ�������" + n + "��λ��");
			} else {
				System.out.println("���Ƕ��ֲ��ҷǵݹ��㷨�Ľ�����ؼ���" + key + "������������");
			}

			int m = binaryRecursion(numlist, key, 0, count);
			if (m != -1) {
				System.out.println("���Ƕ��ֲ��ҵݹ��㷨�Ľ������һ���ؼ���" + key + "λ�������" + m + "��λ��");
			} else {
				System.out.println("���Ƕ��ֲ��ҵݹ��㷨�Ľ�����ؼ���" + key + "������������");
			}
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			System.out.println(e.getMessage());
		}
	}

}
