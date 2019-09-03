package SwordToOffer;

/**
 * @author 黄子玉
 * 时间：2019/07/27 11:00
 * 问题描述：在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 问题分析：实现查找功能，很容易想到暴力解法。时间复杂度为O（n^2）。这种解法没用到题目给的数组条件显然不是
 * 满意答案。
 * 分析一个复杂的问题应该从具体的例子入手。在二维矩阵
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 * 中查找元素7。我们一步一步分析。首先随便取个元素10,10大于7，那7肯定在10的所在列的前面列和10所在行的前面行来找。
 * 这两个区域是相互重叠不好查找，然后我们选取拐角的元素看看能不能降低查找难度。
 * 选取9这个右上角的元素。9大于7，那去掉9所在的这一列，8大于7，去掉8所在的这一列。2小于7，那么7可能在2的右面
 * 或者下面，右面已经被排除，那么只剩下下面了，排除2所在的行，4小于7，那么同理排除4所在的这一行。紧接着就找到7了。
 * 
 * 
 */
public class FindInTwoDimensionalArray {
	//暴力解法
	public boolean Find(int target,int[][] nums){
		int row=nums.length;
		int colum=nums[0].length;
		boolean isFind=false;
		for(int i=0;i<row;i++){
			for(int j=0;j<colum;j++){
				if(isFind==false&&target==nums[i][j]){
					isFind=true;
				}
			}
		}
		return isFind;
	}
	//分治解法
	public boolean Find1(int target,int[][] nums){
		int row=0;
		int colum=nums[0].length;
		boolean isFind=false;
		while(colum>=0&&row<=nums.length-1){
			if(target==nums[row][colum-1]){
				isFind=true;
				break;
			}else if(target>nums[row][colum-1]){
				row++;
			}else{
				colum--;
				}
		}
		return isFind;
	}
	
	public static void main(String[] args) {
		FindInTwoDimensionalArray a=new FindInTwoDimensionalArray();
		int[][] nums={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int target=7;
		System.out.println(a.Find(target, nums));
		System.out.println(a.Find1(target, nums));
	}
}
