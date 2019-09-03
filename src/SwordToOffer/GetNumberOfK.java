package SwordToOffer;

/**
 * @author 黄子玉 数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数
 * 解题思路：正常思路就是二分查找，我们利用递归的方法实现查找k第一次出现的下标
 * 用循环的方法实现了查找k最后一次出现的下标。
 * 除此之外，还有一种思路，因为data中都是整数，所以我们不用搜索k的两个位置，而是
 * 直接搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减就可以了。
 */
public class GetNumberOfK {
	public int getNumberOfK(int[] array,int k){
		int len=array.length;
		if(len==0){
			return 0;
		}
		int first=getFirst(array,k,0,len-1);
		int last=getLast(array,k,0,len-1);
		if(first!=-1&&last!=-1){
			return last-first+1;
		}
		return 0;
	}

	private int getLast(int[] array, int k, int start, int end) {
		int mid;
		while(start<=end){
			mid=start+(end-start)/2;
			if(k<=array[mid]){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		if(start<array.length&&array[start]==k){
			return start;
		}else{
			return -1;
		}
	}

	private int getFirst(int[] array, int k, int start, int end) {
		int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(k >= array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(end >= 0 && array[end] == k)
            return end;
        else
            return -1;
	}
}
