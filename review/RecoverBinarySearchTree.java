class Solution {
	public void recoverTree(TreeNode root) {
		LinkedList<Integer> inOrderList = new LinkedList<Integer>();
		inOrderTraversal(root, inOrderList);
		System.out.println(inOrderList);
		int swap[] = findTwoElements(inOrderList);
		swapTwoElements(swap[0], swap[1], root);
	}

	public void swapTwoElements(int value1, int value2, TreeNode root) {
		if (root.val == value1) {
			root.val = value2;
		} else if (root.val == value2) {
			root.val = value1;
		}

		if (root.right != null) {
			swapTwoElements(value1, value2, root.right);
		}
		if (root.left != null) {
			swapTwoElements(value1, value2, root.left);
		}
	}

	public int[] findTwoElements(LinkedList<Integer> list) {
		int length = list.size();
		int value1 = 0;
		int value2 = 0;

		for (int i = 0; i < length - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				if (value1 == 0) {
					value1 = list.get(i);
					value2 = list.get(i + 1);
				} else {
					value2 = list.get(i + 1);
					break;
				}
			}
		}
		return new int[] { value1, value2 };
	}

	public void inOrderTraversal(TreeNode root, LinkedList<Integer> list) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
