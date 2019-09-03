package SwordToOffer;

/**
 * @author ������ �����е������
 * ��Ŀ�������������е��������֣����ǰ������ִ��ں�������֣����������������
 * һ������ԡ�����һ�����飬�����������е�����Ե�����P������P��1000000007
 * ȡģ�������������P%1000000007
 * ������������֤�����������û����ͬ�����֡�
 * ����˼·���������뵽����ÿһ��Ԫ�أ�����������Ԫ�ضԱȣ�������ڣ���count++
 * ����������ʱ�临�Ӷ���O��n^2����������ǿ����ù鲢����
 * ����7,5,6,4���Ի���Ϊ7,5��6,4����������
 * ��7,5���������ԣ���Ϊ7����5������1��
��6,4���������ԣ���Ϊ6����4����������ټ�1��Ϊ2
��7,5��6,4�������򣬽��Ϊ5,7,��4,6
��������ָ��ֱ�ָ�������������е����ֵ��p1ָ��7��p2ָ��6
�Ƚ�p1��p2ָ���ֵ���������p2����Ϊp2ָ��������ֵ�����Եڶ������������м���Ԫ�ؾ��м��������(��ǰ������Ԫ�أ�����Լ�2,2+2=4)��7>6,�Ƚ���֮��p1ָ���ֵ���븨�����������������������һ������7��Ȼ��p1��ǰ�ƶ�һλָ��5
�ٴ��ж�p1��p2ָ���ֵ��p1С��p2����Ϊp1ָ����ǵ�һ�������������ֵ��������������û���ܺ͵�ǰp2ָ���6��������Ե�������p2ָ���ֵ���븨�����飬����ǰ�ƶ�һλָ��4����ʱ����������Ϊ6,7
�����ж�p1(ָ��5)��p2(ָ��4)��5>4,�ڶ�����������ֻ��һ�����֣�����Լ�1��4+1=5��Ϊ5�ԣ�Ȼ��5���븨�����飬��һ�������������ϣ�ֻʣ�µڶ��������飬��ǰֻ��һ��4����4Ҳ���븨�����飬�������������������ʱΪ4,5,6,7.�����Ϊ5.
 * 
 */
public class InversePairs {
	public int inversePairs(int[] array){
		int len=array.length;
		if(array==null||len<=0){
			return 0;
		}
		return mergeSort(array,0,len-1);
	}

	private int mergeSort(int[] array, int start, int end) {
		if(start==end){
			return 0;
		}
		int mid=(start+end)/2;
		int left_count=mergeSort(array,start,mid);
		int right_count=mergeSort(array,mid+1,end);
		int i=mid,j=end;
		int [] copy = new int[end - start + 1];
        int copy_index = end - start;
        int count = 0;
        while(i >= start && j >= mid + 1){
            if(array[i] > array[j]){
                copy[copy_index--] = array[i--];
                count += j - mid;
                if(count > 1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[copy_index--] = array[j--];
            }
        }
        while(i >= start){
            copy[copy_index--] = array[i--];
        }
        while(j >= mid + 1){
            copy[copy_index--] = array[j--];
        }
        i = 0;
        while(start <= end) {
            array[start++] = copy[i++];
        }
        return (left_count+right_count+count)%1000000007;
	}
}
