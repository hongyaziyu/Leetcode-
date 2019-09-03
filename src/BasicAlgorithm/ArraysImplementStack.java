package BasicAlgorithm;


/**
 * @author ������
 *ʱ�䣺2019/07/07 19:00
 *���⣺��������ʵ��ջ��ջ���ص㣺����ȳ���
 *ջֻ��Ҫһ��ͷָ������ˡ�
 *ջ�Ļ���������
 *Push-��ջ�����Ϸ�����Ԫ��
 *Pop-����ջ���Ϸ���Ԫ�أ�������ɾ��
 *IsEmpty-��ѯջ�Ƿ�Ϊ��
 *Top-����ջ���Ϸ���Ԫ�ز���ɾ��
 */
public class ArraysImplementStack {
	//�����ݵ�����
	private int[] data;
	//ջ����󳤶�
	private int size;
	//ջ����λ��
	private int top;
	
	//���캯������������Խ��г�ʼ��
	public ArraysImplementStack(int size){
		this.size=size;
		data=new int[size];
		top=-1;
	}
	//����size�Ļ�÷����������ж�ջ�ǲ��ǿյġ���������size��set��������һ�������ڴ�������ʱ���С�
	public int getSize() {
		return size;
	}
	//����top�Ļ�÷����������ж�ջ�ǲ������ġ���������top��set������
	public int getTop() {
		return top;
	}
	//�ж��Ƿ�Ϊ��ջ��
	public boolean isEmpty(){
		return top==-1;
	}
	//�ж��Ƿ�Ϊ��ջ��
	public boolean isFull(){
		return (top+1)==size;
	}
	//ѹջ����push
	public boolean push(int data){
		if(isFull()){
			System.out.println("the stack is full!");
			return false;
		}else{
			top++;
			this.data[top]=data;
			return true;
		}
	}
	//��ջ����pop
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("the stack is empty!");
		}else{
			return this.data[top--];
		}
	} 
	//��ȡջ��Ԫ�ز���ɾ��top
	public int top(){
		return this.data[getTop()];
	}
	public static void main(String[] args) {
		ArraysImplementStack stack=new ArraysImplementStack(20);
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("the number of top_stack is:"+stack.top());
		while(!stack.isEmpty()){
			try {
				System.out.println(stack.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
