package SwordToOffer;

/**
 * @author ������ ɾ������ڵ�
 * ��Ŀ��������O(1)ʱ����ɾ������ڵ�
 * �������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ����ɾ���ýڵ㡣
 * ����˼·��һ����������ǻ��뵽��������ڵ��ҵ�Ҫɾ�����Ǹ��ڵ㣬Ȼ����ǰһ���ڵ�ָ���һ���ڵ����ɾ�������Ӷ���
 * O(n)����Ȼ���ܽ�����⣬˼������ΪҪ�ҵ�Ҫɾ���ڵ��ǰһ���ڵ㣬��ʵ����Ҫ�ҵ������ǿ����ҵ���ɾ���ڵ�ĺ�һ���ڵ�
 * Ȼ�󽫺�һ���ڵ�����ݸ��ǵ�Ҫɾ���Ľڵ����ٰ��¸��ڵ�ɾ�������ˡ�
 * ��Ҫע�����㣺1.���Ҫɾ���Ľڵ������һ���ڵ�ʱ�����Ӷ�ֻ����O(n)��
 */
public class DelectListNode {
	public void delectListNode(ListNode head,ListNode delectNode){
		if(head==null||delectNode==null){//�������Ϊ�ջ���ɾ���Ľڵ�Ϊ�գ��򷵻�Ϊ�ա�
			return ;
		}
		if(delectNode.next!=null){
			ListNode postNode=delectNode.next;
			delectNode.val=postNode.val;
			delectNode.next=postNode.next;//���Ǹ���������ɾ��postNode��
		}else{
			ListNode preNode=head;
			while(preNode.next!=null){
				if(preNode.next==delectNode){
					preNode.next=delectNode.next;
				}
			}
		}
		
	}
	//���Ժ���
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		ListNode node7=new ListNode(7);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		DelectListNode a=new DelectListNode();
		a.delectListNode(node1, node5);
		ListNode head=node1;
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
