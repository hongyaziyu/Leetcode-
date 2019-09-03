package BeiKeZhaoFang;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.nextLine();
			String[] n_S=str.split(" ");
			int n=Integer.parseInt(n_S[0]);
			int S=Integer.parseInt(n_S[1]);
			int[] c=new int[n];
			String temp=sc.nextLine();
			String[] tempString=temp.split(" ");
			for(int i=0;i<n;i++){
				c[i]=Integer.parseInt(tempString[i]);
			}
			Arrays.sort(c);
			int result=0;
			while(S>=0&&result<n){
				S=S-c[result];
				result++;
			}
			if(S>=0){
			System.out.println(result);
			}else{
				System.out.println(result-1);
			}
		}
	}
}
