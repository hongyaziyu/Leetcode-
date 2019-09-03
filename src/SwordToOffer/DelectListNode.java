package SwordToOffer;

/**
 * @author 黄子玉 删除链表节点
 * 题目描述：在O(1)时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * 解题思路：一般情况下我们会想到逐个遍历节点找到要删除的那个节点，然后让前一个节点指向后一个节点就能删除。复杂度是
 * O(n)。显然不能解决问题，思考是因为要找到要删除节点的前一个节点，其实不需要找到。我们可以找到被删除节点的后一个节点
 * 然后将后一个节点的内容覆盖到要删除的节点上再把下个节点删除就行了。
 * 需要注意两点：1.如果要删除的节点是最后一个节点时，复杂度只能是O(n)。
 */
public class DelectListNode {
	public void delectListNode(ListNode head,ListNode delectNode){
		if(head==null||delectNode==null){//如果链表为空或者删除的节点为空，则返回为空。
			return ;
		}
		if(delectNode.next!=null){
			ListNode postNode=delectNode.next;
			delectNode.val=postNode.val;
			delectNode.next=postNode.next;//从那个单链表中删除postNode。
		}else{
			ListNode preNode=head;
			while(preNode.next!=null){
				if(preNode.next==delectNode){
					preNode.next=delectNode.next;
				}
			}
		}
		
	}
	//测试函数
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
