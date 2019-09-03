package BeiKeZhaoFang;

import java.util.Scanner;


public class Main1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String str=sc.nextLine();
			String[] n_m=str.split(" ");
			int n=Integer.parseInt(n_m[0]);
			long m=Long.parseLong(n_m[1]);
			long[][] arr=new long[n][2];
			if(n==0){
				break;
			}
			for(int i=0;i<n;i++){
				String s=sc.nextLine();
				String[] temp=s.split(" ");
				arr[i][0]=Long.parseLong(temp[0]);
				arr[i][1]=Long.parseLong(temp[1]);
			}
			int count=0;
			for(int i=0;i<n&&m>=0;i++){
				if(arr[i][1]<=m){
					long temp=m/arr[i][1];
					if(temp<=arr[i][0]){
						count+=temp;
						m-=temp*arr[i][1];
					}else{
						m=m-arr[i][0]*arr[i][1];
						count+=arr[i][0];
					}
				}
			}
			System.out.println(count);
		}
		System.out.println(0);
	}
}