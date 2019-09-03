package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ������
 * ʱ�䣺2019/07/05 22:00
 * ��Ŀ�����ϣ�n��С���ѹ��ţ�һ���������������ŵ�ʱ�䰴�����Ǹ����㣬ÿ�ι����ű�����һ���˻������ֵ�Ͳ
 * �����ʱ�䡣
 * ���������ȶ�С���ѹ���ʱ��������򣬷�������a�2���˹��ţ����Ŵ�����1�Σ�3���˹��ţ����ŵĴ�����3�Σ�
 * 4���˹��ţ����ŵĴ�����5�Σ�...�Դ����ƣ�n���˹��ţ����Ŵ�����2*n-3�Σ����������ֵ�Ͳ���ŵĴ�����n-2����˼������ʱ�䣬һ���뵽̰���㷨
 * ÿ�ζ��ù���ʱ����̵��Ǹ��˻������ֵ�Ͳ�����ܵ����ʱ���ǣ�a[0]*(n-2)+(sum(����a)-a[0])��
 * �������������һ������̵ģ�����һ�����������������˻��ڶ԰���ʱ��a[0]�����ֵ�Ͳ������Ȼ������������˹��ţ�
 * ����ʱ��a[n-1]�������a[1]���ֵ�Ͳ���������a[0]��a[1]һ����Ż�ȥ����ʱ��a[2]�����ܵ����ʱ���ǣ�
 * a[0]*(n-3)+(sum(����a)-a[0]-a[n-2]+2*a[1])
 * �ܽ���ɣ�i���˹��ӻ������ʱ��Ӧ��Ϊ��opt[i]=min{opt[i-1]+a[0]+a[i-1],opt[i-2]+a[0]+a[i-1]+2*a[1]}��
 *�����ǿ����õݹ飬Ҳ�����ö�̬�滮������
 */
public class ThroughBridge {


	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
	        int numOfChild = sc.nextInt();
	        int[] timeCost = new int[numOfChild+1];
	 
	        for(int i=0;i<numOfChild;i++)
	        {
	            timeCost[i] = sc.nextInt();
	        }
	        Arrays.sort(timeCost);
	 
	        int[] optCost = new int[timeCost.length];
	        optCost[0] = 0;
	        optCost[1] = timeCost[1];
	        optCost[2] = timeCost[2];
	 
	        for(int i=3;i<timeCost.length;i++)
	        {
	            optCost[i] = Math.min(optCost[i-1]+timeCost[1]+timeCost[i],optCost[i-2]+timeCost[1]+2*timeCost[2]+timeCost[i]);
	        }
	        System.out.println(optCost[timeCost.length-1]);
	}
}
