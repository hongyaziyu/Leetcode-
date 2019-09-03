package SwordToOffer;

/**
 * @author 黄子玉 求1+2+3+...+n
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch
 * 、case等关键字及条件判断语句（A？B:C）
 *解题思路：
 *累加不能用循环那就试试递归。
 *判断递归终止条件不能用if和switch，那就用短路与代替。
 *(n>0)&&(sum+=sum(n-1))>0
 */
public class NSum {
	public int sum(int n){
		int sum=n;
		boolean t=(n>0)&&(sum+=sum(n-1))>0;
		return sum;
	}
}
