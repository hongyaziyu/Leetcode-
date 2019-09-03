package NiuKe;

/**
 * @author ������ �жϵ������Ƿ��л�
 * ���ַ�����
 * 1.��������ָ��slow��fast��fastÿ����������slowÿ����һ����������ָ��һֱ�������ߣ�ֱ��fastΪ���������޻���
 * ����slow��fast��ȣ��������л���������̿��Ա�֤slow���߹���������֮ǰ�Ľ�㣬ͬʱfast��slow���ߵĲ���
 * ��1��ʼÿ�ε���1�����ҵ���������ʱ���ߵĲ������ǻ��н��ĸ���������������
 * 2.����һ���Խڵ�IDΪ��ֵ��HashSet���ϣ������洢�����������Ľڵ㡣��ͷ�ڵ㿪ʼ�����α����������ÿ���ڵ㡣ÿ
 * ����һ���½ڵ㣬�����½ڵ��hashset���ϵ��д洢�Ľڵ����Ƚϣ����������ͬ�Ľڵ�ID��˵�������л����HashSet
 * ���в�������ͬ�Ľڵ�ID���Ͱ�����½ڵ�ID����HashSet��֮�������һ�ڵ㣬�����ظ��ղŵĲ�����
 */

public class WhetherTheSingleLinkedListHasARing {
	//����1������ָ��
	public static boolean whetherTheSingleLinkedListHasARing(ListNode head){
		if(head==null){//������Ϊ��ʱ��������û�л���
			return false;
		}
		if(head.next==null){//������ֻ��ͷ��㣬ͷ�ڵ��nextΪ�գ�������û�л���
			return false;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null){//fastΪ����ִ��ѭ��
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast){
				return true;//slow��fast�غ����л�
			}
		}
		return false;//fast==null�޻�
	}
	//���������ڵ�
	public static ListNode encounterNode(ListNode head){
		if(head==null){//������Ϊ��ʱ��������û�л���
			return null;
		}
		if(head.next==null){//������ֻ��ͷ��㣬ͷ�ڵ��nextΪ�գ�������û�л���
			return null;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null){//fastΪ����ִ��ѭ��
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast){
				return slow;//slow��fast�غ����л�
			}
		}
		return null;//fast==null�޻�
	}
	
	//���ػ�����ڽڵ�
	
	/**
	 * @param head encounter(��һ��������slow==fastʱ���������)
	 * @return
	 * �����ͼ����ʾ��������㵽����ڵ��ľ���Ϊx������ڵ㵽����1��fast��low�غϵ�ľ���Ϊy��
	 * ������fast��low�غ�ʱfast���ƻ�n�ܣ�n>0�����Ҵ�ʱlow�ƶ��ܳ���Ϊs����fast�ƶ��ܳ���Ϊ2s�����ĳ���Ϊr��
	 * ��
          s + nr = 2s,n>0      ��
          s = x + y            ��
             �ɢ�ʽ��  s = nr                 
             �����ʽ��
       nr = x + y
       x = nr - y                ��
            ����һָ��p1��������㴦��ʼ������ָ��p2��encounter����ʼ��������p1��p2�ƶ�������Ϊ1��
            ��p1�ƶ�x�������ﻷ����ڵ㣬�ɢ�ʽ��֪����ʱp2Ҳ���ƶ�x����nr - y��������p2�Ǵ�encounter����ʼ�ƶ���
            ��p2�ƶ�nr�����ƻص���encounter��������y�����ǵ��˻�����ڵ㡣Ҳ������p1�ƶ�x����һ�ε��ﻷ����ڵ�ʱ��
      p2Ҳǡ�õ����˸���ڵ㡣���Ǻ�����д���£�
	 */
	public static ListNode searchEntranceNode(ListNode head,ListNode encounter){
		
		ListNode fast=head,slow=encounter;
		while(fast!=slow){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	
	//�ж�������
	public static int getCycleLength(ListNode encounter){
		ListNode current=encounter;
		int length=0;
		while(current!=null){
			current=current.next;
			length++;
			if(current==encounter){
				return length;
			}
		}
		return length;
	}
	//���Ժ���
	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		
	    n1.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
	    n5.next = n1;  //����һ������������,ȥ���˾��ʾ������
	    System.out.println(WhetherTheSingleLinkedListHasARing.whetherTheSingleLinkedListHasARing(n1));
	    ListNode encounter=WhetherTheSingleLinkedListHasARing.encounterNode(n1);
	    ListNode entrance=WhetherTheSingleLinkedListHasARing.searchEntranceNode(n1,encounter);
	    System.out.println(entrance.val);
	    System.out.println(WhetherTheSingleLinkedListHasARing.getCycleLength(encounter));
	    
	}
}
