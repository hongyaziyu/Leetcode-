package SwordToOffer;

/**
 * @author ������
 * ʱ�䣺2019/07/27 17:47
 * ���⣺����we are happy.���ַ����滻Ϊ��we%20are%20happy.��
 * ������������ô�ǰ���������ո�ͼ�%20����ô������O��n�����ո�ÿ�滻һ���ո������ַ���Ҫ�����Ų����λ��
 * ��ʱ�临�Ӷ�ΪO��n^2�����϶�������õķ���������˼·���Ӻ���ǰ���������ˣ�ֻ��ҪŲ��һ�Ρ�
 */
public class ReplaceSpace {
	//�����µ��ַ��������µ��ַ����Ͻ����滻�����ǿ����Լ������㹻����ڴ档
	public String replaceSpace(StringBuffer str){
		StringBuffer res=new StringBuffer();
		int len=str.length()-1;
		for(int i=len;i>=0;i--){
			if(str.charAt(i)==' '){
				res.append("02%");
			}else{
				res.append(str.charAt(i));
			}
		}
		return res.reverse().toString();
	}
	//ֻ������ԭ���ַ����Ͻ����滻����֤������ַ����������㹻����ڴ档
	public String replaceSpace1(StringBuffer str){
		int orignalLength=str.length();
		int numberOfBlank=0;
		for(int i=0;i<orignalLength;i++){
			if(str.charAt(i)==' '){
				numberOfBlank++;
			}
		}
		int newLength=orignalLength+numberOfBlank*2;
		int indexOfOriginal=orignalLength-1;
		int indexOfNew=newLength-1;
		str.setLength(newLength);//��stringbuffer�������ݣ�����newlength�Ĵ�С��
		while(indexOfOriginal>=0&&indexOfNew>indexOfOriginal){
			if(str.charAt(indexOfOriginal)==' '){
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			}else{
				str.setCharAt(indexOfNew--,str.charAt(indexOfOriginal) );
			}
			--indexOfOriginal;
		}
		return str.toString();
	}
	//���Է���
	public static void main(String[] args) {
		String str1="We Are Happy.";
		StringBuffer str=new StringBuffer(str1);
		ReplaceSpace a=new ReplaceSpace();
		System.out.println(a.replaceSpace(str));
		System.out.println(a.replaceSpace1(str));
	}
}
