package HuaWei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ������ ��LISP����
 * ��Ŀ������LISP����Ψһ���﷨����Ҫ�������
 * add/sub/mul/div�������㣬����add/mul����Ϊ�������������ϣ�sub/div����Ϊ2
 * ���磺����(mul 3 -7) ��� -21
 * ���� (add 1 2 3) ��� 6
 * ���� (sub (mul 2 4) (div 9 3)) ���5
 * ����(div 1 0)  ��� error
 *�����������Ϸ��ַ������ַ������Ȳ�����512
 *����������Ϸ��ַ������ַ�����'0'-'9'�����Ż���'error'
 */
public class CalculatorLISP {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		calculatorLISP(line);
		sc.close();
	}

	private static void calculatorLISP(String str) {
		Stack<Integer> numStack=new Stack<Integer> ();
		Stack<String> operStack=new Stack<String> ();
		int mark=0;//����һ��markָ������ȡԪ�ء�
		int paramOne=0;
		int paramTwo=0;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c=='('){
				operStack.push(str.substring(i+1, i+4));//��ȡ������
				i+=4;
				mark=i+1;
			}else if(c==')'){
				if(mark<i){
					numStack.push(Integer.valueOf(str.substring(mark, i)));//��������ǰ��һλ����ջ
					i++;
					mark=i+1;
				}
				paramTwo=numStack.pop();
				paramOne=numStack.pop();
				calc(numStack,operStack,paramOne,paramTwo);//���ݲ�����������Ӧ�����㲢�ѽ��ѹ��ջ�С�
			}else{
				if(c==' '){
					if(mark<i){
						numStack.push(Integer.valueOf(str.substring(mark, i)));//��ȡ�ո���һ���ַ���ջ��
						mark=i+1;
					}
				}
			}
		}
		while(!operStack.isEmpty()){
			paramTwo=numStack.pop();
			paramOne=numStack.pop();
			calc(numStack,operStack,paramOne,paramTwo);
		}
		System.out.println(numStack.pop().toString());
	}

	private static void calc(Stack<Integer> numStack, Stack<String> operStack, int paramOne, int paramTwo) {
		switch(operStack.pop()){
		case "add":
			numStack.push(paramOne+paramTwo);
			break;
		case "sub":
			numStack.push(paramOne-paramTwo);
			break;
		case "mul":
			numStack.push(paramOne*paramTwo);
			break;
		case "div":
			if(paramTwo==0){
				System.out.println("error");
			}else{
				numStack.push(paramOne/paramTwo);
			}
			break;
		}
		
	}
}
