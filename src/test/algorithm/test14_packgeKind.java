package test.algorithm;

import java.util.Scanner;

public class test14_packgeKind {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("��������Ʒ����:");
			int count = scanner.nextInt();
			System.out.println("�����뱳������(����):");
			double content = scanner.nextDouble();

			System.out.println("������������Ʒ����:");
			int[] num = new int[count + 1];// ��¼ÿ����Ʒ�ڵ�ǰ˳���е�λ��
			double width[] = new double[count + 1];
			for (int i = 1; i < width.length; i++) {
				width[i] = scanner.nextDouble();
				num[i] = i;// ��ʼ��λ������
			}
			System.out.println("������������Ʒ��ֵ:");
			double value[] = new double[count + 1];
			for (int i = 1; i < value.length; i++) {
				value[i] = scanner.nextDouble();
			}

			double[] result = new double[count + 1];// �洢��Ʒѡ����ֵ��0<=xi<=1;
			knapsack(count, content, width, value, num, result);

			System.out.println("(̰���㷨)һ�㱳��������Ϊ:");
			// �����Ʒѡ����(С��);
			for (int i = 1; i < result.length; i++) {
				System.out.print("��Ʒ[" + i + "]:" + result[i] + "	");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ��Ʒѡ��-���Լ۱ȴӸ���;���ѡ��
	public static void knapsack(int count, double content, double[] width, double[] value, int[] num, double[] result) {
		sort(width, value, num); // ���Լ۱Ƚ���������Ʒλ��(���´�����Ʒ˳���Ϊ������)
		int i; // �����Ʒ��ָ��
		for (i = 1; i <= count; i++) { // ��result�����������
			result[num[i]] = 0;
		}
		for (i = 1; i <= count; i++) { // �ӵ�һ����Ʒ��ʼ�ж�ѡ��
			if (width[i] > content) { // 1.����ǰָ����Ʒ�������ڱ�������
				break; // 2.��ֱ������ѭ��
			}
			result[num[i]] = 1; // �����򽫴���Ʒȫ�����뱳��
			content -= width[i]; // ͬʱ����������ȥ��Ʒ����
		}
		if (i <= count) {
			result[num[i]] = content / width[i];// 3.�ҽ�����Ʒ(�������ڱ���������)�Ĳ��ַ��뱳��
			// 4.�������Ϊ����ʣ������ռ��Ʒ�����ķݶ�
		}
	}

	// ð������-����Ʒ������λ������ֵ������������(����)
	public static void sort(double[] width, double[] value, int[] num) {
		int n = value.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if ((value[j] / width[j]) < (value[j + 1] / width[j + 1])) {
					double t = value[j];
					value[j] = value[j + 1];
					value[j + 1] = t;// ������Ʒ��ֵλ��

					t = width[j];
					width[j] = width[j + 1];
					width[j + 1] = t;// ͬʱ������Ӧ��Ʒ������λ��

					int k = num[j];
					num[j] = num[j + 1];
					num[j + 1] = k;// ͬʱ������Ӧ��Ʒ�ڼ�¼λ�õ�λ�������е�λ��
				}
			}
		}
	}

}
