package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 *ʱ�䣺2019/07/21 14:00
 *��Ŀ����������һ��2-9���ַ����������������ܱ�ʾ����ĸ��ϡ�
 *�������룺��23��
 *�����[��ad������ae������af������bd������be������bf������cd������ce������cf��]
 *�����õ������㷨�������������������
 */
public class LetterCombination {
	static String[] a=new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static StringBuffer sb=new StringBuffer();
	
	public static List<String> letterCombinations(String digits){
		if(digits.length()==0){
			return null;
		}
		List<String> answer=new ArrayList<String>();
		
		//��ʼ����
		zuhe(digits,0,answer);
		return answer;
	}

	private static void zuhe(String digits, int n, List<String> answer) {
		if(n==digits.length()){
			answer.add(sb.toString());
			return;
		}
		for(int i=0;i<a[digits.charAt(n)-'0'].length();i++){  //charAt(int index)�������������ַ���
			sb.append(a[digits.charAt(n)-'0'].charAt(i));
			zuhe(digits,n+1,answer);
			sb.deleteCharAt(sb.length()-1);//StringBuffer.deleteCharAt()������ʾɾ�����������ַ�֮��������ַ������һλ�ɾ�����ַ���
		}
		
	}
	
	//����
	public static void main(String[] args) {
		List<String> x=letterCombinations("23");
		System.out.println(x.toString());
	}
}

