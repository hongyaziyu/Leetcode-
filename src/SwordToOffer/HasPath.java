package SwordToOffer;

/**
 * @author 黄子玉 矩阵中的路径
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串
 * 所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，
 * 向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
 * 则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的
 * 3 X 4 矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入
 * 该格子。
 *解题思路：
 *回溯法：
1. 将matrix字符串映射为一个字符矩阵（index = i * cols + j）
2. 遍历matrix的每个坐标，与str的首个字符对比，如果相同，用flag做标记，
matrix的坐标分别上、下、左、右、移动
（判断是否出界或者之前已经走过[flag的坐标为1]），再和str的下一个坐标相比，
直到str全部对比完，即找到路径，否则找不到。
 */
public class HasPath {
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    {
	        if(matrix.length == 0 || str.length == 0)
	            return false;
	        int [][] flag = new int[rows][cols];
	        for(int i = 0; i < rows; i++){
	            for(int j = 0; j < cols; j++){
	                if(search(matrix, rows, cols, i, j, str, 0, flag))
	                    return true;
	            }
	        }
	        return false;
	    }

	    public boolean search(char[] matrix, int rows, int cols, 
	                          int i, int j, char[] str, int index, int[][] flag){
	        int m_i = i * cols + j;
	        if(i<0 || j<0 || i >= rows || j>=cols || flag[i][j] == 1 || matrix[m_i] != str[index])
	            return false;
	        if(index >= str.length - 1)
	            return true;
	        flag[i][j] = 1;
	        if(search(matrix, rows, cols, i+1, j, str, index+1, flag) || 
	            search(matrix, rows, cols, i-1, j, str, index+1, flag) || 
	            search(matrix, rows, cols, i, j+1, str, index+1, flag) || 
	            search(matrix, rows, cols, i, j-1, str, index+1, flag))
	            return true;
	        flag[i][j] = 0;
	        return false;
	    }
}
