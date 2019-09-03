package MultiTreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ������ lockInterruptibly()��lock()����������
 * �����������lock.lockInterruptibly();�滻Ϊlock.lock();�༭���ᱨ������ʾcatch(){}�������Ч��
 * ��Ϊlock()���������interrupt()�������쳣��
 */
public class Multithreading {
	public static void main (String[] args) throws InterruptedException {
		final Lock lock=new ReentrantLock();
		lock.lock();
		Thread t1=new Thread(new Runnable(){
			public void run(){
				try{
					lock.lockInterruptibly();
					//lock.lock();//�༭���ᱨ��
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
