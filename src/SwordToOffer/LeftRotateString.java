package SwordToOffer;

/**
 * @author ������ ����ת�ַ���
 * ��Ŀ���������硰abcXYZdef����ѭ��������λΪ��XYZdefabc��
 * ����˼·���򵥵��⣬��n���ַ�������һ����Ϊ�������֡�������ƴ���������ɡ�
 */
public class LeftRotateString {
	public String leftRotateString(String str,int n){
		int len=str.length();
		if(len==0){
			return "";
		}
		n=n%len;
		String s1=str.substring(n, len);
		String s2=str.substring(0,n);
		return s1+s2;
	}
}
