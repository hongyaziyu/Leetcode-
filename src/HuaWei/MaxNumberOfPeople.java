package HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

/**
 * @author ������ ����������
 * ��Ŀ�������ٰ�һ��8��Сʱ�ľۻᣬʱ��δ�12:00��20:00�㣬�����õĿ�����д�����ʱ����뿪��ʱ�䣬Ϊ�����վۻ�
 * �ڼ���λ����Ŀ���ȹ��Ʋ�ͬʱ���������������
 * 1.�����ʱ����뿪��ʱ�䣬��������㣬���硰12,18����ʾ����ʱ��Ϊ12���13��ǰ���뿪ʱ��Ϊ17���18��ǰ��
 * 2.��Сʱ����ͳ�ƿ���������
 * 3.��������Ŀ������100����
 */
public class MaxNumberOfPeople {
	public static List<String> list=new ArrayList<String>();
	public static void main(String[] args) {
		String[] str={"12,15","16,17","12,20"};
		for(int i=0;i<str.length;i++){
			reset(str[i]);//����д������һ����ʽ������[12,15)д��[12,13),[13,14),[14,15)
		}
		Hashtable<String,Integer> wordCount=wordcount();//ͳ�Ƴ�ÿ��ʱ��ε�����.
		List<String> newList=new ArrayList<String>();
		for(String key:wordCount.keySet()){//�ĳɹ淶��ʽ���
			newList.add("["+key+")"+":"+wordCount.get(key));
		}
		//����
		Collections.sort(newList, new Comparator<Object>(){
			public int compare(Object o1,Object o2){
				String str1=(String) o1;
				String str2=(String) o2;
				if(str1.compareToIgnoreCase(str2)<0){//compareToIgnoreCase()�������ڰ��ֵ�˳��Ƚ������ַ����������Ǵ�Сд��str1����str2���򷵻ش���0��ֵ��
					return -1;
				}
				return 1;
			}
		});
		for(int i=0;i<newList.size();i++){
			System.out.println(newList.get(i));
		}
	}

	private static Hashtable<String, Integer> wordcount() {
		 Hashtable<String, Integer>  wordCount = new Hashtable<String, Integer>();
	        for (int i = 0; i < list.size(); i++) {
	            String str = list.get(i);
	            if (!wordCount.containsKey(str)) {
	                wordCount.put(str, Integer.valueOf(1));
	            } else {
	                wordCount.put(str, Integer.valueOf(wordCount.get(str).intValue() + 1));
	            }
	        }
	        return wordCount;
	}

	private static void reset(String str) {
		String[] aa=str.split(",");
		int inter=Integer.parseInt(aa[1])-Integer.parseInt(aa[0]);
		for(int i=0;i<inter;i++){
			int newString=Integer.parseInt(aa[0])+i;
			list.add(newString+","+(newString+1));
		}
	}
}
