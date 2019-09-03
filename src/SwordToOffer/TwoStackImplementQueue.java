package SwordToOffer;

import java.util.Stack;

/**
 * @author 黄子玉 包含min函数的栈
 * 题目描述：用两个栈来实现一个队列，完成队列Push和Pop操作。队列中元素为int型。
 * 解题思路：
 * 两个栈Stack1和Stack2：
 * 		push动作都在Stack1中进行。
 * 		pop动作都在Stack2中进行。当Stack2不为空时，直接pop；当Stack2为空时，
 * 		先把Stack1中的元素pop出来，push到Stack2中，再从Stack2中pop元素。
 */
public class TwoStackImplementQueue {
	Stack<Integer> stack1=new Stack<Integer> ();
	Stack<Integer> stack2=new Stack<Integer> ();
	
	public void push(int node){
		stack1.push(node);
	}
	
	public int pop(){
		if(stack1.isEmpty()&&stack2.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		int node;
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				node=stack1.pop();
				stack2.push(node);
			}
		}
		return stack2.pop();
	}
	//测试函数
	public static void main(String[] args) {
		TwoStackImplementQueue a=new TwoStackImplementQueue();
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		a.push(node1.val);
		a.push(node2.val);
		a.push(node3.val);
		a.push(node4.val);
		a.push(node5.val);
		a.push(node6.val);
		a.push(node7.val);
		System.out.println(a.pop());
	}
}
