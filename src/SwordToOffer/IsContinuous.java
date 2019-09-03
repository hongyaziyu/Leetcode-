package SwordToOffer;

import java.util.Arrays;

/**
 * @author ������ �˿��Ƶ�˳��
 * ��Ŀ��������С�����Կ����κ��ƣ���������ƿ��ǲ���˳�ӡ�������0.
 * ����˼·����ͳ������0�����������ٰ��������������һ������ǰ��һ����
 * ����1���ϣ���ô�м��ֵ�����������ֲ�������������������������true��
 * ������false��
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
