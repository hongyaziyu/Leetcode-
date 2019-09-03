package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 黄子玉 序列化二叉树
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树
 * 解题思路：
 * 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，
 * 并且在每次二叉树的结点不为空时，在转化val所得的字符之后添加一个’,’作为分割;
 *  对于空节点则以 ‘#,’ 代替。
      
      对于反序列化：将字符串按照“，”进行分割，插入到队列中，
      然后依次从队列中取出字符建立节点，递归创建一个二叉树。
 *
 */
public class Serialize {
	String serialize(TreeNode root) {
        if(root == null){
            return "#,";
        }
        StringBuffer res = new StringBuffer(root.val + ",");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }
    TreeNode Deserialize(String str) {
        String [] res = str.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < res.length; i++){
            queue.offer(res[i]);
        }
        return pre(queue);
    }
    TreeNode pre(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
    }
    //测试函数
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
		Serialize a=new Serialize();
		String str=a.serialize(node1).toString();
		System.out.println(str);
		TreeNode root=a.Deserialize(str);
		VariousTraversalOfBinaryTrees b=new VariousTraversalOfBinaryTrees();
		b.levelOrderTraversal(root);    
	}
}
