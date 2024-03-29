package SwordToOffer;

/**
 * @author 黄子玉 机器人的运动范围
 * 题目描述：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 *解题思路：回溯法：从(0,0)开始走，每成功走一步用一个flag数组标记当前位置为1，
 *然后从当前位置往四个方向探索，返回1 + 4 个方向的探索值之和。
 */
public class MovingCount {
	 public int movingCount(int threshold, int rows, int cols)
	    {   
	        if(threshold == 0)
	            return 0;
	        int flag[][] = new int[rows][cols];
	        return count(threshold, rows, cols, 0, 0, flag);
	    }
	    public int count(int threshold, int rows, int cols, int i, int j, int[][] flag){
	        if(i<0 || j<0 || i>=rows || j>=cols || sum(i)+sum(j) > threshold || flag[i][j] == 1){
	            return 0;
	        }
	        flag[i][j] = 1;
	        return 1 + count(threshold, rows, cols, i - 1, j, flag) + 
	            count(threshold, rows, cols, i + 1, j, flag) +
	            count(threshold, rows, cols, i, j - 1, flag) +
	            count(threshold, rows, cols, i, j + 1, flag);
	    }
	    public int sum(int i){
	        int s = 0;
	        while(i>0){
	            s += i%10;
	            i /= 10;
	        }
	        return s;
	    }
}
