package SwordToOffer;

import java.util.HashMap;

/**
 * @author 黄子玉 字符流中第一个不重复的字符
 * 题目描述：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是”g”。
 * 当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是”l”。
 * 解题思路：用一个哈希表来存储每个字符及其出现的次数，
 * 另外用一个字符串 s 来保存字符流中字符的顺序。
 * 每次插入的时候，在字符串 s 中插入该字符，然后在哈希表中查看是否存在该字符，
 * 如果存在则它的 value 加1，如果不存在，它在哈希表中插入该字符，它的 value 为 1。
查找第一个只出现一次的字符时，按照 s 的顺序，依次查找 map 中字符出现的次数，
当 value 为 1 时，该字符就是第一个只出现一次的字符。
 */
public class FirstAppearingOnce {
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    StringBuffer s = new StringBuffer();
	    //Insert one char from stringstream
	    public void Insert(char ch)
	    {
	        s.append(ch);
	        if(map.containsKey(ch)){
	            map.put(ch, map.get(ch)+1);
	        }else{
	            map.put(ch, 1);
	        }
	    }
	  //return the first appearence once char in current stringstream
	    public char firstAppearingOnce()
	    {
	        for(int i = 0; i < s.length(); i++){
	            if(map.get(s.charAt(i)) == 1)
	                return s.charAt(i);
	        }
	        return '#';
	    }
}
