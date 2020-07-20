package test.algorithm;

import java.util.Scanner;

//ʵ��쳲��������е��㷨(����)
public class test7_fibonacciDtgh {
	public static void main(String[] args) {
		System.out.println("������һ������������쳲��������У�");
		Scanner scanner = new Scanner(System.in);

		String num1 = scanner.next();
		System.out.println("*************************");
		try {
			int number1 = Integer.parseInt(num1);

			if (number1 > 0) {
				System.out.println("����쳲���������(��ͨ�ݹ�)�ĵ�" + (number1 + 1) + "������" + fibonacci_1(number1) + "��");
				System.out.println("����쳲���������(�Զ�����)�ĵ�" + (number1 + 1) + "������" + fibonacci_2(number1) + "��");
				// System.out.println("����쳲���������(�Ե�����)�ĵ�"+number1+"������"+fibonacci_3(number1-1)+"��");
			} else {
				System.out.println("�Բ������������������������");
			}
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			System.out.println(e.getMessage());
		}
	}

	// ��ͨ�ݹ��㷨
	public static int fibonacci_1(int n) {
		if (n > 1) {
			return fibonacci_1(n - 1) + fibonacci_1(n - 2);
		} else {
			return 1;
		}
	}

	// �Զ������㷨(��̬�滮-����¼)
	public static int fibonacci_2(int n) {
		int num[] = new int[n + 1]; // ����һ����n+1һ����������(0��λ�޶�Ӧ��������)
									// ��Ӧ���fibonacci����(�����±��1��ʼ)������

		// ����ĳ�ʼֵһ����0��������Ԫ�ز�Ϊ0��
		if (num[n] != 0) { // ����������num[n]��Ϊ0����һ�������еĵ�n����
			return num[n];
		}
		// ����������num[n]Ϊ0����Ӧ���fibonacci���е�����
		if (n > 1) {
			return num[n] = fibonacci_2(n - 1) + fibonacci_2(n - 2);
		} else {
			return num[n] = 1;
		}
	}
	// //�Ե������㷨(�ǵݹ�)
	// public static int fibonacci_3(int n){
	//
	// return 0;
	// }

}
