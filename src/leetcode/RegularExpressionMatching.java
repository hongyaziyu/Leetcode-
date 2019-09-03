package leetcode;

/**
 * @author ������ ������ʽƥ��
 * ��Ŀ����������һ���ַ���s��һ���ַ�����p����ʵ��һ��֧��'.'��'*'��������ʽƥ�䡣
 * '.'ƥ�����ⵥ���ַ���
 * '*'ƥ��������߶��ǰ�����һ��Ԫ�ء�
 */
public class RegularExpressionMatching {
	//���õݹ��ж���ͨ�ַ��Ƿ���һ�µ�
	public boolean normalMatch(String text,String pattern){
		if(pattern.isEmpty()){//���Ⱥ������뵽�߽�����
			return text.isEmpty();
		}
		boolean first_match=(!text.isEmpty())&&(pattern.charAt(0)==text.charAt(0));
		return first_match&&normalMatch(text.substring(1),pattern.substring(1));//�ݹ�Ľ����������ַ������ض���0.
	}
	//���õݹ��ж���ͨ�ַ���.�ŵ��Ƿ�һ��
	public boolean normalMatchWithPoint(String text,String pattern){
		if(pattern.isEmpty()){//���Ⱥ������뵽�߽�����
			return text.isEmpty();
		}
		boolean first_match=(!text.isEmpty())&&
				(pattern.charAt(0)==text.charAt(0)||pattern.charAt(0)=='.');
		return first_match&&normalMatch(text.substring(1),pattern.substring(1));
	}
	
	
	//���ݷ�(�����ڵݹ�Ƚ������)
	public boolean isMatch(String text,String pattern){
		if(pattern.isEmpty()){//���Ⱥ������뵽�߽�����
			return text.isEmpty();
		}
		boolean first_match=(!text.isEmpty()&&
				(pattern.charAt(0)==text.charAt(0)||pattern.charAt(0)=='.'));
		if(pattern.length()>=2&&pattern.charAt(1)=='*'){
			return (isMatch(text,pattern.substring(2))||(first_match&&isMatch(text.substring(1),pattern)));
			//������Ǹ�������ĺ�����д����������*���ͨ���ʱ������ÿ�εݹ���˵Ҫ����ƥ��0�Σ�Ҫ����ƥ��1�Ρ�
			//ƥ��0�Σ����������ַ��͡�*��
			//����ƥ��1�Σ���pattern[0]��text[0]ƥ����ƶ�textһλ��ע����⡣
		}else{
			return first_match&&isMatch(text.substring(1),pattern.substring(1));
		}
	}
	//��̬�滮(�����Զ����µı���¼��)
	enum Result{
		TRUE,FALSE
	}
	Result[][] memo;
	public boolean isMatch1(String text,String pattern){
		memo=new Result[text.length()+1][pattern.length()+1];
		return dp(0,0,text,pattern);
	}
	
	private boolean dp(int i, int j, String text, String pattern) {
		if(memo[i][j]!=null){
			return memo[i][j]==Result.TRUE;
		}
		boolean ans;
		if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                       first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
	//���Ժ���
	public static void main(String[] args) {
		RegularExpressionMatching a=new RegularExpressionMatching();
		String text="aaabbbbbcd";
		String pattern="aaab*bc.";
		System.out.println(a.isMatch(text, pattern));
		System.out.println(a.normalMatch(text, pattern));
		System.out.println(a.isMatch1(text, pattern));
	}
}
