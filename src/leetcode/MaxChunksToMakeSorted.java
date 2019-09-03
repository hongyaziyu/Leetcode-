package leetcode;

import java.util.Arrays;

/**
 * @author ������ ������������Ŀ�
 * ��Ŀ������arr��һ�����ܰ����ظ�Ԫ�ص��������飬���ǽ���������Ϊ�����飬����Щ���������֮��������������ʹ�����ӵĽ��
 * �Ͱ�����������ԭ������ͬ������������ܽ�����ֳɶ��ٿ飿
 * ���룺arr=[5,4,3,2,1]
 * �����1
 * ���ͣ�������ֳ�������߸���鶼�޷��õ������
 * ���룺arr=[2,1,3,4,4]
 * �����4
 * ���ͣ�[2,1] [3] [4] [4]
 * ����˼·��
 */
public class MaxChunksToMakeSorted {
	public int maxChunksToMakeSorted(int[] arr){
		int[] a=Arrays.copyOf(arr, arr.length);
		int[] a_cnt=new int[arr.length];
		Arrays.fill(a_cnt, 1);//��ʼ��a_cnt
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
	//���Ժ���
	public static void main(String[] args) {
		int[] arr={5,4,3,2,1,1};
		MaxChunksToMakeSorted a=new MaxChunksToMakeSorted();
		System.out.println(a.maxChunksToMakeSorted(arr));
	}
}
