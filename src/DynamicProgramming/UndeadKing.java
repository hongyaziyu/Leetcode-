package DynamicProgramming;

import java.util.Scanner;

/**
 * @author 黄子玉
 * 时间：2019/07/06 14:00
 * 题目描述：小明有n元钱，有三种商品分别是150元、200元、350元。找出一种方案使得小明被找回的零钱最少。
 * 分析：求最少的零钱数就是求最大的消费数。典型的完全背包问题。
 * 要求：输入：2 900 250
 *      输出：0 50
 */
public class UndeadKing {
	public static int minTip(int n,int[] p){
		int[] dp=new int[10010];
		for(int i=0;i<p.length;i++){
			for(int j=p[i];j<=n;j++){
				dp[j]=Math.max(dp[j-p[i]]+p[i], dp[j]);
			}
		}
		return n-dp[n];
	}
	public static void main(String[] args) {
		int[] p={150,200,350};
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int m=sc.nextInt();
			while(m!=0){
				int[] a=new int[m];
				for(int i=1;i<=m;i++){
					a[i-1]=sc.nextInt();
				}
				for(int i=1;i<=m;i++){
					System.out.println(UndeadKing.minTip(a[i-1], p));
				}
				m--;
			}
		}
		
		/*int n=250;
		int[] p={150,200,350};
		System.out.println(UndeadKing.minTip(n, p));*/
	}
}
