package test.lintcode.day4;

/**
 * Created by lee on 18/5/4.
 */
public class RotateString {
    //给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
    public static void main(String[] args){


    }

 /* 对于字符串 "abcdefg".

    offset=0 => "abcdefg"
    offset=1 => "gabcdef"
    offset=2 => "fgabcde"
    offset=3 => "efgabcd"*/
    public static void rotateString(char[] str, int offset) {
        //当字符数组为空时,直接不变.
        if(str.length != 0){
            //指向旋转后的第一个字符位置,然后从index到最后,再接上从0到index.
            int index = (str.length - offset % str.length) % str.length;

            String result = "";
            for(int i = index; i<str.length; i++){
                result += str[i];
            }
            if(index != 0){
                for(int i = 0; i<index; i++){
                    result += str[i];
                }
            }

            //str = result.toCharArray();
            for(int i = 0; i<str.length; i++){
                str[i] = result.charAt(i);
            }
        }
    }
}
