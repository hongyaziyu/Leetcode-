package SwordToOffer;

import java.util.LinkedList;

/**
 * @author 黄子玉 圆圈中最后剩下的数
 * 题目描述：n个人围成一圈，随机指定一个数m(n>m)，编号为0的人开始喊数一直喊到
 * n-1，每次喊道m-1的那个人出局。从m-1个人后继续喊数0...m-1，问最后剩下的那个人
 * 是谁？
 * 解题思路：用环形链表模拟圆圈。创建一个有n个节点的环形链表，然后在链表中删除
 * 第m个节点。注意，起步是-1不是0.
 */
public class LastRemaining {
	public int lastRemaining(int n,int m){
		if(n<1||m<1){
			return -1;
		}
		LinkedList<Integer> link=new LinkedList<Integer> ();
		for(int i=0;i<n;i++){
			link.add(i);
		}
		int index=-1; //起步是-1不是0
		while(link.size()>1){
			index=(index+m)%link.size();
			link.remove(index);
			index--;
		}
		return link.get(0);
	}
}
