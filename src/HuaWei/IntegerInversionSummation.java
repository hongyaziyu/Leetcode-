package HuaWei;

import java.util.Scanner;

/**
 * @author 黄子玉 整数反转求和
 * 输入两个正整数a和b，求反转和。
 * 例如：reverseAdd（123,456）==321+654==975.
 * 输入描述：a,b均在[1,70000]区间上的正整数。
 * 100和200反转后值为1和2
 * 输出描述：若a或者b小于1或者大于70000，则输出-1；
 * 一般情况下输出和。
 */
public class IntegerInversionSummation {
	public int integerInversionSummation(int a,int b){
		if(a<1||a>70000){
			return -1;
		}else
		if(b<1||b>70000){
			return -1;
		}else{
		int sum=reverse(a)+reverse(b);
		return sum;}
	}

	private int reverse(int yuanshu) {
		int zhuanhuan=0;
		while(yuanshu!=0){
			int yushu=yuanshu%10;
			zhuanhuan=yushu+zhuanhuan*10;
			yuanshu=yuanshu/10;
		}
		return zhuanhuan;
	}
	//测试函数
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String[] nums=s.split(",");
		int a=Integer.parseInt(nums[0]);
		int b=Integer.parseInt(nums[1]);
		IntegerInversionSummation d=new  IntegerInversionSummation();
		System.out.println(d.integerInversionSummation(a, b));	
	}
}
