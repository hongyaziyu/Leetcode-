package sina;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ������ ��С�汾��
 * ��Ŀ����������һϵ�а汾�ţ���1.1.1.1,3.3��3.3.3��2�ȣ����������С�İ汾��
 * 
 */
public class GetMinVersion {
	//��ӡ��С�汾��
	public String printMinVersion(String[] arr){
		StringBuffer res=new StringBuffer();
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1){
				res.append(arr[i]).append(".");
			}else{
				res.append(arr[i]);
			}
		}
		return res.toString();
	}
	//�����С�汾�š�
	public String getMinVersion(String[] list){
		String[][] arr=new String[list.length][];//ע���ö�ά�ַ���������ܡ�����ֻ��������������������
		for(int i=0;i<list.length;i++){
			arr[i]=list[i].split("\\.");
		}
		Arrays.sort(arr, new Comparator<String[]>() {//�ȽϺ���д�ĺܾ��ʿ�����ϸ������
			public int compare(String[] a,String[] b){
				int i=0;
				while(i<a.length&&i<b.length){
					if(Integer.valueOf(a[i])>Integer.valueOf(b[i])){
						return 1;
					}else if(Integer.valueOf(a[i])<Integer.valueOf(b[i])){
						return -1;
					}
					i++;
				}
				if(i<a.length){
					return 1;
				}
				if(i<b.length){
					return -1;
				}
				return 0;
			}
		});
		return this.printMinVersion(arr[0]);
	}
	//���Ժ���
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		GetMinVersion a=new GetMinVersion();
		while(sc.hasNext()){
			String str=sc.nextLine();
			String[] s=str.split(",");
			System.out.println(a.getMinVersion(s));
		}
	}
}
