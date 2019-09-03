package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ������ ���л�������
 * ��Ŀ��������ʵ�������������ֱ��������л��ͷ����л�������
 * ����˼·��
 * �������л���ʹ��ǰ��������ݹ�Ľ���������ֵת��Ϊ�ַ���
 * ������ÿ�ζ������Ľ�㲻Ϊ��ʱ����ת��val���õ��ַ�֮�����һ����,����Ϊ�ָ�;
 *  ���ڿսڵ����� ��#,�� ���档
      
      ���ڷ����л������ַ������ա��������зָ���뵽�����У�
      Ȼ�����δӶ�����ȡ���ַ������ڵ㣬�ݹ鴴��һ����������
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
		Serialize a=new Serialize();
		String str=a.serialize(node1).toString();
		System.out.println(str);
		TreeNode root=a.Deserialize(str);
		VariousTraversalOfBinaryTrees b=new VariousTraversalOfBinaryTrees();
		b.levelOrderTraversal(root);    
	}
}
