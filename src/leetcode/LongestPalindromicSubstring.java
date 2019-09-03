package leetcode;

import java.util.Scanner;

/**
 * @author ������ ������Ӵ�
 *
 */
public class LongestPalindromicSubstring {
	//������չ���������������໥Ϊ���񡣲�����2n-1�����ġ�ע����ĸ��Ϊż���Ļ������Ĵ�������ĸ�м䡣
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
		return s.substring(start, end+1);//ע��substring�Ǵ�start��ʼ(����start)��������end+1(������end+1)��
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L=left,R=right;
		while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
			L--;
			R++;
		}
		return R-L-1;
	}
	//�����ⷨ �㷨���Ӷ�O(n^3)
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
	//��̬�滮�ķ���
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
	//���Ժ���
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
