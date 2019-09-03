package SwordToOffer;

/**
 * @author ������ ���������������
 * ��Ŀ�������ڹ��ϵ�һάģʽʶ���У�������Ҫ�������������������ͣ�������ȫΪ
 * ������ʱ������ܺý�������ǣ���������а����������Ƿ�Ӧ�ð���ĳ��������
 * �����ڴ��Աߵ������ֲ���������:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8
 * (�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��(�������ĳ���������1)
 *����˼·������һ�������е�һ����x������x����ߵ���������Ϊ�Ǹ�����ô����x��ʹ��
 *ֵ�������������Ϊx֮ǰ�����ĺͶ���������й��׵ġ����ǰ����������Ǹ�������
 *��Ϊ�к����ܺ͡�
 *������cur��¼��ǰֵ����max��¼���ֵ�����cur<0��������֮ǰ��������cur
 *���ڵ�ǰ���֣�����cur=cur+��ǰ���֡����cur����max�����max��
 */
public class FindGreatSumOfSubArray {
	public int findGreatSumOfArray(int[] array){
		if(array.length==0){
			return 0;
		}
		int cur=array[0],max=array[0];
		for(int i=1;i<array.length;i++){
			cur= cur>0 ? cur+array[i]:array[i];
			if(max<cur){
				max=cur;
			}
		}
		return max;
	}
}