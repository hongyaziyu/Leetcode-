package KuaiShou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 黄子玉 版本是否升级
 * 题目描述：给定两个版本号，只有在版本号更高的时候才可以升级。版本号中只有数和.号。
 * 例如：0.1<1.1
 * 1.2<13.37
 * 输入描述：输入m表示测试组数，接下来m行进行m次查询。
 * 输出：true或者false
 * 解题思路：从前往后判断，如果前面的数大于后面的数则不能升级，否则能升级，如果都一样，比较较长的那个版本是否大于0，如果大于
 * 则可以升级。
 *
 */
public class VersionUpgrade {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine().trim());
		for(int i=0;i<n;i++){
			String temp=sc.nextLine();
			doWork(temp);
		}
	}

	private static void doWork(String temp) {
		String[] s=temp.split(" ");
		int[] s1=Arrays.stream(s[0].split("\\.")).mapToInt(Integer::parseInt).toArray();//stream流操作，mapToInt是转换操作，将字符串转成Int类型，toArray()是最终的终端操作，将数据流变成int型的数组。
		int[] s2=Arrays.stream(s[1].split("\\.")).mapToInt(Integer::parseInt).toArray();
        int min=s1.length<s2.length?s1.length:s2.length;
        int i=0;
        for(;i<min;i++){
        	if(s1[i]<s2[i]){
        		System.out.println("true");
        		return;
        	}
        	if(s1[i]>s2[i]){
        		System.out.println("false");
        		return;
        	}
        }
        if(i==min){
        	if(s1.length==min){
        		long count=Arrays.stream(Arrays.copyOfRange(s2, min, s2.length)).filter(x->x!=0).count();//对不为0的数量进行计数。
        		if(count>0){//如果存在则后面版本大于前面版本等级可以升级版本
        			System.out.println("true");
        			return;
        		}
        	}else{//如果最小的是s2，则说明s1的版本要高，则一定不能升级。
        		System.out.println("false");
        	}
        }
	}
}
