package SwordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ������ ��С��K����
 * ��Ŀ����������n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8
 * ��С��4������1,2,3,4��
 * ����˼·��
 * ���ַ�����
 * 1.�ȶ������������Ȼ��ȡ��ǰk����
 * 2.�������ѱ�����k������ÿ��ֻ�ͶѶ��ȣ�����ȶѶ�С��ɾ���Ѷ���������ѡ�
 */
public class GetLeastNum {
	//����1
	public ArrayList<Integer> getLeastNum1(int[] input,int k){
		ArrayList<Integer> res=new ArrayList<Integer> ();
		if(input==null||k==0||k>input.length){
			return res;
		}
		Arrays.sort(input);
		for(int i=0;i<k;i++){
			res.add(input[i]);
		}
		return res;
	}
	//����2�����޸ġ�
	public ArrayList<Integer> getLeastNum2(int[] input,int k){
		ArrayList<Integer> res = new ArrayList<Integer>();
	    if(input == null || k ==0 || k > input.length){
	    	return res;
	    }
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>
	    (k);
        for(int i=0; i<input.length; i++){
            if(maxHeap.size() != k)
                maxHeap.offer(input[i]);
            else{
                if(maxHeap.peek() > input[i]){
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }
        for(Integer i: maxHeap){
            res.add(i);
        }
        return res;
    }
	    
	}


