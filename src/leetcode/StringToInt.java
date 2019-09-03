package leetcode;

/**
 * @author ������ ���ַ���ת��Ϊ����
 *
 */
public class StringToInt {
	public int stringToInt(String str){
		if(str==null||str.length()==0){//ע��str.length()==0��ʾ����Ϊ0���ַ�����str==null��ʾ����Ϊnull���ַ�����
			return 0;
		}
		long longRes=0;
		str=str.trim();//ȥ���ַ���ǰ��ո�
		boolean neg=false;//��־λ������Ϊtrue��
		if(str.charAt(0)=='-'){//�жϵ�һλ�ǲ��Ǳ�ʾ�����š�
			neg=true;
			str=str.substring(1, str.length());
		}else if(str.charAt(0)=='+'){
			str=str.substring(1, str.length());
		}
		//������ʽֵ
		int i=0;
		while(i<str.length()){
			char c=str.charAt(i);
			if(c>='0'&&c<='9'){
				longRes=longRes*10+(c-'0');
			}else {//����Ƿ������ַ����޷�����ת��������0.
				break;
			}
			i++;
		}
		longRes=neg?longRes*(-1):longRes;
		if(longRes>Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(longRes<Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int)longRes;
	}
}
