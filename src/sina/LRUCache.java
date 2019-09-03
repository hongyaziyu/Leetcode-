package sina;

import java.util.Hashtable;

/**
 * @author ������ LRU����ԭ��ʵ��
 * LRU��Least Recent Used(��̭�����ʹ�õ�)
 * ʵ��ԭ��Hashtable����˫������
 * 
 *
 */
public class LRUCache {
	class CacheNode{
		int key,value;
		CacheNode pre,next;
	}
	private Hashtable<Integer,CacheNode> cacheTable=new Hashtable<Integer,CacheNode> ();
	private int count;
	private CacheNode head,tail;
	private int capacity;
	
	public LRUCache(int capacity){
		this.count=0;
		this.capacity=capacity;
		head=new CacheNode();
		tail=new CacheNode();
		head.pre=null;
		tail.next=null;
		
		head.next=tail;
		tail.pre=head;
	}
	
	private void moveToHead(CacheNode node){
		this.removeNode(node);
		this.addNode(node);
	}
	
	private void addNode(CacheNode node){//���뵽head֮��head.next֮ǰ��
		node.next=this.head.next;
		node.pre=this.head;
		this.head.next.pre=node;
		this.head.next=node;
		++count;
	}
	
	private CacheNode popTail(){
		if(count==0){
			return null;
		}
		CacheNode node=this.tail.pre;
		this.removeNode(node);
		return node;
	}
	
	private void removeNode(CacheNode node){
		node.pre.next=node.next;
		node.next.pre=node.pre;
		--count;
	}
	
	public int get(int key) throws Exception{//ͨ��hashtable�ҵ�LRU����ڵ㣬����LRUԭ������ڵ������·��ʵ�
		                                     //����Ҫ�ѽڵ�嵽��ͷ��Ȼ�󷵻ػ����ֵ��
		CacheNode node=this.cacheTable.get(key);
		if(node==null){
			throw new Exception("element not found");
		}
		this.moveToHead(node);
		return node.value;
	}
	
	public void put(int key,int value){//LRU����ڵ�
		CacheNode node=this.cacheTable.get(key);//��hashtable���ҵ�key��Ӧ�Ľڵ�
		if(node!=null){//����ڵ���ڸ��½ڵ��ֵ�������ڵ��ƶ�����ͷ
			node.value=value;
			this.moveToHead(node);
		}
		CacheNode newNode=new CacheNode();//�������������Ҫ�����µĽڵ㣬���԰ѽڵ�������ͷ��
		newNode.key=key;
		newNode.value=value;
		
		this.addNode(newNode);
		this.cacheTable.put(key, newNode);
		
		if(count>this.capacity){//���LRU�ռ䲻�㣬����̭β���Ľڵ㣬������hashtable���Ƴ�key��
			CacheNode popNode=this.popTail();
			this.cacheTable.remove(popNode.key);
		}
	}
	
	//���Ժ���
	public static void main(String[] args) {
		LRUCache stack=new LRUCache(3);//�����ڴ�ֻ����������ҳ�Ĵ�С
		stack.put(1, 7);
		stack.put(2, 0);
		stack.put(3, 1);
		stack.put(4, 2);
		try {
			int key2=stack.get(2);
			System.out.println(key2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stack.put(5, 3);
		try {
			int key2=stack.get(2);
			System.out.println(key2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stack.put(6, 4);
	}
}
