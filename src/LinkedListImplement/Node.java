package LinkedListImplement;


/**
 * @author ������
 *ʱ�䣺2019/07/07 23:00
 *ʵ�ֵ�����
 * @param <E>
 */
public class Node<E>{
	private Node<E> next;// ָ����һ���ڵ�
	private E e;// ������
	
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


