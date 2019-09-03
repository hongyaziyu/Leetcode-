package BasicAlgorithm;

import java.util.Arrays;

/**
 * @author ������ ���ֲ���
 * �������ĿΪ��������ôд�ݹ����
 * 1.��׼�����Ҳ�������Ϊ�ݹ����ֹ��������������ֹ���������ף������ҵ�������Ҫ�����������������������飨����ʧ�ܣ���
 * 2.�����ݽ�������������Ϊ��ĳ������һ��һ��������ֹ��������������Ǽ�������ʣ�µ�һ�����顣
 * 3.���˵�˼����ʽ��ơ��ǳ���Ҫ��һ������������ô���ģ�����ִ��ÿһ�����Ӷ�ȷ���������ȷ�ԣ�Ȼ�����ڵݹ�������ǲ�
 * ��Ҫ�ģ�����Ҫֱ��ǰ��������͹��ˡ�
 * 4.��Ҫ���ظ������顣
 */
public class BinarySearch {
	public int binarySearch(int[] array,int start,int end, int target){
		int middle=(end-start)/2+start;//��ʼ�������������á�
		if(end<start){//ʵ�ַ���1��������ֹ����
			return -1;
		}else if(target==array[middle]){
			return middle;
		}
		
		int index;
		if(target>array[middle]){//ʵ�ַ���2�������ݽ�������һ��һ���ƽ�����ֹ������
			index=binarySearch(array,middle+1,end,target);
		}else{
			index=binarySearch(array,start,middle-1,target);
		}
		return index;//�ǳ���Ҫ�����׺��ԣ���Ӧ���������򡣲�Ҫ���Ƿ���2���������еģ�Ҫ��Ϊ����2��ȷ����Ӧ����δ���
		            //�����Զ��׼��ģ�����index�����ˡ�
	}
	//���Ժ���
	public static void main(String[] args) {
		int[] array={3,4,5,3,6,7,9,8,2};
		Arrays.sort(array);
		int target=2;
		BinarySearch a=new BinarySearch();
		System.out.println(a.binarySearch(array, 0, array.length-1, target));
	}
	//�õݹ���1+2+3+...+n=n(n+1)/2(�����ѧ���ɷ�)
	public int sum(int n){
		if(n==1){//������ѧ���ɷ�n=1��ʱ���ù�ʽ��������1
			return 1;
		}else{
			return sum(n-1)+n;//����n-1��ʱ��ʽ��������ôn��ʱ��sum(n)=sum(n-1)+n
		}
	}
	//��ת����
}
