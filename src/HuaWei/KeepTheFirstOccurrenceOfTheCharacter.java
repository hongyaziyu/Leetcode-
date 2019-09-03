package HuaWei;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 黄子玉
 * 题目描述：将重复的字符去除，仅保留第一次出现的字符，保持去重后的字符在原字符串中顺序不变。
 * 输入：12ere12
 * 输出：12er
 */
public class KeepTheFirstOccurrenceOfTheCharacter {
	public String keepTheFirstOccurrenceOfTheCharacter(String s){
		StringBuffer result=new StringBuffer("");
		Set<Character> set=new HashSet<>();
		for(int i=0;i<s.length();i++){
			if(!set.contains(s.charAt(i))){
				result.append(s.charAt(i));
				set.add(s.charAt(i));
			}
		}
		return result.toString();
	}
	//测试函数
	public static void main(String[] args) {
		KeepTheFirstOccurrenceOfTheCharacter a=new KeepTheFirstOccurrenceOfTheCharacter();
		String s="12ere2";
		System.out.println(a.keepTheFirstOccurrenceOfTheCharacter(s));
	}
}
