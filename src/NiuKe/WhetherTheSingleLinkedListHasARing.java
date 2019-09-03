package NiuKe;

/**
 * @author 黄子玉 判断单链表是否有环
 * 两种方法：
 * 1.设置两个指针slow、fast，fast每次走两步，slow每次走一步。这两个指针一直往后面走，直到fast为空则链表无环，
 * 或者slow和fast相等，则单链表有环。这个过程可以保证slow会走过所有在它之前的结点，同时fast比slow多走的步长
 * 从1开始每次递增1，而且当它们相遇时多走的步长就是环中结点的个数的正整数倍。
 * 2.创建一个以节点ID为键值的HashSet集合，用来存储曾经遍历过的节点。从头节点开始，依次遍历单链表的每个节点。每
 * 遍历一个新节点，就用新节点和hashset集合当中存储的节点作比较，如果存在相同的节点ID就说明链表有环如果HashSet
 * 当中不存在相同的节点ID，就把这个新节点ID存入HashSet，之后进入下一节点，继续重复刚才的操作。
 */

public class WhetherTheSingleLinkedListHasARing {
	//方法1：快慢指针
	public static boolean whetherTheSingleLinkedListHasARing(ListNode head){
		if(head==null){//单链表为空时，单链表没有环。
			return false;
		}
		if(head.next==null){//单链表只有头结点，头节点的next为空，单链表没有环。
			return false;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null){//fast为空则不执行循环
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast){
				return true;//slow和fast重合则有环
			}
		}
		return false;//fast==null无环
	}
	//返回相遇节点
	public static ListNode encounterNode(ListNode head){
		if(head==null){//单链表为空时，单链表没有环。
			return null;
		}
		if(head.next==null){//单链表只有头结点，头节点的next为空，单链表没有环。
			return null;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null){//fast为空则不执行循环
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast){
				return slow;//slow和fast重合则有环
			}
		}
		return null;//fast==null无环
	}
	
	//返回环的入口节点
	
	/**
	 * @param head encounter(上一个方法的slow==fast时候的相遇点)
	 * @return
	 * 解答：如图中所示，设链起点到环入口点间的距离为x，环入口点到问题1中fast与low重合点的距离为y，
	 * 又设在fast与low重合时fast已绕环n周（n>0），且此时low移动总长度为s，则fast移动总长度为2s，环的长度为r。
	 * 则
          s + nr = 2s,n>0      ①
          s = x + y            ②
             由①式得  s = nr                 
             代入②式得
       nr = x + y
       x = nr - y                ③
            现让一指针p1从链表起点处开始遍历，指针p2从encounter处开始遍历，且p1和p2移动步长均为1。
            则当p1移动x步即到达环的入口点，由③式可知，此时p2也已移动x步即nr - y步。由于p2是从encounter处开始移动，
            故p2移动nr步是移回到了encounter处，再退y步则是到了环的入口点。也即，当p1移动x步第一次到达环的入口点时，
      p2也恰好到达了该入口点。于是函数可写如下：
	 */
	public static ListNode searchEntranceNode(ListNode head,ListNode encounter){
		
		ListNode fast=head,slow=encounter;
		while(fast!=slow){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	
	//判断链表长度
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
	//测试函数
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
	    n5.next = n1;  //构造一个带环的链表,去除此句表示不带环
	    System.out.println(WhetherTheSingleLinkedListHasARing.whetherTheSingleLinkedListHasARing(n1));
	    ListNode encounter=WhetherTheSingleLinkedListHasARing.encounterNode(n1);
	    ListNode entrance=WhetherTheSingleLinkedListHasARing.searchEntranceNode(n1,encounter);
	    System.out.println(entrance.val);
	    System.out.println(WhetherTheSingleLinkedListHasARing.getCycleLength(encounter));
	    
	}
}
