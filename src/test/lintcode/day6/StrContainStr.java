package test.lintcode.day6;

/**
 * Created by lee on 18/5/6.
 */
public class StrContainStr {
    //对于一个给定的 source 字符串和一个 target 字符串，
    //你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
    public static void main(String[] args){

        System.out.println(strStr("abcdabcdefg", "bcd"));
    }

    //两种思想:
    //  o(n^2):将主串从第一个字符开始,分割成(fatherLength-sonLength+1)个长度为sonLength的串,分别与子串对比.
    //  o(n):KMP算法(利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的).
    public static int strStr(String source, String target) {
        //o(n^2)思想:equals底层实现也是循环对比,所以也算一层.
        if(source == null || target == null){
            return -1;
        }
        int fatherLength = source.length();
        int sonLength = target.length();

        String tmpStr = "";
        for(int i=0; i<(fatherLength-sonLength+1); i++){
            tmpStr = source.substring(i, i+sonLength);
            if(tmpStr.equals(target)){
                return i;
            }
        }

        return -1;
        //o(n)思想:KMP算法实现对比.
//        在简单的一次匹配失败后，我们会想将模式串尽量的右移和主串进行匹配。
//        右移的距离是：在已经匹配的模式串子串中，找出最长的相同的前缀和后缀，然后移动使它们重叠.
//
//        return -1;
    }
}
