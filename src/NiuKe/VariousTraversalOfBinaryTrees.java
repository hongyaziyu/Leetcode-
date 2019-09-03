package NiuKe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ������ �������ĸ��ֱ������
 *	���ܶ�������ǰ������������������������Լ���������������
 *	��Ϊ�ݹ�ͷǵݹ�����
 */
public class VariousTraversalOfBinaryTrees {
	//ǰ������ݹ�汾
	public void preOrderTraversal(TreeNode root){
		if(root!=null){
			System.out.print(root.val+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	//ǰ������ǵݹ�汾(�ݹ�������ջ�϶�Ҳ����)
	/*������1.��������һ��ջ��
	 * 2.��ͷ�ڵ�ѹ��ջ�С�
	 * 3.ÿ�δ�stack�е���ջ���ڵ㣬��Ϊcur��Ȼ���ӡcurֵ�����cur�Һ��Ӳ�Ϊ�ղ�Ϊ�����Һ���ѹ��ջ�С�
	 * ���cur���Ӳ�Ϊ������ѹ��ջ�С�
	 * 4.�ظ�����3ֱ������ջΪ�ա�
    */
	public void preOrderTraversal1(TreeNode root){
		if(root==null){
			return ;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode cur=stack.pop();
			System.out.print(cur.val+" ");
			if(cur.right!=null){
				stack.push(cur.right);
			}
			if(cur.left!=null){
				stack.push(cur.left);
			}
		}
	}
	//��������ĵݹ�汾
	public void inOrderTraversal(TreeNode root){
		if(root!=null){
			inOrderTraversal(root.left);
			System.out.print(root.val+" ");
			inOrderTraversal(root.right);
		}
	}
	//��������ķǵݹ�汾(ͬ����ջ��ʵ��)
	/*������1.����һ����ջstack������һ������cur����ʼʱcurΪͷ�ڵ㣻
	 * 2.�Ȱ�cur�ڵ�ѹ��ջ�У���curΪ�ڵ������������˵�����ΰ���������������ѹ��ջ�У���cur=cur.left��
	 * 3.�����ظ�����2��ֱ������curΪ�գ���ʱ��stack�е���һ���ڵ��Ϊnode����ӡnode��ֵ��
	 * ����cur = node.right��Ȼ������ظ�����2��
     * 4.��stackΪ�ղ���curΪ��ʱ������
    */
	public void inOrderTraversal1(TreeNode root){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode cur=root;
		while(!stack.empty()||cur!=null){
			while(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
			TreeNode node=stack.pop();
			System.out.print(node.val+" ");
			cur=node.right;
		}
		
	}
	//��������ĵݹ�汾
	public void postOrderTraversal(TreeNode root){
		if(root!=null){
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.val+" ");
		}
	}
	//��������ǵݹ�汾(��������ջ��ʵ��)
	/*ʹ������ջʵ��

	1.��������ջstack1��stack2��Ȼ��ͷ���ѹ��stack1�У�
	2.��stack1�е����Ľڵ��Ϊcur��Ȼ���Ȱ�cur������ѹ��stack1�У��ٰ�cur���Һ���ѹ��stack1�У�
	3.�����������У�ÿһ����stack1�е����Ľڵ㶼���ڵڶ���ջstack2�У�
	4.�����ظ�����2�Ͳ���3��ֱ��stack1Ϊ�գ�����ֹͣ��
	5.��stack2�����ε����ڵ㲢��ӡ����ӡ��˳����Ǻ��������˳��*/
	public void postOrderTraversal1(TreeNode root){
		if (root == null)
	    {
	        return;
	    }

	    Stack<TreeNode> stack1 = new Stack<TreeNode>();
	    Stack<TreeNode> stack2 = new Stack<TreeNode>();

	    stack1.push(root);
	    TreeNode cur = root;

	    while (!(stack1.empty()))
	    {
	        cur = stack1.pop();
	        if (cur.left != null)
	        {
	            stack1.push(cur.left);
	        }
	        if (cur.right != null)
	        {
	            stack1.push(cur.right);
	        }
	        stack2.push(cur);
	    }

	    while (!(stack2.empty()))
	    {
	        TreeNode node = stack2.pop();
	        System.out.print(node.val+" ");
	    }
	}
	//�������(��һ��ջ��ʵ��)
	public void postOrderTraversal2(TreeNode root){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		TreeNode h=root;
		TreeNode c=null;
		while(!stack.empty()){
			c=stack.peek();
			if(c.left!=null&&h!=c.left&&h!=c.right){
				stack.push(c.left);
			}else if(c.right!=null&&h!=c.right){
				stack.push(c.right);
			}else{
				TreeNode node=stack.pop();
				System.out.print(node.val+" ");
				h=c;
			}
		}
	}
	//�������
	public void levelOrderTraversal(TreeNode root){
		if(root==null){
			return;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();//queueֻ�ǽӿ�Ҫ��linkedlist��ʵ��
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			System.out.print(node.val+" ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
		
	}
	//���Ժ���
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
		node3.right=node7;
		node3.left=node6;

		
		VariousTraversalOfBinaryTrees a=new VariousTraversalOfBinaryTrees();
	    System.out.println("---------------ǰ�����------------------");
		a.preOrderTraversal(node1);
		System.out.println();
		System.out.println("---------------ǰ������ǵݹ�------------------");
		a.preOrderTraversal1(node1);
		System.out.println();
		System.out.println("---------------�������------------------");
		a.inOrderTraversal(node1);
		System.out.println();
		System.out.println("---------------��������ǵݹ�------------------");
		a.inOrderTraversal1(node1);
		System.out.println();
		System.out.println("---------------�������------------------");
		a.postOrderTraversal(node1);
		System.out.println();
		System.out.println("---------------��������ǵݹ�------------------");
		a.postOrderTraversal1(node1);
		System.out.println();
		System.out.println("---------------��������ǵݹ�------------------");
		a.postOrderTraversal2(node1);
		System.out.println();
		System.out.println("---------------�������------------------");
		a.levelOrderTraversal(node1);
	}
}
