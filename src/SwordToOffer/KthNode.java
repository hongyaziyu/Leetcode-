package SwordToOffer;

/**
 * @author 黄子玉 二叉搜索树的第k个节点
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *解题思路：
 *因为二叉搜索树按照中序遍历的顺序打印出来就是排好序的，
 *所以，我们按照中序遍历找到第k个结点就是题目所求的结点。
 */
public class KthNode {
	int index = 0;
    TreeNode kthNode(TreeNode pRoot, int k)
    {
        if(pRoot != null){
            TreeNode node = kthNode(pRoot.left, k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = kthNode(pRoot.right, k);
            if(node != null)
                return node;
        }
        return null;
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
		
		KthNode a=new KthNode();
		System.out.println(a.kthNode(node1, 1).val);
	}
}
