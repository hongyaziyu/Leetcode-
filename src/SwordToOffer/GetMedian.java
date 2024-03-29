package SwordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 黄子玉 数据流中的中位数
 * 题目描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *解题思路：
 *我们可以将数据排序后分为两部分，左边部分的数据总是比右边的数据小。那么，我们就可以用最大堆和最小堆来装载这些数据：

最大堆装左边的数据，取出堆顶（最大的数）的时间复杂度是O(1)
最小堆装右边的数据，同样，取出堆顶（最小的数）的时间复杂度是O(1)
从数据流中拿到一个数后，先按顺序插入堆中：
如果左边的最大堆是否为空或者该数小于等于最大堆顶的数，则把它插入最大堆，
否则插入最小堆。然后，我们要保证左边的最大堆的size等于右边的最小堆的size
或者最大堆的size比最小堆的size大1。
要获取中位数的话，直接判断最大堆和最小堆的size，如果相等，
则分别取出两个堆的堆顶除以2得到中位数，不然，就是最大堆的size要比最小堆的size大，
这时直接取出最大堆的堆顶就是我们要的中位数。
 */
public class GetMedian {
	 // 最小堆（右）
    private PriorityQueue<Integer> rHeap = new PriorityQueue<>(); 
    // 最大堆（左）
    private PriorityQueue<Integer> lHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    // 保证lHeap.size()>=rHeap.size()
    public void Insert(Integer num) {
        // 先按大小插入，再调整
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
