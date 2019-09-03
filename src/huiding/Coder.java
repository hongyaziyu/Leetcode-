package huiding;

import java.util.Scanner;

/**
 * @author 黄子玉 字符转码
 * 题目描述：首先给定一个字符串，将字符串中每个字符转换成ASCII码值，然后将ASCII码值转换成2进制，如果转换完成后没有8位在
 * 前面添加0使得每个字符对应8位二进制码。然后将二进制码流每次取六位，对应着64个字符的字符串sss选取相应的字符输出。
 * 每三个字符作为一个输入，如果最先开始的字符串不是三的倍数则在转换完成后添加上相应个数的=号使得成为三的倍数。
 * 举例：
 * 输入：Man
 * 输出：TWFu
 * 输入：A
 * 输出：Q==
 *
 */
public class Coder {
	static String sss="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int flag=0;
		if(str.length()%3!=0){
			flag=3-str.length()%3;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			sb.append(toBinary(str.charAt(i)+0));
		}
		for(int i=0;i<flag;i++){
			sb.append("00000000");
		}
		char[] chars1=sss.toCharArray();
		StringBuilder rsr=new StringBuilder();
		for(int i=0;i<sb.length();i=i+6){
			String n=sb.substring(i, i+6);
			int i1=toIndex(n);
			if(i1!=0){
				rsr.append(chars1[i1]);
			}
		}
		if(flag!=0){
			for(int i=0;i<flag;i++){
				rsr.append("=");
			}
		}
		System.out.println(rsr.toString());
	}
	private static int toIndex(String str) {
		char[] cc=str.toCharArray();
		int result=0;
		for(int i=0;i<cc.length;i++){
			if(cc[i]=='1'){
				int l=(int)Math.pow(2, 5-i);
				result+=l;
			}
		}
		return result;
	}
	private static String toBinary(int k) {
		String s=Integer.toBinaryString(k);
		int m=8-s.length();
		String rst="";
		for(int i=0;i<m;i++){
			rst+="0";
		}
		return rst+s;
	}
}
