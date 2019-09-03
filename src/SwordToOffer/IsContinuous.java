package SwordToOffer;

import java.util.Arrays;

/**
 * @author 黄子玉 扑克牌的顺子
 * 题目描述：大小王可以看成任何牌，抽出五张牌看是不是顺子。王看成0.
 * 解题思路：先统计王（0）的数量，再把牌排序，如果后面一个数比前面一个数
 * 大于1以上，那么中间差值必须用王来弥补。看王的数量够不够，够就true，
 * 不够就false。
 */
public class IsContinuous {
	public boolean isContinuous(int[] nums){
		int zero=0,dis=0;
		if(nums.length!=5){
			return false;
		}
		Arrays.sort(nums);
		for(int i=0;i<4;i++){
			if(nums[i]==0){
				zero++;
				continue;
			}
			if(nums[i]==nums[i+1]){
				return false;
			}
			if(nums[i+1]-nums[i]>1){
				dis+=nums[i+1]-nums[i]-1;
			}
		}
		if(zero>=dis){
			return true;
		}else{
			return false;
		}
	}
}
