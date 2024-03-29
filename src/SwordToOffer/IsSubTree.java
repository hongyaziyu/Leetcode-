package SwordToOffer;

/**
 * @author 黄子玉 树的子结构
 * 题目描述：输入两颗二叉树A，B，判断B是不是A的子结构。
 * （约定空树不是任意一个树的子结构）
 * 解题思路：
 * 递归思想，如果根节点相同则递归调用IsSubtree（），如果根节点不同，则判断root1
 * 的左子树和root2是否相同，再判断右子树和root2是否相同。
 * 注意节点为空的条件，HasSubTree中，只要有树为空就返回false；IsSubtree中，
 * 要先判断root2，如果root2为空，则说明第二棵树遍历完了，即匹配成功。
 *
 */
public class IsSubTree {
	public boolean hasSubTree(TreeNode root1,TreeNode root2){
		if(root1==null||root2==null){
			return false;
		}
		return isSubtree(root1,root2)||
				hasSubTree(root1.left,root2)||
				hasSubTree(root1.right,root2);
	}

	private boolean isSubtree(TreeNode root1, TreeNode root2) {
		//要先判断root2, 不然{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}这个测试用例通不过。
		if(root2==null){
			return true;
		}
		if(root1==null){
			return false;
		}
		if(root1.val==root2.val){
			return isSubtree(root1.left,root2.left)&&
					isSubtree(root1.right,root2.right);
		}else{
		return false;
		}
	}
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(8);
		TreeNode node2=new TreeNode(8);
		TreeNode node3=new TreeNode(7);
		TreeNode node4=new TreeNode(9);
		TreeNode node5=new TreeNode(2);
		TreeNode node6=new TreeNode(4);
		TreeNode node7=new TreeNode(7);
		TreeNode node8=new TreeNode(8);
		TreeNode node9=new TreeNode(9);
		TreeNode node10=new TreeNode(2);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node5.left=node6;
		node5.right=node7;
		node8.left=node9;
		node8.right=node10;
		IsSubTree a=new IsSubTree();
		System.out.println(a.hasSubTree(node1, node8));
		
	}
}
