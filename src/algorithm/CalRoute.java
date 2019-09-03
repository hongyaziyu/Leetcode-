package algorithm;

import java.util.Scanner;

public class CalRoute {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int ans=0;
        while (sc.hasNextInt()) {
            int H = sc.nextInt();
            int n = sc.nextInt();
            
            System.out.println(calRoute(H, n));}
    }
    public static double calRoute(int H,int n){
        double result=0;
        if(n==1){
        	return H;
        }
        for(int i=1; i<=n-1;i++){
            double route=2*H/(2*i);
            result+=route;
        }
        return result+H;
    }
}
