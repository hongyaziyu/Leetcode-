package SwordToOffer;

import java.util.ArrayList;

/**
 * @author 黄子玉 和为S的连续正数序列
 * 题目描述：找到一组连续的正数序列使得和为S
 * 解题思路：
 * 滑动窗口法：用两个数字start和end分别表示序列的最小值和最大值，首先将start
 * 初始化为1，end初始化为2.如果从start到end和大于sum，就从序列中去掉较小的值
 * （即增大start），相反，只需要增大end。
 * 终止条件为：一直增加begin到（1+sum）/2并且end小于sum
 */
public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
		ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
		if(sum<3){
			return res;
		}
		int start=1,end=2,mid=(sum+1)/2;
		while(start<mid){
			int s=totalSum(start,end);
			if(s==sum){
				res.add(getSequence(start,end));
				end++;
			}else if(s<sum){
				end++;
			}else if(s>sum){
				start++;
			}
		}
		return res;
	}

	private ArrayList<Integer> getSequence(int start, int end) {
		ArrayList<Integer> temp=new ArrayList<Integer>();
		for(int i=start;i<=end;i++){
			temp.add(i);
		}
		return temp;
	}

	private int totalSum(int start, int end) {
		int sum=0;
		for(int i=start;i<=end;i++){
			sum+=i;
		}
		return sum;
	}
}
