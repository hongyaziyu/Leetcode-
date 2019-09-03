package SwordToOffer;

/**
 * @author ������
 * ��Ŀ��������һ�������ʼ���ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������
 * һ���Ǽ�����������һ����ת��������ת�������СԪ�ء�����{3,4,5,1,2}Ϊ
 * {1,2,3,4,5}��һ����ת�����������СֵΪ1.Note��������Ԫ�ض�����0���������С
 * Ϊ0���뷵��0.
 * 
 * ����˼·��
 * ���ö��ֲ��ҷ���
 * ��Ҫ�������������
 * 		array[mid]>array[high]:
 * 		�������������array����[3,4,5,6,0,1,2],��ʱ��С����һ����mid���ұߡ�
 * 		low=mid+1
 * 			
 * 			array[mid]==array[high]:
 * 			�������������array����[1,0,1,1,1]����[1,1,1,0,1]����ʱ��С����
 * 			�����ж���mid��߻����ұߣ���ʱֻ��һ��һ����
 * 			high=high-1
 * 			array[mid]<array[high]:
 * 			�������������array����[2,2,3,4,5,6,6]����ʱ��С����һ������
 * 			array[mid]������mid����ߡ���Ϊ�ұ߱�Ȼ�ǵ����ġ�
 * 			high=mid
 * 		ע�������и��ӣ��������ѯ�ķ�Χ���ֻʣ������������ômidһ����ָ���±�
 * 		��ǰ�����֣����磺array=[4,6]
 * 		array[low]=4 array[mid]=4 array[high]=6
 * 		���high=mid-1,�ͻ�����������high=mid.
 * 		
 */
public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int[] array){
		int len=array.length;
		if(len==0){
			return 0;
		}
		int low=0,high=len-1;
		while(low<high){
			int mid=low+(high-low)/2;
			if(array[mid]>array[high]){
				low=mid+1;
			}else if(array[mid]==array[high]){
				high=high-1;
			}else{
				high=mid;
			}
		}
		return array[low];
	}
}
