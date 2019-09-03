package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ������ �����������
 * ��Ŀ����������һ�ö����������������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����ڵ��γ�����
 * һ��·�����·���ĳ���Ϊ������ȡ�
 * ����˼·��
 * ����1���ݹ鷨�������������Ⱦ���������������������������ļ���һ�����ڵ㣬
 * ���εݹ鼴�ɡ�
 * ����2����α�����û����һ�㣬deep��1��ֱ�ӵ����һ�����deep��
 */
public class TreeDepth {
	//����1���ݹ鷨��
	public int treeDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=treeDepth(root.left)+1;
		int right=treeDepth(root.right)+1;
		return left>right?left:right;
	}
	//����2����α���
	public int treeDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int start = 0, end = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            start ++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(start == end){
                end = queue.size();
                start = 0;
                deep ++;
            }
        }
        return deep;
    }
}
