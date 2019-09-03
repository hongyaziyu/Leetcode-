package SwordToOffer;
/**
 * @author ������ ����������һ���ڵ�
 * ��Ŀ������
 *����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 *ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 *����˼·��
 *����������� -> �� -> ��
�����������

�����ǰ�ڵ�Ϊ�գ�ֱ�ӷ��ؿգ�
�����ǰ�ڵ������������򷵻�������������������
�����ǰ�ڵ�û�����������ٷ����������
������ǰ�ڵ��ǲ������ĸ��ڵ��������������ǣ��򷵻����ĸ��ڵ㣻
�����ǰ�ڵ㲻�����ĸ��ڵ������������Ѹ��ڵ㸳����ǰ�ڵ㣬
���жϵ�ǰ�ڵ��ǲ������ĸ��ڵ����������ֱ����ǰ�ڵ��ǲ������ĸ��ڵ����������
�������ĸ��ڵ㡣
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
	//���Ժ���
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
