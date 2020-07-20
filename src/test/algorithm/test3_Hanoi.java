package test.algorithm;

import java.util.Scanner;

//ʵ��Hanoi���ĵݹ��㷨
public class test3_Hanoi {
	static int count = 0; // ��¼Բ���ƶ�����

	// ��n��Բ�̴�A�ƶ���B��C������
	public static void Hanoi(int n, String A, String B, String C) {
		if (n > 0) {
			count++;
			Hanoi(n - 1, A, C, B); // ��n-1��Բ�̴�A�ƶ���C��B������
			System.out.println("move " + A + " to " + B); // �����һ����A�ƶ���B
			Hanoi(n - 1, C, B, A); // ��n-1��Բ�̴�C�ƶ���B��A������
		}
	}

	public static void main(String[] args) {
		System.out.println("s������Բ�̸���������Ҫ̫��ʵ�ֵݹ��㷨��");
		Scanner scanner = new Scanner(System.in);

		String num1 = scanner.next();

		try {
			int number1 = Integer.parseInt(num1);

			String A = "A", B = "B", C = "C";
			Hanoi(number1, A, B, C);
			System.out.println(number1 + "��Բ����Ҫ�ƶ�" + count + "�Σ�");
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			e.getMessage();
		}
	}

}
