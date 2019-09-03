package HuaWei;

import java.util.Scanner;

/**
 * @author 黄子玉 
 * 题目描述：输入整数，问其二进制有多少个101子串，以及第一个101子串的位置。
 * 注意：二进制数是从右往左读。
 * 举例：84的二进制码是0010101
 * 输出：2 2
 * 总共有两个101的子串，第一个子串最后一位是在2上。
 */
public class TheNumberOf101 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String s=Integer.toBinaryString(sc.nextInt());
			String str="101";
			int count=0;
			int index=-1;
			for(int i=0;i<=s.length()-3;i++){
				if(s.substring(i, i+3).equals(str)){
					count++;
					index=i+3;
				}
			}
			if(index==-1){
				System.out.print("0 -1");
			}else{
				index=s.length()-index;
				System.out.print(count+" "+index);
			}
		}
		sc.close();
	}
}
