package HuaWei;

import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author ������ �߼�������
 * ��Ŀ���������õ��߼�������And(��ʾΪ&);Or(��ʾΪ|)��Not(��ʾΪ!)��
 * 1&1=1��1&0=0��0&1=0��0&0=0��
 * 1|1=1��1|0=1��0|1=1��0|0=0��
 * !0=1;!1=0
 * ���У����ǵ����ȼ���ϵ�ǣ���Not(��ʾΪ!)>And(��ʾΪ&)>Or(��ʾΪ|)
 * ����������1.���������м��޿ո񣬲���Ҫ���ǿո�
 * 2.�����������ʽֻ�����"0","1","(",")","&","|","!"��
 * 3.�����������ǺϷ����룬���迼�ǷǷ����롣
 * 4.�����������ʽ���ᳬ��128���ַ���
 * 5.���ſ����ظ�Ƕ�ס�
 * �������������߼������������0����1��
 */
public class LogicalCalculator {
	public static int calc(String s){
		char c;
		int a,b,val;
		Stack<Integer> numStack=new Stack<Integer>();
		Stack<Character> operStack=new Stack<Character>();
		//�������ŵı��ʽ��,!�����ȼ���ߡ�
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
	/*����һ��ʵ�ַ�ʽ��
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