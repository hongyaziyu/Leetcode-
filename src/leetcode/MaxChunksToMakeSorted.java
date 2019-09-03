package leetcode;

import java.util.Arrays;

/**
 * @author 黄子玉 最多能完成排序的块
 * 题目描述：arr是一个可能包含重复元素的整数数组，我们将这个数组分为几个块，将这些块进行排序。之后再连接起来，使得连接的结果
 * 和按升序排序后的原数组相同。问我们最多能将数组分成多少块？
 * 输入：arr=[5,4,3,2,1]
 * 输出：1
 * 解释：将数组分成两块或者更多块都无法得到结果。
 * 输入：arr=[2,1,3,4,4]
 * 输出：4
 * 解释：[2,1] [3] [4] [4]
 * 解题思路：
 */
public class MaxChunksToMakeSorted {
	public int maxChunksToMakeSorted(int[] arr){
		int[] a=Arrays.copyOf(arr, arr.length);
		int[] a_cnt=new int[arr.length];
		Arrays.fill(a_cnt, 1);//初始化a_cnt
		Arrays.sort(a);
		for(int i=1;i<a.length;i++){
			if(a[i]==a[i-1]){
				a_cnt[i]=a_cnt[i-1]+1;
			}
		}
		int res=0,max=0,cnt=0;
		for(int i=0;i<arr.length;i++){
			if(max==arr[i]){
				cnt++;
			}else if(max<arr[i]){
				cnt=1;
				max=arr[i];
			}
			if(max==a[i]&&cnt==a_cnt[i]){
				res++;
			}
		}
		return res;
	}
	//测试函数
	public static void main(String[] args) {
		int[] arr={5,4,3,2,1,1};
		MaxChunksToMakeSorted a=new MaxChunksToMakeSorted();
		System.out.println(a.maxChunksToMakeSorted(arr));
	}
}
