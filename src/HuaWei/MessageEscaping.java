package HuaWei;

import java.util.Scanner;

/**
 * @author ������ ����ת��
 * ��Ŀ������ʵ�ֱ��ĵ�ת�幦�ܣ��������������0x0A��ת���2���ֽ�0x12 0x13,�������0x0B��ת���Ϊ2���ֽ�
 * 0xAB 0xCD�����������ֽڱ��ֲ��䡣
 * ����������1.���뱨��Ϊ16���ƣ����뱨�ĳ��Ȳ�����127�����뱨�ĵ�һ���ֽ�Ϊ���ĳ��ȣ���һ���ֽ�����ʽ���ĵ�һ����
 * ���ǲ�����ת�塣
 * 2.����ı���ÿ���ֽ��ÿո������
 * ���������1.���Ϊת���ı��ģ�ת���ı��ĳ���Ҳ������255������ı��ĵ�һ���ֽ�����ʽ���ĵ�һ���֣�Ϊת���
 * ���ĳ��ȡ�
 * 2.����ı������ݶ�Ϊ��д��16���ƣ��������Ϊ16���ƣ�����0xǰ׺
 * 3.�����ÿ�������ÿո������
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
