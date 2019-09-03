package sina;

import java.util.Hashtable;

/**
 * @author 黄子玉 LRU缓存原理实现
 * LRU：Least Recent Used(淘汰最不经常使用的)
 * 实现原理：Hashtable加上双向链表。
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
	
	private void addNode(CacheNode node){//插入到head之后，head.next之前。
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
	
	public int get(int key) throws Exception{//通过hashtable找到LRU链表节点，根据LRU原理，这个节点是最新访问的
		                                     //所以要把节点插到队头，然后返回缓存的值。
		CacheNode node=this.cacheTable.get(key);
		if(node==null){
			throw new Exception("element not found");
		}
		this.moveToHead(node);
		return node.value;
	}
	
	public void put(int key,int value){//LRU保存节点
		CacheNode node=this.cacheTable.get(key);//在hashtable中找到key对应的节点
		if(node!=null){//如果节点存在更新节点的值，并将节点移动到表头
			node.value=value;
			this.moveToHead(node);
		}
		CacheNode newNode=new CacheNode();//如果不存在则需要构造新的节点，尝试把节点塞到队头。
		newNode.key=key;
		newNode.value=value;
		
		this.addNode(newNode);
		this.cacheTable.put(key, newNode);
		
		if(count>this.capacity){//如果LRU空间不足，则淘汰尾部的节点，并且在hashtable中移除key。
			CacheNode popNode=this.popTail();
			this.cacheTable.remove(popNode.key);
		}
	}
	
	//测试函数
	public static void main(String[] args) {
		LRUCache stack=new LRUCache(3);//假设内存只能容纳三个页的大小
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
