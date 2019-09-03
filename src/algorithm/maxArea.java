package algorithm;

import java.util.Scanner;

public class maxArea {
	//�����ⷨ��
	//�㷨ʱ�临�Ӷȣ�O��n^2�� �㷨�ռ临�Ӷȣ�O��1����ʹ�ö�Ŀռ䡣
	public int solution(int[] height){
		int maxarea=0;
		for(int i=0;i<height.length;i++){
			for(int j=i+1;j<height.length;j++){
				maxarea=Math.max(maxarea, Math.min(height[i], height[j])*(j-i));
			}
		}
		return maxarea;
	}
	//˫ָ�뷨��
	//�㷨ʱ�临�Ӷȣ�O��n�� �㷨�ռ临�Ӷȣ�O��1��
	//��������������������������������������ɵľ��������Ȼ��ÿ�ν��϶�һ�ߵ�������ϳ�һ�ߡ�
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