package SwordToOffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 黄子玉 和为S的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得它们的和
 * 正好是S，如果有多对，输出两个数的乘积最小的。
 * 解题思路：
 * 方法1：哈希法。
 * 用一个HashMap，它的key存储数S与数组中每个数的差，value存储当前的数字。
 * 我们遍历数组，判断hashmap中的key是否存在当前的数字，如果存在，说明存在着另一个数
 * 与当前的数相加和为S，我们就可以判断他们的乘积是否小于之前的乘积，如果小的话就替换
 * 如果大的话就放弃当前找的。如果hashmap 中的 key 不存在当前的数字，
 * 说明还没有找到相加和为 S 的两个数，那就把S与当前数字的差作为 key，
 * 当前数字作为 value 插入到 hashmap 中，继续遍历。
 * 
 * 方法2：左右夹逼法
 * a+b=sum，a和b越远乘积越小，因为数组是递增排序，
 * 所以一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况。
 * 若ai+aj==sum,说明就是答案（相差越远乘积越小）
 * 若ai+aj>sum,说明aj太大了，j--；
 * 若ai+aj<sum，说明ai太小了，i++；
 */
public class FindNumbersWithSum {
	//方法1：哈希法
	public ArrayList<Integer> findNumberWithSum(int[] array,int sum){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(array.length<2){
			return res;
		}
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int less=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				if(array[i]*map.get(array[i])<less){
					less=array[i]*map.get(array[i]);
					res.clear();
					res.add(map.get(array[i]));
					res.add(array[i]);
				}else{
					int key=sum-array[i];
					map.put(key, array[i]);
				}
			}
		}
		return res;
	}
	//方法2：夹逼法
	public ArrayList<Integer> findNumbersWithSum1(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(array.length < 2)
            return res;
        int i = 0, j = array.length - 1;
        while(i!=j){
        	if(array[i]+array[j]==sum){
        		res.add(array[i]);
        		res.add(array[j]);
        		break;
        	}else if(array[i]+array[j]<sum){
        		i++;
        	}else{
        		j--;
        	}
        }
        return res;
	}
}
