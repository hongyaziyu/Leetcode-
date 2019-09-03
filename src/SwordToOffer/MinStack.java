package SwordToOffer;

import java.util.Stack;

/**
 * @author ������ ����min������ջ
 * ��Ŀ����������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��С��min������
 * 
 * ����˼·����һ��ջstack�������ݣ�������һ��ջtemp����������ջ��С����
 * ���磬stack��������ջ
 * 5,3,4,10,2,12,1,8
 * ��tempһ����ջ
 * 5,3,3,3,2,2,1,1
 * ÿ����ջ��ʱ�������ջ��Ԫ�ر�min�е�ջ��Ԫ��С���ߵ�������ջ����������С
 * Ԫ����ջ��
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
