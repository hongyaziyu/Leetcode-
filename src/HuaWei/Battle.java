package HuaWei;

import java.util.Scanner;

/**
 * @author 黄子玉 汽水瓶问题
 * 题目描述：商店规定：三个空瓶可以换一瓶汽水，小张手上有10个空瓶，请问小张可以喝几瓶水？答案是五瓶。
 * 输入描述：文件包含10组数据，每个数据占一行，包含一个整数。n=0表示输入结束。
 * 输出描述：输出能喝到的瓶数。
 */
public class Battle {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int num=sc.nextInt();
			if(num==0){
				break;
			}
			int total=0;
			int temp=num;
			while(temp!=0){
				if(temp==2){
					total+=1;
					break;
				}else if(temp==1){
					break;
				}else{
					int cur=temp/3;
					total+=cur;
					temp=temp-3*cur+cur;
				}
			}
			System.out.println(total);
		}
	}
}
