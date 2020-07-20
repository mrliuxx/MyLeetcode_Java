package test.examtest;

import java.io.InputStream;
import java.util.Scanner;
/**
 * Created by lee on 18/5/12.
 */
public class Main5 {

    //把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变且长度不变.
    //输入数据有多组,每组有一个字符串s.
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //多组数据的组数,没有给出.这里用hasNext进行判断是否还有下一个元素.
        //hasNext()这个方法是如果此扫描器的输入中有内容即不是空字符，则返回true进入循环.在等待要扫描的输入时，此方法可能阻塞.(可以自己设置break)
        //也可以手动设置一个终止符如:!scanner.hasNext("#EOF"),即当输入内容不含终止符时,返回false进入循环.否则返回true结束循环.
        while (!scanner.hasNext("#EOF")){
            String strContent = scanner.next();

            String strSmall = "";
            String strBig = "";

            for(int i=0; i<strContent.length(); i++){
                char tmpChar = strContent.charAt(i);

                if(tmpChar >= 'a' && tmpChar <= 'z'){
                    strSmall += tmpChar;
                }else {
                    strBig += tmpChar;
                }
            }

            System.out.println(strSmall + strBig);
        }

        //释放输入流
        scanner.close();
    }
}
