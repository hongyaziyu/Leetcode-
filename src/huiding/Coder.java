package huiding;

import java.util.Scanner;

/**
 * @author ������ �ַ�ת��
 * ��Ŀ���������ȸ���һ���ַ��������ַ�����ÿ���ַ�ת����ASCII��ֵ��Ȼ��ASCII��ֵת����2���ƣ����ת����ɺ�û��8λ��
 * ǰ�����0ʹ��ÿ���ַ���Ӧ8λ�������롣Ȼ�󽫶���������ÿ��ȡ��λ����Ӧ��64���ַ����ַ���sssѡȡ��Ӧ���ַ������
 * ÿ�����ַ���Ϊһ�����룬������ȿ�ʼ���ַ����������ı�������ת����ɺ��������Ӧ������=��ʹ�ó�Ϊ���ı�����
 * ������
 * ���룺Man
 * �����TWFu
 * ���룺A
 * �����Q==
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
