package KuaiShou;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author 黄子玉 实现合并流
 * 题目描述：合并两个内容流，实现隔四个插入一个，如果合并完还有尾部则加入内容流尾部。
 * 举例：
 * 输入：
 * 1 2 3 4 5 6 7 8 9
 * a b c
 * 输出：
 * 1 2 3 4 a 5 6 7 8 b 9 c
 * 解题思路：用while循环，对于第一个字符串直到遍历到字符串结尾。用一个指针标记，每遍历完4个先放到新字符串中，遍历到第四个
 * 字符后第五个字符应该取第二个字符串第一个字符，以此类推。遍历完第一个字符串如果第二个字符串还有就接到第一个字符串。
 */
public class MergeInputStream {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str1=sc.nextLine();
			String str2=sc.nextLine();
			String str1_copy=str1;
			String str2_copy=str2;
			doWork1(str1,str2);
			dowork2(str1_copy,str2_copy);
		}
	}

	private static void dowork2(String str1, String str2) {
		String[] s1=str1.split(" ");
		String[] s2=str2.split(" ");
		StringBuilder sb=new StringBuilder(str1.length()+str2.length());
		int index1=0;
		int index2=0;
		while(index1<s1.length){
			if(index1%4==0&&index1>=4&&index2<str2.length()){
				sb.append(s2[index2]+" ");
				index2++;
			}
			sb.append(s1[index1]+" ");
			index1++;
		}
		while(index2<s2.length){
			sb.append(s2[index2]+" ");
			index2++;
		}
		if(sb.length()>0){
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
	}

	private static void doWork1(String str1, String str2) {
		String[] s1=str1.split(" ");
		String[] s2=str2.split(" ");
		ArrayList<String> result1=new ArrayList<String>();
		if(s1.length<=4){
			System.out.println(str1+" "+str2);
		}
		int num=s1.length/4;
		if(num<s2.length){
			for(int i=0;i<num;i++){
				result1.add(s1[i*4]);
				result1.add(s1[i*4+1]);
				result1.add(s1[i*4+2]);
				result1.add(s1[i*4+3]);
				result1.add(s2[i]);
			}
			for(int i=4*num;i<s1.length;i++){
				result1.add(s1[i]);
			}
			for(int i=num;i<s2.length;i++){
				result1.add(s2[i]);
			}
		}else {
			for(int i=0;i<num;i++){
				result1.add(s1[i*4]);
				result1.add(s1[i*4+1]);
				result1.add(s1[i*4+2]);
				result1.add(s1[i*4+3]);
				result1.add(s2[i]);
			}
			for(int i=4*num;i<s1.length;i++){
				result1.add(s1[i]);
			}
		}
		StringBuffer result=new StringBuffer("");
		for(int i=0;i<result1.size();i++){
			result.append(result1.get(i)+" ");
		}
		System.out.println(result.substring(0, result.length()-1));
	}
}
