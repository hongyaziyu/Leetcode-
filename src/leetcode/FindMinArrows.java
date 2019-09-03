package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 黄子玉 用最少的箭引爆气球
 * 题目描述：二维空间有很多气球，每个气球提供气球直径开始和结束的坐标，有弓箭平行于y轴射出。若xstart<x<xend
 * 则气球可以被射爆，继续往上推进射爆范围内所有气球，问最少需要多少只弓箭。
 * 输入：[[10,16], [2,8], [1,6], [7,12]]
 * 输出：2
 * 解释：在x=6处射爆[2,8],[1,6]两个球以及x=11处射爆另外两个气球
 */
public class FindMinArrows {
	//贪心策略求解
	public int findMinArrows(int[][] points){
		if(points.length==0){
			return 0;
		}
		Ballon[] ballons=new Ballon[points.length];//构造气球对象，初始化为气球的个数
		for(int i=0;i<points.length;i++){
			ballons[i]=new Ballon(points[i][0],points[i][1]);//初始化气球直径的开始和结束坐标
		}
		Arrays.sort(ballons, new Comparator<Ballon>(){
			@Override
			public int compare(Ballon o1,Ballon o2){
				return o1.end-o2.end;
			}
		});//注意Arrays.sort()用的是双轴快速排序,Collections.sort()用的是归并排序。这里是根据end坐标进行排序。
		int ans=1;//首先只要有气球在，就必须至少要有一个弓箭
		int right=ballons[0].end;//将右边设置为end最小的那一个。
		for(Ballon ballon:ballons){
			if(ballon.start>right){//如果存在一个球直径最左位置大于当前球直径最大位置，则还需要一个弓箭
				right=ballon.end;
				ans++;
			}
		}
		return ans;
	}
	//测试函数
	public static void main(String[] args) {
		int[][] points={{10,16},{2,8},{1,6},{7,12}};
		FindMinArrows a=new FindMinArrows();
		System.out.println(a.findMinArrows(points));
	}
}
