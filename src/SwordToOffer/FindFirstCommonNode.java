package SwordToOffer;

import java.util.Stack;

/**
 * @author 黄子玉 两个链表的第一个公共节点
 * 题目描述：输入两个链表，找出它们的第一个公共节点
 * 解题思路：如果两个链表存在公共节点，那么它们从公共节点开始一直到链表的结尾都是
 * 一样的。因此我们只需要从链表的结尾开始，往前搜索，找到最后一个相同的节点即可。
 * 但是题目给的是单向链表，我们只能从前往后搜索，这是我们就可以借助栈来完成。先把
 * 两个链表依次装入到两个栈中，然后比较两个栈的栈顶节点是否相同，如果相同则出栈，
 * 如果不同那就是相同的节点返回值就行了。
 * 第二种思路：上一种思路之所以用到栈是因为我们想同时遍历到达两个栈的尾结点。当链
 * 表长度不同时，我们从头遍历到达尾部节点的时间就不一致。所以想个办法，先遍历两个
 * 链表记下链表的长度，然后让链表长度较长的那一个指针先走多出的那部分长度，然后两
 * 个链表的指针同时遍历，第一个相同的点就是我们要的那个点。
 */
public class FindFirstCommonNode {
	//方法1：利用堆栈实现
	public ListNode findFirstCommonNode(ListNode pHead1,ListNode pHead2){
		Stack<ListNode> s1=new Stack<>();
		Stack<ListNode> s2=new Stack<>();
		while(pHead1!=null){
			s1.push(pHead1);
			pHead1=pHead1.next;
		}
		while(pHead2!=null){
			s2.push(pHead2);
			pHead2=pHead2.next;
		}
		ListNode res=null;
		while(!s1.empty()&&!s2.empty()&&s1.peek()==s2.peek()){
			s1.pop();
			res=s2.pop();
		}
		return res;
	}
	//方法2：更好的实现方法。
	public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        int count1 = 1, count2 = 1;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1.next != null){
            p1 = p1.next;
            count1++;
        }
        while(p2.next != null){
            p2 = p2.next;
            count2++;
        }
        if(count1>count2){
            int dif = count1 - count2;
            while(dif != 0){
                pHead1 = pHead1.next;
                dif--;
            }
        }else{
            int dif = count2 - count1;
            while(dif != 0){
                pHead2 = pHead2.next;
                dif--;
            }
        }
        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
	//测试用例
	public static void main(String[] args) {
		FindFirstCommonNode a=new FindFirstCommonNode();
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		ListNode n6=new ListNode(6);
		ListNode n7=new ListNode(7);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n6;
		n6.next=n7;
		
		n4.next=n5;
		n5.next=n6;
		
		ListNode firstCommonNode=a.findFirstCommonNode(n1, n4);
		ListNode firstCommonNode1=a.findFirstCommonNode1(n1, n4);
		System.out.println(firstCommonNode.val);
		System.out.println(firstCommonNode1.val);
	}
}
