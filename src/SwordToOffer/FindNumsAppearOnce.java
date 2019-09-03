package SwordToOffer;

import java.util.HashMap;

/**
 * @author 黄子玉 数组中只出现一次的数字
 * 题目描述：一个整型数组里除了两个数字外，其他的数字都出现了偶数次，请写程序找出
 * 这两个只出现一次的数字。
 * 解题思路：
 * 1.HashMap
 * 2.异或法：任何一个数字异或它自己都为0
 *
 */
public class FindNumsAppearOnce {
	//方法1：HashMap法
	public void findNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            if(temp.containsKey(array[i]))
                temp.remove(array[i]);
            else
                temp.put(array[i], 1);
        }
        int [] a = new int [array.length];
        int i = 0;
        for(Integer k: temp.keySet()){
            a[i] = k;
            i++;
        }
        num1[0] = a[0];
        num2[0] = a[1];
    }
	//方法2：异或法
	 public void findNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
	        num1[0] = 0;
	        num2[0] = 0;
	        if(array.length == 0)
	            return;
	        int num = 0;
	        for(int i = 0; i < array.length; i++){
	            num ^= array[i];
	        }
	        int index = 0;
	        while((num & 1) == 0 && index < 8){
	            num = num >> 1;
	            index ++;
	        }

	        for(int i = 0; i < array.length; i++){
	            if(isa1(array[i], index))
	                num1[0] ^= array[i];
	            else
	                num2[0] ^= array[i];
	        }
	    }

	    public boolean isa1(int i, int index){
	        i = i >> index;
	        return (i & 1) == 1;
	    }
}
