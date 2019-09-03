package HuaWei;

import java.util.Stack;

/**
 * @author 黄子玉 括号匹配
 * 题目描述：给定一个字符串，里面可能包含“()”、"{}"、"[]"三种括号，请编写程序检查括号是否成对出现，且嵌套关系正确。
 * 
 *
 */
public class BracketMatch {
	private static final String HashMap = null;
	public boolean isMatch(String s){
		Stack<Character> stack=new Stack<Character>();
		char[] ch=s.toCharArray();
		for(int i=0;i<ch.length;i++){
			//如果字符不是右括号则进栈
			if(ch[i]!='}'&&ch[i]!=']'&&ch[i]!=')'){
				stack.push(ch[i]);
			}else{
				//如果字符是右括号，但栈顶不是左括号则一直出栈。
				while(stack.peek()!='{'&&stack.peek()!='('&&stack.peek()!='['){
					stack.pop();
				}
				//如果字符是右大括号且栈顶为左大括号则出栈。
				if(ch[i]=='}'&&stack.peek()=='{'){
					stack.pop();
				//如果字符是右中括号且栈顶为左中括号则出栈。
				}else if(ch[i]==']'&&stack.peek()=='['){
					stack.pop();
				//如果字符是右小括号且栈顶为左小括号则出栈。
				}else if(ch[i]==')'&&stack.peek()=='('){
					stack.pop();
				//其他情况则入栈(尤其注意这种情况，这种情况常发生在括号不匹配的时候就入栈)即括号不匹配的时候。
				}else{
					stack.push(ch[i]);
				}
			}
		}
		//此判断针对表达式第一个字符不是括号时，如：3+(3*{(3+2）*34+[(3+2)*3+6])
		while(!stack.empty()){
			if(stack.peek()!='{'&&stack.peek()!='['&&stack.peek()!='('){
				stack.pop();
			}else{
				break;
			}
		}
		if(stack.empty()){
			return true;
		}else{
			return false;
		}
	}
	//测试函数
	public static void main(String[] args) {
		BracketMatch a=new BracketMatch();
		String s="3+(3*{(3+2)*34+[(3+2)*3+6]})";
		System.out.println(a.isMatch(s));
	}
}
