package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 * ʱ�䣺2019/07/06 22:00
 * ������Լɪ�����⣺0,1,...,n-1��n������Χ��һȦ��������0��ʼ��ÿ��ɾ��Բ���е�m�����֣�ɾ����ɺ���һ������
 * �ִ�0��ʼ������
 * ������0->1->2->3->4->0;ÿ��ɾ�����������֣���ô����ɾ������2��0��4��1,����ʣ��������3��
 * ������Ŀ����һ�֣����Ľⷨ���û���������ģ��ԲȦ��
 * �ڶ��ֽⷨ����̬�滮�ķ���������˵�ݹ�ķ�������f(n,m)��ʾ���һ����ɾ�������֣���һ�α�ɾ����������(m-1)%n.
 * ���������Ϊk��ڶ���ɾ����ʼ�������±�����ԭ�ȵ�������0,1,2,...,k-1,k+1,...,n-1����k+1���¿�ʼ������
 * k+1->0
 * k+2->1
 * ...
 * n-1->n-k-2
 * 0  ->n-k-1
 * 1  ->n-k
 * ...
 * k-1->n-2
 * �����Ӧӳ���ϵΪp(x)=(x-k-1)%n,��ӳ���ϵΪq(x)=(x+k+1)%n��
 * f(n-1,m)=q[f(n-1,m)]=[f(n-1,m)+k+1]%n,��k=(m-1)%n���룬�õ�f(n,m)=f(n-1,m)=[f(n-1,m)+m]%n
 * ��ʼ�����϶���n=1,f(n,m)=0.
 */
public class CircleNumber {
	/**
     * Լɪ�򻷣���֪n����(�Ա��1��2��3...n�ֱ��ʾ)Χ����һ��Բ����Χ��
     * �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;������һ�����ִ�1��ʼ������
     * ����m���Ǹ����ֳ���;���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
     * 
     * @param n �˵�����
     * @param start ��ʼ��������ţ�start < n
     * @param m ���еı��(���Դ���n)
     */
	public static void josephRing(int n,int start,int m){
		List<Integer> list=new ArrayList<Integer>();
		//��ʼ���б�
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		while(list.size()>0){
			for(int j=1;j<m;j++){
				list.add(list.remove(start));
			}
			System.out.println(list.remove(start));
		}
	}
	
	public static int josephRing(int n,int m){
		if(n<1||m<1){
			return -1;
		}
		int last=0;
		for(int i=2;i<=n;i++){
			last=(last+m)%i;
		}
		return last+1;
	}
	
	 public static void main(String[] args){
	        josephRing(5,0,3);
	        System.out.println(josephRing(5,3));
	    }
}
