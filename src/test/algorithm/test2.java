package test.algorithm;

import java.util.Scanner;

//锟斤拷锟街简单递癸拷实锟街ｏ拷锟阶乘ｏ拷斐诧拷锟斤拷锟斤拷锟斤拷锟叫和帮拷锟斤拷锟斤拷锟斤拷锟斤拷
public class test2 {
	// 锟阶筹拷
	public static long jiecheng(int n) {
		if (n != 0) {
			return n * jiecheng(n - 1);
		} else {
			return 1;
		}
	}

	// 斐诧拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static long fibonacci(int n) {
		if (n > 1) {
			return fibonacci(n - 1) + fibonacci(n - 2);
		} else {
			return 1;
		}
	}

	// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static long ackerman(int n, int m) {
		if (m == 0 && n == 1) {
			return 2;
		} else if (m >= 0 && n == 0) {
			return 1;
		} else if (m == 0 && n >= 2) {
			return n + 2;
		} else if (m >= 1 && n >= 1) {
			return ackerman((int) ackerman(n - 1, m), m - 1);
		} else {
			throw new IllegalArgumentException(); // 锟阶筹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟届常
		}
	}

	public static void main(String[] args) {
		System.out.println("锟斤拷锟斤拷锟斤拷锟侥革拷锟斤拷锟斤拷锟斤拷实锟街递癸拷锟姐法锟斤拷");
		Scanner scanner = new Scanner(System.in);

		System.out.print("n锟侥阶乘递癸拷锟姐法锟斤拷");
		String num1 = scanner.next();
		System.out.print("斐诧拷锟斤拷锟斤拷锟斤拷锟叫递癸拷锟姐法锟斤拷");
		String num2 = scanner.next();
		System.out.print("锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟捷癸拷锟姐法锟斤拷");
		String num3 = scanner.next();
		String num4 = scanner.next();
		scanner.close();

		System.out.println("*************************");
		try {
			int number1 = Integer.parseInt(num1);
			int number2 = Integer.parseInt(num2);
			int number3 = Integer.parseInt(num3);
			int number4 = Integer.parseInt(num4);

			if (number1 > 0) {
				System.out.println("锟斤拷锟斤拷" + number1 + "锟侥阶乘斤拷锟斤拷锟? + jiecheng(number1) + "锟斤拷");
			} else {
				System.out.println("锟皆诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟?);
			}

			if (number2 > 0) {
				System.out.println("锟斤拷锟斤拷斐诧拷锟斤拷锟斤拷锟斤拷锟叫的碉拷" + number2 + "锟斤拷锟斤拷锟斤拷" + fibonacci(number2 - 1) + "锟斤拷");
			} else {
				System.out.println("锟皆诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟?);
			}

			// 锟斤拷为锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟届，ack(n,m)锟斤拷锟斤拷时锟斤拷锟斤拷0<=m<4为准锟斤拷锟斤拷n锟斤拷值锟斤拷要太锟斤拷舜锟斤拷锟斤拷锟斤拷锟斤拷为5锟斤拷
			if (number3 >= 0 && number3 <= 5 && number4 >= 0 && number4 < 4) {
				System.out.println("锟斤拷锟角帮拷锟斤拷锟斤拷锟斤拷锟斤拷(" + number3 + ", " + number4 + ")锟侥斤拷锟斤拷锟? + ackerman(number3, number4) + "锟斤拷");
			} else {
				System.out.println("锟皆诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥诧拷锟斤拷锟较癸拷锟斤拷");
			}
		} catch (NumberFormatException e) {
			System.out.println("锟皆诧拷锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷锟斤拷瞎锟斤拷锟?);
			System.out.println(e.getMessage());
		}
	}
}
