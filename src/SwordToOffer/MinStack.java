package SwordToOffer;

import java.util.Stack;

/**
 * @author 黄子玉 包含min函数的栈
 * 题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小的min函数。
 * 
 * 解题思路：用一个栈stack保存数据，用另外一个栈temp保存依次入栈最小的数
 * 比如，stack中依次入栈
 * 5,3,4,10,2,12,1,8
 * 则temp一次入栈
 * 5,3,3,3,2,2,1,1
 * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或者等于则入栈，否则用最小
 * 元素入栈。
 */
public class MinStack {
	Stack<Integer> stack=new Stack<Integer> ();
	Stack<Integer> temp=new Stack<Integer> ();
	int min=Integer.MAX_VALUE;
	public void push(int node){
		stack.push(node);
		if(node<min){
			temp.push(node);
			min=node;
		}
		else{
			temp.push(min);
		}
	}
	
	public void pop(){
		stack.pop();
		temp.pop();
	}
	
	public int top(){
		int t=stack.pop();
		stack.push(t);
		return t;
	}
	
	public int min(){
		int m=temp.pop();
		temp.push(m);
		return m;
	}
}
