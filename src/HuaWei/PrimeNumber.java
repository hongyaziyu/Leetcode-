package HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 黄子玉 
 * 题目描述：
 * 质数：在大于1的自然数中，除了1和它本身，不能整除其他自然数的数，如2,3,23等。
 * 给定取值范围[low,high),找到该范围内所有的质数，输出这些质数的十位数之和和个位数之和的较小值，如果该质数小于10
 * 则十位数为0.
 * 输入描述：
 * 第一行：low,high 用例保证均不小于0，且low<high，不用考虑输入的合法性，如果没有质数，则输出0
 * 输出描述：
 * 较小值
 *
 */
public class PrimeNumber {
	public static boolean isPrime(int n){
		if(n<2){
			return false;
		}
		if(n==2){
			return true;
		}
		if(n%2==0){
			return false;
		}
		for(int i=3;i*i<=n;i+=2){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String s=sc.nextLine();
			String[] a=s.split(" ");
			int low=Integer.parseInt(a[0]);
			int high=Integer.parseInt(a[1]);
			List<Integer> nums=new ArrayList<>();
			for(int i=low;i<high;i++){
				if(isPrime(i)){
					nums.add(i);
				}
			}
			if(nums.isEmpty()){
				System.out.println(0);
			}
			int gewei=0;
			int shiwei=0;
			for(int i=0;i<nums.size();i++){
				gewei+=nums.get(i)%10;
				shiwei+=nums.get(i)/10;
			}
			System.out.println(Math.min(shiwei, gewei));
		}
	}
}
