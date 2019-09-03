package SwordToOffer;

import java.util.ArrayList;

/**
 * @author ������ ���������ڵ����͹�������
 * 
 */
public class TheLowestCommonAncestorOfTheTwoNodesInTheTree {
	//�������1�������Ƕ�����������������������һ������Ķ��������������Ľڵ�С�ڸ��ڵ㣬�������Ľڵ���ڸ��ڵ㣩
	//�Ӹ��ڵ㿪ʼ����������������ڵ��ֵ�����ڵ�ǰ�ڵ㣬����͵ĸ��ڵ�һ�����������У���������ڵ��ֵ��С��
	//��ǰ�ڵ�����͸��ڵ�һ�����������У������ǰ�ڵ�ֵ����һ���ڵ�С��һ���ڵ��˵������ڵ������͸��ڵ㡣
	public static TreeNode theLowestCommonAncestorOfTheTwoNodesInTheTree(TreeNode pRoot,
			TreeNode pLeft,TreeNode pRight){
		
		TreeNode treeNode=null;
		if(pRoot==null||pLeft.val>pRight.val){
			return null;
		}//��������������������ô�ͷ��ؿ�ֵ
		if(pRoot.val >= pRight.val){
			treeNode = theLowestCommonAncestorOfTheTwoNodesInTheTree(pRoot.left, pLeft, pRight);
		}//���ڵ�����ҽڵ㣬��ô�����������������
		if(pRoot.val <= pLeft.val){
			treeNode = theLowestCommonAncestorOfTheTwoNodesInTheTree(pRoot.right, pLeft, pRight);
		}//���ڵ�С����ڵ㣬��ô�����������������
		if(pRoot.val >= pLeft.val && pRoot.val <= pRight.val){
			return pRoot;
		}//������Ⱦ��Ǹ��ڵ�
		return treeNode;//û�������ĵ�Ͳ����ڷ��ؿ�ֵ
	}
	//�������2����������ͨ�Ķ��������ݹ�����ҵ��������������ڵ㣬Ȼ�����ϱ�ǣ�ֱ����һ���ڵ�����ӽڵ�����ӽڵ�
	//����Ϊ�գ����ؼ��ɡ�
	public static TreeNode theLowestCommonAncestorOfTheTwoNodesInTheTree1(TreeNode pRoot,
			TreeNode pLeft,TreeNode pRight){
		if(pRoot==null||pRoot==pLeft||pRoot==pRight){
			return pRoot;
		}//����Ŀ��ڵ���ͨ������ֵ��Ǹ���������ĳ��Ŀ��ڵ�
		//�鿴���������Ƿ���Ŀ��ڵ㣬û����Ϊnull
		TreeNode left=theLowestCommonAncestorOfTheTwoNodesInTheTree1(pRoot.left,pLeft,pRight);
		//�鿴�������Ƿ���Ŀ��ڵ㣬û��Ϊnull
		TreeNode right=theLowestCommonAncestorOfTheTwoNodesInTheTree1(pRoot.right,pLeft,pRight);
		//����Ϊ�գ�˵����������Ŀ��ڵ㣬�򹫹����Ⱦ��Ǳ���
		if(left!=null&&right!=null){
			return pRoot;
		}
		//���������Ŀ��ڵ㣬��������ϱ��Ϊ��Ŀ��ڵ�
		return left==null?right:right;
	}
	//�������3����������ͨ����������ÿ���ӽڵ㶼��ָ�򸸽ڵ��ָ�룬�����Ļ������������ҹ����ڵ�һ������
	//FindFirstCommonNode.java
	//�������4���������һ����ͨ�������ӽڵ�û��ָ�򸸽ڵ��ָ�롣
	public static TreeNode theLowestCommonAncestorOfTheTwoNodesInTheTree2(TreeNode pRoot,
			TreeNode pLeft,TreeNode pRight){
		//����pLeft��·��
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		//����pRight��·��
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> tmpList = new ArrayList<TreeNode>();
		getNodePath(pRoot, pLeft, tmpList, path1);
		getNodePath(pRoot, pRight, tmpList, path2);
		//���·�������ڣ����ؿ�
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
			//ѭ������ʱtmpNode��Ϊ���һ����ͬ���
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
		tmpList.remove(tmpList.size()-1);//��ռ���
	}
	//���Ժ���
	public static void main(String[] args) {
		//����������
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
		
		//��ͨ������
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
