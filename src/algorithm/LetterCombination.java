package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄子玉
 *时间：2019/07/21 14:00
 *题目描述：给定一个2-9的字符串，返回所有他能表示的字母组合。
 *例如输入：“23”
 *输出：[“ad”，“ae”，“af”，“bd”，“be”，“bf”，“cd”，“ce”，“cf”]
 *明显用到回溯算法，采用深度优先搜索。
 */
public class LetterCombination {
	static String[] a=new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static StringBuffer sb=new StringBuffer();
	
	public static List<String> letterCombinations(String digits){
		if(digits.length()==0){
			return null;
		}
		List<String> answer=new ArrayList<String>();
		
		//开始回溯
		zuhe(digits,0,answer);
		return answer;
	}

	private static void zuhe(String digits, int n, List<String> answer) {
		if(n==digits.length()){
			answer.add(sb.toString());
			return;
		}
		for(int i=0;i<a[digits.charAt(n)-'0'].length();i++){  //charAt(int index)返回索引处的字符。
			sb.append(a[digits.charAt(n)-'0'].charAt(i));
			zuhe(digits,n+1,answer);
			sb.deleteCharAt(sb.length()-1);//StringBuffer.deleteCharAt()方法表示删除索引处的字符之后的所有字符向后退一位填补删除的字符。
		}
		
	}
	
	//测试
	public static void main(String[] args) {
		List<String> x=letterCombinations("23");
		System.out.println(x.toString());
	}
}

