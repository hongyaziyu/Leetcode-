package SwordToOffer;

import java.util.HashMap;

/**
 * @author ������ ��һ��ֻ����һ�ε��ַ�
 * ��Ŀ��������һ���ַ�����0<=�ַ�������<=10000,ȫ������ĸ��ɣ����ҵ���һ��ֻ
 * ����һ�ε��ַ�������������λ�ã����û���򷵻�-1
 * ����˼·������hash����ͳ�Ƹ���ĸ���ִ������ڶ���ɨ��ֱ�ӷ���hash���ô�����
 * Ҳ�������������hash��
 */
public class FirstNotRepeatingChar {
	public int firstNotRepeatingChar(String str){
		int len=str.length();
		if(len==0){
			return -1;
		}
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<len;i++){
			if(map.containsKey(str.charAt(i))){
				int value=map.get(str.charAt(i));
				map.put(str.charAt(i), value+1);
			}else{
				map.put(str.charAt(i), 1);
			}
		}
		for(int i=0;i<len;i++){
			if(map.get(str.charAt(i))==1){
				return i;
			}
		}
		return -1;
	}
}
