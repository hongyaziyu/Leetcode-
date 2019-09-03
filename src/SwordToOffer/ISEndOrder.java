package SwordToOffer;

/**
 * @author ������ �������ĺ������
 * ��Ŀ����������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������
 * ����������Yes���������No���������������������������ֶ�������ͬ��
 * ����˼·��������<��<=������
 * ���ں��������˵��������������һ��Ԫ��һ���Ǹ��ڵ㣬�������Ԫ�أ���ǰ��
 * �������Ϊ�����������֣���ಿ�ֶ��ȸ�Ԫ��С���Ҳಿ�ֶ��ȸ�Ԫ�ش����
 * �Ҳಿ���бȸø��ڵ�С��Ԫ�أ���ô�Ͳ��Ǻ����������˵ݹ���С�
 */
public class ISEndOrder {
	public boolean isEndOrder(int[] sequence){
		if(sequence.length==0){
			return false;
		}
		if(sequence.length==1){
			return true;
		}
		return judge(sequence,0,sequence.length-1);
	}

	private boolean judge(int[] sequence, int start, int root) {
		if(start>=root){
			return true;
		}
		int i=start;
		while(i<root&&sequence[i]<sequence[root]){
			i++;
		}
		for(int j=i;j<root;j++){
			if(sequence[j]<sequence[root]){
				return false;
			}
		}
		return (judge(sequence,start,i-1)&&judge(sequence,i,root-1));
	}
}
