package HuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ������ ת����Ϣ
 * ��Ŀ��������ͨѶ����У���Ⱥ��ת����Ϣ������ɢ���ܶ��������֪��m��Ⱥ������һ���˰�һ����Ϣ�����Լ����ڵ�����
 * Ⱥ���棬���Ⱥ����ÿ�����ְ���Ϣ�ٴ�ת���������е�Ⱥ���棬��������Ⱥ�������˶�ת����һ�κ���󼸸����յ�����Ϣ
 * ����������Ϣ���ˣ�������յ���Ϣ��������
 * ����������
 * ����һ����Ϣ������
 * Ⱥ�����m
 * Ⱥ��1��Ա�����б�
 * Ⱥ��2��Ա�����б�
 * ...
 * Ⱥ��m��Ա�����б�
 * ���������
 * ��ʮ��������ʾ���������ظ��յ���Ϣ��������
 * ������
 * Jack
 * 3
 * Jack,Tom,Anny,Lucy
 * Tom,Danny
 * Jack,Lily
 * �����
 * 6
 */
public class ForwardingMessage {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String transmit=sc.nextLine();
			int m=Integer.parseInt(sc.nextLine());
			String[] group=new String[m];
			int max=Integer.MIN_VALUE;
			for(int i=0;i<m;i++){
				group[i]=sc.nextLine();
				max=group[i].split(",").length>max ? group[i].split(",").length:max;
			}
			String[][] input=new String[m][max];
			for(int i=0;i<m;i++){
				for(int j=0;j<group[i].split(",").length;j++){
					String[] temp=group[i].split(",");
					input[i][j]=temp[j];
				}
			}
			ArrayList<String> list=new ArrayList<>();
			HashMap<String,Integer> map=new HashMap<>();
			
			list.add(transmit);//��һ������洢���������ڵ�Ⱥ�顣
			map.put(transmit, 1);//�洢���������жϡ�
			int flag=0;
			
			while(flag<list.size()&&list.get(flag)!=null){
				for(int i=0;i<m;i++){
					for(int j=0;j<max;j++){
						if(input[i][j]!=null&&input[i][j].equals(list.get(flag))){
							method(list,map,i,input);
						}
					}
				}
				flag++;
			}
			System.out.println(map.size());
			map.clear();
			list.clear();
		}
	}

	private static void method(ArrayList<String> list, HashMap<String, Integer> map, int row, String[][] input) {
		for(int i=0;i<input[row].length;i++){
			if(input[row][i]!=null&&!map.containsKey(input[row][i])){
				map.put(input[row][i], 1);
				list.add(input[row][i]);//��������һ�ν��յ���Ϣ���˼�����һ�δ�����
			}
		}
	}
}
