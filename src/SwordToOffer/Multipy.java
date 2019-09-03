package SwordToOffer;

/**
 * @author ������ �����˻�����
 * ��Ŀ����������һ������A[0,1,2,...,N-1]���빹��һ������B[0,1,2,...,N-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 * ����˼·��B[i]��ֵ���Կ���ͼ�о����i������Ԫ�صĳ˻���
 * B0     1  A1  A2  ...  A(n-2)  A(n-1)
 * B1     A0  1  A2  ...  A(n-2)  A(n-1)
 * B2     A0  A1  1  ...  A(n-2)  A(n-1)
 * ...    A0  A1  ...  1  A(n-2)  A(n-1)
 * B(n-1) A0  A1  ...     A(n-2)  1
 * ���ǿ��������������е����ˣ������������B[i]�е�һ���֣�Ȼ�󵹹����������Ƿֲ�
 * ���ɣ�������һ����Ҳ�˽�ȥ��
 */
public class Multipy {
	public int[] multiply(int[] A){
		if(A.length<=1){
			return A;
		}
		int[] B=new int[A.length];
		B[0]=1;
		for(int i=1;i<A.length;i++){
			B[i]=B[i-1]*A[i-1];
		}
		int temp=1;
		for(int j=A.length-2;j>=0;j--){
			temp*=A[j+1];
			B[j]*=temp;
		}
		return B;
	}
}
