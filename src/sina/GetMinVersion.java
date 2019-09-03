package sina;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 黄子玉 最小版本号
 * 题目描述：输入一系列版本号，如1.1.1.1,3.3，3.3.3，2等，求出其中最小的版本号
 * 
 */
public class GetMinVersion {
	//打印最小版本号
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
	//获得最小版本号。
	public String getMinVersion(String[] list){
		String[][] arr=new String[list.length][];//注意用二维字符串数组接受。可以只定义行数不定义列数。
		for(int i=0;i<list.length;i++){
			arr[i]=list[i].split("\\.");
		}
		Arrays.sort(arr, new Comparator<String[]>() {//比较函数写的很精彩可以仔细看看。
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
	//测试函数
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
