package HuaWei;

import java.util.Scanner;

/**
 * @author ������ ������ת���
 * ��������������a��b����ת�͡�
 * ���磺reverseAdd��123,456��==321+654==975.
 * ����������a,b����[1,70000]�����ϵ���������
 * 100��200��ת��ֵΪ1��2
 * �����������a����bС��1���ߴ���70000�������-1��
 * һ�����������͡�
 */
public class IntegerInversionSummation {
	public int integerInversionSummation(int a,int b){
		if(a<1||a>70000){
			return -1;
		}else
		if(b<1||b>70000){
			return -1;
		}else{
		int sum=reverse(a)+reverse(b);
		return sum;}
	}

	private int reverse(int yuanshu) {
		int zhuanhuan=0;
		while(yuanshu!=0){
			int yushu=yuanshu%10;
			zhuanhuan=yushu+zhuanhuan*10;
			yuanshu=yuanshu/10;
		}
		return zhuanhuan;
	}
	//���Ժ���
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String[] nums=s.split(",");
		int a=Integer.parseInt(nums[0]);
		int b=Integer.parseInt(nums[1]);
		IntegerInversionSummation d=new  IntegerInversionSummation();
		System.out.println(d.integerInversionSummation(a, b));	
	}
}
