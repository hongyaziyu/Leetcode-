package HuaWei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author ������ �����ظ�����
 * ��Ŀ����������һ�������������������ظ������Ժ�����������
 * ���������������������ǳ�������
 * ��������������ظ������Ժ�����������
 * ����������423234
 * ���������432
 * ����˼·��1.���Ƚ��ַ���ȥ�غ�õ���������һ����СС��10�������С�
 * 2.ö�ٳ���������Щ������ɵ�����
 * 3.����Щ������TreeSet���ϡ�
 * 4.����TreeSet���ϣ��ж�Ԫ���Ƿ���ԭʼ���г��ֹ�����û��������ɾ����
 * 5.���ȡ��TreeSet�����һ��Ԫ�ؾ������������
 */
public class EliminateDuplicateNumbers {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TreeSet<Integer> set=new TreeSet<Integer>();
		String[] strArr;
		int k=0;
		Long maxNum=0L;//0L��ʾ������0 int������������ֽڡ�long���ܱ�ʾ�����ֽڵ�����
		int st=0;
		TreeMap<Long,Boolean> map=new TreeMap<Long,Boolean>();
		while(sc.hasNext()){
			String line=sc.nextLine();
			//���Ƚ��ַ���ȥ�غ�õ���������һ����СС��10�������С�
			for(int i=0;i<line.length();i++){
				set.add(Character.getNumericValue(line.charAt(i)));
			}//������TreeSet����û���ظ�Ԫ�ص��ص�
			strArr=new String[set.size()];
			for(Integer in:set){
				strArr[k]=in+"";
				k++;
			}
			//ö�ٳ�����Щ������ɵ���������Щ������TreeSet�����С�
			permutate(strArr,st,map);//������TreeSet������ص㡣
			//����TreeSet���ϣ��ж�Ԫ���Ƿ���ԭʼ���г��ֹ�����û��������ɾ����
			for(Map.Entry<Long, Boolean> entry:map.entrySet()){
				Long key=entry.getKey();
				boolean isFind=findStrByKey(line,key);
				if(isFind){
					map.put(key, true);
				}
			}
			//���ȡ��TreeMap�����һ��Ԫ�ؾ��������������ΪTreeSet������ģ����һ��Ԫ�������ġ�
			for(Map.Entry<Long,Boolean> entry:map.entrySet()){
				if(entry.getValue()){
					maxNum=entry.getKey();
				}
			}
			System.out.println(maxNum);
		}
	}

	private static void permutate(String[] strArr, int st, TreeMap<Long, Boolean> map) {
		if(st == strArr.length-1){
			// ����ǰ�ַ��������ʾ����������set��
			StringBuilder sb = new StringBuilder();
			// ��ӡ��ǰ�ַ���
			for (int i = 0; i < strArr.length; i++) {
			String string = strArr[i];
			// System.out.print(string + "");
			sb.append(string);
			}
			// System.out.println();
			String s = sb.toString();
			map.put(new Long(s), false);
			}else {
			for(int i=st ; i<strArr.length ; i++){
			swap(strArr, i, st);
			permutate(strArr, st + 1, map);
			swap(strArr, i, st);
			}
			}
	}

	private static void swap(String[] strArr, int i, int st) {
		String temp = strArr[i];
		strArr[i] = strArr[st];
		strArr[st] = temp;
	}

	private static boolean findStrByKey(String line, Long key) {
		String keyStr=key.toString();
		String[] temp=new String[keyStr.length()];
		int k=0;
		int j=0;
		for(int i=0;i<keyStr.length();i++){
			temp[i]=keyStr.charAt(i)+"";
			// temp[i] = Character.getNumericValue(keyStr.charAt(i)) +  "";
		}
		while(k<temp.length){
			while(j<line.length()){
			if(temp[k].equals(line.charAt(j)+"")){
			k++;
			j++;
			break;
			}
			j++;
			}
			if(j==line.length()){
			break;
			}
		}
		// �����ж�k�Ƿ񵽴�ĩβ�Ϳ�֪�治���ڣ�
		if(k==temp.length){
		return true;
		}
		return false;
	}
	
}
