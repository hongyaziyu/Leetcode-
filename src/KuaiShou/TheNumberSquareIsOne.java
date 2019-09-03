package KuaiShou;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ������ ��λƽ����Ϊ1������
 * ��Ŀ������ȡһ������ÿһλ��ƽ����͵õ�������Ȼ�����������ȡ��λƽ����ͣ�ֱ��ƽ����Ϊ1����true�����򷵻�false
 * ������
 * ���룺19
 * �����true
 * ԭ��1^2+9^2=82;
 *      8^2+2^2=68;
 *      6^2+8^2=100;
 *      1^2+0^2+0^2=1;
 * ����˼·��ÿ�μ�¼�������������1�򷵻�true���������г�����ͬ���������ѭ����ֱ�ӷ���false��
 */
public class TheNumberSquareIsOne {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int m=sc.nextInt();
			int[] nums=new int[m];
			for(int i=0;i<m;i++){
				nums[i]=sc.nextInt();
			}
			for(int i=0;i<m;i++){
				doWork(nums[i]);
			}
		}
	}

	public static void doWork(int num) {
		int sum=0;
		String temp=String.valueOf(num);
		ArrayList<String> list=new ArrayList<String>();
		while(true){
			sum=0;
			list.add(temp);//һֱ������Ľ���ŵ�list���档
			for(int i=0;i<temp.length();i++) {
				sum += (int) Math.pow(temp.charAt(i) - '0', 2);
			}
			if (sum == 1) {
				System.out.println("true");//�����1�򷵻�true��
			break;
			}
			temp=Integer.toString(sum);
			for(String s:list) {
				if (s.equals(temp)) {//����б�������Ԫ���򷵻�false��
					System.out.print("false");
					return;
				}
		    }
		}
	}
}
