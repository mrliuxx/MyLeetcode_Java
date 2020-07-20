package test.algorithm.secondExam;

import java.util.Scanner;

public class twoJuZhenLC {
	// �������Ž��ַ���
	// ���ݼ�¼����ֵ�Ͽ�λ�õ�����s*�������Ž�
	public static String toString(int i, int j, int s[][]) {
		if (i == j) {
			return "A" + i;
		}
		return "(" + toString(i, s[i][j], s) + toString(s[i][j] + 1, j, s) + ")";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();
			int[] num = new int[count + 1];
			for (int i = 0; i < num.length; i++) {
				num[i] = scanner.nextInt();
			}

			int s2[][] = new int[count + 1][count + 1];
			int m2[][] = new int[count + 1][count + 1];
			juzhenlc_1(num, count, m2, s2);
			System.out.println(toString(1, count, s2));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	// �Ե�����(�ǵݹ�)�㷨
	public static void juzhenlc_1(int num[], int n, int m2[][], int s2[][]) {
		for (int i = 1; i <= n; i++) {// �������󣬳˻�����Ϊ0
			m2[i][i] = 0;
		}

		for (int r = 2; r <= n; r++) {// rΪÿ��ѭ������ĳ���
			for (int i = 1; i <= n - r + 1; i++) {// ��1��n-r+1ѭ��ȡ���󳤶�rʱ�ľ���
				int j = i + r - 1;

				m2[i][j] = m2[i + 1][j] + num[i - 1] * num[i] * num[j];// ȡ��һ����ȡλ��
				s2[i][j] = i; // �Ͽ�λ��Ϊi
				for (int k = i + 1; k < j; k++) {// ѭ��ȡk�Ŀ�ȡλ��
					int t = m2[i][k] + m2[k + 1][j] + num[i - 1] * num[k] * num[j];
					if (t < m2[i][j]) {
						m2[i][j] = t;
						s2[i][j] = k;
					}
				}
			}
		}
	}

}
