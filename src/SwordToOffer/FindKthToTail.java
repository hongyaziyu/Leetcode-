package SwordToOffer;

/**
 * @author ������ �����е�����k�����
 * ��������������һ�������������������k����㡣
 * ����˼·�������˫ָ�뷨����������ָ�룬��һ��ָ��������ͷָ�뿪ʼ������ǰ��
 * k-1�����ڶ���ָ�뱣�ֲ������ӵ�k����ʼ���ڶ���ָ��Ҳ��ʼ�������ͷָ�뿪ʼ����
 * ��������ָ��ľ��뱣����k-1������һ��ָ�뵽������β���ʱ���ڶ���ָ��պ�ָ��
 * ������k����㡣
 * ����һ�ַ�����ջ�ķ�����������˳��ѹ��ջ��Ȼ��ȡ��ջ�ĵ�k���ڵ㡣
 * 
 * ��עҪ�㣺
 * 1.����ͷָ���Ƿ�Ϊ�գ���Ϊ����ֱ�ӷ���null��
 * 2.k�Ƿ�Ϊ0��kΪ0Ҳ����Ҫ���ҵ�����0����㣬���ڼ���һ���Ǵ�1��ʼ����������0
 * û�����壬����null��
 * 3.k�Ƿ񳬳������ȣ��������ڵ���С��k������ָ����ƹ����л����nextָ��
 * ��ָ��Ĵ������Գ�����Ҫ�Ӹ��жϡ�
 */
public class FindKthToTail {
	public ListNode findKthToTail(ListNode head,int k){
		if(head==null||k==0){
			return null;
		}
		ListNode temp=head;
		ListNode pB=head;
		//�ж�k�Ƿ񳬹�����ڵ�ĸ�����ע����i<k-1
		for(int i=0;i<k-1;i++){
			if(temp.next!=null){
				temp=temp.next;
			}else{
				return null;
			}
		}
		ListNode pA=head;
		for(int j=0;j<k-1;j++){
			pA=pA.next;
		}while(pA.next!=null){
			pA=pA.next;
			pB=pB.next;
		}
		
		return pB;
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
		FindKthToTail a=new FindKthToTail();
		System.out.println(a.findKthToTail(node1, 4).val);
	}
}
