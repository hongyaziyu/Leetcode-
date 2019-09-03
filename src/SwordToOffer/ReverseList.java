package SwordToOffer;

/**
 * @author ������ ��ת����
 * ��������������һ��������ת��������������ı�ͷ��
 * ����˼·����������ָ�룬headΪ��ǰ�ڵ㣬preΪ��ǰ�ڵ��ǰһ���ڵ㣬nextΪ
 * ��ǰ�ڵ����һ���ڵ㣬��Ҫpre��next��Ŀ�����õ�ǰ�ڵ��
 * pre->head->next1->next2���pre<-head , next1->next2�Ĺ����У���pre
 * �ýڵ㷴ת��ָ����next�ڵ㱣��next1�ڵ��ֹ����Ͽ�
 * ��Ҫע��ĵ㣺
 * 1.���ͷ�����null���򷵻�null��
 * 2.������ѵĿ��ǡ�
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
	//���Ժ���
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		ReverseList a=new ReverseList();
		ListNode head=a.reverseList(node1);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
