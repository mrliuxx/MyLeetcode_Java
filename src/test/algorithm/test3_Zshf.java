package test.algorithm;

import java.util.Scanner;

//ʵ�����������ֵĵݹ��㷨
public class test3_Zshf {
	// ����������(nΪ��������number1��mΪ���ƻ��ַ�Χnumber2)
	public static int Zshf(int n, int m) {
		// ��������һ���������������ٻ���
		if (n < 1 || m < 1) {
			return 0;
		}
		// ����ΧΪ1ʱ�����۱�������nΪ���٣���ֻ��һ�ֻ��ּ�ȫ1��ӵ�n;
		if (n == 1 && m == 1) {
			return 1;
		}
		// ����Χm���ڱ�������nʱ���൱�ڻ���n��������Χ�����ʱ��Χm����ڱ����n��
		if (n < m) {
			return Zshf(n, n);
		}
		// ����Χm���ڱ�������nʱ��Ҳ�൱�ڻ���n��������Χ��
		// ��n=n(��n=m)��һ�ֻ��֣��ټ��ϱ�������n�ڷ�Χm<=n-1�ĵݹ黮����ɡ�
		if (n == m) {
			return 1 + Zshf(n, n - 1);
		}
		// ����ΧmС�ڱ�������nʱ���൱�ڶ�n�е�1--m�ķ�Χ���֡�
		// �ɱ�������n-m�ڷ�ΧΪm�Ļ��֣��ټ��ϱ�������n�ڷ�Χm<=m-1�ĵݹ黮����ɡ�
		return Zshf(n - m, m) + Zshf(n, m - 1);
	}

	public static void main(String[] args) {
		System.out.println("������һ��������ʵ�ֵݹ��㷨��");
		Scanner scanner = new Scanner(System.in);

		String num1 = scanner.next();
		System.out.println("������һ������������number1�Ļ��ֽ���(������)��");
		String num2 = scanner.next();

		try {
			int number1 = Integer.parseInt(num1);
			int number2 = Integer.parseInt(num2);

			// ��number1<=number2(������)��������һ�����൱�ڻ���number1������Χ��
			// �������Ƕ�number1�е�1---number2��Χ���л��֡�
			if (number2 > 0 && number1 > 0) {
				System.out.println("������" + number1 + "������" + number2 + "�Ļ��ָ���Ϊ��" + Zshf(number1, number2) + "����");
			} else {
				System.out.println("�Բ���������Ĳ����Ϲ���");
			}
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			e.getMessage();
		}
	}

}
