package SwordToOffer;

import java.util.Stack;

/**
 * @author ������ ��������ĵ�һ�������ڵ�
 * ��Ŀ�������������������ҳ����ǵĵ�һ�������ڵ�
 * ����˼·���������������ڹ����ڵ㣬��ô���Ǵӹ����ڵ㿪ʼһֱ������Ľ�β����
 * һ���ġ��������ֻ��Ҫ������Ľ�β��ʼ����ǰ�������ҵ����һ����ͬ�Ľڵ㼴�ɡ�
 * ������Ŀ�����ǵ�����������ֻ�ܴ�ǰ�����������������ǾͿ��Խ���ջ����ɡ��Ȱ�
 * ������������װ�뵽����ջ�У�Ȼ��Ƚ�����ջ��ջ���ڵ��Ƿ���ͬ�������ͬ���ջ��
 * �����ͬ�Ǿ�����ͬ�Ľڵ㷵��ֵ�����ˡ�
 * �ڶ���˼·����һ��˼·֮�����õ�ջ����Ϊ������ͬʱ������������ջ��β��㡣����
 * ���Ȳ�ͬʱ�����Ǵ�ͷ��������β���ڵ��ʱ��Ͳ�һ�¡���������취���ȱ�������
 * �����������ĳ��ȣ�Ȼ���������Ƚϳ�����һ��ָ�����߶�����ǲ��ֳ��ȣ�Ȼ����
 * �������ָ��ͬʱ��������һ����ͬ�ĵ��������Ҫ���Ǹ��㡣
 */
public class FindFirstCommonNode {
	//����1�����ö�ջʵ��
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
	//����2�����õ�ʵ�ַ�����
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
	//��������
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
