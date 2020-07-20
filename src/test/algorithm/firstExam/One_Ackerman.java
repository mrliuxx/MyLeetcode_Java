package test.algorithm.firstExam;

import java.util.Scanner;

public class One_Ackerman {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			System.out.println(ackerman(n, m));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

	// ����������
	public static int ackerman(int n, int m) {
		if (m == 0 && n == 1) {
			return 2;
		} else if (m >= 0 && n == 0) {
			return 1;
		} else if (m == 0 && n >= 2) {
			return n + 2;
		} else if (m >= 1 && n >= 1) {
			return ackerman(ackerman(n - 1, m), m - 1);
		} else {
			throw new IllegalArgumentException(); // �׳������������쳣
		}
	}
	// //����������
	// public static int ackerman(int n, int m) {
	// if (n == 0)
	// return 1;
	// else if (m == 0) {
	// if (n == 1)
	// return 2;
	// else
	// return (n + 2);
	// } else
	// return ackerman(ackerman(n - 1, m), m - 1);
	// }

}
