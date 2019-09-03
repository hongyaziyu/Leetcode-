package SwordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ������ �������е���λ��
 * ��Ŀ��������εõ�һ���������е���λ����������������ж�����������ֵ��
 * ��ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ��
 * ��ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 *����˼·��
 *���ǿ��Խ�����������Ϊ�����֣���߲��ֵ��������Ǳ��ұߵ�����С����ô�����ǾͿ��������Ѻ���С����װ����Щ���ݣ�

����װ��ߵ����ݣ�ȡ���Ѷ�������������ʱ�临�Ӷ���O(1)
��С��װ�ұߵ����ݣ�ͬ����ȡ���Ѷ�����С��������ʱ�临�Ӷ���O(1)
�����������õ�һ�������Ȱ�˳�������У�
�����ߵ������Ƿ�Ϊ�ջ��߸���С�ڵ������Ѷ�������������������ѣ�
���������С�ѡ�Ȼ������Ҫ��֤��ߵ����ѵ�size�����ұߵ���С�ѵ�size
�������ѵ�size����С�ѵ�size��1��
Ҫ��ȡ��λ���Ļ���ֱ���ж����Ѻ���С�ѵ�size�������ȣ�
��ֱ�ȡ�������ѵĶѶ�����2�õ���λ������Ȼ���������ѵ�sizeҪ����С�ѵ�size��
��ʱֱ��ȡ�����ѵĶѶ���������Ҫ����λ����
 */
public class GetMedian {
	 // ��С�ѣ��ң�
    private PriorityQueue<Integer> rHeap = new PriorityQueue<>(); 
    // ���ѣ���
    private PriorityQueue<Integer> lHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    // ��֤lHeap.size()>=rHeap.size()
    public void Insert(Integer num) {
        // �Ȱ���С���룬�ٵ���
        if(lHeap.isEmpty() || num <= lHeap.peek())
            lHeap.offer(num);
        else
            rHeap.offer(num);

        if(lHeap.size() < rHeap.size()){
            lHeap.offer(rHeap.peek());
            rHeap.poll();
        }else if(lHeap.size() - rHeap.size() == 2){
            rHeap.offer(lHeap.peek());
            lHeap.poll();
        }
    }
    public Double getMedian() {
        if(lHeap.size() > rHeap.size())
            return new Double(lHeap.peek());
        else
            return new Double(lHeap.peek() + rHeap.peek())/2;
    }
}
