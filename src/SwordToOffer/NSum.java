package SwordToOffer;

/**
 * @author ������ ��1+2+3+...+n
 * ��Ŀ��������1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch
 * ��case�ȹؼ��ּ������ж���䣨A��B:C��
 *����˼·��
 *�ۼӲ�����ѭ���Ǿ����Եݹ顣
 *�жϵݹ���ֹ����������if��switch���Ǿ��ö�·����档
 *(n>0)&&(sum+=sum(n-1))>0
 */
public class NSum {
	public int sum(int n){
		int sum=n;
		boolean t=(n>0)&&(sum+=sum(n-1))>0;
		return sum;
	}
}
