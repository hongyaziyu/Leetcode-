package algorithm;

public class ConvertBST {
	static int sum=0;
	public static void preOrder(TreeNode root){
		if(null==root){
			return;
		}
		preOrder(root.right);
		root.val+=sum;
		sum=root.val;
		preOrder(root.left);
	}
	public static TreeNode convert(TreeNode root){
		preOrder(root);
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		TreeNode rootleft=new TreeNode(2);
		TreeNode rootright=new TreeNode(13);
		root.left=rootleft;
		root.right=rootright;
		TreeNode result=convert(root);
		System.out.println(result.val);


	}

}
