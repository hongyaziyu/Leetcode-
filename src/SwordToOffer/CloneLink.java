package SwordToOffer;

/**
 * @author 黄子玉 复杂链表的复制
 * 题目描述：输入一个复杂链表（每个节点有节点值，以及两个指针，一个指向下一个节点
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出
 * 结果请不要返回参数中的节点引用，否则判题程序会出错。）
 *
 */
public class CloneLink {
	public RandomListNode clone(RandomListNode pHead){
		 if(pHead == null){
	            return null;
		 }
        //复制节点 A->B->C 变成 A->A'->B->B'->C->C'
        RandomListNode head = pHead;
        while(head != null){
            RandomListNode node = new RandomListNode(head.label);//新拷贝的node
            node.next = head.next;//先实现A’->B
            head.next = node;//再实现A->A'
            head = node.next;//最后将head指针指向下一个节点B
        }
        //复制random
        head = pHead;//头节点返回
        while(head != null){
            head.next.random = head.random == null ? null : head.random.next;//实现了复制random
            head = head.next.next;//指向下一个head，即B
        }
        //折分
        head = pHead;//头节点返回
        RandomListNode chead = head.next;//chead指向A’
        while(head != null){
            RandomListNode node = head.next;//node指向A'
            head.next = node.next;//head.next指向B
            node.next = node.next == null ? null : node.next.next;//node.next指向B'
            head = head.next;//head移向下一个B，继续循环
        }
        return chead;
    }
	//测试函数
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

