package SwordToOffer;

/**
 * @author 黄子玉
 * 时间：2019/07/27 17:47
 * 问题：将“we are happy.”字符串替换为“we%20are%20happy.”
 * 分析：如果采用从前往后遇到空格就加%20，那么假设有O（n）个空格，每替换一个空格后面的字符都要向后面挪动几位，
 * 则时间复杂度为O（n^2），肯定不是最好的方法。换个思路，从后往前遍历就行了，只需要挪动一次。
 */
public class ReplaceSpace {
	//创建新的字符串，在新的字符串上进行替换。我们可以自己分配足够多的内存。
	public String replaceSpace(StringBuffer str){
		StringBuffer res=new StringBuffer();
		int len=str.length()-1;
		for(int i=len;i>=0;i--){
			if(str.charAt(i)==' '){
				res.append("02%");
			}else{
				res.append(str.charAt(i));
			}
		}
		return res.reverse().toString();
	}
	//只允许在原来字符串上进行替换，保证输入的字符串后面有足够多的内存。
	public String replaceSpace1(StringBuffer str){
		int orignalLength=str.length();
		int numberOfBlank=0;
		for(int i=0;i<orignalLength;i++){
			if(str.charAt(i)==' '){
				numberOfBlank++;
			}
		}
		int newLength=orignalLength+numberOfBlank*2;
		int indexOfOriginal=orignalLength-1;
		int indexOfNew=newLength-1;
		str.setLength(newLength);//对stringbuffer进行扩容，扩成newlength的大小。
		while(indexOfOriginal>=0&&indexOfNew>indexOfOriginal){
			if(str.charAt(indexOfOriginal)==' '){
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			}else{
				str.setCharAt(indexOfNew--,str.charAt(indexOfOriginal) );
			}
			--indexOfOriginal;
		}
		return str.toString();
	}
	//测试方法
	public static void main(String[] args) {
		String str1="We Are Happy.";
		StringBuffer str=new StringBuffer(str1);
		ReplaceSpace a=new ReplaceSpace();
		System.out.println(a.replaceSpace(str));
		System.out.println(a.replaceSpace1(str));
	}
}
