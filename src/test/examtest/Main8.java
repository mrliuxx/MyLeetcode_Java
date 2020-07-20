package test.examtest;

import java.io.IOException;
/*
 *如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，
 *才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，
 *每个小格都是正方形，且边长为1，如p到d的距离就是4。随机输入n个派送点坐标，
 *求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 *
 *输入范例:
 *4
 *2,2
 *2,8
 *4,4
 *7,2
 *输出：
 *30
 *输入范例:
 *3
 *2,2
 *2,8
 *6,6
 *输出:
 *28
 *
 */
public class Main {
	public static void main(String[] args) {
		char readNumber = 0;
		try {
			readNumber = (char)System.in.read();
			
			String[] pointData = new String[Integer.valueOf(readNumber+"")];
			System.in.read();
			for (int i = 0; i < pointData.length; i++) {
				byte[] b=new byte[3];
                System.in.read(b);
                pointData[i] = new String(b);

                System.in.read();
			}
			
			for (int i = 0; i < pointData.length; i++) {
                System.out.println("pointData["+i+"]="+pointData[i]+"===");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
