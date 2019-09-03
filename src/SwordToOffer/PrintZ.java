package SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ������ ��֮���δ�ӡ������
 *��Ŀ��������ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 *�ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 *����˼·��
 *������ջ��s2��������㣬s1���ż����
����s2�ڵ��ͬʱ��������������������˳�����s1��
����s1�ڵ��ͬʱ��������������������˳�����s2
 */
public class PrintZ {
	 public ArrayList<ArrayList<Integer> > printZ(TreeNode pRoot) {
	        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
	        Stack<TreeNode> s1 = new Stack<TreeNode>();
	        Stack<TreeNode> s2 = new Stack<TreeNode>();
	        int flag = 1;
	        if(pRoot == null)
	            return res;
	        s2.push(pRoot);
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        while(!s1.isEmpty() || !s2.isEmpty()){
	            if(flag % 2 != 0){
	                while(!s2.isEmpty()){
	                    TreeNode node = s2.pop();
	                    temp.add(node.val);
	                    if(node.left != null){
	                        s1.push(node.left);
	                    }
	                    if(node.right != null){
	                        s1.push(node.right);
	                    }
	                }
	            }
	            if(flag % 2 == 0){
	                while(!s1.isEmpty()){
	                    TreeNode node = s1.pop();
	                    temp.add(node.val);
	                    if(node.right != null){
	                        s2.push(node.right);
	                    }
	                    if(node.left != null){
	                        s2.push(node.left);
	                    }
	                }
	            }
	            res.add(new ArrayList<Integer>(temp));
	            temp.clear();
	            flag ++;
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
		    PrintZ a=new PrintZ();
		    System.out.println(a.printZ(node1).toString());
	}
}
