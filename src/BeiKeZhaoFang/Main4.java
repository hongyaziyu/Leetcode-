package BeiKeZhaoFang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 黄子玉
 * 假设有N个物品，第i个物品的重量为Wi。现在要将这些物品分成两堆，使得在"第一堆物品的总重量与第二堆物品总重量尽可能
 * 小"的前提下，两堆物品的数量之差尽可能大。那么，两堆物品的总重量之差最小是多少？在总重量之差最小的前提下，物品数量
 * 之差是多少？
 * 输入：
 * 第一行包含一个整数N，N介于2到100
 * 第二行包含w1到wn
 * 输出：
 * 两个数
 * 举例：
 * 输入：
 * 6
 * 1 2 3 4 5 6
 * 输出：
 * 1 2
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.nextLine();
			int N=Integer.parseInt(str);
			String s=sc.nextLine();
			int[] w=new int[N];
			for(int i=0;i<N;i++){
				w[i]=Integer.parseInt(s.split(" ")[i]);
			}
			Arrays.sort(w);
			int sum=0;
			for(int i=0;i<N;i++){
				sum+=w[i];
			}
			int temp=0;
			int j=N-1;
			while(temp<=sum/2&&j>=0){
				temp+=w[j];
				j--;
			}
			int valueDifference=Math.abs(sum-temp-temp);
			int quantityDifference=Math.abs(N-2*(j+1));
			System.out.println(valueDifference+" "+quantityDifference);
		}
	}
}
