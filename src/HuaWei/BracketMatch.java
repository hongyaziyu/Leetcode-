package HuaWei;

import java.util.Stack;

/**
 * @author ������ ����ƥ��
 * ��Ŀ����������һ���ַ�����������ܰ�����()����"{}"��"[]"�������ţ����д�����������Ƿ�ɶԳ��֣���Ƕ�׹�ϵ��ȷ��
 * 
 *
 */
public class BracketMatch {
	private static final String HashMap = null;
	public boolean isMatch(String s){
		Stack<Character> stack=new Stack<Character>();
		char[] ch=s.toCharArray();
		for(int i=0;i<ch.length;i++){
			//����ַ��������������ջ
			if(ch[i]!='}'&&ch[i]!=']'&&ch[i]!=')'){
				stack.push(ch[i]);
			}else{
				//����ַ��������ţ���ջ��������������һֱ��ջ��
				while(stack.peek()!='{'&&stack.peek()!='('&&stack.peek()!='['){
					stack.pop();
				}
				//����ַ����Ҵ�������ջ��Ϊ����������ջ��
				if(ch[i]=='}'&&stack.peek()=='{'){
					stack.pop();
				//����ַ�������������ջ��Ϊ�����������ջ��
				}else if(ch[i]==']'&&stack.peek()=='['){
					stack.pop();
				//����ַ�����С������ջ��Ϊ��С�������ջ��
				}else if(ch[i]==')'&&stack.peek()=='('){
					stack.pop();
				//�����������ջ(����ע�����������������������������Ų�ƥ���ʱ�����ջ)�����Ų�ƥ���ʱ��
				}else{
					stack.push(ch[i]);
				}
			}
		}
		//���ж���Ա��ʽ��һ���ַ���������ʱ���磺3+(3*{(3+2��*34+[(3+2)*3+6])
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
	//���Ժ���
	public static void main(String[] args) {
		BracketMatch a=new BracketMatch();
		String s="3+(3*{(3+2)*34+[(3+2)*3+6]})";
		System.out.println(a.isMatch(s));
	}
}
