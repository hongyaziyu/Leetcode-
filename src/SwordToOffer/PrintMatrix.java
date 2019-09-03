package SwordToOffer;

import java.util.ArrayList;

/**
 * @author ������ ˳ʱ���ӡ����
 * ��Ŀ����������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬
 * ����������¾���
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * �����δ�ӡ������
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * ����˼·���ȵõ������������������Ȼ��������ת��ӡ���ݣ�һ����ת��ӡ������
 * ���ԽǷֱ�ǰ���ͺ���һ����λ��
 * 
 */
public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix){
		int row=matrix.length;
		int col=matrix[0].length;
		ArrayList<Integer> res=new ArrayList<Integer> ();
		
		if(row==0&&col==0){
			return res;
		}
		int left=0,right=col-1,top=0,bottom=row-1;
		while(left<=right&&top<=bottom){
			//�ϣ�������
			for(int i=left;i<=right;i++){
				res.add(matrix[top][i]);
			}
			//�ң����ϵ���
			for(int i=top+1;i<=bottom;i++){
				res.add(matrix[i][right]);
			}
			//�£����ҵ���
			if(top!=bottom){
				//��ֹ�������
				for(int i=right-1;i>=left;i--){
					res.add(matrix[bottom][i]);
				}
			}
			//�󣺴��µ���
			if(left!=right){
				//��ֹ�������
				for(int i=bottom-1;i>top;i--){
					res.add(matrix[i][left]);
				}
			}
			left++;right--;top++;bottom--;
		}
		return res;
	}
	//���Ժ���
	public static void main(String[] args) {
		PrintMatrix a=new PrintMatrix();
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<Integer> res=a.printMatrix(matrix);
		System.out.println(res.toString());
	}
}
