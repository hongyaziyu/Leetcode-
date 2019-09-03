package HuaWei;

import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author 黄子玉 逻辑计算器
 * 题目描述：常用的逻辑运算有And(表示为&);Or(表示为|)；Not(表示为!)。
 * 1&1=1；1&0=0；0&1=0；0&0=0；
 * 1|1=1；1|0=1；0|1=1；0|0=0；
 * !0=1;!1=0
 * 其中，它们的优先级关系是：；Not(表示为!)>And(表示为&)>Or(表示为|)
 * 输入描述：1.测试用例中间无空格，不需要考虑空格。
 * 2.测试用例表达式只会出现"0","1","(",")","&","|","!"。
 * 3.测试用例都是合法输入，无需考虑非法输入。
 * 4.测试用例表达式不会超过128个字符。
 * 5.括号可以重复嵌套。
 * 输出描述：输出逻辑运算最后结果：0或者1。
 */
public class LogicalCalculator {
	public static int calc(String s){
		char c;
		int a,b,val;
		Stack<Integer> numStack=new Stack<Integer>();
		Stack<Character> operStack=new Stack<Character>();
		//不带括号的表达式中,!的优先级最高。
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)=='!'){
				if(s.charAt(i+1)=='1'){
					s.replace(s.charAt(i+1), '0');
				}else{
					s.replace(s.charAt(i+1), '1');
				}
				s=s.substring(0, i)+s.substring(i+1);
			}
		}
		val=Integer.valueOf(s.charAt(0));
		numStack.push(val);
		for(int i=1;i<s.length();i++){
			c=s.charAt(i);
			i+=1;
			val=Integer.valueOf(s.charAt(i));
			if(c=='&'){
				if(1==val&&1==numStack.peek()){
					val=1;
				}else{
					val=0;
				}
				numStack.pop();
				numStack.push(val);
			}else{
				numStack.push(val);
				operStack.push(c);
			}
		}
		while(!operStack.empty()){
			a=numStack.peek();
			numStack.pop();
			b=numStack.peek();
			numStack.pop();
			if(a==0&&b==0){
				numStack.push(0);
			}else{
				numStack.push(1);
			}
			operStack.pop();
		}
		return numStack.peek();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Stack<Integer> kuohao=new Stack<Integer>();
		int len=str.length();
		int from,to;
		for(int i=0;i<len;i++){
			if(str.charAt(i)=='('||str.charAt(i)==')'){
				if(kuohao.empty()||str.charAt(i)==str.charAt(kuohao.peek())){
					kuohao.push(i);
				}
				else{
					from=kuohao.peek();
					to=i;
					kuohao.pop();
					int tmp=calc(str.substring(from+1, to-from-1));
					String tmpS=String.valueOf(tmp);
					str.replace(str.substring(from, to+1), tmpS);
					len=str.length();
					i=from-1;
				}
			}
		}
		int result=calc(str);
		System.out.println(result);
	}
	/*另外一种实现方式。
	 * public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = null;
		try {
			result = engine.eval(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String rs = null;
		try {
			if((Boolean)result == false) {
				rs = "0";
			}else {
				rs = "1";
			}
			System.out.println(rs);
		} catch (Exception e) {
			System.out.println(result);
		}
		sc.close();*/
}