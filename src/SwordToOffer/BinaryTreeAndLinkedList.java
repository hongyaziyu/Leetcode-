package SwordToOffer;

/**
 * @author ������ ������������˫������
 * ��Ŀ����������һ�ö��������������ö���������ת����һ�������˫������Ҫ����
 * �����κ��µĽڵ㡣ֻ�ܵ������нڵ�ָ���ָ��
 * ����˼·��
 *��Ŀ�Ƚ�����⣬���ǿ��Ծٸ����ӣ�
 *    10
 *    / \
 *   6  14     ת����    4<->6<->8<->10<->12<->14<->16
 *  / \ / \    
 * 4  8 12 16
 * �ڶ��������������У����ӽڵ��ֵ����С�ڸ��ڵ��ֵ�����ӽڵ��ֵ���Ǵ��ڸ��ڵ�
 * ��ֵ�����������ת��������˫������ʱ��ԭ��ָ�����ӽڵ��ָ�����Ϊ������ָ��
 * ǰһ���ڵ��ָ�룬ԭ��ָ�����ӽڵ��ָ�����Ϊ������ָ���һ���ڵ��ָ�롣
 * ��Ϊ��������ǰ��մ�С�����˳�������������������������������������е�ÿһ��
 * �ڵ�õ���������Ҫ����ź���ġ������������£�
 * ÿ�α����ڵ�����ӡ��Һ��ӣ�������ָ��ת�������β�ڵ㣬
 * ����ĩβָ����Һ���ָ���Լ����Һ���ָ��ڵ���Һ��ӡ����û���Һ��Ӿͷ��ء�
 * ��һ���̿����õݹ�ʵ�֡�
 */
public class BinaryTreeAndLinkedList {
	TreeNode head=null;//head��������ͷ�ڵ�
	TreeNode end=null;//end��������β���
	public TreeNode convert(TreeNode pRootOfTree){
		convertSub(pRootOfTree);
		return head;
	}
	public void convertSub(TreeNode pRootOfTree) {
		//�൱���������
		if(pRootOfTree==null){
			return;
		}
		convert(pRootOfTree.left);
		if(end==null){
			head=pRootOfTree;
			end=pRootOfTree;
		}else{
			end.right=pRootOfTree;//ԭ��ָ�����ӽڵ��ָ�����Ϊ������ָ���һ���ڵ��ָ�롣
			pRootOfTree.left=end;//ԭ��ָ�����ӽڵ��ָ�����Ϊ������ָ��ǰһ���ڵ��ָ�롣
			end=pRootOfTree;//endָ��ָ����һ���ڵ㡣
		}
		convert(pRootOfTree.right);
	}
	//���Ժ���
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
