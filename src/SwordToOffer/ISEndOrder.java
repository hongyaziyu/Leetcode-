package SwordToOffer;

/**
 * @author 黄子玉 二叉树的后序遍历
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则输出Yes，否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 解题思路：左子树<根<=右子树
 * 对于后序遍历来说，序列数组的最后一个元素一定是根节点，根据这个元素，将前面
 * 的数组分为左、右两个部分，左侧部分都比该元素小，右侧部分都比该元素大，如果
 * 右侧部分有比该根节点小的元素，那么就不是后序遍历，如此递归进行。
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
