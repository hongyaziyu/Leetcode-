package SwordToOffer;

/**
 * @author 黄子玉 链表中倒数第k个结点
 * 问题描述：输入一个链表，输出该链表倒数第k个结点。
 * 解题思路：经典的双指针法。定义两个指针，第一个指针从链表的头指针开始遍历向前走
 * k-1步，第二个指针保持不动，从第k步开始，第二个指针也开始从链表的头指针开始遍历
 * 由于两个指针的距离保持在k-1，当第一个指针到达链表尾结点时，第二个指针刚好指向
 * 倒数第k个结点。
 * 另外一种方法是栈的方法，将链表顺序压入栈，然后取出栈的第k个节点。
 * 
 * 关注要点：
 * 1.链表头指针是否为空，若为空则直接返回null。
 * 2.k是否为0，k为0也就是要查找倒数第0个结点，由于计数一般是从1开始，所有输入0
 * 没有意义，返回null。
 * 3.k是否超出链表长度，如果链表节点数小于k，则在指针后移过程中会出现next指向
 * 空指针的错误，所以程序中要加个判断。
 */
public class FindKthToTail {
	public ListNode findKthToTail(ListNode head,int k){
		if(head==null||k==0){
			return null;
		}
		ListNode temp=head;
		ListNode pB=head;
		//判断k是否超过链表节点的个数，注意是i<k-1
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
		FindKthToTail a=new FindKthToTail();
		System.out.println(a.findKthToTail(node1, 4).val);
	}
}
