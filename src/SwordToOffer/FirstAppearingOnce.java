package SwordToOffer;

import java.util.HashMap;

/**
 * @author ������ �ַ����е�һ�����ظ����ַ�
 * ��Ŀ������
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ���go��ʱ����һ��ֻ����һ�ε��ַ��ǡ�g����
 * ���Ӹ��ַ����ж���ǰ�����ַ���google��ʱ����һ��ֻ����һ�ε��ַ��ǡ�l����
 * ����˼·����һ����ϣ�����洢ÿ���ַ�������ֵĴ�����
 * ������һ���ַ��� s �������ַ������ַ���˳��
 * ÿ�β����ʱ�����ַ��� s �в�����ַ���Ȼ���ڹ�ϣ���в鿴�Ƿ���ڸ��ַ���
 * ������������� value ��1����������ڣ����ڹ�ϣ���в�����ַ������� value Ϊ 1��
���ҵ�һ��ֻ����һ�ε��ַ�ʱ������ s ��˳�����β��� map ���ַ����ֵĴ�����
�� value Ϊ 1 ʱ�����ַ����ǵ�һ��ֻ����һ�ε��ַ���
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
