package SwordToOffer;

/**
 * @author ������ �������ľ���
 * ��Ŀ���������������Ķ�����������任ΪԴ�������ľ���
 * �����壺
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
 * ����˼·��ͨ���������������Ĺ۲죬���ǿ����ܽ�������������ڵ���ͬ�������ǵ�����
 * ���������ӽڵ㽻����λ�á��������ǿ��Եó���һ�����ľ�����̣���ǰ����������
 * ��ÿ���ڵ㣬����������Ľڵ����ӽڵ㣬�ͽ������������ӽڵ㡣�����������з�Ҷ�ڵ�
 * �������ӽڵ�󣬾͵õ������ľ��� 
 */
public class MirrorTree {
	public void mirror(TreeNode root){
		//��ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
		if(root==null){
			return;
		}
		//��ǰ�ڵ�û��Ҷ�ӽڵ㣬ֱ�ӷ���
		if(root.left==null&&root.right==null){
			return;
		}
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		//�ݹ齻���ӽڵ�
		if(root.left!=null){
			mirror(root.left);
		}
		if(root.right!=null){
			mirror(root.right);
		}
	}
	//���Ժ���
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
