package SwordToOffer;

/**
 * @author ������ �����������ĵ�k���ڵ�
 * ��Ŀ����������һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
 * ���磬 ��5��3��7��2��4��6��8���У��������ֵ��С˳�����С����ֵΪ4��
 *����˼·��
 *��Ϊ�����������������������˳���ӡ���������ź���ģ�
 *���ԣ����ǰ�����������ҵ���k����������Ŀ����Ľ�㡣
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
		
		KthNode a=new KthNode();
		System.out.println(a.kthNode(node1, 1).val);
	}
}
