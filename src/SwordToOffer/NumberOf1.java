package SwordToOffer;

/**
 * @author 黄子玉
 * 题目描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码来表示。
 * 解题思路：如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，
 * 那么原来处在整数最右边的1就会变为0，原来在1后面的所有0会变成1（如果最右边的1
 * 还有0），其余位不受影响。
 * 
 */
public class NumberOf1 {
	public int numberOf1(int n){
		int count=0;
		while(n!=0){
			count+=1;
			n&=(n-1);
		}
		return count;
	}
}
