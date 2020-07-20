package test.algorithm;

import java.util.Scanner;

//ʵ�ֺϲ�����(�ݹ�ͷǵݹ�)�Ϳ�������(�ݹ�)���㷨ʵ��
public class test5_Sort {
	// ����ɴ�����
	public static String toString(int[] number) {
		String str = "[";
		for (int i = 0; i < number.length; i++) {
			str = str + number[i] + ",";
		}
		return str + "]";
	}

	public static void main(String[] args) {
		System.out.println("������һ����������ȷ������Ԫ�ظ���(����ʮΪ��)��");
		Scanner scanner = new Scanner(System.in);
		String countstr = scanner.next();

		try {
			int count = Integer.parseInt(countstr);

			int[] numlist = new int[count];
			System.out.println("������һ��������");
			for (int i = 0; i < count; i++) {
				String num = scanner.next();
				numlist[i] = Integer.parseInt(num);
			}
			// 5 6 8 2 7 3 8 2 9 3
			System.out.println("����δ��������飺" + toString(numlist));
			System.out.println("*************************************************");

			int b[] = new int[numlist.length];
			b = Copy(b, numlist, 0, numlist.length - 1);
			HeBingRecursion(b, 0, numlist.length - 1);
			System.out.println("���Ǻϲ�����ݹ��㷨�Ľ����" + toString(b));
			System.out.println("*************************************************");

			int c[] = new int[numlist.length];
			c = Copy(c, numlist, 0, numlist.length - 1);
			HeBingNotRecursion(c, numlist.length);
			System.out.println("���Ǻϲ�����ǵݹ��㷨�Ľ����" + toString(c));
			System.out.println("*************************************************");

			int d[] = new int[numlist.length];
			d = Copy(d, numlist, 0, numlist.length - 1);
			QuickRecursion(d, 0, numlist.length - 1);
			System.out.println("���ǿ�������ݹ��㷨�Ľ����" + toString(d));
		} catch (NumberFormatException e) {
			System.out.println("�Բ���������Ĳ����Ϲ���");
			System.out.println(e.getMessage());
		}
	}

	// �ϲ�����ݹ��㷨
	public static void HeBingRecursion(int[] num, int lef, int rig) {
		if (lef < rig) {
			int num2[] = new int[num.length];
			int m = (lef + rig) / 2;
			HeBingRecursion(num, lef, m);
			HeBingRecursion(num, m + 1, rig);
			HeBing(num, num2, lef, m, rig);
			Copy(num, num2, lef, rig);
		}
	}

	public static int[] Copy(int[] num, int[] num2, int lef, int rig) {
		// Ĭ��num��num2�����鳤��һ�£����Բ��������ݴ���ֱ�Ӹ���Ԫ��
		for (int i = lef; i <= rig; i++) {
			num[i] = num2[i];
		}
		return num;
	}

	public static void HeBing(int[] num, int[] num2, int lef, int mid, int rig) {
		// �ϲ�num[lef:mid]��num[mid+1:rig]��num2[lef:rig]
		int i = lef, j = mid + 1, k = lef;

		while ((i <= mid) && (j <= rig)) {
			if (num[i] <= num[j]) {
				num2[k++] = num[i++];
			} else {
				num2[k++] = num[j++];
			}
		}
		if (i > mid) {
			for (int q = j; q <= rig; q++) {
				num2[k++] = num[q];
			}
		} else {
			for (int q = i; q <= mid; q++) {
				num2[k++] = num[q];
			}
		}
	}

	// �ϲ�����ǵݹ��㷨
	public static void HeBingNotRecursion(int[] num, int length) {
		int num2[] = new int[length];

		int lensss = 1;
		while (lensss < length) {
			HeBingPass(num, num2, lensss, length); // �ϲ�������num2
			lensss += lensss;
			HeBingPass(num2, num, lensss, length); // �ϲ�������num
			lensss += lensss;
		}

	}

	public static void HeBingPass(int[] num, int[] num2, int lensss, int length) {
		// �ϲ���СΪlensss������������
		int i = 0;
		while (i <= length - 2 * lensss) {
			// �ϲ���СΪlensss������2��������
			HeBing(num, num2, i, i + lensss - 1, i + 2 * lensss - 1);
			i = i + 2 * lensss;
		}

		if (i + lensss < length) {
			HeBing(num, num2, i, i + lensss - 1, length - 1);
		} else {
			for (int j = i; j <= length - 1; j++) {
				num2[j] = num[j];
			}
		}
	}

	// ��������
	public static void QuickRecursion(int[] num, int lef, int rig) {
		if (lef < rig) {
			int q = Partition(num, lef, rig);

			QuickRecursion(num, lef, q - 1); // ����������
			QuickRecursion(num, q + 1, rig); // ���Ұ������
		}
	}

	public static int Partition(int[] num, int lef, int rig) {
		// ��ʼ�ͽ����±�
		int i = lef, j = rig;
		// ѡ���һ��Ԫ��Ϊ��׼Ԫ��
		int vot = num[i];
		// ѭ���������� i=j
		while (i != j) {
			// ���������ұȻ�׼Ԫ��С�ģ���Ĳ���ֱ����һ��
			while (i < j && vot <= num[j])
				j--;
			// �ҵ���ֵ֮���� i<j����� ��jΪ�±��ֵ������i����i++
			if (i < j)
				num[i++] = num[j];
			// ���������ұȻ�׼Ԫ�ش�ģ�С�Ĳ���ֱ����һ��
			while (i < j && vot >= num[i]) {
				i++;
			}
			if (i < j)
				num[j--] = num[i];
		}
		// System.out.println("i="+i);
		// System.out.println("j="+j);
		return i;
	}
	// public static int[]a;
	// private static int Partition(int p, int r) {
	// int i=p,j=r+1;
	// int x=a[p];
	// while(true){
	// while(a[++i]<x&&i<r);
	// while(a[--j]>x);
	// if(i>=j)
	// break;
	// int temp=a[i];
	// a[i]=a[j];
	// a[j]=temp;
	//
	// }
	// a[p]=a[j];
	// a[j]=x;
	// return j;
	// }

}
