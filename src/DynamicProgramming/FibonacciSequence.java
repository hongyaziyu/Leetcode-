package DynamicProgramming;


/**
 * @author 黄子玉
 * 时间：2019/07/05 10:00
 * 分析：动态规划入门之斐波那契数列。
 * 求解方式：自顶向下的备忘录法和自底向上
 * 条件：Fibonacci(0)=1,Fibonacci(1)=1,Fibonacci(n)=Fibonacci(n-1)+Fibonacci(n-2)
 */
public class FibonacciSequence {
	//方法1：备忘录法
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
	//备忘录
	public static int fib(int n,int[] Memo){
		//如果求出fib(n)的值就直接返回。
		if(Memo[n]!=-1)
			return Memo[n];
		//将求出来的值放在备忘录中。
		if(n<=1)
			Memo[n]=1;
		else Memo[n]=fib(n-1,Memo)+fib(n-2,Memo);
		return Memo[n];
	}
	//方法2：自底向上的动态规划
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
