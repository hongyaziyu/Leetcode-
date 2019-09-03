package SwordToOffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ������ ��ΪS����������
 * ��Ŀ����������һ����������������һ������S���������в�����������ʹ�����ǵĺ�
 * ������S������ж�ԣ�����������ĳ˻���С�ġ�
 * ����˼·��
 * ����1����ϣ����
 * ��һ��HashMap������key�洢��S��������ÿ�����Ĳvalue�洢��ǰ�����֡�
 * ���Ǳ������飬�ж�hashmap�е�key�Ƿ���ڵ�ǰ�����֣�������ڣ�˵����������һ����
 * �뵱ǰ������Ӻ�ΪS�����ǾͿ����ж����ǵĳ˻��Ƿ�С��֮ǰ�ĳ˻������С�Ļ����滻
 * �����Ļ��ͷ�����ǰ�ҵġ����hashmap �е� key �����ڵ�ǰ�����֣�
 * ˵����û���ҵ���Ӻ�Ϊ S �����������ǾͰ�S�뵱ǰ���ֵĲ���Ϊ key��
 * ��ǰ������Ϊ value ���뵽 hashmap �У�����������
 * 
 * ����2�����ҼбƷ�
 * a+b=sum��a��bԽԶ�˻�ԽС����Ϊ�����ǵ�������
 * ����һͷһβ����ָ�����ڿ����ķ����ҵ��ľ��ǳ˻���С�������
 * ��ai+aj==sum,˵�����Ǵ𰸣����ԽԶ�˻�ԽС��
 * ��ai+aj>sum,˵��aj̫���ˣ�j--��
 * ��ai+aj<sum��˵��ai̫С�ˣ�i++��
 */
public class FindNumbersWithSum {
	//����1����ϣ��
	public ArrayList<Integer> findNumberWithSum(int[] array,int sum){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(array.length<2){
			return res;
		}
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int less=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				if(array[i]*map.get(array[i])<less){
					less=array[i]*map.get(array[i]);
					res.clear();
					res.add(map.get(array[i]));
					res.add(array[i]);
				}else{
					int key=sum-array[i];
					map.put(key, array[i]);
				}
			}
		}
		return res;
	}
	//����2���бƷ�
	public ArrayList<Integer> findNumbersWithSum1(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(array.length < 2)
            return res;
        int i = 0, j = array.length - 1;
        while(i!=j){
        	if(array[i]+array[j]==sum){
        		res.add(array[i]);
        		res.add(array[j]);
        		break;
        	}else if(array[i]+array[j]<sum){
        		i++;
        	}else{
        		j--;
        	}
        }
        return res;
	}
}
