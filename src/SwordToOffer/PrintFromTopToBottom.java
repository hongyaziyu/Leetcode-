package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ������ �������´�ӡ������
 * ��Ŀ�������������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * ����˼·�����Ƕ������Ĳ������������һ�����оͿ���ʵ�֡�
 * ʹ����������һ����Žڵ㣬һ�����ֵ���Ƚ����ڵ���뵽�����У�Ȼ����������е�
 * Ԫ�أ����������У����ʸ�Ԫ�ص����ҽڵ㣬�ٽ������ӽڵ���뵽����������
 * ע��Queue�����ķ�ʽ��
 * Queue<TreeNode> queue = new LinkedList<TreeNode>();
 * ��add��Ԫ����ӵ������У���remove���Ƴ������ض���Ԫ�ء�
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> printFromTopToBottom(TreeNode root){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(root==null){
			return res;
		}
		//Queue�ǳ���ģ�������new Queue<TreeNode>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(queue.size()!=0){
			root=queue.remove();
			res.add(root.val);
			if(root.left!=null){
				queue.add(root.left);
			}
			if(root.right!=null){
				queue.add(root.right);
			}
		}
		return res;
	}
	//���Ժ���(��һ����ǲ������)
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
	    node1.left=node2;
	    node1.right=node3;
	    node2.left=node4;
	    node2.right=node5;
	    node3.left=node6;
	    node3.right=node7;
	    
	    PrintFromTopToBottom a=new PrintFromTopToBottom();
	    System.out.println(a.printFromTopToBottom(node1).toString());
	}
}
