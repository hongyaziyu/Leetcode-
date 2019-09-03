package SwordToOffer;

/**
 * @author ������ ɾ���������ظ��ڵ�
 * ��Ŀ��������һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬
 * �ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ
 *  1->2->5
 *  ����˼·��
 *  �������һ��ͷ�ڵ㣬�Է���������һ�����ڶ����ڵ����ͬ�����
���� first ��second ָ�룬 first ָ��ָ��ǰȷ�����ظ����Ǹ��ڵ㣬
��secondָ���൱�ڹ���ָ�룬һֱ������������
 */
public class DeleteDuplication {
	 public ListNode deleteDuplication(ListNode pHead)
	    {
	        if(pHead == null || pHead.next == null)
	            return pHead;
	        ListNode head = new ListNode(-1);
	        head.next = pHead;
	        ListNode first = head;
	        ListNode second = first.next;
	        while(second != null){
	            if(second.next != null && second.val == second.next.val){
	                while(second.next != null && second.val == second.next.val){
	                    second = second.next;
	                }
	                first.next = second.next;//�൱��ɾ�������ظ��Ľڵ㡣
	            }else{
	                first = first.next;
	            }
	            second = second.next;
	        }
	        return head.next;
	    }
	 //���Ժ���
	 public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(3);
		ListNode node5=new ListNode(4);
		ListNode node6=new ListNode(4);
		ListNode node7=new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		DeleteDuplication a=new DeleteDuplication();
		ListNode head=a.deleteDuplication(node1);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
