package algorithm;

public class Fibonacci {
	public static int fibonacci(int n){
		if(n<=0)
			return n;
		int[] Memo=new int[n+1];
		for(int i=0;i<=n;i++){
			Memo[i]=-1;
		}
		return fib(n,Memo);
	}

	private static int fib(int n, int[] memo) {
		int[] Memo=new int[n+1];
		if(Memo[n]!=-1)
			return Memo[n];
		if(n<=2)
			Memo[n]=1;
		else Memo[n]=fib(n-1,Memo)+fib(n-2,Memo);
		return Memo[n];
	}
	public static void main(String[] args) {
		System.out.println(Fibonacci.fibonacci(5));
	}

}
