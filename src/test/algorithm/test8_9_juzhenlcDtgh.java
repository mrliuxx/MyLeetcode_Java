package test.algorithm;

import java.util.Scanner;

//ʵ�־������˵��㷨(����)

//a.�α�49ҳ���㷨������
//b.�α�47ҳ���㷨������
//c.�α�51ҳ���㷨������
public class test8_9_juzhenlcDtgh {
	// ����m[][]Ϊ����ֵ���飬����s[][]Ϊ��¼����ֵ�Ͽ�λ�õ�����
	private static int s1[][] = new int[30][30];

	private static int s2[][] = new int[30][30];
	private static int m2[][] = new int[30][30];

	private static int s3[][] = new int[30][30];
	private static int m3[][] = new int[30][30];
	private static int p3[] = new int[30];

	public static int[] getP3() {
		return p3;
	}

	public static void setP3(int[] p3) {
		test8_9_juzhenlcDtgh.p3 = p3;
	}

	public static void main(String[] args) {
		System.out.println("������Ҫ���˵ľ������:");
		Scanner scanner = new Scanner(System.in);

		try {
			int count = scanner.nextInt();

			System.out.println("���������˾����ά��:");
			int num[] = new int[count + 1];
			for (int i = 0; i < num.length; i++) {
				num[i] = scanner.nextInt();
			}

			System.out.println("***************************************");
			juzhenlc_1(1, count, num);
			System.out.println("������ͨ�ݹ��㷨�����" + toString(1, count, s1));

			System.out.println("***************************************");
			juzhenlc_2(num, count, m2, s2);
			System.out.println("�����Ե�����(�ǵݹ�)�㷨�����" + toString(1, count, s2));

			System.out.println("***************************************");
			test8_9_juzhenlcDtgh.setP3(num);
			juzhenlc_3(count, m3, s3);
			System.out.println("�����Զ����µݹ��㷨�����" + toString(1, count, s3));
		} catch (Exception e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			System.out.println(e.getMessage());
		}
	}

	// �������Ž��ַ���
	// ���ݼ�¼����ֵ�Ͽ�λ�õ�����s*�������Ž�
	public static String toString(int i, int j, int s[][]) {
		if (i == j) {
			return "A" + i;
		}
		return "(" + toString(i, s[i][j], s) + toString(s[i][j] + 1, j, s) + ")";
	}

	// ��ͨ�ݹ��㷨
	// ���õݹ�ʽֱ�Ӽ���A[i:j]�ĵݹ��㷨
	public static int juzhenlc_1(int i, int j, int p[]) {
		if (i == j) {
			return 0;
		}
		int u = juzhenlc_1(i, i, p) + juzhenlc_1(i + 1, j, p) + p[i - 1] * p[i] * p[j];
		s1[i][j] = i;
		for (int k = i + 1; k < j; k++) {
			int t = juzhenlc_1(i, k, p) + juzhenlc_1(k + 1, j, p) + p[i - 1] * p[k] * p[j];
			if (t < u) {
				u = t;
				s1[i][j] = k;
			}
		}
		return u;
	}

	// �Ե�����(�ǵݹ�)�㷨
	// ���ݵݹ�ʽ���Ե����ϵķ�ʽ���㣬�����˴������ظ�����
	public static void juzhenlc_2(int p[], int n, int m[][], int s[][]) {
		for (int i = 1; i <= n; i++) {// �������󣬳˻�����Ϊ0
			m2[i][i] = 0;
		}

		for (int r = 2; r <= n; r++) {// rΪÿ��ѭ������ĳ���
			for (int i = 1; i <= n - r + 1; i++) {// ��1��n-r+1ѭ��ȡ���󳤶�rʱ�ľ���
				int j = i + r - 1;

				m2[i][j] = m2[i + 1][j] + p[i - 1] * p[i] * p[j];// ȡ��һ����ȡλ��
				s2[i][j] = i; // �Ͽ�λ��Ϊi
				for (int k = i + 1; k < j; k++) {// ѭ��ȡk�Ŀ�ȡλ��
					int t = m2[i][k] + m2[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (t < m2[i][j]) {
						m2[i][j] = t;
						s2[i][j] = k;
					}
				}
			}
		}
	}

	// �Զ������㷨(��̬�滮-����¼)
	public static int juzhenlc_3(int n, int m[][], int s[][]) {
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				m[i][j] = 0;
			}
		}
		return LookupChain(1, n);
	}

	public static int LookupChain(int i, int j) {
		if (m3[i][j] > 0) {
			return m3[i][j];
		}
		if (i == j) {
			return 0;
		}
		int u = LookupChain(i, i) + LookupChain(i + 1, j) + p3[i - 1] * p3[i] * p3[j];
		s3[i][j] = i;
		for (int k = i + 1; k < j; k++) {
			int t = LookupChain(i, k) + LookupChain(k + 1, j) + p3[i - 1] * p3[k] * p3[j];
			if (t < u) {
				u = t;
				s3[i][j] = k;
			}
		}
		// System.out.println(u+"test");
		m3[i][j] = u;
		return u;
	}

}
