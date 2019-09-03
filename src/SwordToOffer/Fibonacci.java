package SwordToOffer;

/**
 * @author ������
 * ��Ŀ��������Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲���������
 * ��n���0��ʼ����0��Ϊ0����n<=39
 * ����˼·��
 * ��ʽ��
 * f(n)=n,n<=1
 * f(n)=f(n-1)+f(n-2),n>1
 * ����ֱ��ʹ�õݹ�ķ�����
 * if(n<=1) return n;
 * else return Fibonacci(n-1)+Fibonacci(n-2);
 */
public class Fibonacci {
	public int fibonacci(int n){
		if(n==0||n==1){
			return n;
		}
		int fn1=0;
		int fn2=1;
		for(int i=2;i<=n;i++){
			fn2+=fn1;
			fn1=fn2-fn1;
		}
		return fn2;
	}
}
