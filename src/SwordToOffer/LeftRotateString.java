package SwordToOffer;

/**
 * @author 黄子玉 左旋转字符串
 * 题目描述：例如“abcXYZdef”，循环左移三位为“XYZdefabc”
 * 解题思路：简单的题，在n个字符后面切一刀分为两个部分。再重新拼接起来即可。
 */
public class LeftRotateString {
	public String leftRotateString(String str,int n){
		int len=str.length();
		if(len==0){
			return "";
		}
		n=n%len;
		String s1=str.substring(n, len);
		String s2=str.substring(0,n);
		return s1+s2;
	}
}
