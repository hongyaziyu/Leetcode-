package KuaiShou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ������ �汾�Ƿ�����
 * ��Ŀ���������������汾�ţ�ֻ���ڰ汾�Ÿ��ߵ�ʱ��ſ����������汾����ֻ������.�š�
 * ���磺0.1<1.1
 * 1.2<13.37
 * ��������������m��ʾ����������������m�н���m�β�ѯ��
 * �����true����false
 * ����˼·����ǰ�����жϣ����ǰ��������ں���������������������������������һ�����ȽϽϳ����Ǹ��汾�Ƿ����0���������
 * �����������
 *
 */
public class VersionUpgrade {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine().trim());
		for(int i=0;i<n;i++){
			String temp=sc.nextLine();
			doWork(temp);
		}
	}

	private static void doWork(String temp) {
		String[] s=temp.split(" ");
		int[] s1=Arrays.stream(s[0].split("\\.")).mapToInt(Integer::parseInt).toArray();//stream��������mapToInt��ת�����������ַ���ת��Int���ͣ�toArray()�����յ��ն˲����������������int�͵����顣
		int[] s2=Arrays.stream(s[1].split("\\.")).mapToInt(Integer::parseInt).toArray();
        int min=s1.length<s2.length?s1.length:s2.length;
        int i=0;
        for(;i<min;i++){
        	if(s1[i]<s2[i]){
        		System.out.println("true");
        		return;
        	}
        	if(s1[i]>s2[i]){
        		System.out.println("false");
        		return;
        	}
        }
        if(i==min){
        	if(s1.length==min){
        		long count=Arrays.stream(Arrays.copyOfRange(s2, min, s2.length)).filter(x->x!=0).count();//�Բ�Ϊ0���������м�����
        		if(count>0){//������������汾����ǰ��汾�ȼ����������汾
        			System.out.println("true");
        			return;
        		}
        	}else{//�����С����s2����˵��s1�İ汾Ҫ�ߣ���һ������������
        		System.out.println("false");
        	}
        }
	}
}
