package HuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 黄子玉 转发消息
 * 题目描述：在通讯软件中，在群里转发消息可以扩散到很多人那里，已知有m个群，其中一个人把一条消息发到自己所在的所有
 * 群里面，这个群里面每个人又把消息再次转发到他所有的群里面，请问所有群的所有人都转发过一次后，最后几个人收到该消息
 * （包括发消息的人）？输出收到消息的人数。
 * 输入描述：
 * 发第一条消息的人名
 * 群组个数m
 * 群组1成员人名列表
 * 群组2成员人名列表
 * ...
 * 群组m成员人名列表
 * 输出描述：
 * 以十进制数表示，不包含重复收到消息的人数。
 * 举例：
 * Jack
 * 3
 * Jack,Tom,Anny,Lucy
 * Tom,Danny
 * Jack,Lily
 * 输出：
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
			
			list.add(transmit);//建一个数组存储发送人所在的群组。
			map.put(transmit, 1);//存储人数加上判断。
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
				list.add(input[row][i]);//传播到第一次接收到信息的人继续下一次传播。
			}
		}
	}
}
