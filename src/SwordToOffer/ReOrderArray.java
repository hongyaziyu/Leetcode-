package SwordToOffer;

import java.util.Vector;

/**
 * @author ������ ��������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ����������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�
 * ����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������
 * ż����ż�������λ�ò��䡣
 * ����˼·����򵥵ķ������ǰ�������ż����˳�����������ֱ�ŵ�vector�����
 * ż����vector�ӵ�����vector��ĩβ��
 */
public class ReOrderArray {
	public void reOrderArray(int[] array){
		Vector<Integer> odd=new Vector<Integer> ();
		Vector<Integer> even=new Vector<Integer> ();
		
		for(int i=0;i<array.length;i++){
			if(array[i]%2==0){
				even.add(array[i]);
			}else{
				odd.add(array[i]);
			}
		}
		odd.addAll(even);
		for(int i=0;i<array.length;i++){
			array[i]=odd.get(i);
		}
	}
}
