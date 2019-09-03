package SwordToOffer;

/**
 * @author ������
 * ʱ�䣺2019/07/27 11:00
 * ������������һ����ά�����У�ÿ��һά����ĳ�����ͬ����
 * ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
 * ���������ʵ�ֲ��ҹ��ܣ��������뵽�����ⷨ��ʱ�临�Ӷ�ΪO��n^2�������ֽⷨû�õ���Ŀ��������������Ȼ����
 * ����𰸡�
 * ����һ�����ӵ�����Ӧ�ôӾ�����������֡��ڶ�ά����
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 * �в���Ԫ��7������һ��һ���������������ȡ��Ԫ��10,10����7����7�϶���10�������е�ǰ���к�10�����е�ǰ�������ҡ�
 * �������������໥�ص����ò��ң�Ȼ������ѡȡ�սǵ�Ԫ�ؿ����ܲ��ܽ��Ͳ����Ѷȡ�
 * ѡȡ9������Ͻǵ�Ԫ�ء�9����7����ȥ��9���ڵ���һ�У�8����7��ȥ��8���ڵ���һ�С�2С��7����ô7������2������
 * �������棬�����Ѿ����ų�����ôֻʣ�������ˣ��ų�2���ڵ��У�4С��7����ôͬ���ų�4���ڵ���һ�С������ž��ҵ�7�ˡ�
 * 
 * 
 */
public class FindInTwoDimensionalArray {
	//�����ⷨ
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
	//���νⷨ
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
