package SwordToOffer;

/**
 * @author ������ ���ַ���ת��������
 * ��Ŀ��������һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�
 * ����string����������Ҫ��ʱ����0)��Ҫ����ʹ���ַ���ת�������Ŀ⺯����
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * ����˼·��
 * ����˼·�����жϵ�һλ�ǲ��Ƿ���λ������з��ţ���flag����ǡ�
 * �����ַ����е�ÿ���ַ���������ڷ����ֵ��ַ���ֱ�ӷ���0�������õ�ǰ�ַ���ȥ��0��
 * �õ���ǰ�����֣��ٽ������㡣
 */
public class StrToInt {
	public int strToInt(String str){
		if(str.length()==0){
			return 0;
		}
		int flag=0;
		if(str.charAt(0)=='+'){
			flag=1;
		}else if(str.charAt(0)=='-'){
			flag=2;
		}
		int start=flag>0?1:0;
		long res=0;
		while(start<str.length()){
			if(str.charAt(start)>'9'||str.charAt(start)<'0'){
				return 0;
			}
			res=res*10+(str.charAt(start)-'0');
			start++;
		}
		return flag==2?-(int)res:(int)res;
	}
}
