package SwordToOffer;

/**
 * @author ������ ���������������г��ֵĴ���
 * ��Ŀ������ͳ��һ�����������������г��ֵĴ���
 * ����˼·������˼·���Ƕ��ֲ��ң��������õݹ�ķ���ʵ�ֲ���k��һ�γ��ֵ��±�
 * ��ѭ���ķ���ʵ���˲���k���һ�γ��ֵ��±ꡣ
 * ����֮�⣬����һ��˼·����Ϊdata�ж����������������ǲ�������k������λ�ã�����
 * ֱ������k-0.5��k+0.5��������Ӧ�ò����λ�ã�Ȼ������Ϳ����ˡ�
 */
public class GetNumberOfK {
	public int getNumberOfK(int[] array,int k){
		int len=array.length;
		if(len==0){
			return 0;
		}
		int first=getFirst(array,k,0,len-1);
		int last=getLast(array,k,0,len-1);
		if(first!=-1&&last!=-1){
			return last-first+1;
		}
		return 0;
	}

	private int getLast(int[] array, int k, int start, int end) {
		int mid;
		while(start<=end){
			mid=start+(end-start)/2;
			if(k<=array[mid]){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		if(start<array.length&&array[start]==k){
			return start;
		}else{
			return -1;
		}
	}

	private int getFirst(int[] array, int k, int start, int end) {
		int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(k >= array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(end >= 0 && array[end] == k)
            return end;
        else
            return -1;
	}
}
