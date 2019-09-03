package SwordToOffer;

import java.util.LinkedList;

/**
 * @author ������ ԲȦ�����ʣ�µ���
 * ��Ŀ������n����Χ��һȦ�����ָ��һ����m(n>m)�����Ϊ0���˿�ʼ����һֱ����
 * n-1��ÿ�κ���m-1���Ǹ��˳��֡���m-1���˺��������0...m-1�������ʣ�µ��Ǹ���
 * ��˭��
 * ����˼·���û�������ģ��ԲȦ������һ����n���ڵ�Ļ�������Ȼ����������ɾ��
 * ��m���ڵ㡣ע�⣬����-1����0.
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
		int index=-1; //����-1����0
		while(link.size()>1){
			index=(index+m)%link.size();
			link.remove(index);
			index--;
		}
		return link.get(0);
	}
}
