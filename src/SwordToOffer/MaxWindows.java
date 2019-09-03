package SwordToOffer;

import java.util.ArrayList;

/**
 * @author 黄子玉 窗口滑动的最大值
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 *  {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 *   {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *解题思路：法一：简单的暴力法
法二：双向队列
用一个双向队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次，
判断当前最大值是否过期（当前最大值的位置是不是在窗口之外），
新增加的值从队尾开始比较，把所有比他小的值丢掉。这样时间复杂度为O(n)。
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
