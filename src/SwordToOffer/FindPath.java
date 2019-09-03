package SwordToOffer;

import java.util.ArrayList;

/**
 * @author 黄子玉 二叉树中和为某一值的路径
 * 题目描述：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有
 * 路径。路径定义为从根节点开始往下一直到叶节点所经过形成的一条路径。
 * 解题思路：用前序遍历的方式访问到某一节点时，把该节点添加到路径上，并用目标值
 * 减去该节点值。如果该节点为叶节点并且目标值减去该节点的值刚好为0，则当前路径
 * 符合要求，我们把它加入res数组中。如果当前节点不是叶节点，则继续访问它的子节点。
 * 当前节点访问结束后，递归函数将自动回到它的父节点。因此我们在函数退出之前要在
 * 路径上删除当前节点，以确保返回父节点时路径刚好是从根节点到父节点的路径。
 */
public class FindPath {
	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> temp=new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
		if(root==null){
			return res;
		}
		target-=root.val;
		temp.add(root.val);
		if(target==0&&root.left==null&&root.right==null){
			res.add(new ArrayList<Integer>(temp));
		}else{
			findPath(root.left,target);
			findPath(root.right,target);
		}
		temp.remove(temp.size()-1);
		return res;
	}
	//测试函数
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(5);
		TreeNode node3=new TreeNode(12);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(7);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		FindPath a=new FindPath();
		ArrayList<ArrayList<Integer>> path=a.findPath(node1, 22);
		System.out.println(path.toString());
	}
}
