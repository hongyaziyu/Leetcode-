package SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 黄子玉 字符串的排列
 * 题目描述：输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入
 * 字符串abc，则打印出由a,b,c所能排列出来的所有字符串。
 * abc,acb,bac,bca,cab和cba。
 * 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 解题思路：把复杂的问题分成几个小问题来解决：
 * 第一步求可能出现在第一个位置的字符（即把第一个字符和后面所有的字符交换）相同
 * 字符不交换。
 * 第二步固定第一个字符，求后面所有字符的排列。这时候可以把后面的所有字符拆成
 * 两个部分（第一个字符和后面所有的字符），以此类推。用递归的方法解决。
 */
public class ArrangementOfString {
	ArrayList<String> res=new ArrayList<String>();
	public ArrayList<String> arrangementOfString(String str){
		if(str==null){
			return res;
		}
		permutationHelper(str.toCharArray(),0);
		Collections.sort(res);
		return res;
	}
	public void permutationHelper(char[] str, int i) {
		if(i==str.length-1){
			res.add(String.valueOf(str));
		}else{
			for(int j=i;j<str.length;j++){
				if(j!=i&&str[i]==str[j]){
					continue;
				}
				swap(str,i,j);
				permutationHelper(str,i+1);
				swap(str,i,j);
			}
		}
		
	}
	public void swap(char[] str, int i, int j) {
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
}
