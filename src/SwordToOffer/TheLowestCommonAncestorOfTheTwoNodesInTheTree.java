package SwordToOffer;

import java.util.ArrayList;

/**
 * @author 黄子玉 树中两个节点的最低公共祖先
 * 
 */
public class TheLowestCommonAncestorOfTheTwoNodesInTheTree {
	//解决方法1：假设是二叉搜索树（二叉搜索树是一个排序的二叉树，左子树的节点小于根节点，右子树的节点大于根节点）
	//从根节点开始遍历树，如果两个节点的值都大于当前节点，则最低的父节点一定在右子树中，如果两个节点的值都小于
	//当前节点那最低父节点一定在左子树中，如果当前节点值大于一个节点小于一个节点就说明这个节点就是最低父节点。
	public static TreeNode theLowestCommonAncestorOfTheTwoNodesInTheTree(TreeNode pRoot,
			TreeNode pLeft,TreeNode pRight){
		
		TreeNode treeNode=null;
		if(pRoot==null||pLeft.val>pRight.val){
			return null;
		}//如果不满足二叉搜索树那么就返回空值
		if(pRoot.val >= pRight.val){
			treeNode = theLowestCommonAncestorOfTheTwoNodesInTheTree(pRoot.left, pLeft, pRight);
		}//根节点大于右节点，那么最低祖先在左子树上
		if(pRoot.val <= pLeft.val){
			treeNode = theLowestCommonAncestorOfTheTwoNodesInTheTree(pRoot.right, pLeft, pRight);
		}//根节点小于左节点，那么最低祖先在右子树上
		if(pRoot.val >= pLeft.val && pRoot.val <= pRight.val){
			return pRoot;
		}//最低祖先就是根节点
		return treeNode;//没有这样的点就不存在返回空值
	}
	//解决方法2：假设是普通的二叉树。递归遍历找到所给定的两个节点，然后向上标记，直到有一个节点的左子节点和右子节点
	//都不为空，返回即可。
	public static TreeNode theLowestCommonAncestorOfTheTwoNodesInTheTree1(TreeNode pRoot,
			TreeNode pLeft,TreeNode pRight){
		if(pRoot==null||pRoot==pLeft||pRoot==pRight){
			return pRoot;
		}//发现目标节点则通过返回值标记该子树发现某个目标节点
		//查看左子树中是否有目标节点，没有则为null
		TreeNode left=theLowestCommonAncestorOfTheTwoNodesInTheTree1(pRoot.left,pLeft,pRight);
		//查看右子树是否有目标节点，没有为null
		TreeNode right=theLowestCommonAncestorOfTheTwoNodesInTheTree1(pRoot.right,pLeft,pRight);
		//都不为空，说明右子树有目标节点，则公共祖先就是本身
		if(left!=null&&right!=null){
			return pRoot;
		}
		//如果发现了目标节点，则继续向上标记为该目标节点
		return left==null?right:right;
	}
	//解决方法3：假设是普通的树，但是每个子节点都有指向父节点的指针，这样的话类似于链表找公共节点一样。见
	//FindFirstCommonNode.java
	//解决方法4：假设就是一棵普通的树，子节点没有指向父节点的指针。
	public static TreeNode theLowestCommonAncestorOfTheTwoNodesInTheTree2(TreeNode pRoot,
			TreeNode pLeft,TreeNode pRight){
		//保存pLeft的路径
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		//保存pRight的路径
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> tmpList = new ArrayList<TreeNode>();
		getNodePath(pRoot, pLeft, tmpList, path1);
		getNodePath(pRoot, pRight, tmpList, path2);
		//如果路径不存在，返回空
		if(path1.size() == 0 || path2.size() == 0){
			return null;
		}
		return getLastCommonParent(path1, path2);
		
	}
	private static TreeNode getLastCommonParent(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {
		TreeNode tmpNode=null;
		for(int i=0;i<path1.size();i++){
			if(path1.get(i)!=path2.get(i)){
				break;
			}
			//循环结束时tmpNode即为最后一个共同结点
			tmpNode=path1.get(i);
		}
		return tmpNode;
	}
	private static void getNodePath(TreeNode pRoot, TreeNode pNode, ArrayList<TreeNode> tmpList,
			ArrayList<TreeNode> path) {
		if(pRoot==pNode||pRoot==null){
			return;
		}
		tmpList.add(pRoot);
		ArrayList<TreeNode> childs=new ArrayList<TreeNode>();
		childs.add(pRoot.left);
		childs.add(pRoot.right);
		for(TreeNode node:childs){
			if(node==pNode){
				path.addAll(tmpList);
				break;
			}
			getNodePath(node,pNode,tmpList,path);
		}
		tmpList.remove(tmpList.size()-1);//清空集合
	}
	//测试函数
	public static void main(String[] args) {
		//二叉搜索树
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		node4.left=node2;
		node4.right=node6;
		node2.left=node1;
		node2.right=node3;
		node6.left=node5;
		node6.right=node7;
		System.out.println(theLowestCommonAncestorOfTheTwoNodesInTheTree(node4, node1, node5).val);
		System.out.println(theLowestCommonAncestorOfTheTwoNodesInTheTree(node4, node1, node5).val);
		
		//普通二叉树
		TreeNode node8=new TreeNode(8);
		TreeNode node9=new TreeNode(9);
		TreeNode node10=new TreeNode(10);
		TreeNode node11=new TreeNode(11);
		TreeNode node12=new TreeNode(12);
		TreeNode node13=new TreeNode(13);
		TreeNode node14=new TreeNode(14);
		node8.left=node9;
		node8.right=node10;
		node9.left=node11;
		node9.right=node12;
		node10.left=node13;
		node10.right=node14;
		System.out.println(theLowestCommonAncestorOfTheTwoNodesInTheTree1(node8, node13, node14).val);
		
	}
}
