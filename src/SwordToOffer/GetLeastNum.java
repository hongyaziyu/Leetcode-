package SwordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 黄子玉 最小的K个数
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8
 * 最小的4个数是1,2,3,4。
 * 解题思路：
 * 两种方法：
 * 1.先对数组进行排序，然后取出前k个。
 * 2.利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
 */
public class GetLeastNum {
	//方法1
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
	//方法2，待修改。
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


