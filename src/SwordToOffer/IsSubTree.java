package SwordToOffer;

/**
 * @author ������ �����ӽṹ
 * ��Ŀ�������������Ŷ�����A��B���ж�B�ǲ���A���ӽṹ��
 * ��Լ��������������һ�������ӽṹ��
 * ����˼·��
 * �ݹ�˼�룬������ڵ���ͬ��ݹ����IsSubtree������������ڵ㲻ͬ�����ж�root1
 * ����������root2�Ƿ���ͬ�����ж���������root2�Ƿ���ͬ��
 * ע��ڵ�Ϊ�յ�������HasSubTree�У�ֻҪ����Ϊ�վͷ���false��IsSubtree�У�
 * Ҫ���ж�root2�����root2Ϊ�գ���˵���ڶ������������ˣ���ƥ��ɹ���
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
		//Ҫ���ж�root2, ��Ȼ{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}�����������ͨ������
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
