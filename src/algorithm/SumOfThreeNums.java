package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 黄子玉
 * 时间：2019/7/20 16:35
 *题目描述：给定包含n个整数的数组nums，判断数组中是否存在a，b，c三个元素使得a+b+c=0.找出所有满足条件的三元组。
 *注意：三元组不能相同。
 *分析：一看是一题数组遍历题。
 *     1.首先排除数组为空和数组元素小于3个的情况。然后不管怎么样先对数组进行排序。
 *     2.排序后先固定一个数nums[i],然后使用左右指针指向nums[i+1]和数组最后一个数，数字分别为nums[L]和nums[R]
 *     计算三个数的和sum是否为0，满足则填入结果。
 *     3.如果nums[i]大于0，则跳出循环，三数之和一定不会为0.
 *     4.如果nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
 *     5.当sum == 0 时,nums[L] == nums[L+1]则会导致结果重复，应该跳过，L++
 *     6.当sumsum == 00 时，nums[R] == nums[R-1]则会导致结果重复，应该跳过，R--
 *     7.时间复杂度：O(n^2),n为数组长度。 
 *     
 * 推广到k数之和为target
 *
 *     
 */
public class SumOfThreeNums {
	public List<List<Integer>> threeSum(int[] nums){
		if(nums==null||nums.length<3){
			return Collections.emptyList();
		}
		
		Arrays.sort(nums);//对数组进行排序
		final List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0)
				break;//如果当前数字大于0，那么三数之和结果肯定大于零，所以结束循环。
			if(i>0&&nums[i]==nums[i-1])
				continue;//去重
			int L=i+1;
			int R=nums.length-1;
			while(L<R){
				int sum=nums[i]+nums[L]+nums[R];
				if(sum==0){
					res.add(Arrays.asList(nums[i],nums[L],nums[R]));
					 while (L+1<R && nums[L] == nums[L+1]) L++; // 去重
	                 while (L<R-1 && nums[R] == nums[R-1]) R--; // 去重
	                 L++;
	                 R--;
				}
				else if(sum<0){
					L++;
				}
				else if(sum>0){
					R--;
				}
			}
		}
		return res;
	}
	
	//求k数之和
	public List<List<Integer>> kSum(int[] nums,int target,int k,int start){
		//先排序
		Arrays.sort(nums);
		int len=nums.length;
		List<List<Integer>> res=new LinkedList<>();
		
		if(k==2){
			int left=start,right=len-1;
			while(left<right){
				int sum=nums[left]+nums[right];
				if(sum==target){
					List<Integer> temp=new LinkedList<>();
					temp.add(nums[left]);
					temp.add(nums[right]);
					res.add(temp);
					//跳过左边的重复的数字
					while(left+1<right&&nums[left]==nums[left+1]){
						left++;
					}
					//跳过右边的重复数字
					while(left<right-1&&nums[right]==nums[right-1]){
						right--;
					}
					left++;
					right--;
				}else if(sum<target){
					left++;
				}else if(sum>target){
					right--;
				}
			}
		}else{
			for(int i=start,end=len-(k-1);i<end;i++){
				//跳过重复数字
				if(i>start&&nums[i]==nums[i-1]){
					continue;
				}
				// 将K数之和转换成K-1数之和
                List<List<Integer>> temp = kSum(nums,target - nums[i], k - 1, i + 1 );
                for (List<Integer> item : temp)
                    item.add(0, nums[i]);
                res.addAll(temp);
			}
		}
		return res;	
	}
	
	
	
	
	
	
	//测试函数
	public static void main(String[] args) {
		SumOfThreeNums a=new SumOfThreeNums();
		Scanner sc=new Scanner(System.in);
		int len=sc.nextInt();
		int[] nums=new int[len];
		for(int i=0;i<len;i++){
			nums[i]=sc.nextInt();
		}
		List<List<Integer>> threesum=a.threeSum(nums);
		List<List<Integer>> foursum=a.kSum(nums, 0, 4, 0);
		List<List<Integer>> fivesum=a.kSum(nums, 0, 5, 0);
		List<List<Integer>> twosum=a.kSum(nums, 0, 2, 0);
		System.out.println(foursum);
		System.out.println(threesum);
		System.out.println(fivesum);
		System.out.println(twosum);
		
		
		
	}
	
}
