package DynamicProgramming;


/**
 * @author ������
 * ʱ�䣺2019/07/05 10:00
 * ��������̬�滮����֮쳲��������С�
 * ��ⷽʽ���Զ����µı���¼�����Ե�����
 * ������Fibonacci(0)=1,Fibonacci(1)=1,Fibonacci(n)=Fibonacci(n-1)+Fibonacci(n-2)
 */
public class FibonacciSequence {
	//����1������¼��
	public static int Fibonacci1(int n) {
		if(n<0){
			return 0;
		}
		int[] Memo=new int[n+1];
		for(int i=0;i<=n;i++){
			Memo[i]=-1;
		}
		return fib(n,Memo);
		
	}
	//����¼
	public static int fib(int n,int[] Memo){
		//������fib(n)��ֵ��ֱ�ӷ��ء�
		if(Memo[n]!=-1)
			return Memo[n];
		//���������ֵ���ڱ���¼�С�
		if(n<=1)
			Memo[n]=1;
		else Memo[n]=fib(n-1,Memo)+fib(n-2,Memo);
		return Memo[n];
	}
	//����2���Ե����ϵĶ�̬�滮
	public static int Fibonacci2(int n)
	{
	        if(n<0)
	            return 0;
	        int []Memo=new int[n+1];
	        Memo[0]=0;
	        Memo[1]=1;
	        for(int i=2;i<=n;i++)
	        {
	            Memo[i]=Memo[i-1]+Memo[i-2];
	        }       
	        return Memo[n];
	}
	public static void main(String[] args) {
		int n=2;
		System.out.println(FibonacciSequence.Fibonacci2(n));
	}
}
