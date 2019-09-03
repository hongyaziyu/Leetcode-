package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ������ �Ѷ�������ӡ�ɶ���
 *��Ŀ���������ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 *����˼·��
 *���Ƕ������Ĳ���������ö�����ʵ�֡�������Ҫ����������
 *һ��start��¼��ǰ���Ѿ���ӡ�Ľڵ������һ��end��¼ǰ�������еĽڵ������
 *�� start == end ʱ����ʱ��ǰ��������ˣ��Ϳ��Կ�ʼ��һ�������
 */
public class Print {
	 ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
	        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
	        if(pRoot == null)
	            return res;
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        Queue<TreeNode> layer = new LinkedList<TreeNode>();
	        layer.offer(pRoot);
	        int start = 0, end = 1;
	        while(!layer.isEmpty()){
	            TreeNode node = layer.poll();
	            temp.add(node.val);
	            start ++;
	            if(node.left != null)
	                layer.add(node.left);
	            if(node.right != null)
	                layer.add(node.right);
	            if(start == end){
	                start = 0;
	                res.add(temp);
	                temp = new ArrayList<Integer>();
	                end = layer.size();
	            }
	        }
	        return res;
	    }
	 //���Ժ���
	 public static void main(String[] args) {
		 TreeNode node1=new TreeNode(1);
			TreeNode node2=new TreeNode(2);
			TreeNode node3=new TreeNode(3);
			TreeNode node4=new TreeNode(4);
			TreeNode node5=new TreeNode(5);
			TreeNode node6=new TreeNode(6);
			TreeNode node7=new TreeNode(7);
		    node1.left=node2;
		    node1.right=node3;
		    node2.left=node4;
		    node2.right=node5;
		    node3.left=node6;
		    node3.right=node7;
		    Print a=new Print();
		    System.out.println(a.print(node1).toString());
		    
	}
}
