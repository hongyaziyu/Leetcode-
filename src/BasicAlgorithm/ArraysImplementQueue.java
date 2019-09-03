package BasicAlgorithm;

/**
 * talk is cheap, show me the code.
 * @author ������
 * ʱ�䣺2019/07/07 19:00
 *���⣺��������ʵ�ֶ��С����е��ص㣺�Ƚ��ȳ���
 *������Ҫһ��ͷָ���һ��βָ�롣
 *���еĻ���������
 *Enqueue-�ڶ���ĩβ����Ԫ��
 *Dequeue-�����е�һ��Ԫ��ɾ��
 *IsEmpty-��ѯ�����Ƿ�Ϊ��
 *Top-���ض��е�һ��Ԫ��
 *
 *ע��˳����У�ͷָ��ָ���ͷԪ�أ���βָ��ָ���βԪ�ص���һ��λ��.
 *˳������и���/�����е��ж���������Ϊ�ջ�����ʱ�������front==rear��������޷�ͨ������������жϡ�
 *����취��1.��һ�������������߱�־����������еĿպ�����2.ʹ��һ����������¼���еĳ��ȡ�
 *3.����һ��Ԫ�صĿռ䡣Լ�����ǰ����βָ��rear��ѭ�������¼�1���Ƿ����front����������ʾ�������п�����δ�䡣
 *
 *���пյ�������front=rear
 *��������������(rear+1)%size==front
 *ͨ�ü�����г��ȵĹ�ʽ��(rear-front+size)%size
 */
public class ArraysImplementQueue {
	private int[] data;//�����ݵ�����
	private int size;//���еĴ�С
	private int front;//���е�ͷָ��
	private int rear;//���е�βָ��
	
	public ArraysImplementQueue(int size){
		this.data=new int[size];
		front=rear=0;//������ѭ������ʵ�ֶ��в���˳������ʵ�ֶ��У���Ϊ˳���������n��Ԫ������Ԫ�ض�Ҫ��ǰ�ƶ�
		             //n����λ��������Ч�ʻ�ܵ͡�
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return front==rear;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isFull(){
		return (rear+1)%size==front;
	}
	//��Ӳ���enQueue
	public boolean enQueue(int data){
		if(isFull()){
			System.out.println("the queue is full!");
			return false;
		}else{
			this.data[rear]=data;
			rear=(rear+1)%size;
			return true;
		}
	}
	//���Ӳ���deQueue
	public int deQueue() throws Exception{
		if(isEmpty()){
			throw new Exception("the stack is empty!");
		}else{
			int a=data[front];
			front=(front+1)%size;
			return a;
		}
	} 
	
	public static void main(String[] args) {
		ArraysImplementQueue queue=new ArraysImplementQueue(20);
		queue.enQueue(0);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		while(!queue.isEmpty()){
			try {
				System.out.println(queue.deQueue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
