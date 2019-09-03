package HuaWei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ������  ��ȡʣ������ַ���
 * ��Ŀ���������������ַ�����һ��Ϊȫ���ַ�����һ��Ϊ��ռ���ַ�����Ҫ�����ʣ������ַ�����
 * �����������������ȫ���ַ�������ռ���ַ����������ַ�����@���ӡ�@ǰΪȫ���ַ�����@��Ϊ��ռ���ַ�����
 * �ַ������ַ���ʾΪ���ּ��ַ�����ʽ���ַ���������ð�Ÿ���������a:1����ʾ1��a�ַ����ַ�ֻ����Ӣ����ĸ�����ִ�Сд
 * ����ֻ���������Σ�����������100�����һ���ַ���û��ռ�ã�@�ַ���Ȼ���ڣ����磺a:3,b:5,c:2@
 * ��������������ַ�����������س����С�
 * ʵ����  ���� a:3,b:5,c:2@a:1,b:2
 *       ��� a:2,b:3,c:2
 * ����˼·���������뵽����@��,�������ָ��ַ���������hashmap���洢��ֵ����������
 */
public class GetTheRemainingAvailableCharacterSet {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(str.charAt(str.length()-1)=='@'){
			System.out.println(str.substring(0, str.length()-1));
			return;
		}
		getTheRemainingAvailableCharacterSet(str);
	}

	private static void getTheRemainingAvailableCharacterSet(String str) {
		String q=str.split("@")[0];
		String s=str.split("@")[1];
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		//����ȫ���ַ���
		String[] q1=q.split(",");
		int length1=q1.length;
		for(int i=0;i<length1;i++){
			String temp=q1[i];
			String[] temp1=temp.split(":");
			map.put(temp1[0], Integer.parseInt(temp1[1]));
		}
		//������ռ���ַ���
		String[] s1=s.split(",");
		int length2=s1.length;
		for(int i=0;i<length2;i++){
			String temp=s1[i];
			String[] temp1=temp.split(":");
			int result=map.get(temp1[0])-Integer.parseInt(temp1[1]);
			map.put(temp1[0], result);//ע����HashMap�ĵײ�ԭ���֪��key�ظ��Ḳ�ǣ�value�����ظ���
		}
		//��ӡʣ���ַ���
		StringBuffer sb=new StringBuffer("");
		for(int k=0;k<length1;k++){
			String zifu=q1[k].split(":")[0];
			int number=map.get(zifu);
			if(number!=0){    //ע�����ʣ���ַ�Ϊ��Ͳ���Ҫ��ӡ�ˡ�
				sb.append(zifu+":"+number+",");
			}
		}
		String remaining=sb.toString();
		System.out.println(remaining.substring(0, remaining.length()-1));
	}
}
