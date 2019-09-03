package SwordToOffer;

/**
 * @author 黄子玉 合并两个链表
 * 题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，我们需要合成后的
 * 链表满足单调不减的规则。
 * 解题思路：递归和非递归。
 *
 */
public class MergeListNode {
	 public ListNode Merge(ListNode list1,ListNode list2) {
	        if(list1 == null)
	            return list2;
	        else if(list2 == null)
	            return list1;
	        ListNode mergehead = null;
	        if(list1.val <= list2.val){
	            mergehead = list1;
	            mergehead.next = Merge(list1.next,list2);
	        }else{
	            mergehead = list2;
	            mergehead.next = Merge(list1, list2.next);
	        }
	        return mergehead;
	    }
	//非递归解法
	    public ListNode Merge1(ListNode list1,ListNode list2) {
	        if(list1 == null)
	            return list2;
	        else if(list2 == null)
	            return list1;
	        ListNode mergehead = null;
	        if(list1.val <= list2.val){
	            mergehead = list1;
	            list1 = list1.next;
	        }else{
	            mergehead = list2;
	            list2 = list2.next;
	        }
	        ListNode cur = mergehead;
	        while(list1 != null && list2 != null){
	            if(list1.val <= list2.val){
	                cur.next = list1;
	                list1 = list1.next;
	            }else{
	                cur.next = list2;
	                list2 = list2.next;
	            }
	            cur = cur.next;
	        }
	        if(list1 == null)
	            cur.next = list2;
	        else if(list2 == null)
	            cur.next = list1;
	        return mergehead;
	    }
	    //测试函数
	    public static void main(String[] args) {
	    	MergeListNode a=new MergeListNode();
	    	ListNode node1=new ListNode(1);
			ListNode node2=new ListNode(2);
			ListNode node3=new ListNode(3);
			ListNode node4=new ListNode(4);
			ListNode node5=new ListNode(5);
			ListNode node6=new ListNode(6);
			ListNode node7=new ListNode(7);
			ListNode node8=new ListNode(8);
			
			node1.next=node3;
			node3.next=node5;
			node5.next=node7;
			node2.next=node4;
			node4.next=node6;
			node6.next=node8;
			
		/*	ListNode head=a.Merge(node1, node2);
			while(head!=null){
				System.out.println(head.val);
				head=head.next;
			}*/
			
		/*	ListNode head1=a.Merge1(node1, node2);
			while(head1!=null){
				System.out.println(head1.val);
				head1=head1.next;
			}*/
			
			ListNode head2=a.Merge(null, node2);
			while(head2!=null){
				System.out.println(head2.val);
				head2=head2.next;
			}
			
		}
}
