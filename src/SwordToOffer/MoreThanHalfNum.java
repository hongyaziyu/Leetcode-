package SwordToOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ������ �����г��ִ�������һ�������
 * ��Ŀ��������������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����
 * 5�Σ��������鳤�ȵ�һ�룬�����2�������ھ����0.
 * ����˼·��
 * ���ֽⷨ��
 * 1.����HashMap�洢����ÿ�������ֵĴ���������Ƿ������ֳ��ִ����������鳤��
 * ��һ�롣
 * 2.����������������ĳ�����ֳ��ִ����������鳤�ȵ�һ�룬��һ�����������м�
 * ��λ�ã�����ȡ�����ͳ��һ�³��ֵĴ����Ƿ�������鳤�ȵ�һ�롣
 * 3.ĳ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬
 * ��˼���������ֵĴ����������������ֳ��ֵĴ����ͻ�Ҫ�ࡣ
 * ������ǿ����ڱ��������ʱ���¼����ֵ��1. �����е�����;2. ������
 * ������һ������ʱ��������֮ǰ�����������ͬ���������1�����������1��
 * ������Ϊ0���򱣴���һ�����֣�����������Ϊ1����������������������ּ�Ϊ����
 * ������ж����Ƿ����������
 */
public class MoreThanHalfNum {
	//����һ��HashMap����
	public int moreThanHalfNum_1(int[] array){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int length=array.length;
		for(int i=0;i<length;i++){
			if(!map.containsKey(array[i])){
				map.put(array[i], 1);
			}else{
				map.put(array[i], map.get(array[i])+1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			if(entry.getValue()*2>length){
				return entry.getKey();
			}
		}
		return 0;
	}
	//����2
	public int moreThanHalfNum_2(int[] array){
		Arrays.sort(array);
		int half=array.length/2;
		int count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==array[half]){
				count++;
			}
		}
		if(count>half){
			return array[half];
		}else{
			return 0;
		}
	}
	//����3
	public int moreThanHalfNum_3(int[] array){
		int res=array[0],count=1;
		for(int i=1;i<array.length;i++){
			if(array[i]==res){
				count++;
			}else{
				count--;
			}
		}
		count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==res){
				count++;
			}
		}
		return count>array.length/2 ? res:0;
	}
}
