package HuaWei;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ������
 * ��Ŀ���������ظ����ַ�ȥ������������һ�γ��ֵ��ַ�������ȥ�غ���ַ���ԭ�ַ�����˳�򲻱䡣
 * ���룺12ere12
 * �����12er
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
	//���Ժ���
	public static void main(String[] args) {
		KeepTheFirstOccurrenceOfTheCharacter a=new KeepTheFirstOccurrenceOfTheCharacter();
		String s="12ere2";
		System.out.println(a.keepTheFirstOccurrenceOfTheCharacter(s));
	}
}
