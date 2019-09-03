package HuaWei;

import java.util.Scanner;

/**
 * @author 黄子玉 报文转义
 * 题目描述：实现报文的转义功能，报文中如果出现0x0A，转义成2个字节0x12 0x13,如果出现0x0B，转义成为2个字节
 * 0xAB 0xCD，其它报文字节保持不变。
 * 输入描述：1.输入报文为16进制，输入报文长度不超过127，输入报文第一个字节为报文长度，第一个字节算正式报文的一部分
 * 但是不参与转义。
 * 2.输入的报文每个字节用空格隔开。
 * 输出描述：1.输出为转义后的报文，转义后的报文长度也不超过255，输出的报文第一个字节算正式报文的一部分，为转义后
 * 报文长度。
 * 2.输出的报文内容都为大写的16进制，输出报文为16进制，不带0x前缀
 * 3.输出的每个报文用空格隔开。
 */
public class MessageEscaping {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String s=sc.nextLine();
			String[] nums=s.split(" ");
			
			StringBuffer zhuanyi=new StringBuffer("");
			int count=0;
			for(int i=1;i<nums.length;i++){
				if(nums[i].equals("A")){
					count++;
					zhuanyi.append(" 12 13");
				}else if(nums[i].equals("B")){
					count++;
					zhuanyi.append(" AB CD");
				}else{
					zhuanyi.append(" "+String.valueOf(Integer.parseInt(nums[i], 16)));
				}
			}
			String result=String.valueOf(nums.length+count).concat(zhuanyi.toString());
			System.out.println(result);
		}
	}
}
