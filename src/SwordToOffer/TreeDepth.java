package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 黄子玉 二叉树的深度
 * 题目描述：输入一棵二叉树，求该树的深度。从根节点到叶节点依次经过节点形成树的
 * 一条路径，最长路径的长度为树的深度。
 * 解题思路：
 * 方法1：递归法，求二叉树的深度就是求左子树、右子树中深度最大的加上一个根节点，
 * 依次递归即可。
 * 方法2：层次遍历。没遍历一层，deep加1，直接到最后一层输出deep。
 */
public class TreeDepth {
	//方法1：递归法。
	public int treeDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=treeDepth(root.left)+1;
		int right=treeDepth(root.right)+1;
		return left>right?left:right;
	}
	//方法2：层次遍历
	public int treeDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int start = 0, end = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            start ++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(start == end){
                end = queue.size();
                start = 0;
                deep ++;
            }
        }
        return deep;
    }
}
