package SwordToOffer;

/**
 * @author 黄子玉
 * 题目描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列
 * 第n项（从0开始，第0项为0）。n<=39
 * 解题思路：
 * 公式：
 * f(n)=n,n<=1
 * f(n)=f(n-1)+f(n-2),n>1
 * 可以直接使用递归的方法：
 * if(n<=1) return n;
 * else return Fibonacci(n-1)+Fibonacci(n-2);
 */
public class Fibonacci {
	public int fibonacci(int n){
		if(n==0||n==1){
			return n;
		}
		int fn1=0;
		int fn2=1;
		for(int i=2;i<=n;i++){
			fn2+=fn1;
			fn1=fn2-fn1;
		}
		return fn2;
	}
}
