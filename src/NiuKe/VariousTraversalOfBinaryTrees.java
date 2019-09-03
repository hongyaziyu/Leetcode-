package NiuKe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 黄子玉 二叉树的各种遍历情况
 *	介绍二叉树的前序遍历、中序遍历、后序遍历以及层序遍历的情况。
 *	分为递归和非递归排序。
 */
public class VariousTraversalOfBinaryTrees {
	//前序遍历递归版本
	public void preOrderTraversal(TreeNode root){
		if(root!=null){
			System.out.print(root.val+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	//前序遍历非递归版本(递归能做的栈肯定也能做)
	/*分析：1.首先申请一个栈。
	 * 2.将头节点压入栈中。
	 * 3.每次从stack中弹出栈顶节点，记为cur，然后打印cur值，如果cur右孩子不为空不为空则将右孩子压入栈中。
	 * 如果cur左孩子不为空则将其压入栈中。
	 * 4.重复步骤3直到整个栈为空。
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
	//中序遍历的递归版本
	public void inOrderTraversal(TreeNode root){
		if(root!=null){
			inOrderTraversal(root.left);
			System.out.print(root.val+" ");
			inOrderTraversal(root.right);
		}
	}
	//中序遍历的非递归版本(同样用栈来实现)
	/*分析：1.申请一个新栈stack，申请一个变量cur，初始时cur为头节点；
	 * 2.先把cur节点压入栈中，以cur为节点的整颗子树来说，依次把整颗树的左子树压入栈中，令cur=cur.left。
	 * 3.不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点记为node，打印node的值，
	 * 并让cur = node.right，然后继续重复步骤2；
     * 4.当stack为空并且cur为空时结束。
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
	//后序遍历的递归版本
	public void postOrderTraversal(TreeNode root){
		if(root!=null){
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.val+" ");
		}
	}
	//后序遍历非递归版本(利用两个栈来实现)
	/*使用两个栈实现

	1.申请两个栈stack1，stack2，然后将头结点压入stack1中；
	2.从stack1中弹出的节点记为cur，然后先把cur的左孩子压入stack1中，再把cur的右孩子压入stack1中；
	3.在整个过程中，每一个从stack1中弹出的节点都放在第二个栈stack2中；
	4.不断重复步骤2和步骤3，直到stack1为空，过程停止；
	5.从stack2中依次弹出节点并打印，打印的顺序就是后序遍历的顺序*/
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
	//后序遍历(用一个栈来实现)
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
	//层序遍历
	public void levelOrderTraversal(TreeNode root){
		if(root==null){
			return;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();//queue只是接口要用linkedlist来实现
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
	//测试函数
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
	    System.out.println("---------------前序遍历------------------");
		a.preOrderTraversal(node1);
		System.out.println();
		System.out.println("---------------前序遍历非递归------------------");
		a.preOrderTraversal1(node1);
		System.out.println();
		System.out.println("---------------中序遍历------------------");
		a.inOrderTraversal(node1);
		System.out.println();
		System.out.println("---------------中序遍历非递归------------------");
		a.inOrderTraversal1(node1);
		System.out.println();
		System.out.println("---------------后序遍历------------------");
		a.postOrderTraversal(node1);
		System.out.println();
		System.out.println("---------------后序遍历非递归------------------");
		a.postOrderTraversal1(node1);
		System.out.println();
		System.out.println("---------------后序遍历非递归------------------");
		a.postOrderTraversal2(node1);
		System.out.println();
		System.out.println("---------------层序遍历------------------");
		a.levelOrderTraversal(node1);
	}
}
