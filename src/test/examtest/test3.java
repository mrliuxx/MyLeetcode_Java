package test.examtest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	/**
	 * 判断若密码问题：输入N个字符串，按条件判断每个字符串是否为若密码；
	 * 若是弱密码，则输出no；否则输出yes。
	 * 
	 * 满足下列条件一条或多条则为若密码
	 * 1、长度小于8；
	 * 2、没有同时包含大写字母，小写字母，数字和特殊符号（!@#$%^&*()_\\-=+[]{},.<>/?）；
	 * 3、同时包含三个连续的数字，且三个数字构成等差数列；
	 * 4、同时包含三个连续的大写（或小写）字母，且三个大写（或小写）字母的顺序为字母顺序；
	 * 5、包含常用字password、admin、qwerty、hello、iloveyou、112233等；
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numberN = in.nextInt();
		String[] resultArray = new String[numberN];
		for(int i=0; i<numberN; i++){
			String pwdStr = in.next();
			
			String result = "yes";
			// 长度是否小于8
			if(pwdStr.length() < 8){
				result = "no";
				resultArray[i] = result;
				continue;
			}
			// 是否同时包含大小写字母，数字以及如特殊字符
			boolean note2 = matches("^.*[A-Z]+.*$", pwdStr) && matches("^.*[a-z]+.*$", pwdStr)
					&& matches("^.*[0-9]+.*$", pwdStr) && matches("^.*[!@#$%^&*()_\\-=+[]{},.<>/?]+.*$", pwdStr);
			if(!note2){
				result = "no";
				resultArray[i] = result;
				continue;
			}
			// 是否包含三个连续且等差的数字
			boolean note3 = matches("^.*\\d{3}.*$", pwdStr);
			if(note3){
				if(arithmetic(pwdStr)){
					result = "no";
					resultArray[i] = result;
					continue;
				}
			}
			// 是否包含三个连续且顺序的大写字母或小写字母
			boolean note4 = matches("^.*[A-Z]{3}.*$", pwdStr) || matches("^.*[a-z]{3}.*$", pwdStr);
			if(note4){
				if(sequence("[A-Z]", pwdStr) || sequence("[a-z]", pwdStr)){
					result = "no";
					resultArray[i] = result;
					continue;
				}
			}
			// 是否包含常用字
			boolean note5 = pwdStr.contains("password") || pwdStr.contains("admin") 
					|| pwdStr.contains("qwerty") || pwdStr.contains("hello") 
					|| pwdStr.contains("iloveyou") || pwdStr.contains("112233");
			if(note5){
				result = "no";
				resultArray[i] = result;
				continue;
			}
		}
		
		// 输出结果
		for(int i=0; i<numberN; i++){
			System.out.println(resultArray[i]);
		}
	}

	// 根据正则表达式验证字符串
	public static boolean matches(String regex, String content) {
		Matcher matcher = Pattern.compile(regex).matcher(content);  
        return matcher.matches();  
	}
	
	// 找到所有的三位连续数字并判断三个数字是否为等差数列
	public static boolean arithmetic(String content) {
		boolean note = false;
		
		int i = 0;
		while(i < content.length()-2){
			String number1 = content.charAt(i)+"";
			if(matches("\\d", number1)){
				String number2 = content.charAt(i+1)+"";
				if(matches("\\d", number2)){
					String number3 = content.charAt(i+2)+"";
					if(matches("\\d", number3)){
						int n1 = Integer.parseInt(number1) - Integer.parseInt(number2);
						int n2 = Integer.parseInt(number2) - Integer.parseInt(number3);
						if(n1 == n2){
							note = true;
							break;
						}
					}
					i++;
				}
				i++;
			}
			i++;
			continue;
		}
		
        return note;  
	}
	// 找到所有的三位连续字母并判断三个字母是否为顺序的
	public static boolean sequence(String regex, String content) {
		boolean note = false;
		
		int i = 0;
		while(i < content.length()-2){
			char char1 = content.charAt(i);
			if(matches(regex, char1+"")){
				char char2 = content.charAt(i+1);
				if(matches(regex, char2+"")){
					char char3 = content.charAt(i+2);
					if(matches(regex, char3+"")){
						int n1 = char1 - char2;
						int n2 = char2 - char3;
						if(n1 == -1 && n2 == -1){
							note = true;
							break;
						}
					}
					i++;
				}
				i++;
			}
			i++;
			continue;
		}
		
        return note;  
	}
}
