package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄子玉
 * 时间：2019/07/06 22:00
 * 著名的约瑟夫环问题：0,1,...,n-1这n个数字围成一圈，从数字0开始，每次删除圆环中第m个数字，删除完成后下一个数字
 * 又从0开始计数。
 * 举例：0->1->2->3->4->0;每次删除第三个数字，那么依次删除的是2、0、4、1,最后的剩下数字是3。
 * 分析题目：第一种，最经典的解法，用环形链表来模拟圆圈。
 * 第二种解法，动态规划的方法，或者说递归的方法。用f(n,m)表示最后一个被删除的数字，第一次被删除的数字是(m-1)%n.
 * 这个数字设为k则第二轮删除开始后又重新报数，原先的数字是0,1,2,...,k-1,k+1,...,n-1。从k+1重新开始计数：
 * k+1->0
 * k+2->1
 * ...
 * n-1->n-k-2
 * 0  ->n-k-1
 * 1  ->n-k
 * ...
 * k-1->n-2
 * 这个对应映射关系为p(x)=(x-k-1)%n,逆映射关系为q(x)=(x+k+1)%n。
 * f(n-1,m)=q[f(n-1,m)]=[f(n-1,m)+k+1]%n,将k=(m-1)%n代入，得到f(n,m)=f(n-1,m)=[f(n-1,m)+m]%n
 * 初始条件肯定是n=1,f(n,m)=0.
 */
public class CircleNumber {
	/**
     * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
     * 从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，
     * 数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
     * 
     * @param n 人的总数
     * @param start 开始报数的序号，start < n
     * @param m 出列的标记(可以大于n)
     */
	public static void josephRing(int n,int start,int m){
		List<Integer> list=new ArrayList<Integer>();
		//初始化列表
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		while(list.size()>0){
			for(int j=1;j<m;j++){
				list.add(list.remove(start));
			}
			System.out.println(list.remove(start));
		}
	}
	
	public static int josephRing(int n,int m){
		if(n<1||m<1){
			return -1;
		}
		int last=0;
		for(int i=2;i<=n;i++){
			last=(last+m)%i;
		}
		return last+1;
	}
	
	 public static void main(String[] args){
	        josephRing(5,0,3);
	        System.out.println(josephRing(5,3));
	    }
}
