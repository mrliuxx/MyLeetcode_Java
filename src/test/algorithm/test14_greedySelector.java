package test.algorithm;

import java.util.Scanner;

public class test14_greedySelector {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("����������:");
			int count = scanner.nextInt();

			System.out.println("������������ʼʱ��ͽ���ʱ��:");
			int[] start = new int[count + 1]; // ��������ʼʱ��
			int[] end = new int[count + 1]; // ����������ʱ��
			int[] num = new int[count + 1]; // ��¼ÿ����ڵ�ǰ˳���е�λ��
			for (int i = 1; i < count + 1; i++) {
				start[i] = scanner.nextInt();
				end[i] = scanner.nextInt();
				num[i] = i; // ��ʼ��λ������
			}

			sort(start, end, num); // �����������ʱ�䡱�Ǽ�������
			int[] result = new int[count + 1]; // �洢���0-1���ֵ
			select(count, start, end, num, result);// ���лѡ��

			// ����ѡ����
			System.out.println("(̰���㷨)�����������Ϊ:");
			for (int i = 1; i < result.length; i++) {
				System.out.print("�[" + i + "]:" + result[i] + "	");
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	// ð������-�����������ʱ�䡱�Ǽ�������(����)
	public static void sort(int[] start, int[] end, int[] num) {
		int n = end.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (end[j] > end[j + 1]) {
					int t = end[j];
					end[j] = end[j + 1];
					end[j + 1] = t;// ���������ʱ��

					t = start[j];
					start[j] = start[j + 1];
					start[j + 1] = t;// ͬʱ������Ӧ��Ŀ�ʼʱ��

					t = num[j];
					num[j] = num[j + 1];
					num[j + 1] = t;// ͬʱ������Ӧ��ڼ�¼λ�õ�λ�������е�λ��
				}
			}
		}
	}

	// <�����Ǽ������еĻ>�ѡ��-�жϻ�ཻ���������Ŀ�ʼʱ�䲻С��ǰ���Ľ���ʱ�䣬����Ϊ��������������ཻ
	public static void select(int count, int[] start, int[] end, int[] num, int[] result) {
		result[num[1]] = 1;// Ĭ�ϵ�һ���һ����ѡ��

		int j = 1;
		for (int i = 2; i <= count; i++) {
			if (start[i] >= end[j]) {// �жϻ�Ƿ��ཻ(����һ������ͺ���Ļ)
				result[num[i]] = 1;// �����ཻ��ѡ��˻��������Ϊ����һ������ٽ����ж�
				j = i;
			} else {
				result[num[i]] = 0;// ���ཻ��������������һ��ѭ���ж���һ�����֪���ҵ����ཻ��ѡ��
			}
		}
	}

}
