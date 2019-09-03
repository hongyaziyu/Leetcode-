package SwordToOffer;

/**
 * @author ������ ���üӼ��˳����ӷ�
 * ��Ŀ����������������֮�ͣ�Ҫ�󲻵�ʹ��+��-��*��/����������š�
 * ����˼·��
 * ��λ������ʵ�֡�
 * step1������������㣬��������������λ������ӣ������ǽ�λ��
 * step2������λ�����㣬Ȼ������һλ�������λֵ��
 * step3�����������Ľ������num1���ѽ�λ���ֵ����num2������ѭ������λֵΪ�յ�
 * ʱ�����ѭ����num1��������֮�͡�
 */
public class Add {
	public int add(int num1,int num2){
		if(num2==0){
			return num1;
		}
		int sum=0,carry=0;
		while(num2!=0){
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		return num1;
	}
}
