package SwordToOffer;

/**
 * @author 黄子玉 不用加减乘除做加法
 * 题目描述：求两个整数之和，要求不得使用+、-、*、/四则运算符号。
 * 解题思路：
 * 用位运算来实现。
 * step1：进行异或运算，计算两个数各个位置上相加，不考虑进位；
 * step2：进行位与运算，然后左移一位，计算进位值。
 * step3：把异或运算的结果赋给num1，把进位结果值赋给num2，依次循环，进位值为空的
 * 时候结束循环，num1就是两数之和。
 */
public class Add {
	public int add(int num1,int num2){
		if(num2==0){
			return num1;
		}
		int sum=0,carry=0;
		while(num2!=0){
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		return num1;
	}
}
