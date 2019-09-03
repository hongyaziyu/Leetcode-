package algorithm;

import javax.swing.tree.TreeNode;

public class MergeTwoBinaryTrees {
	
	 public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		 if(t1==null){
			 return t2;
		 }
		 if(t2==null){
			 return t1;
		 }
         // �ϲ����ڵ�
		 t1.val+=t2.val;
		 //�ٵݹ�ϲ���������
		 t1.left=mergeTrees(t1.left,t2.left);
		 t1.right=mergeTrees(t1.right,t2.right);
		 
		 return t1;
	        
	    }
	 public class TreeNode {
		     public int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	 }


}
