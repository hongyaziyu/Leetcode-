package SwordToOffer;

/**
 * @author ������ ��������ĸ���
 * ��Ŀ����������һ����������ÿ���ڵ��нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ�
 * ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬���
 * ����벻Ҫ���ز����еĽڵ����ã������������������
 *
 */
public class CloneLink {
	public RandomListNode clone(RandomListNode pHead){
		 if(pHead == null){
	            return null;
		 }
        //���ƽڵ� A->B->C ��� A->A'->B->B'->C->C'
        RandomListNode head = pHead;
        while(head != null){
            RandomListNode node = new RandomListNode(head.label);//�¿�����node
            node.next = head.next;//��ʵ��A��->B
            head.next = node;//��ʵ��A->A'
            head = node.next;//���headָ��ָ����һ���ڵ�B
        }
        //����random
        head = pHead;//ͷ�ڵ㷵��
        while(head != null){
            head.next.random = head.random == null ? null : head.random.next;//ʵ���˸���random
            head = head.next.next;//ָ����һ��head����B
        }
        //�۷�
        head = pHead;//ͷ�ڵ㷵��
        RandomListNode chead = head.next;//cheadָ��A��
        while(head != null){
            RandomListNode node = head.next;//nodeָ��A'
            head.next = node.next;//head.nextָ��B
            node.next = node.next == null ? null : node.next.next;//node.nextָ��B'
            head = head.next;//head������һ��B������ѭ��
        }
        return chead;
    }
	//���Ժ���
	public static void main(String[] args) {
		RandomListNode node1=new RandomListNode(1);
		RandomListNode node2=new RandomListNode(2);
		RandomListNode node3=new RandomListNode(3);
		RandomListNode node4=new RandomListNode(4);
		RandomListNode node5=new RandomListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node1.random=node3;
		node2.random=node5;
		node4.random=node2;
		
		CloneLink a=new CloneLink();
		RandomListNode head=a.clone(node1);
		while(head!=null){
			System.out.println(head.label);
			head=head.next;
		}
	}
 }

