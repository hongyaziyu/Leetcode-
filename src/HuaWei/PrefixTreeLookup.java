package HuaWei;

import java.util.HashMap;

/**
 * @author 黄子玉 前缀树查找
 * 题目描述：如下图是一颗Trie树，圆圈表示内部节点，指向孩子节点的每个标记的值的范围在0~255之间，每个内部节点最多
 * 有256个孩子节点。三角形表示叶子节点，每个叶子节点存储一个value，根节点到叶子节点之间路径上的所有字符构成一个
 * 完整的key。
 * 
 * 输入描述：第1行的数字M(0<M<=2000000)表示Labels、HasChild、POUDS数组大小，紧跟着三行是三个数组的内容，用
 * 空格隔开。Labels数组每个字符在0~255之间，HasChild、POUDS数组取值是0或者1。
 * 第5行的数字是Value数组的大小（0<=N<=2000000）,随后一行表示数组的内容（0~2^32），用空格分开。
 * 第7行数字P（0<=P<=20）表示数组key大小，随后一行表示要查找的key字符数组，每个字符的取值在0~255之间，字符之间
 * 用空格隔开。
 * 输出描述：输出一行key对应的value，如不存在则输出0.
 */

import java.util.Scanner;
 
public class PrefixTreeLookup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String m = sc.nextLine();
		//表示数组大小
		int M = Integer.parseInt(m);
		//定义一个3行M列的二维数组
		int[][] arr = new int[3][M];
		//初始化数组内容
		for(int i=0;i<3;i++) {
			String str = sc.nextLine();
			String[] s = str.split(" "); 
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		String n = sc.nextLine();
		//Values数组大小
		int N = Integer.parseInt(n);
		int[] value = new int[N];
		String values = sc.nextLine();
		String[] val = values.split(" ");
		for(int i=0;i<N;i++) {
			value[i] = Integer.parseInt(val[i]);
		}
		String kk = sc.nextLine();
		//Key数组大小
		int Key = Integer.parseInt(kk);
		int[] key = new int[Key];
		String keys = sc.nextLine();
		String[] k = keys.split(" ");
		for(int i=0;i<Key;i++){
			key[i]=Integer.parseInt(k[i]);
		}
		
		sc.close();
	}
}


