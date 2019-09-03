package BasicAlgorithm;

import java.util.Arrays;

/**
 * @author 黄子玉 二分查找
 * 以这个题目为例来看怎么写递归程序。
 * 1.基准情况。也可以理解为递归的终止条件，在这里终止条件很容易，就是找到我们想要的数或者搜索完了整个数组（查找失败）。
 * 2.不断演进。这里可以理解为将某个条件一步一步推向终止条件。在这里就是继续查找剩下的一半数组。
 * 3.用人的思考方式设计。非常重要，一般情况下我们用大脑模拟电脑执行每一条语句从而确定编码的正确性，然而这在递归编码中是不
 * 需要的，这需要直到前两条法则就够了。
 * 4.不要做重复的事情。
 */
public class BinarySearch {
	public int binarySearch(int[] array,int start,int end, int target){
		int middle=(end-start)/2+start;//初始条件很容易设置。
		if(end<start){//实现法则1，设置终止条件
			return -1;
		}else if(target==array[middle]){
			return middle;
		}
		
		int index;
		if(target>array[middle]){//实现法则2，不断演进将条件一步一步推进到终止条件。
			index=binarySearch(array,middle+1,end,target);
		}else{
			index=binarySearch(array,start,middle-1,target);
		}
		return index;//非常重要，容易忽略，对应第三条法则。不要考虑法则2是怎样运行的，要认为法则2正确运行应该如何处理
		            //就是显而易见的，返回index就行了。
	}
	//测试函数
	public static void main(String[] args) {
		int[] array={3,4,5,3,6,7,9,8,2};
		Arrays.sort(array);
		int target=2;
		BinarySearch a=new BinarySearch();
		System.out.println(a.binarySearch(array, 0, array.length-1, target));
	}
	//用递归求1+2+3+...+n=n(n+1)/2(类比数学归纳法)
	public int sum(int n){
		if(n==1){//首先数学归纳法n=1的时候用公式计算结果是1
			return 1;
		}else{
			return sum(n-1)+n;//假设n-1的时候公式成立。那么n的时候sum(n)=sum(n-1)+n
		}
	}
	//反转链表。
}
