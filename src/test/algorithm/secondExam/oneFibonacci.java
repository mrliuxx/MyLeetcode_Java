package test.algorithm.secondExam;

import java.util.Scanner;

public class oneFibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int number = scanner.nextInt();

			System.out.println(fibonacci(number));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// �Զ������㷨(��̬�滮-����¼)
	public static int fibonacci(int number) {
		int num[] = new int[number + 1];// ����һ����n+1һ����������(0��λ�޶�Ӧ��������)
										// ��Ӧ���fibonacci����(�����±��1��ʼ)������
		// ����ĳ�ʼֵһ����0��������Ԫ�ز�Ϊ0��
		if (num[number] != 0) {
			return num[number]; // ����������num[n]��Ϊ0����һ�������еĵ�n����
		}
		// ����������num[n]Ϊ0����Ӧ���fibonacci���е�����
		if (number >= 2) {
			return num[number] = fibonacci(number - 1) + fibonacci(number - 2);
		} else {
			return num[number] = 1;
		}

		// int num[]=new int[number+1];
		//
		// if(num[number]!=0){
		// return num[number];
		// }
		// int x=0;
		// if(number==0||number==1){
		// x=1;
		// }else if(number>=2){
		// x=fibonacci(number-1)+fibonacci(number-2);
		// }
		// return num[number]=x;
		//
	}

}
