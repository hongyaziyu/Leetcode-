package SwordToOffer;

/**
 * @author 黄子玉 把字符串转换成整数
 * 题目描述：将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 解题思路：
 * 常规思路，先判断第一位是不是符号位，如果有符号，有flag做标记。
 * 遍历字符串中的每个字符，如果存在非数字的字符，直接返回0，否则用当前字符减去‘0’
 * 得到当前的数字，再进行运算。
 */
public class StrToInt {
	public int strToInt(String str){
		if(str.length()==0){
			return 0;
		}
		int flag=0;
		if(str.charAt(0)=='+'){
			flag=1;
		}else if(str.charAt(0)=='-'){
			flag=2;
		}
		int start=flag>0?1:0;
		long res=0;
		while(start<str.length()){
			if(str.charAt(start)>'9'||str.charAt(start)<'0'){
				return 0;
			}
			res=res*10+(str.charAt(start)-'0');
			start++;
		}
		return flag==2?-(int)res:(int)res;
	}
}
