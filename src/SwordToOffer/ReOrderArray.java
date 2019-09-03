package SwordToOffer;

import java.util.Vector;

/**
 * @author 黄子玉 调整数组顺序使奇数位于偶数前面
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的
 * 奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数的相对位置不变。
 * 解题思路：最简单的方法就是把奇数和偶数按顺序挑出来，分别放到vector里，最后把
 * 偶数的vector接到奇数vector的末尾。
 */
public class ReOrderArray {
	public void reOrderArray(int[] array){
		Vector<Integer> odd=new Vector<Integer> ();
		Vector<Integer> even=new Vector<Integer> ();
		
		for(int i=0;i<array.length;i++){
			if(array[i]%2==0){
				even.add(array[i]);
			}else{
				odd.add(array[i]);
			}
		}
		odd.addAll(even);
		for(int i=0;i<array.length;i++){
			array[i]=odd.get(i);
		}
	}
}
