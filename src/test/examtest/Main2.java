package test.examtest;

import java.util.Scanner;

/**
 * Created by lee on 18/5/11.
 *
 * 笔试编程:输入一段程序(字符串),但是有几组参数没有确定,每组多少行也没确定,这里暂定一组数据,且只有5行.
 * 求这组参数中有多少对注释(分单行和多行注释),引号内的注释符号不计算.
 *
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textContent = "";
        int i = 0;
        while(i < 5){
            String tmpLine = scanner.nextLine();
            textContent += tmpLine;

            i++;
//            if(!tmpLine.contains("#")){
//                textContent += tmpLine;
//            }else{
//                int tmpIndex = tmpLine.indexOf("#");
//                textContent += tmpLine.substring(0, tmpIndex);
//                break;
//            }
        }

        int charIndex = 0;		//遍历字符下标
        int countChar = 0;      //注释的个数
        boolean note = false;   //判断是否处在引号对中
        while(charIndex < textContent.length()){
            String charStr = textContent.charAt(charIndex)+"";

            //如果是空格，跳过进行下一个字符的判断
            if(" ".equals(charStr)){
                charIndex++;
                continue;
            }
            //如果是引号,跳过进行下一个,且将标识置为true表示处于引号对中,不计算注释符号
            else if("\"".equals(charStr)){
                charIndex++;
                note = !note;

                continue;
            }
            //进入条件为不在引号对且符号为"/"
            else if(!note && "/".equals(charStr)){
                charIndex++;
                charStr = textContent.charAt(charIndex)+"";

                //判断单行注释.
                if("/".equals(charStr)){
                    countChar++;
                    continue;
                }
                //判断多行注释.
                else if("*".equals(charStr)){
                    charIndex++;

                    //找到多行注释的右侧之后才累加计数.
                    while(charIndex < textContent.length()){
                        charStr = textContent.charAt(charIndex)+"";
                        if("*".equals(charStr)){
                            charIndex++;
                            charStr = textContent.charAt(charIndex)+"";
                            if("/".equals(charStr)){

                                countChar++;
                            }else{
                                charIndex++;
                                continue;
                            }
                        }else{
                            charIndex++;
                        }
                    }

                    continue;
                }
                //若不满足//或/*,也同样跳过.
                else{
                    charIndex++;
                }
            }
            //否则其他符号都跳过.
            else{
                charIndex++;
            }
        }

        System.out.print(countChar);
    }
}
