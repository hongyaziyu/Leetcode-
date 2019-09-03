package LinkedListImplement;


/**
 * @author 黄子玉
 *时间：2019/07/07 23:00
 *实现单链表。
 * @param <E>
 */
public class Node<E>{
	private Node<E> next;// 指向下一个节点
	private E e;// 数据域
	
	public Node(){
		
	}
	public Node(E e){
		this.e=e;
	}
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
}


