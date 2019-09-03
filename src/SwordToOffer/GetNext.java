package SwordToOffer;
/**
 * @author 黄子玉 二叉树的下一个节点
 * 题目描述：
 *给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *解题思路：
 *中序遍历：左 -> 根 -> 右
分三种情况：

如果当前节点为空，直接返回空；
如果当前节点有右子树，则返回右子树的最左子树；
如果当前节点没有右子树，再分两种情况：
看看当前节点是不是它的父节点的左子树，如果是，则返回它的父节点；
如果当前节点不是它的父节点的左子树，则把父节点赋给当前节点，
再判断当前节点是不是它的父节点的左子树，直到当前节点是不是它的父节点的左子树，
返回它的父节点。
 */
public class GetNext {
	public TreeLinkNode getNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        while(pNode.next != null){
            TreeLinkNode root = pNode.next;
            if(pNode == root.left)
                return root;
            pNode = root;
        }
        return null;
    }
	//测试函数
	public static void main(String[] args) {
		TreeLinkNode node1=new TreeLinkNode(1);
		TreeLinkNode node2=new TreeLinkNode(2);
		TreeLinkNode node3=new TreeLinkNode(3);
		TreeLinkNode node4=new TreeLinkNode(4);
		TreeLinkNode node5=new TreeLinkNode(5);
		TreeLinkNode node6=new TreeLinkNode(6);
		TreeLinkNode node7=new TreeLinkNode(7);
		TreeLinkNode node8=new TreeLinkNode(8);
		TreeLinkNode node9=new TreeLinkNode(9);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		node5.left=node8;
		node5.right=node9;
		node2.next=node1;
		node3.next=node1;
		node4.next=node2;
		node5.next=node2;
		node6.next=node3;
		node7.next=node3;
		node8.next=node5;
		node9.next=node5;
		GetNext a=new GetNext();
		System.out.println(a.getNext(node5).val);
		
	}
}
