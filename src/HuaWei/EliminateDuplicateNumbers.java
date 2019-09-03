package HuaWei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author 黄子玉 消除重复数字
 * 题目描述：给定一个正整数，给出消除重复数字以后最大的整数。
 * 输入描述：正整数，考虑长整数。
 * 输出描述：消除重复数字以后的最大整数。
 * 输入样例：423234
 * 输出样例：432
 * 解题思路：1.首先将字符串去重后得到的数放入一个大小小于10的数组中。
 * 2.枚举出所有由这些数字组成的数。
 * 3.将这些数放入TreeSet集合。
 * 4.遍历TreeSet集合，判断元素是否在原始串中出现过，若没出现则将其删除。
 * 5.最后取出TreeSet中最后一个元素就是最大整数。
 */
public class EliminateDuplicateNumbers {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TreeSet<Integer> set=new TreeSet<Integer>();
		String[] strArr;
		int k=0;
		Long maxNum=0L;//0L表示长整型0 int整数最大两个字节。long是能表示两个字节的数。
		int st=0;
		TreeMap<Long,Boolean> map=new TreeMap<Long,Boolean>();
		while(sc.hasNext()){
			String line=sc.nextLine();
			//首先将字符串去重后得到的数放入一个大小小于10的数组中。
			for(int i=0;i<line.length();i++){
				set.add(Character.getNumericValue(line.charAt(i)));
			}//利用了TreeSet集合没有重复元素的特点
			strArr=new String[set.size()];
			for(Integer in:set){
				strArr[k]=in+"";
				k++;
			}
			//枚举出由这些数字组成的数，将这些数放入TreeSet集合中。
			permutate(strArr,st,map);//利用了TreeSet有序的特点。
			//遍历TreeSet集合，判断元素是否在原始串中出现过，若没出现则将其删除。
			for(Map.Entry<Long, Boolean> entry:map.entrySet()){
				Long key=entry.getKey();
				boolean isFind=findStrByKey(line,key);
				if(isFind){
					map.put(key, true);
				}
			}
			//最后取出TreeMap中最后一个元素就是最大整数。因为TreeSet是有序的，最后一个元素是最大的。
			for(Map.Entry<Long,Boolean> entry:map.entrySet()){
				if(entry.getValue()){
					maxNum=entry.getKey();
				}
			}
			System.out.println(maxNum);
		}
	}

	private static void permutate(String[] strArr, int st, TreeMap<Long, Boolean> map) {
		if(st == strArr.length-1){
			// 将当前字符串数组表示的整数存入set。
			StringBuilder sb = new StringBuilder();
			// 打印当前字符串
			for (int i = 0; i < strArr.length; i++) {
			String string = strArr[i];
			// System.out.print(string + "");
			sb.append(string);
			}
			// System.out.println();
			String s = sb.toString();
			map.put(new Long(s), false);
			}else {
			for(int i=st ; i<strArr.length ; i++){
			swap(strArr, i, st);
			permutate(strArr, st + 1, map);
			swap(strArr, i, st);
			}
			}
	}

	private static void swap(String[] strArr, int i, int st) {
		String temp = strArr[i];
		strArr[i] = strArr[st];
		strArr[st] = temp;
	}

	private static boolean findStrByKey(String line, Long key) {
		String keyStr=key.toString();
		String[] temp=new String[keyStr.length()];
		int k=0;
		int j=0;
		for(int i=0;i<keyStr.length();i++){
			temp[i]=keyStr.charAt(i)+"";
			// temp[i] = Character.getNumericValue(keyStr.charAt(i)) +  "";
		}
		while(k<temp.length){
			while(j<line.length()){
			if(temp[k].equals(line.charAt(j)+"")){
			k++;
			j++;
			break;
			}
			j++;
			}
			if(j==line.length()){
			break;
			}
		}
		// 最终判断k是否到达末尾就可知存不存在；
		if(k==temp.length){
		return true;
		}
		return false;
	}
	
}
