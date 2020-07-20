package test.examtest;

import java.util.Scanner;

public class Main2 {
	/**
	 * 数苹果问题：有N堆苹果，每堆有Ni颗苹果；
	 * 当输入M个数后，问每个输入数第Mi颗苹果在哪一堆中；
	 * 
	 * （若正确输入，不存在找不到的情况）
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// 填充苹果数量数据
		int numberN = in.nextInt();
		int numberN_ArrayAdd[] = new int[numberN];
		for(int i=0; i<numberN; i++){
			int numberN_Tmp = in.nextInt();
			
			if(i == 0){
				numberN_ArrayAdd[i] = 0 + numberN_Tmp;
			}else{
				numberN_ArrayAdd[i] = numberN_ArrayAdd[i-1] + numberN_Tmp;
			}
		}
		
		// 填充询问数据
		int numberM = in.nextInt();
		String resultArray[] = new String[numberM];
		for(int i=0; i<numberM; i++){
			int numberM_Tmp = in.nextInt();
			
			// 判断位置结果（法一：已经是升序数组，采用二分查找）
			int result = 0;
			int start = 0;
			int end = numberN - 1;
			int middle = 0;
			while(start <= end){
				middle = (start + end) / 2;
				System.out.println("测试："+middle);
				
				if(numberM_Tmp <= numberN_ArrayAdd[middle]){
					if(middle == 0 || middle == numberN-1){
						result = middle+1;
						break;
					}else if(numberM_Tmp > numberN_ArrayAdd[middle-1]){
						result = middle+1;
						break;
					}else{
						end = middle - 1;
					}
				}else{
					// 代表numberM_Tmp > numberN_ArrayAdd[middle]
					start = middle + 1;
				}
			}
			// 判断位置结果（法二：顺序查找）
//			for(int j=0; j<numberN; j++){
//				if(numberM_Tmp <= numberN_ArrayAdd[j]){
//					result = j+1;
//					break;
//				}
//			}
			resultArray[i] = result+"";
		}
		
		// 输出结果
		for(int i=0; i<numberM; i++){
			System.out.println(resultArray[i]);
		}
	}
}
