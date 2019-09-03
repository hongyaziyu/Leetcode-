package HuaWei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 黄子玉  获取剩余可用字符集
 * 题目描述：给定两个字符集，一个为全量字符集，一个为已占用字符集。要求输出剩余可用字符集。
 * 输入描述：输入包括全量字符集和已占用字符集，两个字符集用@连接。@前为全量字符集，@后为已占用字符集。
 * 字符集中字符表示为数字加字符的形式，字符和数字用冒号隔开。比如a:1，表示1个a字符。字符只考虑英文字母，区分大小写
 * 数字只考虑正整形，数量不超过100，如果一个字符都没被占用，@字符仍然存在，例如：a:3,b:5,c:2@
 * 输出描述：可用字符集。输出带回车换行。
 * 实例：  输入 a:3,b:5,c:2@a:1,b:2
 *       输出 a:2,b:3,c:2
 * 解题思路：很容易想到利用@，,，：来分割字符串，再用hashmap来存储键值。最后输出。
 */
public class GetTheRemainingAvailableCharacterSet {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(str.charAt(str.length()-1)=='@'){
			System.out.println(str.substring(0, str.length()-1));
			return;
		}
		getTheRemainingAvailableCharacterSet(str);
	}

	private static void getTheRemainingAvailableCharacterSet(String str) {
		String q=str.split("@")[0];
		String s=str.split("@")[1];
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		//处理全量字符集
		String[] q1=q.split(",");
		int length1=q1.length;
		for(int i=0;i<length1;i++){
			String temp=q1[i];
			String[] temp1=temp.split(":");
			map.put(temp1[0], Integer.parseInt(temp1[1]));
		}
		//处理已占用字符集
		String[] s1=s.split(",");
		int length2=s1.length;
		for(int i=0;i<length2;i++){
			String temp=s1[i];
			String[] temp1=temp.split(":");
			int result=map.get(temp1[0])-Integer.parseInt(temp1[1]);
			map.put(temp1[0], result);//注意由HashMap的底层原理可知，key重复会覆盖，value允许重复。
		}
		//打印剩余字符集
		StringBuffer sb=new StringBuffer("");
		for(int k=0;k<length1;k++){
			String zifu=q1[k].split(":")[0];
			int number=map.get(zifu);
			if(number!=0){    //注意如果剩余字符为零就不需要打印了。
				sb.append(zifu+":"+number+",");
			}
		}
		String remaining=sb.toString();
		System.out.println(remaining.substring(0, remaining.length()-1));
	}
}
