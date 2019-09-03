package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 黄子玉
 * 时间：2019/07/05 22:00
 * 题目：晚上，n个小朋友过桥，一次最多过两个，过桥的时间按慢的那个人算，每次过完桥必须有一个人回来送手电筒
 * 求最短时间。
 * 分析：首先对小朋友过桥时间进行排序，放在数组a里。2个人过桥，过桥次数是1次，3个人过桥，过桥的次数是3次，
 * 4个人过桥，过桥的次数是5次，...以此类推，n个人过桥，过桥次数是2*n-3次，其中因送手电筒过桥的次数是n-2。再思考过桥时间，一般想到贪心算法
 * 每次都让过桥时间最短的那个人回来送手电筒。那总的最短时间是：a[0]*(n-2)+(sum(数组a)-a[0])。
 * 但是这种情况不一定是最短的，还有一种情况就是最后两个人还在对岸的时候，a[0]先送手电筒回来，然后让最后两个人过桥，
 * 花费时间a[n-1]，最后让a[1]送手电筒回来，最后a[0]和a[1]一起过桥回去花费时间a[2]。那总的最短时间是：
 * a[0]*(n-3)+(sum(数组a)-a[0]-a[n-2]+2*a[1])
 * 总结规律：i个人过河花费最短时间应该为：opt[i]=min{opt[i-1]+a[0]+a[i-1],opt[i-2]+a[0]+a[i-1]+2*a[1]}。
 *明显是可以用递归，也可以用动态规划来做。
 */
public class ThroughBridge {


	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
	        int numOfChild = sc.nextInt();
	        int[] timeCost = new int[numOfChild+1];
	 
	        for(int i=0;i<numOfChild;i++)
	        {
	            timeCost[i] = sc.nextInt();
	        }
	        Arrays.sort(timeCost);
	 
	        int[] optCost = new int[timeCost.length];
	        optCost[0] = 0;
	        optCost[1] = timeCost[1];
	        optCost[2] = timeCost[2];
	 
	        for(int i=3;i<timeCost.length;i++)
	        {
	            optCost[i] = Math.min(optCost[i-1]+timeCost[1]+timeCost[i],optCost[i-2]+timeCost[1]+2*timeCost[2]+timeCost[i]);
	        }
	        System.out.println(optCost[timeCost.length-1]);
	}
}
