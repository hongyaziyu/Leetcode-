package SwordToOffer;

/**
 * @author ������ ��ֵ�������η�
 * ��Ŀ����������һ��double���͵ĸ�����base��int���͵�����exponent����base
 * ��exponent�η���
 * ����˼·��
 * 1. ָ��Ϊ��ʱ�������ȶ�ָ�������ֵ������η��Ľ������ȡ����
 * 2. ������Ϊ0��ָ��Ϊ��ʱ�����ֶ�0���������Ҫ���⴦��
 * 3. 0��0�η�����ѧ��û�����壬�������0����1���ǿ��Խ��ܵġ�
 * 4. �ڼ���η���ʱ�򣬳��˼򵥵ı��������ǿ���ʹ�õݹ�˼�롣
 */
public class PowerUnsignedExponent {
	public double power(double base,int exponent){
		int n=exponent;
		if(exponent==0){
			//��ָ��Ϊ0����Ϊ0ʱ��û�����壬����0���߷���1������
			return 1;
		}else if(exponent<0){
			if(base==0){
				throw new RuntimeException("��ĸ����Ϊ0");
				}
			n=-exponent;
		}
		double res=powerUnsignedExponent(base,n);
		return exponent<0? 1/res:res;
	}

	private double powerUnsignedExponent(double base, int n) {
		if(n==0){
			return 1;
		}
		if(n==1){
			return base;
		}
		//�ݹ�
		double res=powerUnsignedExponent(base,n/2);
		res*=res;
		if(n%2==1){
			res*=base;
		}
		return res;
	}
}
