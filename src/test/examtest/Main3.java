package test.examtest;

import java.util.Scanner;
/**
 * Created by lee on 18/5/12.
 *
 * 笔试编程:输入m,n两个整数,分别代表m个字符串前缀库和n个需要比对的字符串.然后输入m行前缀串+空格+n行比对串.
 * (代表一组参数,可能输入多组参数)
 *要求若比对串的前缀能和前缀库比对上(前缀长度不确定),则输出1;否则输出-1.输出一组的n行结果.
 *
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        String[] strLibrary = new String[m];
        for(int i=0; i<m; i++){
            strLibrary[i] = scanner.next();
        }

        //System.out.println();
        scanner.nextLine();
        String[] strEquals = new String[n];
        int[] result = new int[n];  //比对串的对应结果
        for(int i=0; i<n; i++){
            strEquals[i] = scanner.next();
            result[i] = -1;
        }

        String tmpStr = "";         //字符串前缀库中的某个元素
        for(int i=0; i<m; i++){     //遍历前缀库,与比对串对比.
            tmpStr = strLibrary[i];

            String tmp = "";        //比对串的前缀
            for(int j=0; j<n; j++){ //遍历n个比对串,得到n个结果
                tmp = strEquals[j].substring(0, tmpStr.length());

                if(tmpStr.equals(tmp)){
                    result[j] = 1;
                }
            }
        }

        //输出比对串的比对结果
        for(int i=0; i<n; i++){
            System.out.print(result[i]);
            if(i != n-1){
                System.out.println();
            }
        }
    }
}
