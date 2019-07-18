package zTest;

import java.util.*;

public class DiameterOfBinaryTree_BFS {

	public static void main(String[] args) {
		DiameterOfBinaryTree_BFS a = new DiameterOfBinaryTree_BFS();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
		System.out.println("val: "+a.bfs(node));
	}

	
	public int bfs(TreeNode root) {
		if(root==null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count =0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			count++;
		}
		return count;
		
	}
}
