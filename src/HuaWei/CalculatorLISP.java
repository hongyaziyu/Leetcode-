package HuaWei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 黄子玉 仿LISP运算
 * 题目描述：LISP语言唯一的语法就是要括号配对
 * add/sub/mul/div四种运算，其中add/mul参数为两个或两个以上，sub/div参数为2
 * 例如：输入(mul 3 -7) 输出 -21
 * 输入 (add 1 2 3) 输出 6
 * 输入 (sub (mul 2 4) (div 9 3)) 输出5
 * 输入(div 1 0)  输出 error
 *输入描述：合法字符串，字符串长度不超过512
 *输出描述：合法字符串，字符包括'0'-'9'及负号或者'error'
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
		int mark=0;//定义一个mark指针来获取元素。
		int paramOne=0;
		int paramTwo=0;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c=='('){
				operStack.push(str.substring(i+1, i+4));//截取操作符
				i+=4;
				mark=i+1;
			}else if(c==')'){
				if(mark<i){
					numStack.push(Integer.valueOf(str.substring(mark, i)));//将右括号前的一位数入栈
					i++;
					mark=i+1;
				}
				paramTwo=numStack.pop();
				paramOne=numStack.pop();
				calc(numStack,operStack,paramOne,paramTwo);//根据操作符进行相应的运算并把结果压入栈中。
			}else{
				if(c==' '){
					if(mark<i){
						numStack.push(Integer.valueOf(str.substring(mark, i)));//获取空格后的一个字符入栈。
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
