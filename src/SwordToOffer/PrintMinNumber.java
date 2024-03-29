package SwordToOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 黄子玉 把数组排成最小的数
 * 题目描述：输入一个正整数数组，把数组里所有的数字排成一个数，打印出能拼接出最小
 * 的一个数。例如输入{2,32,243}，最小数字是224332
 * 解题思路：现将数组转换成字符串数组，然后对字符串数组按照规则排序，最后将排好序
 * 的字符串数组拼接出来。
 * 关键就是制定排序规则：
 * 	若ab>ba 则a>b
 *  若ab < ba 则 a < b
 *  若ab = ba 则 a = b
 * 解释说明：
   a = 21
   b = 2
     因为 212 < 221, 即 ab < ba ，所以 a < b
     所以我们通过对ab和ba比较大小，来判断a在前或者b在前的。
 */
public class PrintMinNumber {
	public String printMinNumber(int[] nums){
		int len=nums.length;
		if(len==0){
			return "";
		}
		if(len==1){
			return String.valueOf(nums[0]);
		}
		StringBuffer res=new StringBuffer();
		String[] str=new String[len];
		for(int i=0;i<len;i++){
			str[i]=String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>(){
			public int compare(String s1,String s2){
				String c1=s1+s2;
			    String c2=s2+s1;
			    return c1.compareTo(c2);
		    }
		});//这里用到了Arrays.sort(String[] a, Comparator<? super String> c)
		   //这种方法，a是字符串数组，后面的是自定义的排序规则。
		for(int i=0;i<len;i++){
			res.append(str[i]);
		}
		return res.toString();
	}
}
