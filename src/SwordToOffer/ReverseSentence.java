package SwordToOffer;
/**
 * @author ������ ��ת����˳����
 * ��Ŀ��������ת���ӡ�
 * ����˼·���ܼ򵥵��⣬ûɶ��˵�ģ�ע��һ�²�������ȫ�ǿո�������
 * trim():ȥ���ַ�����β�Ŀո�
 * split():���ַ������������������зָ
 */
public class ReverseSentence {
	public String reverseSentence(String str){
		if(str.trim().length()==0){
			return str;
		}
		String[] temp=str.split(" ");
		String res="";
		for(int i=temp.length-1;i>=0;i++){
			res+=temp[i];
			if(i!=0){
				res+=" ";
			}
		}
		return res;
	}
}
