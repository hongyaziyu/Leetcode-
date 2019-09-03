package HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ������ 
 * ��Ŀ������
 * �������ڴ���1����Ȼ���У�����1����������������������Ȼ����������2,3,23�ȡ�
 * ����ȡֵ��Χ[low,high),�ҵ��÷�Χ�����е������������Щ������ʮλ��֮�ͺ͸�λ��֮�͵Ľ�Сֵ�����������С��10
 * ��ʮλ��Ϊ0.
 * ����������
 * ��һ�У�low,high ������֤����С��0����low<high�����ÿ�������ĺϷ��ԣ����û�������������0
 * ���������
 * ��Сֵ
 *
 */
public class PrimeNumber {
	public static boolean isPrime(int n){
		if(n<2){
			return false;
		}
		if(n==2){
			return true;
		}
		if(n%2==0){
			return false;
		}
		for(int i=3;i*i<=n;i+=2){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String s=sc.nextLine();
			String[] a=s.split(" ");
			int low=Integer.parseInt(a[0]);
			int high=Integer.parseInt(a[1]);
			List<Integer> nums=new ArrayList<>();
			for(int i=low;i<high;i++){
				if(isPrime(i)){
					nums.add(i);
				}
			}
			if(nums.isEmpty()){
				System.out.println(0);
			}
			int gewei=0;
			int shiwei=0;
			for(int i=0;i<nums.size();i++){
				gewei+=nums.get(i)%10;
				shiwei+=nums.get(i)/10;
			}
			System.out.println(Math.min(shiwei, gewei));
		}
	}
}
