package SwordToOffer;

/**
 * @author 黄子玉 二叉搜索树和双向链表
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能
 * 创建任何新的节点。只能调整树中节点指针的指向。
 * 解题思路：
 *题目比较难理解，我们可以举个例子：
 *    10
 *    / \
 *   6  14     转换成    4<->6<->8<->10<->12<->14<->16
 *  / \ / \    
 * 4  8 12 16
 * 在二叉树的搜索树中，左子节点的值总是小于父节点的值，右子节点的值总是大于父节点
 * 的值。因此我们在转换成排序双向链表时，原先指向左子节点的指针调整为链表中指向
 * 前一个节点的指针，原先指向右子节点的指针调整为链表中指向后一个节点的指针。
 * 因为中序遍历是按照从小到大的顺序遍历二叉搜索树，所以我们用中序遍历树中的每一个
 * 节点得到的正好是要求的排好序的。遍历过程如下：
 * 每次遍历节点的左孩子、右孩子，把左孩子指向转换链表的尾节点，
 * 并把末尾指针的右孩子指向自己。右孩子指向节点的右孩子。如果没有右孩子就返回。
 * 这一过程可以用递归实现。
 */
public class BinaryTreeAndLinkedList {
	TreeNode head=null;//head标记链表的头节点
	TreeNode end=null;//end标记链表的尾结点
	public TreeNode convert(TreeNode pRootOfTree){
		convertSub(pRootOfTree);
		return head;
	}
	public void convertSub(TreeNode pRootOfTree) {
		//相当于中序遍历
		if(pRootOfTree==null){
			return;
		}
		convert(pRootOfTree.left);
		if(end==null){
			head=pRootOfTree;
			end=pRootOfTree;
		}else{
			end.right=pRootOfTree;//原先指向右子节点的指针调整为链表中指向后一个节点的指针。
			pRootOfTree.left=end;//原先指向左子节点的指针调整为链表中指向前一个节点的指针。
			end=pRootOfTree;//end指针指向下一个节点。
		}
		convert(pRootOfTree.right);
	}
	//测试函数
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(14);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(8);
		TreeNode node6=new TreeNode(12);
		TreeNode node7=new TreeNode(16);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		
		BinaryTreeAndLinkedList a=new BinaryTreeAndLinkedList();
		TreeNode head=a.convert(node1);
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.right;
		}
		System.out.println();
	}
}
