package SwordToOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄子玉 数组中出现次数超过一半的数字
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了
 * 5次，超过数组长度的一半，则输出2，不存在就输出0.
 * 解题思路：
 * 三种解法。
 * 1.借助HashMap存储数组每个数出现的次数，最后看是否有数字出现次数超过数组长度
 * 的一半。
 * 2.排序。数组排序后如果某个数字出现次数超过数组长度的一半，则一定会在数组中间
 * 的位置，所以取这个数统计一下出现的次数是否大于数组长度的一半。
 * 3.某个数字出现的次数大于数组长度的一半，
 * 意思就是它出现的次数比其他所有数字出现的次数和还要多。
 * 因此我们可以在遍历数组的时候记录两个值：1. 数组中的数字;2. 次数。
 * 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
 * 若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。
 * 最后再判断它是否符合条件。
 */
public class MoreThanHalfNum {
	//方法一：HashMap方法
	public int moreThanHalfNum_1(int[] array){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int length=array.length;
		for(int i=0;i<length;i++){
			if(!map.containsKey(array[i])){
				map.put(array[i], 1);
			}else{
				map.put(array[i], map.get(array[i])+1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			if(entry.getValue()*2>length){
				return entry.getKey();
			}
		}
		return 0;
	}
	//方法2
	public int moreThanHalfNum_2(int[] array){
		Arrays.sort(array);
		int half=array.length/2;
		int count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==array[half]){
				count++;
			}
		}
		if(count>half){
			return array[half];
		}else{
			return 0;
		}
	}
	//方法3
	public int moreThanHalfNum_3(int[] array){
		int res=array[0],count=1;
		for(int i=1;i<array.length;i++){
			if(array[i]==res){
				count++;
			}else{
				count--;
			}
		}
		count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==res){
				count++;
			}
		}
		return count>array.length/2 ? res:0;
	}
}
