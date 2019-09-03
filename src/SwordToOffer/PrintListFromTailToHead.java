package SwordToOffer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 黄子玉 从尾到头打印链表
 * 问题描述：输出一个链表，按链表值从尾到头的顺序返回一个ArrrayList
 * 解题思路：1.用栈来实现
 *          2.利用三个指针把链表反转，关键是r指针保存断开的节点。
 */
public class PrintListFromTailToHead {
	//方法1：用栈来实现
	public void printListFromTailToHead1(ListNode listNode){
		Stack<ListNode> stackNodes=new Stack<ListNode> ();
		ListNode node=listNode;
		//单链表元素依次入栈
		while(node!=null){
			stackNodes.push(node);
			node=node.next;
		}
		//栈中的单链表元素依次出栈
		while(stackNodes.size()>0){
			ListNode top=stackNodes.pop();
			System.out.println(top.val);
		}
	}
	//方法2：利用三个指针把链表反转。(破坏了原有的链表结构)
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		if(listNode==null){
			return new ArrayList<Integer>();
		}
		ListNode head=listNode;
		ListNode cur=listNode.next;
		while(cur!=null){
			ListNode tmp=cur.next;
			cur.next=head;
			head=cur;
			cur=tmp;
		}
		//此时listNode的next还指向第二个node，所以要让listNode.next=null,防止循环。非常重要
		//用三个指针反转链表时，注意将第一个节点的指针指向null。
		listNode.next = null;
	/*	如果用这种方式就不用将第一个指针指向null了。
		ListNode pre=null;
		ListNode next=null;
		while(listNode!=null){
			next=listNode.next;
			listNode.next=pre;
			pre=listNode;
			listNode=next;
		}*/
		
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(head !=null){
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
	//方法3：递归和栈是相同的思想，利用递归的方式实现从尾到头打印
	public void printListFromTailToHead2(ListNode listNode){
		if(listNode!=null){
			if(listNode.next!=null){
				ListNode nextListNode=listNode.next;
				printListFromTailToHead2(nextListNode);
			}
			System.out.println(listNode.val);
		}else{
			return;
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
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		PrintListFromTailToHead a=new PrintListFromTailToHead();
		a.printListFromTailToHead2(node1);
		a.printListFromTailToHead1(node1);
		System.out.println(a.printListFromTailToHead(node1).toString());
		
	}
}

