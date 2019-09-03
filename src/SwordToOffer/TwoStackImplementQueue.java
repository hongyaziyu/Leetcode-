package SwordToOffer;

import java.util.Stack;

/**
 * @author ������ ����min������ջ
 * ��Ŀ������������ջ��ʵ��һ�����У���ɶ���Push��Pop������������Ԫ��Ϊint�͡�
 * ����˼·��
 * ����ջStack1��Stack2��
 * 		push��������Stack1�н��С�
 * 		pop��������Stack2�н��С���Stack2��Ϊ��ʱ��ֱ��pop����Stack2Ϊ��ʱ��
 * 		�Ȱ�Stack1�е�Ԫ��pop������push��Stack2�У��ٴ�Stack2��popԪ�ء�
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
	//���Ժ���
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
