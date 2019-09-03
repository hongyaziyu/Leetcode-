package SwordToOffer;


/**
 * @author ������
 * ��Ŀ����������ĳ������ǰ���������������Ľ�����ؽ����ö����������������
 * ǰ���������������Ľ���ж������ظ������֣��ؽ������������ء�
 * ����˼·������֪��ǰ������ĵ�һ���ڵ���Ǹ��ڵ㣬�����ȸ���ǰ������ĵ�һ������
 * �������ڵ㣬����������������������ҵ����ڵ��λ�ã����ڵ����������������ұ���
 * ����������������ȷ�����������ڵ��������ǰ���������������������л���������
 * �����ڵ��ֵ�Ժ󣬾Ϳ��Եݹ��ȥ�ֱ𹹽���������������
 * �����õ��˵ݹ�ǳ����ӣ�������ϸ������
 */
public class ReconstructBinaryTree {
	public TreeNode reconstructBinaryTree(int[] pre,int[] in){
		if(pre.length==0||in.length==0){
			return null;
		}
		return constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
	}

	private TreeNode constructBinaryTree(int[] pre, int ps, int pe, 
			int[] in, int is, int ie) {
		if(ps>pe||is>ie){
			return null;
		}
		TreeNode root=new TreeNode(pre[ps]);
		for(int i=is;i<=ie;i++){
			if(in[i]==pre[ps]){
				root.left=constructBinaryTree(pre,ps+1,ps+i-is,in,is,i-1);
				root.right=constructBinaryTree(pre,ps+i-is+1,pe,in,i+1,ie);
				break;
			}
		}
		return root;
	}
	//���Ժ���
	public static void main(String[] args) {
		ReconstructBinaryTree a=new ReconstructBinaryTree();
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		TreeNode root=a.reconstructBinaryTree(preOrder, inOrder);
		VariousTraversalOfBinaryTrees b=new VariousTraversalOfBinaryTrees();
		b.levelOrderTraversal(root);
	}
}
