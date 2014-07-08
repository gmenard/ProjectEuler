import java.util.Stack;

/*
 * How to inorder traverse a binary tree without recursion.
 */

public class Question1 {

	// With a stack
	public static void inorder1(Node root) {

		Boolean isDone = false;

		Node current = root;
		Stack<Node> stack = new Stack<Node>();

		while (!isDone) {
			if (current != null) {
				stack.push(current);
				current = current.leftChild;
			} else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					System.out.println(current);
					current = current.rightChild;
				} else {
					isDone = true;
				}
			}
		}
	}

	// Without a stack (Morris Traversal)
	public static void inorder2(Node root) {

		Node current = root;

		while (current != null) {
			if (current.leftChild == null) {
				System.out.println(current);
				current = current.rightChild;
			} else {
				Node parent = current.leftChild;
				while (parent.rightChild != null && parent.rightChild != current)
					parent = parent.rightChild;

				if (parent.rightChild == null) {
					parent.rightChild = current;
					current = current.leftChild;
				} else {
					parent.rightChild = null;
					System.out.println(current);
					current = current.rightChild;
				}
			}
		}
	}

	public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman 1");

		Question1.inorder1(theTree.root);
		System.out.println("###");
		Question1.inorder2(theTree.root);

	}
}
