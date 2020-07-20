package test.examtest;

import java.util.Scanner;

public class Main1 {
	/**
	 * 工资税收问题：工资超过5000的部分，在不同范围按不同的税率收取；
	 * 
	 * X = num - 5000;
	 * 1、X <= 3000的部分，3%
	 * 2、3000 < X <= 12000的部分，10%
	 * 3、12000 < X <= 25000的部分，20%
	 * 4、25000 < X <= 35000的部分，25%
	 * 5、35000 < X <= 55000的部分，30%
	 * 6、55000 < X <= 80000的部分，35%
	 * 7、80000 < X的部分，45%
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberT = in.nextInt();
		String[] resultArray = new String[numberT];
		for(int i=0; i<numberT; i++){
			int num = in.nextInt()-5000;
			
			double result = 0.0;
			if(num > 0){
				if(num <= 3000){
					result += (num - 3000)*0.03;
					resultArray[i] = Math.round(result)+"";
					continue;
				}else{
					result += (3000-0)*0.03;
				}
				if(num <= 12000){
					result += (num-3000)*0.10;
					resultArray[i] = Math.round(result)+"";
					continue;
				}else{
					result += (12000-3000)*0.10;
				}
				if(num <= 25000){
					result += (num-12000)*0.20;
					resultArray[i] = Math.round(result)+"";
					continue;
				}else{
					result += (25000-12000)*0.20;
				}
				if(num <= 35000){
					result += (num-25000)*0.25;
					resultArray[i] = Math.round(result)+"";
					continue;
				}else{
					result += (35000-25000)*0.25;
				}
				if(num <= 55000){
					result += (num-35000)*0.30;
					resultArray[i] = Math.round(result)+"";
					continue;
				}else{
					result += (55000-35000)*0.30;
				}
				if(num <= 80000){
					result += (num-5500)*0.35;
					resultArray[i] = Math.round(result)+"";
					continue;
				}else{
					result += (80000-5500)*0.35;
				}
				if(num > 80000){
					result += (num-8000)*0.45;
					resultArray[i] = Math.round(result)+"";
					continue;
				}
			}else{
				result += 0;
				resultArray[i] = Math.round(result)+"";
				continue;
			}
		}
		
		// 输入结果
		for(int i=0; i<numberT; i++){
			System.out.println(resultArray[i]);
		}
	}
}
