package algorithm;

public class PalindramicSubstrings {
	public static int countSubstrings(String s){
		int count=0;
		for(int i=0;i<s.length();i++){
			count+=extendPalindrame(s,i,i);//odd length
			count+=extendPalindrame(s,i,i+1);//even length
		}
		return count;
	}
	

	private static int extendPalindrame(String s, int left, int right) {
		// TODO Auto-generated method stub
		int count=0;
		while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
			count++;
			left--;
			right++;
		}
		return count;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaa";
		int result=PalindramicSubstrings.countSubstrings(s);
		System.out.println(result);
	}

}
