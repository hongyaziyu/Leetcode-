package HuaWei;

import java.util.Scanner;

/**
 * @author ������ ��ˮƿ����
 * ��Ŀ�������̵�涨��������ƿ���Ի�һƿ��ˮ��С��������10����ƿ������С�ſ��Ժȼ�ƿˮ��������ƿ��
 * �����������ļ�����10�����ݣ�ÿ������ռһ�У�����һ��������n=0��ʾ���������
 * �������������ܺȵ���ƿ����
 */
public class Battle {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int num=sc.nextInt();
			if(num==0){
				break;
			}
			int total=0;
			int temp=num;
			while(temp!=0){
				if(temp==2){
					total+=1;
					break;
				}else if(temp==1){
					break;
				}else{
					int cur=temp/3;
					total+=cur;
					temp=temp-3*cur+cur;
				}
			}
			System.out.println(total);
		}
	}
}
