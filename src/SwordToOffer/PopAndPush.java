package SwordToOffer;

import java.util.Stack;

/**
 * @author 黄子玉 栈的压入、弹出序列
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否
 * 为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的
 * 压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就
 * 不可能是该压栈序列的弹出序列。
 * 解题思路：模拟堆操作的过程，将原数列依次压栈，把栈顶元素与所给出的栈队列相比，
 * 如果相同则出栈，如果不同则继续压栈，直到原数列中所有数字压栈完毕。最后，检测栈
 * 是否为空，若空则说明是对的，否则是错的。
 */
public class PopAndPush {
	public boolean isPopOrder(int[] pushA,int[] popA){
		if(pushA.length!=popA.length||
				pushA.length==0||
				popA.length==0){
			return false;
		}
		Stack<Integer> stack=new Stack<Integer>();
		int index=0;
		for(int i=0;i<pushA.length;i++){
			stack.push(pushA[i]);
			while(!stack.empty()&&stack.peek()==popA[index]){
				stack.pop();
				index++;
			}
		}
		return stack.empty();
	}
	//测试函数
	public static void main(String[] args) {
		int[] push={1,2,3,4,5};
		int[] pop1={4,5,3,2,1};
		int[] pop2={4,3,5,1,2};
		PopAndPush a=new PopAndPush();
		System.out.println(a.isPopOrder(push, pop1));
		System.out.println(a.isPopOrder(push, pop2));
	}
}
