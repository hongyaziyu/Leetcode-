package BasicAlgorithm;


/**
 * @author 黄子玉
 *时间：2019/07/07 19:00
 *问题：利用数组实现栈。栈的特点：后进先出。
 *栈只需要一个头指针就行了。
 *栈的基本操作：
 *Push-在栈的最上方插入元素
 *Pop-返回栈最上方的元素，并将其删除
 *IsEmpty-查询栈是否为空
 *Top-返回栈最上方的元素并不删除
 */
public class ArraysImplementStack {
	//存数据的数组
	private int[] data;
	//栈的最大长度
	private int size;
	//栈顶的位置
	private int top;
	
	//构造函数，对类的属性进行初始化
	public ArraysImplementStack(int size){
		this.size=size;
		data=new int[size];
		top=-1;
	}
	//设置size的获得方法，用来判断栈是不是空的。不用设置size的set方法，这一步可以在创建对象时进行。
	public int getSize() {
		return size;
	}
	//设置top的获得方法，用来判断栈是不是满的。不用设置top的set方法。
	public int getTop() {
		return top;
	}
	//判断是否为空栈。
	public boolean isEmpty(){
		return top==-1;
	}
	//判断是否为满栈。
	public boolean isFull(){
		return (top+1)==size;
	}
	//压栈操作push
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
	//弹栈操作pop
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("the stack is empty!");
		}else{
			return this.data[top--];
		}
	} 
	//获取栈顶元素并不删除top
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
