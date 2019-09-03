package leetcode;

/**
 * @author 黄子玉 两个有序数组的中位数
 *
 */
public class MedianOfTwoSortedArrays {
	//简单的暴力解法。时间复杂度O(m+n)，空间复杂度O(m+n)。
	public double findMedianOfTwoSortedArrays(int[] nums1,int[] nums2){
		int[] nums;
		int m=nums1.length;
		int n=nums2.length;
		nums=new int[m+n];
		if(m==0){
			if(n%2==0){
				return (nums2[n/2-1]+nums2[n/2])/2.0;
			}else{
				return nums2[n/2];
			}
		}
		
		if(n==0){
			if(m%2==0){
				return (nums1[m/2-1]+nums1[m/2])/2.0;
			}else{
				return nums1[m/2];
			}
		}
		
		int count=0;
		int i=0,j=0;
		while(count!=(m+n)){
			if(nums1[i]<nums2[j]){
				nums[count++]=nums1[i++];
			}else{
				nums[count++]=nums2[j++];
			}
			if(i==m){
				while(j!=n){
					nums[count++]=nums2[j++];
				}
				break;
			}
			if(j==n){
				while(i!=m){
					nums[count++]=nums2[i++];
				}
				break;
			}
		}
		if(count%2==0){
			return (nums[count/2-1]+nums[count/2])/2.0;
		}else{
			return nums[count/2];
		}
	}
}
