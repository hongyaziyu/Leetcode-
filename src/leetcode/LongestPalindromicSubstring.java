package leetcode;

import java.util.Scanner;

/**
 * @author 黄子玉 最长回文子串
 *
 */
public class LongestPalindromicSubstring {
	//中心扩展法：回文中心两侧互为镜像。并且有2n-1个中心。注意字母数为偶数的回文中心处于两字母中间。
	public String longestPalindromicSubstring(String s){
		if(s==null||s.length()<1){
			return "";
		}
		int start=0,end=0;
		for(int i=0;i<s.length();i++){
			int len1=expandAroundCenter(s,i,i);
			int len2=expandAroundCenter(s,i,i+1);
			int len=Math.max(len1, len2);
			if(len>end-start){
				start=i-(len-1)/2;
				end=i+len/2;
			}
		}
		return s.substring(start, end+1);//注意substring是从start开始(包括start)，结束于end+1(不包括end+1)。
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L=left,R=right;
		while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
			L--;
			R++;
		}
		return R-L-1;
	}
	//暴力解法 算法复杂度O(n^3)
	public boolean isPalindromic(String s){
		int len=s.length();
		for(int i=0;i<len/2;i++){
			if(s.charAt(i)!=s.charAt(len-i-1)){
				return false;
			}
		}
		return true;
	}
	public String longestPalindromicSubstring1(String s){
		String ans="";
		int max=0;
		int len=s.length();
		for(int i=0;i<len;i++){
			for(int j=i+1;j<=len;j++){
				String test=s.substring(i, j);
				if(isPalindromic(test)&&test.length()>max){
					ans=s.substring(i, j);
					max=Math.max(max, ans.length());
				}
			}
		}
		return ans;
	}
	//动态规划的方法
	public String longestPalindromicSubstring2(String s){
		int len=s.length();
		int maxLen=0;
		String longestString="";
		boolean[][] P=new boolean[len][len];
		for(int length=1;length<=len;length++){
			for(int start=0;start<len;start++){
				int end=start+len-1;
				if(end>=length){
					break;
				}
				P[start][end]=(length==1||length==2||P[start+1][end-1])&&s.charAt(start)==s.charAt(end);
				if(P[start][end]&&length>maxLen){
					longestString=s.substring(start, end+1);
				}
			}
		}
		return longestString;
	}
	//测试函数
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		LongestPalindromicSubstring a=new LongestPalindromicSubstring();
		System.out.println(a.longestPalindromicSubstring(s));
		System.out.println(a.longestPalindromicSubstring1(s));
		System.out.println(a.longestPalindromicSubstring2(s));
		sc.close();
	}
}
