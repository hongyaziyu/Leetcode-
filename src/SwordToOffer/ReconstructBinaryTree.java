package SwordToOffer;


/**
 * @author 黄子玉
 * 题目描述：输入某二叉树前序遍历和中序遍历的结果，重建出该二叉树。假设输入的
 * 前序遍历和中序遍历的结果中都不含重复的数字，重建二叉树并返回。
 * 解题思路：我们知道前序遍历的第一个节点就是根节点，我们先根据前序遍历的第一个数字
 * 创建根节点，接下来在中序遍历序列中找到根节点的位置，根节点的左边是左子树，右边是
 * 右子树，这样就能确定左、右子树节点的数量在前序遍历和中序遍历的序列中划分了左、右
 * 子树节点的值以后，就可以递归地去分别构建它的左右子树。
 * 这题用到了递归非常复杂，可以仔细看看。
 */
public class ReconstructBinaryTree {
	public TreeNode reconstructBinaryTree(int[] pre,int[] in){
		if(pre.length==0||in.length==0){
			return null;
		}
		return constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
	}

	private TreeNode constructBinaryTree(int[] pre, int ps, int pe, 
			int[] in, int is, int ie) {
		if(ps>pe||is>ie){
			return null;
		}
		TreeNode root=new TreeNode(pre[ps]);
		for(int i=is;i<=ie;i++){
			if(in[i]==pre[ps]){
				root.left=constructBinaryTree(pre,ps+1,ps+i-is,in,is,i-1);
				root.right=constructBinaryTree(pre,ps+i-is+1,pe,in,i+1,ie);
				break;
			}
		}
		return root;
	}
	//测试函数
	public static void main(String[] args) {
		ReconstructBinaryTree a=new ReconstructBinaryTree();
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		TreeNode root=a.reconstructBinaryTree(preOrder, inOrder);
		VariousTraversalOfBinaryTrees b=new VariousTraversalOfBinaryTrees();
		b.levelOrderTraversal(root);
	}
}
