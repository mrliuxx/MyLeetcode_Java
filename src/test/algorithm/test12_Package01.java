package test.algorithm;

import java.util.Scanner;

public class test12_Package01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("��������Ʒ����:");
			int count = scanner.nextInt();
			System.out.println("�����뱳������(����):");
			int content = scanner.nextInt();

			System.out.println("������������Ʒ����:");
			int width[] = new int[count + 1];
			for (int i = 1; i < width.length; i++) {
				width[i] = scanner.nextInt();
			}
			System.out.println("������������Ʒ��ֵ:");
			int value[] = new int[count + 1];
			for (int i = 1; i < value.length; i++) {
				value[i] = scanner.nextInt();
			}

			int[][] m = new int[count + 1][content + 1];// �洢����ֵ,m[1][c]λ�ô洢���Ž�
			knapsack(count, content, width, value, m);
			int[] result = new int[count + 1];// �洢0-1���ֵ��0��װ�뱳����1��ʾװ�뱳��
			traceback(count, content, width, m, result);

			System.out.println("����ѡ������:");
			// ������Ž�0-1���
			for (int i = 1; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		} catch (Exception e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			System.out.println(e.getMessage());
		}
	}

	// ������ֵ����m[][]������.
	public static void knapsack(int count, int content, int[] width, int[] value, int[][] m) {
		int jMax = Math.min(width[count] - 1, content); // ����ʣ���������ޣ���Χ[0~w[n]-1]

		for (int j = 0; j <= jMax; j++) {
			m[count][j] = 0;
		}
		for (int j = width[count]; j <= content; j++) { // ���Ʒ�Χ[w[n]~c]
			m[count][j] = value[count];
		}
		for (int i = count - 1; i >= 1; i--) {
			jMax = Math.min(width[i] - 1, content);
			for (int j = 0; j <= jMax; j++) // ������ͬʣ������j<=jMax<c
				m[i][j] = m[i + 1][j]; // û�����κ�Ч��
			for (int j = width[i]; j <= content; j++) // ������ͬʣ������j-wi>c
				m[i][j] = Math.max(m[i + 1][j], m[i + 1][j - width[i]] + value[i]);// Ч��ֵ����vi
		}
		m[1][content] = m[2][content];
		if (content >= width[1]) {
			m[1][content] = Math.max(m[1][content], m[2][content - width[1]] + value[1]);
		}
	}

	// ����m[][]����������ֵ�ıȽϹ�����Ӧ���Ž�,����result[]������
	public static void traceback(int count, int content, int[] width, int[][] m, int[] result) {
		for (int i = 1; i < count; i++) {
			if (m[i][content] == m[i + 1][content]) {// ���m[1][c]==m[2][c],֤��x1=0;����x1=1;
				result[i] = 0;// ���x1=0,��m[2][c]�����������Ž�;
			} else {
				result[i] = 1;// ���x1=1,��m[2][c-w1]�����������Ž�;
				content -= width[i];
			}
		}
		result[count] = (m[count][content] > 0) ? 1 : 0;
	}

}
