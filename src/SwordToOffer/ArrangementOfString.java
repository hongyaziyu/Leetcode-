package SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ������ �ַ���������
 * ��Ŀ����������һ���ַ��������ֵ����ӡ�����ַ������ַ����������С���������
 * �ַ���abc�����ӡ����a,b,c�������г����������ַ�����
 * abc,acb,bac,bca,cab��cba��
 * ��������������һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 * ����˼·���Ѹ��ӵ�����ֳɼ���С�����������
 * ��һ������ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ��ͺ������е��ַ���������ͬ
 * �ַ���������
 * �ڶ����̶���һ���ַ�������������ַ������С���ʱ����԰Ѻ���������ַ����
 * �������֣���һ���ַ��ͺ������е��ַ������Դ����ơ��õݹ�ķ��������
 */
public class ArrangementOfString {
	ArrayList<String> res=new ArrayList<String>();
	public ArrayList<String> arrangementOfString(String str){
		if(str==null){
			return res;
		}
		permutationHelper(str.toCharArray(),0);
		Collections.sort(res);
		return res;
	}
	public void permutationHelper(char[] str, int i) {
		if(i==str.length-1){
			res.add(String.valueOf(str));
		}else{
			for(int j=i;j<str.length;j++){
				if(j!=i&&str[i]==str[j]){
					continue;
				}
				swap(str,i,j);
				permutationHelper(str,i+1);
				swap(str,i,j);
			}
		}
		
	}
	public void swap(char[] str, int i, int j) {
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
}
