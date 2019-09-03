package SwordToOffer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ������ ��β��ͷ��ӡ����
 * �������������һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrrayList
 * ����˼·��1.��ջ��ʵ��
 *          2.��������ָ�������ת���ؼ���rָ�뱣��Ͽ��Ľڵ㡣
 */
public class PrintListFromTailToHead {
	//����1����ջ��ʵ��
	public void printListFromTailToHead1(ListNode listNode){
		Stack<ListNode> stackNodes=new Stack<ListNode> ();
		ListNode node=listNode;
		//������Ԫ��������ջ
		while(node!=null){
			stackNodes.push(node);
			node=node.next;
		}
		//ջ�еĵ�����Ԫ�����γ�ջ
		while(stackNodes.size()>0){
			ListNode top=stackNodes.pop();
			System.out.println(top.val);
		}
	}
	//����2����������ָ�������ת��(�ƻ���ԭ�е�����ṹ)
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
		//��ʱlistNode��next��ָ��ڶ���node������Ҫ��listNode.next=null,��ֹѭ�����ǳ���Ҫ
		//������ָ�뷴ת����ʱ��ע�⽫��һ���ڵ��ָ��ָ��null��
		listNode.next = null;
	/*	��������ַ�ʽ�Ͳ��ý���һ��ָ��ָ��null�ˡ�
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
	//����3���ݹ��ջ����ͬ��˼�룬���õݹ�ķ�ʽʵ�ִ�β��ͷ��ӡ
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
		PrintListFromTailToHead a=new PrintListFromTailToHead();
		a.printListFromTailToHead2(node1);
		a.printListFromTailToHead1(node1);
		System.out.println(a.printListFromTailToHead(node1).toString());
		
	}
}

