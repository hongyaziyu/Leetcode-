package BeiKeZhaoFang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ������
 * ������N����Ʒ����i����Ʒ������ΪWi������Ҫ����Щ��Ʒ�ֳ����ѣ�ʹ����"��һ����Ʒ����������ڶ�����Ʒ������������
 * С"��ǰ���£�������Ʒ������֮����ܴ���ô��������Ʒ��������֮����С�Ƕ��٣���������֮����С��ǰ���£���Ʒ����
 * ֮���Ƕ��٣�
 * ���룺
 * ��һ�а���һ������N��N����2��100
 * �ڶ��а���w1��wn
 * �����
 * ������
 * ������
 * ���룺
 * 6
 * 1 2 3 4 5 6
 * �����
 * 1 2
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.nextLine();
			int N=Integer.parseInt(str);
			String s=sc.nextLine();
			int[] w=new int[N];
			for(int i=0;i<N;i++){
				w[i]=Integer.parseInt(s.split(" ")[i]);
			}
			Arrays.sort(w);
			int sum=0;
			for(int i=0;i<N;i++){
				sum+=w[i];
			}
			int temp=0;
			int j=N-1;
			while(temp<=sum/2&&j>=0){
				temp+=w[j];
				j--;
			}
			int valueDifference=Math.abs(sum-temp-temp);
			int quantityDifference=Math.abs(N-2*(j+1));
			System.out.println(valueDifference+" "+quantityDifference);
		}
	}
}
