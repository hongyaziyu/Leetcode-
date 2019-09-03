package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 黄子玉 最长的没有重复字母的子串 滑动窗口法
 * 
 */
public class LongestSubstringWithoutRepeatingCharacter {
	//暴力解法，列出所有的情况，逐个判断是否不含有重复的字符。
	public int lengthOfLongestSubstring1(String s){
		int len=s.length();
		int ans=0;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<=len;j++){
				if(allUnique(s,i,j)){
					ans=Math.max(ans, j-i);
				}
			}
		}
		return ans;
	}
	//利用set集合唯一的特点来判断元素有没有重复。
	private boolean allUnique(String s, int start, int end) {
		Set<Character> set=new HashSet<>();
		for(int i=start;i<end;i++){
			Character ch=s.charAt(i);
			if(set.contains(ch)){
				return false;
			}
			set.add(ch);
		}
		return true;
	}
	//滑动窗口法
	public int lengthOfLongestSubstring2(String s){
		int len=s.length();
		Set<Character> set=new HashSet<>();
		int ans=0,i=0,j=0;
		while(i<len&&j<len){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));//先加入j位置的元素，然后再j++。
				ans=Math.max(ans, j-i);
			}else{
				set.remove(s.charAt(i++));//如果元素重复则移除一个元素，并将窗口向前移动一位。
			}
		}
		return ans;
	}
	public int lengthOfLongestSubstring(String s){
		int[] count =new int[256];
		int max=0;
		for(int i=0,j=0;i<s.length();i++){
			char c=s.charAt(i);
			count[c]++;
			for(;j<i&&count[c]>1;j++){
				count[s.charAt(j)]--;
			}
			max=Math.max(max, i-j+1);
		}
		return max;
	}
	//测试函数
	public static void main(String[] args) {
		String s="pwwkew";
		LongestSubstringWithoutRepeatingCharacter a=new LongestSubstringWithoutRepeatingCharacter();
		System.out.println(a.lengthOfLongestSubstring(s));
		System.out.println(a.lengthOfLongestSubstring1(s));
		System.out.println(a.lengthOfLongestSubstring2(s));
	}
}
