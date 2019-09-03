package SwordToOffer;

/**
 * @author 黄子玉 构建乘积数组
 * 题目描述：给定一个数组A[0,1,2,...,N-1]，请构建一个数组B[0,1,2,...,N-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 解题思路：B[i]的值可以看做图中矩阵第i行所有元素的乘积。
 * B0     1  A1  A2  ...  A(n-2)  A(n-1)
 * B1     A0  1  A2  ...  A(n-2)  A(n-1)
 * B2     A0  A1  1  ...  A(n-2)  A(n-1)
 * ...    A0  A1  ...  1  A(n-2)  A(n-1)
 * B(n-1) A0  A1  ...     A(n-2)  1
 * 我们可以先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角分布
 * 规律，把另外一部分也乘进去。
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
