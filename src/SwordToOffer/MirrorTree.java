package SwordToOffer;

/**
 * @author 黄子玉 二叉树的镜像
 * 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 镜像定义：
 *      8           
 *     /  \
 *    6   10
 *   / \  / \
 *  5  7 9  11
 *      8
 *     /  \
 *    10   6
 *   / \  / \
 *  11  9 7  5
 *  
 * 解题思路：通过对以上两棵树的观察，我们可以总结出这两棵树根节点相同，但它们的两个
 * 左、右两个子节点交换了位置。所以我们可以得出求一棵树的镜像过程：先前序遍历这棵树
 * 的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。当交换完所有非叶节点
 * 的左、右子节点后，就得到了树的镜像。 
 */
public class MirrorTree {
	public void mirror(TreeNode root){
		//当前节点为空，直接返回
		if(root==null){
			return;
		}
		//当前节点没有叶子节点，直接返回
		if(root.left==null&&root.right==null){
			return;
		}
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		//递归交换子节点
		if(root.left!=null){
			mirror(root.left);
		}
		if(root.right!=null){
			mirror(root.right);
		}
	}
	//测试函数
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(8);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(10);
		TreeNode node4=new TreeNode(5);
		TreeNode node5=new TreeNode(7);
		TreeNode node6=new TreeNode(9);
		TreeNode node7=new TreeNode(11);
	    node1.left=node2;
	    node1.right=node3;
	    node2.left=node4;
	    node2.right=node5;
	    node3.left=node6;
	    node3.right=node7;
	    MirrorTree a=new MirrorTree();
	    a.mirror(node1);
	    VariousTraversalOfBinaryTrees b=new VariousTraversalOfBinaryTrees();
	    b.levelOrderTraversal(node1);
	}
}
