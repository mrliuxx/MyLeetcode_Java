package test.algorithm.secondExam;

import java.util.Scanner;

public class FourbinartSearchTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();// ��������������ĸ���

			int[] succProbability = new int[count + 1];// (���ʡ�100)�����������������ɹ��ĸ��ʡ�count
			for (int i = 1; i <= count; i++) {
				succProbability[i] = scanner.nextInt();
			}
			int[] failProbability = new int[count + 1];// (���ʡ�100)����������������ʧ�ܵĸ��ʡ�(count+1)
			for (int i = 0; i <= count; i++) {
				failProbability[i] = scanner.nextInt();
			}

			int[][] s = new int[count + 2][count + 1];// ��ѽڵ�
			int[][] w = new int[count + 2][count + 1];
			int[][] m = new int[count + 2][count + 1];
			oBST(count, succProbability, failProbability, w, m, s);
			ToString(1, count, s);// ���Ž�
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	// �Ե�����(�ǵݹ�)�㷨
	public static void oBST(int count, int[] succProbability, int[] failProbability, int[][] w, int[][] m, int[][] s) {
		for (int i = 0; i <= count; i++) {
			w[i + 1][i] = failProbability[i];
			m[i + 1][i] = 0;
		}
		for (int r = 0; r < count; r++) {
			for (int i = 1; i <= count - r; i++) {
				int j = i + r;
				w[i][j] = w[i][j - 1] + succProbability[j] + failProbability[j];
				m[i][j] = m[i + 1][j];
				s[i][j] = i;
				for (int k = i + 1; k <= j; k++) {
					int t = m[i][k - 1] + m[k + 1][j];
					if (t < m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}
				m[i][j] += w[i][j];
			}
		}
	}

	// �������Ž�
	public static void ToString(int i, int j, int[][] s) {
		if (i < j) {
			int root = s[i][j];// ���ڵ�
			System.out.println("s" + root + "�Ǹ�");
			if (s[i][root - 1] > 0) {
				System.out.println("s" + root + "��������s" + s[i][root - 1]);
			}
			if (s[root + 1][j] > 0) {
				System.out.println("s" + root + "���Һ�����s" + s[root + 1][j]);
			}
			ToString(i, root - 1, s);
			ToString(root + 1, j, s);
		}
	}

}
