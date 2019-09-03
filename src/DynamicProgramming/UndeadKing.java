package DynamicProgramming;

import java.util.Scanner;

/**
 * @author ������
 * ʱ�䣺2019/07/06 14:00
 * ��Ŀ������С����nԪǮ����������Ʒ�ֱ���150Ԫ��200Ԫ��350Ԫ���ҳ�һ�ַ���ʹ��С�����һص���Ǯ���١�
 * �����������ٵ���Ǯ�����������������������͵���ȫ�������⡣
 * Ҫ�����룺2 900 250
 *      �����0 50
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
