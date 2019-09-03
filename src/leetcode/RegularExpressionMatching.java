package leetcode;

/**
 * @author 黄子玉 正则表达式匹配
 * 题目描述：给定一个字符串s和一个字符规律p，来实现一个支持'.'和'*'的正则表达式匹配。
 * '.'匹配任意单个字符。
 * '*'匹配零个或者多个前面的那一个元素。
 */
public class RegularExpressionMatching {
	//利用递归判断普通字符是否是一致的
	public boolean normalMatch(String text,String pattern){
		if(pattern.isEmpty()){//首先很容易想到边界条件
			return text.isEmpty();
		}
		boolean first_match=(!text.isEmpty())&&(pattern.charAt(0)==text.charAt(0));
		return first_match&&normalMatch(text.substring(1),pattern.substring(1));//递归的结束条件是字符串被截短至0.
	}
	//利用递归判断普通字符带.号的是否一致
	public boolean normalMatchWithPoint(String text,String pattern){
		if(pattern.isEmpty()){//首先很容易想到边界条件
			return text.isEmpty();
		}
		boolean first_match=(!text.isEmpty())&&
				(pattern.charAt(0)==text.charAt(0)||pattern.charAt(0)=='.');
		return first_match&&normalMatch(text.substring(1),pattern.substring(1));
	}
	
	
	//回溯法(类似于递归比较难理解)
	public boolean isMatch(String text,String pattern){
		if(pattern.isEmpty()){//首先很容易想到边界条件
			return text.isEmpty();
		}
		boolean first_match=(!text.isEmpty()&&
				(pattern.charAt(0)==text.charAt(0)||pattern.charAt(0)=='.'));
		if(pattern.length()>=2&&pattern.charAt(1)=='*'){
			return (isMatch(text,pattern.substring(2))||(first_match&&isMatch(text.substring(1),pattern)));
			//这里就是根据上面的函数改写，当发现有*这个通配符时，对于每次递归来说要不就匹配0次，要不就匹配1次。
			//匹配0次，则跳过该字符和‘*’
			//或者匹配1次，当pattern[0]和text[0]匹配后，移动text一位。注意理解。
		}else{
			return first_match&&isMatch(text.substring(1),pattern.substring(1));
		}
	}
	//动态规划(采用自顶向下的备忘录法)
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
	//测试函数
	public static void main(String[] args) {
		RegularExpressionMatching a=new RegularExpressionMatching();
		String text="aaabbbbbcd";
		String pattern="aaab*bc.";
		System.out.println(a.isMatch(text, pattern));
		System.out.println(a.normalMatch(text, pattern));
		System.out.println(a.isMatch1(text, pattern));
	}
}
