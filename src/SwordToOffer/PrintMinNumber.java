package SwordToOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ������ �������ų���С����
 * ��Ŀ����������һ�����������飬�����������е������ų�һ��������ӡ����ƴ�ӳ���С
 * ��һ��������������{2,32,243}����С������224332
 * ����˼·���ֽ�����ת�����ַ������飬Ȼ����ַ������鰴�չ�����������ź���
 * ���ַ�������ƴ�ӳ�����
 * �ؼ������ƶ��������
 * 	��ab>ba ��a>b
 *  ��ab < ba �� a < b
 *  ��ab = ba �� a = b
 * ����˵����
   a = 21
   b = 2
     ��Ϊ 212 < 221, �� ab < ba ������ a < b
     ��������ͨ����ab��ba�Ƚϴ�С�����ж�a��ǰ����b��ǰ�ġ�
 */
public class PrintMinNumber {
	public String printMinNumber(int[] nums){
		int len=nums.length;
		if(len==0){
			return "";
		}
		if(len==1){
			return String.valueOf(nums[0]);
		}
		StringBuffer res=new StringBuffer();
		String[] str=new String[len];
		for(int i=0;i<len;i++){
			str[i]=String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>(){
			public int compare(String s1,String s2){
				String c1=s1+s2;
			    String c2=s2+s1;
			    return c1.compareTo(c2);
		    }
		});//�����õ���Arrays.sort(String[] a, Comparator<? super String> c)
		   //���ַ�����a���ַ������飬��������Զ�����������
		for(int i=0;i<len;i++){
			res.append(str[i]);
		}
		return res.toString();
	}
}
