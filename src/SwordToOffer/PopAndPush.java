package SwordToOffer;

import java.util.Stack;

/**
 * @author ������ ջ��ѹ�롢��������
 * ��Ŀ���������������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�
 * Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��
 * ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2��
 * �������Ǹ�ѹջ���еĵ������С�
 * ����˼·��ģ��Ѳ����Ĺ��̣���ԭ��������ѹջ����ջ��Ԫ������������ջ������ȣ�
 * �����ͬ���ջ�������ͬ�����ѹջ��ֱ��ԭ��������������ѹջ��ϡ���󣬼��ջ
 * �Ƿ�Ϊ�գ�������˵���ǶԵģ������Ǵ�ġ�
 */
public class PopAndPush {
	public boolean isPopOrder(int[] pushA,int[] popA){
		if(pushA.length!=popA.length||
				pushA.length==0||
				popA.length==0){
			return false;
		}
		Stack<Integer> stack=new Stack<Integer>();
		int index=0;
		for(int i=0;i<pushA.length;i++){
			stack.push(pushA[i]);
			while(!stack.empty()&&stack.peek()==popA[index]){
				stack.pop();
				index++;
			}
		}
		return stack.empty();
	}
	//���Ժ���
	public static void main(String[] args) {
		int[] push={1,2,3,4,5};
		int[] pop1={4,5,3,2,1};
		int[] pop2={4,3,5,1,2};
		PopAndPush a=new PopAndPush();
		System.out.println(a.isPopOrder(push, pop1));
		System.out.println(a.isPopOrder(push, pop2));
	}
}
