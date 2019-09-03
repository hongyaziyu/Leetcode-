package SwordToOffer;

/**
 * @author 黄子玉 反转链表
 * 问题描述：输入一个链表，反转链表后，输出新链表的表头。
 * 解题思路：设置三个指针，head为当前节点，pre为当前节点的前一个节点，next为
 * 当前节点的下一个节点，需要pre和next的目的是让当前节点从
 * pre->head->next1->next2变成pre<-head , next1->next2的过程中，用pre
 * 让节点反转所指方向，next节点保存next1节点防止链表断开
 * 需要注意的点：
 * 1.如果头结点是null，则返回null。
 * 2.链表断裂的考虑。
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
	//测试函数
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
