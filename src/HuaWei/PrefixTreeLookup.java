package HuaWei;

import java.util.HashMap;

/**
 * @author ������ ǰ׺������
 * ��Ŀ����������ͼ��һ��Trie����ԲȦ��ʾ�ڲ��ڵ㣬ָ���ӽڵ��ÿ����ǵ�ֵ�ķ�Χ��0~255֮�䣬ÿ���ڲ��ڵ����
 * ��256�����ӽڵ㡣�����α�ʾҶ�ӽڵ㣬ÿ��Ҷ�ӽڵ�洢һ��value�����ڵ㵽Ҷ�ӽڵ�֮��·���ϵ������ַ�����һ��
 * ������key��
 * 
 * ������������1�е�����M(0<M<=2000000)��ʾLabels��HasChild��POUDS�����С��������������������������ݣ���
 * �ո������Labels����ÿ���ַ���0~255֮�䣬HasChild��POUDS����ȡֵ��0����1��
 * ��5�е�������Value����Ĵ�С��0<=N<=2000000��,���һ�б�ʾ��������ݣ�0~2^32�����ÿո�ֿ���
 * ��7������P��0<=P<=20����ʾ����key��С�����һ�б�ʾҪ���ҵ�key�ַ����飬ÿ���ַ���ȡֵ��0~255֮�䣬�ַ�֮��
 * �ÿո������
 * ������������һ��key��Ӧ��value���粻���������0.
 */

import java.util.Scanner;
 
public class PrefixTreeLookup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String m = sc.nextLine();
		//��ʾ�����С
		int M = Integer.parseInt(m);
		//����һ��3��M�еĶ�ά����
		int[][] arr = new int[3][M];
		//��ʼ����������
		for(int i=0;i<3;i++) {
			String str = sc.nextLine();
			String[] s = str.split(" "); 
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		String n = sc.nextLine();
		//Values�����С
		int N = Integer.parseInt(n);
		int[] value = new int[N];
		String values = sc.nextLine();
		String[] val = values.split(" ");
		for(int i=0;i<N;i++) {
			value[i] = Integer.parseInt(val[i]);
		}
		String kk = sc.nextLine();
		//Key�����С
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


