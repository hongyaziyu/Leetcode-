package SwordToOffer;

import java.util.ArrayList;

/**
 * @author ������ �������к�Ϊĳһֵ��·��
 * ��Ŀ����������һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������
 * ·����·������Ϊ�Ӹ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������γɵ�һ��·����
 * ����˼·����ǰ������ķ�ʽ���ʵ�ĳһ�ڵ�ʱ���Ѹýڵ���ӵ�·���ϣ�����Ŀ��ֵ
 * ��ȥ�ýڵ�ֵ������ýڵ�ΪҶ�ڵ㲢��Ŀ��ֵ��ȥ�ýڵ��ֵ�պ�Ϊ0����ǰ·��
 * ����Ҫ�����ǰ�������res�����С������ǰ�ڵ㲻��Ҷ�ڵ㣬��������������ӽڵ㡣
 * ��ǰ�ڵ���ʽ����󣬵ݹ麯�����Զ��ص����ĸ��ڵ㡣��������ں����˳�֮ǰҪ��
 * ·����ɾ����ǰ�ڵ㣬��ȷ�����ظ��ڵ�ʱ·���պ��ǴӸ��ڵ㵽���ڵ��·����
 */
public class FindPath {
	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> temp=new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
		if(root==null){
			return res;
		}
		target-=root.val;
		temp.add(root.val);
		if(target==0&&root.left==null&&root.right==null){
			res.add(new ArrayList<Integer>(temp));
		}else{
			findPath(root.left,target);
			findPath(root.right,target);
		}
		temp.remove(temp.size()-1);
		return res;
	}
	//���Ժ���
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(5);
		TreeNode node3=new TreeNode(12);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(7);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		FindPath a=new FindPath();
		ArrayList<ArrayList<Integer>> path=a.findPath(node1, 22);
		System.out.println(path.toString());
	}
}
