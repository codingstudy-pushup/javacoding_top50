package zTest01;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class MaxDepth {

	public static void main(String[] args) {
		MaxDepth a = new MaxDepth();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(a.solve(root));
	}

	int max = 0;

	public int solve(TreeNode root) {
		maxDepth(root);
		return max;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(left + right, max);

		return Math.max(left, right) + 1;

	}

}
