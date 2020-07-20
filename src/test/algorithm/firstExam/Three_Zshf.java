package test.algorithm.firstExam;

import java.util.Scanner;

public class Three_Zshf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = scanner.nextInt();

			System.out.println(Zshf(n, n));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int Zshf(int n, int m) {
		if ((n < 1) || (m < 1))
			return 0;
		if ((n == 1) || (m == 1))
			return 1;
		if (n < m)
			return Zshf(n, n);
		if (n == m)
			return Zshf(n, n - 1) + 1;
		else
			return Zshf(n - m, m) + Zshf(n, m - 1);
	}

}
