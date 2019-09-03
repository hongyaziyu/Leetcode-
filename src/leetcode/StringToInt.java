package leetcode;

/**
 * @author 黄子玉 将字符串转化为整数
 *
 */
public class StringToInt {
	public int stringToInt(String str){
		if(str==null||str.length()==0){//注意str.length()==0表示长度为0的字符串；str==null表示引用为null的字符串。
			return 0;
		}
		long longRes=0;
		str=str.trim();//去掉字符串前后空格。
		boolean neg=false;//标志位，负号为true。
		if(str.charAt(0)=='-'){//判断第一位是不是表示正负号。
			neg=true;
			str=str.substring(1, str.length());
		}else if(str.charAt(0)=='+'){
			str=str.substring(1, str.length());
		}
		//计算表达式值
		int i=0;
		while(i<str.length()){
			char c=str.charAt(i);
			if(c>='0'&&c<='9'){
				longRes=longRes*10+(c-'0');
			}else {//如果是非数字字符则无法进行转换，返回0.
				break;
			}
			i++;
		}
		longRes=neg?longRes*(-1):longRes;
		if(longRes>Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(longRes<Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int)longRes;
	}
}
