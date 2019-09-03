package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ������ �����ٵļ���������
 * ��Ŀ��������ά�ռ��кܶ�����ÿ�������ṩ����ֱ����ʼ�ͽ��������꣬�й���ƽ����y���������xstart<x<xend
 * ��������Ա��䱬�����������ƽ��䱬��Χ������������������Ҫ����ֻ������
 * ���룺[[10,16], [2,8], [1,6], [7,12]]
 * �����2
 * ���ͣ���x=6���䱬[2,8],[1,6]�������Լ�x=11���䱬������������
 */
public class FindMinArrows {
	//̰�Ĳ������
	public int findMinArrows(int[][] points){
		if(points.length==0){
			return 0;
		}
		Ballon[] ballons=new Ballon[points.length];//����������󣬳�ʼ��Ϊ����ĸ���
		for(int i=0;i<points.length;i++){
			ballons[i]=new Ballon(points[i][0],points[i][1]);//��ʼ������ֱ���Ŀ�ʼ�ͽ�������
		}
		Arrays.sort(ballons, new Comparator<Ballon>(){
			@Override
			public int compare(Ballon o1,Ballon o2){
				return o1.end-o2.end;
			}
		});//ע��Arrays.sort()�õ���˫���������,Collections.sort()�õ��ǹ鲢���������Ǹ���end�����������
		int ans=1;//����ֻҪ�������ڣ��ͱ�������Ҫ��һ������
		int right=ballons[0].end;//���ұ�����Ϊend��С����һ����
		for(Ballon ballon:ballons){
			if(ballon.start>right){//�������һ����ֱ������λ�ô��ڵ�ǰ��ֱ�����λ�ã�����Ҫһ������
				right=ballon.end;
				ans++;
			}
		}
		return ans;
	}
	//���Ժ���
	public static void main(String[] args) {
		int[][] points={{10,16},{2,8},{1,6},{7,12}};
		FindMinArrows a=new FindMinArrows();
		System.out.println(a.findMinArrows(points));
	}
}
