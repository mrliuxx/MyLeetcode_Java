package test.examtest;

import java.util.Scanner;

import org.junit.Test;

public class test2 {

	@Test
	public void testMain() {
		Scanner sc = new Scanner(System.in);
        String initData = sc.nextLine();
        int number = sc.nextInt();
        
        // 填充杨氏矩阵
        String[] matrix_h = initData.split("|");
        int[][] numberMatrix = new int[matrix_h.length][];
        int i = 0;
        for(String sh : matrix_h){
        	String[] matrix_l = sh.split(",");
        	numberMatrix[i] = new int[matrix_l.length];
        	i++;
        	
        	int j = 0;
        	for(String sl : matrix_l){
        		numberMatrix[i][j] = Integer.valueOf(sl);
        	}
        }
        
        // 杨氏矩阵查找某元素，算法复杂度O(M+N)；
        boolean note = false;
        // 初始指针指向右上角元素
        int index_row = 0;
        int index_col = numberMatrix[0].length - 1;
        while(index_row < numberMatrix.length && index_col >= 0){
        	if(number > numberMatrix[index_row][index_col]){
        		// 如果查找元素大于指针元素说明这行没有，向下一行查找(指针下移)
        		index_row ++;
        	}else if(number > numberMatrix[index_row][index_col]){
        		// 如果查找元素小于指针元素说明这列没有，向前一列查找(指针左移)
        		index_col --;
        	}else if(number == numberMatrix[index_row][index_col]){
        		note = true;
        	}
        }
        
        System.out.println(note);
	}

}
