package LinkedListImplement;

public class MyLinkedList<E> {
	private Node<E> head;// ����ͷ�ڵ�
	private Node<E> last;// ����ͷ�ڵ�
	
	private int size;// ����Ĵ�С
	private int modcount;// �����޸ı�Ĵ���
	
	public MyLinkedList() {
		head = new Node<E>();// ʵ����ͷ�ڵ�
		last = head;
	}
	/**
	 * ��ȡ�������д洢��Ԫ������
	 * 
	 * @return ����size����
	 */
	public int size() {
		return size;
	}

	/**
	 * ��ȡָ������λ�õĽڵ����
	 * 
	 * @param index����λ��
	 * @return ���ػ�ȡ���Ľڵ����
	 */
	private Node<E> Select(int index) {
		Node<E> node = head.getNext();// ��ͷ�ڵ����һ���ڵ㸳��node
		for (int i = 0; i < index; i++) {
			node = node.getNext();// ��ȡnode����һ���ڵ�
		}
		return node;
	}

	/**
	 * �ҵ�ָ���ڵ�������򣬲�����
	 * 
	 * @param index
	 *            ����
	 * @return �ڵ��������
	 */
	public E GetE(int index) {
		if (index < 0 || index > size - 1)
			return null;
		Node<E> node = Select(index); // ����ָ������λ�õĽڵ����
		return node.getE();// ��ȡ�ڵ��е�������Ԫ�ز�����
	}

	/**
	 * ��
	 * 
	 * @param eҪ��ӵ�Ԫ��
	 */
	public void add(E e) {
		Node<E> node = new Node<E>(e);// ��eʵ����һ���ڵ�
		last.setNext(node);// ��β�ڵ��ӽڵ�
		last = node;// �ýڵ���Ϊ���һ���ڵ�
		size++;
	}

	/**
	 * ɾ��ָ���Ľڵ�e,������e
	 * 
	 * @param iΪ������
	 * @return ����ɾ����Ԫ��e
	 */
	public E Delete(int index) {

		if (index < 0 || index > size)
			return null;
		if (index == 0) {// ������Ϊ1ʱ����ͷ�ڵ����һ���ڵ�Ϊͷ�ڵ�
			Node<E> node2 = head.getNext();
			head.setNext(node2.getNext());
			size--;
			return node2.getE();
		}
		// ��ȡҪɾ���ڵ��ǰһ���ڵ�
		Node<E> bNode = Select(index - 1);
		// ��ȡҪɾ���Ľڵ�
		Node<E> Node = bNode.getNext();
		// ��ȡҪɾ���ڵ�ĺ�һ���ڵ�
		Node<E> nNode = Node.getNext();

		// �Ƚ���ɾ���ڵ��ǰһ���ڵ��ɾ���ڵ�ĺ�һ���ڵ�Ĺ�ϵ
		bNode.setNext(nNode);
		// ���dNode����һ���ڵ�
		Node.setNext(null);
		size--;// ��������1
		return Node.getE();// ����ɾ���ڵ��е�������
	}

	/**
	 * �޸�ָ��λ�õ�������
	 * @param x������
	 * @param index����λ��
	 * @return �����޸ĺ������
	 */
	public E Renew(E x, int index) {
		if (index < 0 || index > size || size == 0)
			return null;
		Node<E> xnode = new Node<E>(x);// ��ȡһ���½ڵ�
		Node<E> node = Select(index);
		node.setE(xnode.getE());
		return node.getE();
             }
	}
	

