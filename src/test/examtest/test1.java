package test.examtest;

import java.util.Scanner;

import org.junit.Test;

public class test1 {

	@Test
	public void testMain() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = n+1;
        int lcm1 = LCM((n+1), max);
        int lcm2 = 1;
        for(int i=2; i<=max; i++){
        	lcm2 = LCM(lcm2, i);
        }
        
        while(lcm1 != lcm2){
        	max += 1;

        	lcm1 = LCM(lcm1, max);
        	lcm2 = LCM(lcm2, max);
        }

        System.out.println(max);
	}
	// 辗转相除法求两个数的最小公倍数
	private static int LCM(int start, int end){
		if(start == end){
			return start;
		}
		
		int mul = start*end;
		int model = start;
		if(end < start){
			model = end;
			end = start;
			start = model;
		}
		while(model != 0){
			model = end % start;
			end = start;
			start = model;
		}
		
		return mul / end;
	}

}
