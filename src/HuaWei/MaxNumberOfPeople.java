package HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 黄子玉 最大客人数量
 * 题目描述：举办一场8个小时的聚会，时间段从12:00到20:00点，让来访的客人填写到达的时间和离开的时间，为了掌握聚会
 * 期间座位的数目，先估计不同时间的最大客人数量。
 * 1.到达的时间和离开的时间，以整点计算，比如“12,18”表示到达时间为12点后13点前，离开时间为17点后18点前。
 * 2.按小时区间统计客人数量。
 * 3.假设邀请的客人最多100个。
 */
public class MaxNumberOfPeople {
	public static List<String> list=new ArrayList<String>();
	public static void main(String[] args) {
		String[] str={"12,15","16,17","12,20"};
		for(int i=0;i<str.length;i++){
			reset(str[i]);//重新写成另外一种形式，例如[12,15)写成[12,13),[13,14),[14,15)
		}
		Hashtable<String,Integer> wordCount=wordcount();//统计出每个时间段的人数.
		List<String> newList=new ArrayList<String>();
		for(String key:wordCount.keySet()){//改成规范形式输出
			newList.add("["+key+")"+":"+wordCount.get(key));
		}
		//重排
		Collections.sort(newList, new Comparator<Object>(){
			public int compare(Object o1,Object o2){
				String str1=(String) o1;
				String str2=(String) o2;
				if(str1.compareToIgnoreCase(str2)<0){//compareToIgnoreCase()方法用于按字典顺序比较两个字符串，不考虑大小写。str1大于str2，则返回大于0的值。
					return -1;
				}
				return 1;
			}
		});
		for(int i=0;i<newList.size();i++){
			System.out.println(newList.get(i));
		}
	}

	private static Hashtable<String, Integer> wordcount() {
		 Hashtable<String, Integer>  wordCount = new Hashtable<String, Integer>();
	        for (int i = 0; i < list.size(); i++) {
	            String str = list.get(i);
	            if (!wordCount.containsKey(str)) {
	                wordCount.put(str, Integer.valueOf(1));
	            } else {
	                wordCount.put(str, Integer.valueOf(wordCount.get(str).intValue() + 1));
	            }
	        }
	        return wordCount;
	}

	private static void reset(String str) {
		String[] aa=str.split(",");
		int inter=Integer.parseInt(aa[1])-Integer.parseInt(aa[0]);
		for(int i=0;i<inter;i++){
			int newString=Integer.parseInt(aa[0])+i;
			list.add(newString+","+(newString+1));
		}
	}
}
