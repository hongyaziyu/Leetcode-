package HuaWei;

import java.util.Scanner;

/**
 * @author ������ 
 * ��Ŀ��������������������������ж��ٸ�101�Ӵ����Լ���һ��101�Ӵ���λ�á�
 * ע�⣺���������Ǵ����������
 * ������84�Ķ���������0010101
 * �����2 2
 * �ܹ�������101���Ӵ�����һ���Ӵ����һλ����2�ϡ�
 */
public class TheNumberOf101 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String s=Integer.toBinaryString(sc.nextInt());
			String str="101";
			int count=0;
			int index=-1;
			for(int i=0;i<=s.length()-3;i++){
				if(s.substring(i, i+3).equals(str)){
					count++;
					index=i+3;
				}
			}
			if(index==-1){
				System.out.print("0 -1");
			}else{
				index=s.length()-index;
				System.out.print(count+" "+index);
			}
		}
		sc.close();
	}
}
