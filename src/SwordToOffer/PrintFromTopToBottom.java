package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 黄子玉 从上往下打印二叉树
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解题思路：就是二叉树的层序遍历。借助一个队列就可以实现。
 * 使用两个队列一个存放节点，一个存放值。先将根节点加入到队列中，然后遍历队列中的
 * 元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来。
 * 注意Queue创建的方式：
 * Queue<TreeNode> queue = new LinkedList<TreeNode>();
 * 用add将元素添加到队列中，用remove来移除并返回队首元素。
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> printFromTopToBottom(TreeNode root){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(root==null){
			return res;
		}
		//Queue是抽象的，不能用new Queue<TreeNode>();
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
	//测试函数(这一题就是层序遍历)
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
