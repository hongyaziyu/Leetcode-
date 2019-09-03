package DynamicProgramming;


/**
 * @author 黄子玉
 * 时间：2019/07/05 12:00
 * 钢条切割问题
 *假设长度为i的钢条价格为p(i)，给定长度为n的钢条和价格表p(i)，求最佳分割方案使得获益r(n)最大。
 *分析：r(n)=max(p(n),r(1)+r(n-1),...,r(i)+r(n-i),...,r(n-1)+r(1))
 */
/**
 * @author 黄子玉
 *
 */
public class SteelCutting {
	//方法1：用递归法解决问题。
	public static int cut(int n,int[] p){
		if(n==0){
			return 0;
		}
		int q=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			q=Math.max(q, p[i-1]+cut(n-i,p));
		}
		return q;
	}
	//方法2：备忘录法：记录每个子结果的最优解
	public static int cutMemo(int[] p){
		int[] r=new int[p.length+1];
		for(int i=0;i<=p.length;i++){
			r[i]=-1;
		}
		return cut(p,p.length,r);
	}
	//分析：假设此时p[0]=1;p[1]=5,p[2]=8,p[3]=9.r[0]=-1,r[1]=-1,r[2]=-1,r[3]=-1,r[4]=-1。
	//即此时p.length=4.r数组长度是5，下标是0到4。
	//输出r[4]的值。
	//r[4]=max{r[3]+p[0],r[2]+p[1],r[1]+p[2],r[0]+p[3]}。就要先求r[3]、r[2]、r[1]、r[0]
	//r[3]=max{r[2]+p[0],r[1]+p[1],r[0]+p[2]}
	//r[2]=max{r[1]+p[0],r[0]+p[1]}
	//r[1]=max{r[0]+p[0]}
	//r[0]=0
	//从下往上迭代算出r[4]给q，然后q作为返回值。
	public static int cut(int[] p, int n, int[] r) {
		int q=-1;
        if(n==0)
            q=0;
        else {
            for(int i=1;i<=n;i++)
                q=Math.max(q, cut(p, n-i,r)+p[i-1]);
        }
        r[n]=q;

        return q;
	}
	//方法3：自底向上动态规划。
	//从上面一个方法的分析可以发现可以先计算r[0],r[1],r[2],r[3],r[4]的值存在数组里想取什么值就取什么值。
	public static int buttom_up_cut(int[] p){
		int[] r=new int[p.length+1];
		r[0]=0;//可以不写，默认为0
		//外层循环分别求出r[1],r[2],...
		for(int i=1;i<=p.length;i++){
			int q=-1;
			//内层循环分别求r[1],r[2],...最优解。
			for(int j=1;j<=i;j++){
				q=Math.max(q, p[j-1]+r[i-j]);
			}
			r[i]=q;
		}
		return r[p.length];
	}
	
	public static void main(String[] args) {
		int[] p={1,5,8,9};
		int n=2;
		System.out.println(SteelCutting.buttom_up_cut(p));
	}
}
