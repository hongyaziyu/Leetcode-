package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ������
 * ʱ�䣺2019/7/20 16:35
 *��Ŀ��������������n������������nums���ж��������Ƿ����a��b��c����Ԫ��ʹ��a+b+c=0.�ҳ�����������������Ԫ�顣
 *ע�⣺��Ԫ�鲻����ͬ��
 *������һ����һ����������⡣
 *     1.�����ų�����Ϊ�պ�����Ԫ��С��3���������Ȼ�󲻹���ô���ȶ������������
 *     2.������ȹ̶�һ����nums[i],Ȼ��ʹ������ָ��ָ��nums[i+1]���������һ���������ֱַ�Ϊnums[L]��nums[R]
 *     �����������ĺ�sum�Ƿ�Ϊ0����������������
 *     3.���nums[i]����0��������ѭ��������֮��һ������Ϊ0.
 *     4.���nums[i] == nums[i-1]����˵���������ظ����ᵼ�½���ظ�������Ӧ������
 *     5.��sum == 0 ʱ,nums[L] == nums[L+1]��ᵼ�½���ظ���Ӧ��������L++
 *     6.��sumsum == 00 ʱ��nums[R] == nums[R-1]��ᵼ�½���ظ���Ӧ��������R--
 *     7.ʱ�临�Ӷȣ�O(n^2),nΪ���鳤�ȡ� 
 *     
 * �ƹ㵽k��֮��Ϊtarget
 *
 *     
 */
public class SumOfThreeNums {
	public List<List<Integer>> threeSum(int[] nums){
		if(nums==null||nums.length<3){
			return Collections.emptyList();
		}
		
		Arrays.sort(nums);//�������������
		final List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0)
				break;//�����ǰ���ִ���0����ô����֮�ͽ���϶������㣬���Խ���ѭ����
			if(i>0&&nums[i]==nums[i-1])
				continue;//ȥ��
			int L=i+1;
			int R=nums.length-1;
			while(L<R){
				int sum=nums[i]+nums[L]+nums[R];
				if(sum==0){
					res.add(Arrays.asList(nums[i],nums[L],nums[R]));
					 while (L+1<R && nums[L] == nums[L+1]) L++; // ȥ��
	                 while (L<R-1 && nums[R] == nums[R-1]) R--; // ȥ��
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
	
	//��k��֮��
	public List<List<Integer>> kSum(int[] nums,int target,int k,int start){
		//������
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
					//������ߵ��ظ�������
					while(left+1<right&&nums[left]==nums[left+1]){
						left++;
					}
					//�����ұߵ��ظ�����
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
				//�����ظ�����
				if(i>start&&nums[i]==nums[i-1]){
					continue;
				}
				// ��K��֮��ת����K-1��֮��
                List<List<Integer>> temp = kSum(nums,target - nums[i], k - 1, i + 1 );
                for (List<Integer> item : temp)
                    item.add(0, nums[i]);
                res.addAll(temp);
			}
		}
		return res;	
	}
	
	
	
	
	
	
	//���Ժ���
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
