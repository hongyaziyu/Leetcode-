package SwordToOffer;

import java.util.ArrayList;

/**
 * @author ������ ��ΪS��������������
 * ��Ŀ�������ҵ�һ����������������ʹ�ú�ΪS
 * ����˼·��
 * �������ڷ�������������start��end�ֱ��ʾ���е���Сֵ�����ֵ�����Ƚ�start
 * ��ʼ��Ϊ1��end��ʼ��Ϊ2.�����start��end�ʹ���sum���ʹ�������ȥ����С��ֵ
 * ��������start�����෴��ֻ��Ҫ����end��
 * ��ֹ����Ϊ��һֱ����begin����1+sum��/2����endС��sum
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
