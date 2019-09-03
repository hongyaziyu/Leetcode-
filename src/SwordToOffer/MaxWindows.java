package SwordToOffer;

import java.util.ArrayList;

/**
 * @author ������ ���ڻ��������ֵ
 * ��Ŀ����������һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� 
 * �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}��
 *  {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}��
 *   {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 *����˼·����һ���򵥵ı�����
������˫�����
��һ��˫����У����е�һ��λ�ñ��浱ǰ���ڵ����ֵ�������ڻ���һ�Σ�
�жϵ�ǰ���ֵ�Ƿ���ڣ���ǰ���ֵ��λ���ǲ����ڴ���֮�⣩��
�����ӵ�ֵ�Ӷ�β��ʼ�Ƚϣ������б���С��ֵ����������ʱ�临�Ӷ�ΪO(n)��
 */
public class MaxWindows {
	 public ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if(num.length < size || size == 0)
	            return res;
	        for(int i = 0; i < num.length - size + 1; i++){
	            res.add(max(num, i, size));
	        }
	        return res;
	    }
	    public int max(int [] num, int index, int size){
	        int res = num[index];
	        for(int i = index + 1; i < index + size; i++){
	            if(num[i] > res)
	                res = num[i];
	        }
	        return res;
	    }
}
