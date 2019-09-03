package SwordToOffer;
/**
 * @author 黄子玉 翻转单词顺序列
 * 题目描述：翻转句子。
 * 解题思路：很简单的题，没啥好说的，注意一下测试用例全是空格的情况。
 * trim():去除字符串首尾的空格。
 * split():对字符串按照所传参数进行分割。
 */
public class ReverseSentence {
	public String reverseSentence(String str){
		if(str.trim().length()==0){
			return str;
		}
		String[] temp=str.split(" ");
		String res="";
		for(int i=temp.length-1;i>=0;i++){
			res+=temp[i];
			if(i!=0){
				res+=" ";
			}
		}
		return res;
	}
}
