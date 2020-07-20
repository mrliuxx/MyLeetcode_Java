package test.algorithm;

import java.util.Scanner;

public class test13_binartSearchTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("��������������ĸ�����");
			int count = scanner.nextInt();

			System.out.println("(���ʡ�100)�����������������ɹ��ĸ��ʡ�count��");
			int[] succProbability = new int[count + 1];
			for (int i = 1; i <= count; i++) {
				succProbability[i] = scanner.nextInt();
			}
			System.out.println("(���ʡ�100)����������������ʧ�ܵĸ��ʡ�(count+1)��");
			int[] failProbability = new int[count + 1];
			for (int i = 0; i <= count; i++) {
				failProbability[i] = scanner.nextInt();
			}

			int[][] s = new int[count + 2][count + 1];// ��ѽڵ�
			int[][] w = new int[count + 2][count + 1];
			int[][] m = new int[count + 2][count + 1];
			oBST(count, succProbability, failProbability, w, m, s);
			System.out.println("��Сƽ��·���Ķ����������ǣ�");
			ToString(1, count, s);// ���Ž�
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
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
				w[i][j] = w[i][j - 1] + failProbability[j] + succProbability[j];
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
		if (j > i) {
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
