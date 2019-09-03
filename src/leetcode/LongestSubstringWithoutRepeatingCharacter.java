package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ������ ���û���ظ���ĸ���Ӵ� �������ڷ�
 * 
 */
public class LongestSubstringWithoutRepeatingCharacter {
	//�����ⷨ���г����е����������ж��Ƿ񲻺����ظ����ַ���
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
	//����set����Ψһ���ص����ж�Ԫ����û���ظ���
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
	//�������ڷ�
	public int lengthOfLongestSubstring2(String s){
		int len=s.length();
		Set<Character> set=new HashSet<>();
		int ans=0,i=0,j=0;
		while(i<len&&j<len){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));//�ȼ���jλ�õ�Ԫ�أ�Ȼ����j++��
				ans=Math.max(ans, j-i);
			}else{
				set.remove(s.charAt(i++));//���Ԫ���ظ����Ƴ�һ��Ԫ�أ�����������ǰ�ƶ�һλ��
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
	//���Ժ���
	public static void main(String[] args) {
		String s="pwwkew";
		LongestSubstringWithoutRepeatingCharacter a=new LongestSubstringWithoutRepeatingCharacter();
		System.out.println(a.lengthOfLongestSubstring(s));
		System.out.println(a.lengthOfLongestSubstring1(s));
		System.out.println(a.lengthOfLongestSubstring2(s));
	}
}
