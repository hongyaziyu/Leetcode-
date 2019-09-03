package algorithm;

import java.util.Arrays;

public class DailyTemperatures {

	public static int[] dailyTemperatures(int[] T){
		if(T==null || T.length==0){
			return T;
		}
		int[] result=new int[T.length];
		for(int i=0;i<T.length;i++){
			for(int j=i+1;j<T.length;j++){
				if(T[j]>T[i]){
					result[i]=j-i;
					break;
				}
			}
		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] result=DailyTemperatures.dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(result));

	}

}
