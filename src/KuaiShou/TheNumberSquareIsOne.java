package KuaiShou;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 黄子玉 各位平方和为1的数。
 * 题目描述：取一个数的每一位数平方求和得到新数，然后对新数继续取各位平方求和，直到平方和为1返回true，否则返回false
 * 举例：
 * 输入：19
 * 输出：true
 * 原因：1^2+9^2=82;
 *      8^2+2^2=68;
 *      6^2+8^2=100;
 *      1^2+0^2+0^2=1;
 * 解题思路：每次记录计算结果，如果有1则返回true，如果结果中出现相同的数则存在循环，直接返回false。
 */
public class TheNumberSquareIsOne {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int m=sc.nextInt();
			int[] nums=new int[m];
			for(int i=0;i<m;i++){
				nums[i]=sc.nextInt();
			}
			for(int i=0;i<m;i++){
				doWork(nums[i]);
			}
		}
	}

	public static void doWork(int num) {
		int sum=0;
		String temp=String.valueOf(num);
		ArrayList<String> list=new ArrayList<String>();
		while(true){
			sum=0;
			list.add(temp);//一直将计算的结果放到list里面。
			for(int i=0;i<temp.length();i++) {
				sum += (int) Math.pow(temp.charAt(i) - '0', 2);
			}
			if (sum == 1) {
				System.out.println("true");//如果是1则返回true。
			break;
			}
			temp=Integer.toString(sum);
			for(String s:list) {
				if (s.equals(temp)) {//如果列表里面有元素则返回false。
					System.out.print("false");
					return;
				}
		    }
		}
	}
}
