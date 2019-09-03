package algorithm;

import java.util.Scanner;

public class maxArea {
	//暴力解法。
	//算法时间复杂度：O（n^2） 算法空间复杂度：O（1），使用额定的空间。
	public int solution(int[] height){
		int maxarea=0;
		for(int i=0;i<height.length;i++){
			for(int j=i+1;j<height.length;j++){
				maxarea=Math.max(maxarea, Math.min(height[i], height[j])*(j-i));
			}
		}
		return maxarea;
	}
	//双指针法。
	//算法时间复杂度：O（n） 算法空间复杂度：O（1）
	//分析：求矩形面积最大，首先找最外面的两个数组成的矩形面积，然后每次将较短一边的数移向较长一边。
	public int solution1(int[] height){
		int maxarea=0,l=0,r=height.length-1;
		while(l<r){
			maxarea=Math.max(maxarea, Math.min(height[l], height[r])*(r-l));
			if(height[l]<height[r]){
				l++;
			}else{
				r--;
			}
		}
		return maxarea;
	}
	public static void main(String[] args) {
		maxArea a=new maxArea();
		int[] height={1,8,6,2,5,4,8,3,7};
		System.out.println(a.solution1(height));
		Scanner sc=new Scanner(System.in);
		int len=sc.nextInt();
		int[] height1=new int[len];
		while(sc.hasNext()){
			for(int i=0;i<len;i++){
				height1[i]=sc.nextInt();
		}
		System.out.println(a.solution(height1));
		
		
	}
}
}