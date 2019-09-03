package SwordToOffer;

import java.util.Stack;

/**
 * @author 黄子玉 对称的二叉树
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 解题思路：
 *法一：递归。根节点的左右子树相同，左子树的左子树和右子树的右子树相同，
 *左子树的右子树和右子树的左子树相同即可。
 *法二：非递归。非递归也是一样，采用栈或队列存取各级子树根节点。
 */
public class IsSymmetrical {
	//方法1：递归
	 boolean isSymmetrical(TreeNode pRoot)
	    {
	        if(pRoot == null)
	            return true;
	        return isSymmetrical(pRoot.left, pRoot.right);
	    }
	    boolean isSymmetrical(TreeNode left, TreeNode right){
	        if(left == null && right == null)
	            return true;
	        if(left == null || right == null)
	            return false;
	        if(left.val == right.val){
	            return isSymmetrical(left.left, right.right) && 
	                isSymmetrical(left.right, right.left);
	        }
	        return false;
	    }
	   //方法2：非递归
	    boolean isSymmetrical1(TreeNode pRoot)
	    {
	        if(pRoot == null)
	            return true;
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        s.push(pRoot.left);
	        s.push(pRoot.right);
	        while(!s.isEmpty()){
	            TreeNode right = s.pop();
	            TreeNode left = s.pop();
	            if(right == null && left == null)
	                continue;
	            if(right == null || left == null)
	                return false;
	            if(right.val != left.val)
	                return false;
	            s.push(left.left);
	            s.push(right.right);
	            s.push(left.right);
	            s.push(right.left);
	        }
	        return true;
	    }
}
