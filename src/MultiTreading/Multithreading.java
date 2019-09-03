package MultiTreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 黄子玉 lockInterruptibly()和lock()方法的区别
 * 区别是如果将lock.lockInterruptibly();替换为lock.lock();编辑器会报错，会提示catch(){}代码块无效，
 * 因为lock()方法会忽略interrupt()引发的异常。
 */
public class Multithreading {
	public static void main (String[] args) throws InterruptedException {
		final Lock lock=new ReentrantLock();
		lock.lock();
		Thread t1=new Thread(new Runnable(){
			public void run(){
				try{
					lock.lockInterruptibly();
					//lock.lock();//编辑器会报错
				}catch(InterruptedException e){
					System.out.println("interrupted.");
				}
			}
		});
		t1.start();
		t1.interrupt();
		Thread.sleep(1);
	}
}
