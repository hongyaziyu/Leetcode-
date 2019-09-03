package BasicAlgorithm;

/**
 * talk is cheap, show me the code.
 * @author 黄子玉
 * 时间：2019/07/07 19:00
 *问题：利用数组实现队列。队列的特点：先进先出。
 *队列需要一个头指针和一个尾指针。
 *队列的基本操作：
 *Enqueue-在队列末尾插入元素
 *Dequeue-将队列第一个元素删除
 *IsEmpty-查询队列是否为空
 *Top-返回队列第一个元素
 *
 *注意顺序队列，头指针指向队头元素，而尾指针指向队尾元素的下一个位置.
 *顺序队列有个空/满队列的判定，当队列为空或者满时都会出现front==rear的情况。无法通过这个条件来判断。
 *解决办法：1.设一个布尔变量或者标志变量区别队列的空和满。2.使用一个计数器记录队列的长度。
 *3.保留一个元素的空间。约定入队前测试尾指针rear在循环意义下加1后是否等于front，若相等则表示队满。判空条件未变。
 *
 *队列空的条件：front=rear
 *队列满的条件：(rear+1)%size==front
 *通用计算队列长度的公式：(rear-front+size)%size
 */
public class ArraysImplementQueue {
	private int[] data;//存数据的数组
	private int size;//队列的大小
	private int front;//队列的头指针
	private int rear;//队列的尾指针
	
	public ArraysImplementQueue(int size){
		this.data=new int[size];
		front=rear=0;//这里用循环数组实现队列不用顺序数组实现队列，因为顺序数组出队n个元素所有元素都要向前移动
		             //n个单位，这样的效率会很低。
	}
	//判断队列是否为空
	public boolean isEmpty(){
		return front==rear;
	}
	//判断队列是否为满
	public boolean isFull(){
		return (rear+1)%size==front;
	}
	//入队操作enQueue
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
	//出队操作deQueue
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
