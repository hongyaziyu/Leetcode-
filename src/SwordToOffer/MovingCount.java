package SwordToOffer;

/**
 * @author ������ �����˵��˶���Χ
 * ��Ŀ������������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���
 * ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� 
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
 * ���ʸû������ܹ��ﵽ���ٸ����ӣ�
 *����˼·�����ݷ�����(0,0)��ʼ�ߣ�ÿ�ɹ���һ����һ��flag�����ǵ�ǰλ��Ϊ1��
 *Ȼ��ӵ�ǰλ�����ĸ�����̽��������1 + 4 �������̽��ֵ֮�͡�
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
