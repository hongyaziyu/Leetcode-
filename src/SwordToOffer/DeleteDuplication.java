package SwordToOffer;

/**
 * @author 黄子玉 删除链表中重复节点
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为
 *  1->2->5
 *  解题思路：
 *  首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
设置 first ，second 指针， first 指针指向当前确定不重复的那个节点，
而second指针相当于工作指针，一直往后面搜索。
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
	                first.next = second.next;//相当于删除所有重复的节点。
	            }else{
	                first = first.next;
	            }
	            second = second.next;
	        }
	        return head.next;
	    }
	 //测试函数
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
