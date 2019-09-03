package SwordToOffer;

/**
 * @author ������ �����е�·��
 * ��Ŀ�����������һ�������������ж���һ���������Ƿ����һ������ĳ�ַ���
 * �����ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ���������
 * ���ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ�
 * ��֮�����ٴν���������ӡ� ���� a b c e s f c s a d e e ������
 * 3 X 4 �����а���һ���ַ�����bcced����·�������Ǿ����в�������abcb��·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���
 * �ø��ӡ�
 *����˼·��
 *���ݷ���
1. ��matrix�ַ���ӳ��Ϊһ���ַ�����index = i * cols + j��
2. ����matrix��ÿ�����꣬��str���׸��ַ��Աȣ������ͬ����flag����ǣ�
matrix������ֱ��ϡ��¡����ҡ��ƶ�
���ж��Ƿ�������֮ǰ�Ѿ��߹�[flag������Ϊ1]�����ٺ�str����һ��������ȣ�
ֱ��strȫ���Ա��꣬���ҵ�·���������Ҳ�����
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
