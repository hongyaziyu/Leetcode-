package SwordToOffer;

/**
 * @author 黄子玉 数组中的逆序对
 * 题目描述：在数组中的两个数字，如果前面的数字大于后面的数字，则这两个数字组成
 * 一个逆序对。输入一个数组，求出这个数组中的逆序对的总数P。并将P对1000000007
 * 取模输出结果。即输出P%1000000007
 * 输入描述：保证输入的数组中没有相同的数字。
 * 解题思路：很容易想到遍历每一个元素，让其与后面的元素对比，如果大于，则count++
 * 但是这样的时间复杂度是O（n^2），因此我们可以用归并排序
 * 例如7,5,6,4可以划分为7,5和6,4两个子数组
 * 在7,5中求出逆序对，因为7大于5所以有1对
在6,4中求出逆序对，因为6大于4所以逆序对再加1，为2
对7,5和6,4进行排序，结果为5,7,和4,6
设置两个指针分别指向两个子数组中的最大值，p1指向7，p2指向6
比较p1和p2指向的值，如果大于p2，因为p2指向的是最大值，所以第二个子数组中有几个元素就有几对逆序对(当前有两个元素，逆序对加2,2+2=4)，7>6,比较完之后将p1指向的值放入辅助数组里，辅助数组里现在有一个数字7，然后将p1向前移动一位指向5
再次判断p1和p2指向的值，p1小于p2，因为p1指向的是第一个子数组中最大值，所以子数组中没有能和当前p2指向的6构成逆序对的数，将p2指向的值放入辅助数组，并向前移动一位指向4，此时辅助数组内为6,7
继续判断p1(指向5)和p2(指向4)，5>4,第二个子数组中只有一个数字，逆序对加1，4+1=5，为5对，然后将5放入辅助数组，第一个子数组遍历完毕，只剩下第二个子数组，当前只有一个4，将4也放入辅助数组，函数结束。辅助数组此时为4,5,6,7.逆序对为5.
 * 
 */
public class InversePairs {
	public int inversePairs(int[] array){
		int len=array.length;
		if(array==null||len<=0){
			return 0;
		}
		return mergeSort(array,0,len-1);
	}

	private int mergeSort(int[] array, int start, int end) {
		if(start==end){
			return 0;
		}
		int mid=(start+end)/2;
		int left_count=mergeSort(array,start,mid);
		int right_count=mergeSort(array,mid+1,end);
		int i=mid,j=end;
		int [] copy = new int[end - start + 1];
        int copy_index = end - start;
        int count = 0;
        while(i >= start && j >= mid + 1){
            if(array[i] > array[j]){
                copy[copy_index--] = array[i--];
                count += j - mid;
                if(count > 1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[copy_index--] = array[j--];
            }
        }
        while(i >= start){
            copy[copy_index--] = array[i--];
        }
        while(j >= mid + 1){
            copy[copy_index--] = array[j--];
        }
        i = 0;
        while(start <= end) {
            array[start++] = copy[i++];
        }
        return (left_count+right_count+count)%1000000007;
	}
}
