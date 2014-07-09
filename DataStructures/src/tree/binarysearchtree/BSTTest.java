package tree.binarysearchtree;

import tree.utils.Node;
import tree.utils.TreePrinter;

/**
 * Tests for BST.java
 * 
 * @author Guillaume Menard
 */
public class BSTTest {


	private static Node<Integer> makeTree() {
		Node<Integer> root = new Node<Integer>(10);
		Node<Integer> n11 = new Node<Integer>(5);
		Node<Integer> n12 = new Node<Integer>(13);
		Node<Integer> n21 = new Node<Integer>(2);
		Node<Integer> n22 = new Node<Integer>(8);
		Node<Integer> n23 = new Node<Integer>(15);
		Node<Integer> n31 = new Node<Integer>(7);
		Node<Integer> n32 = new Node<Integer>(9);
		Node<Integer> n33 = new Node<Integer>(14);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;

		n12.right = n23;
		n22.left = n31;
		n22.right = n32;

		n23.left = n33;

		return root;
	}

	public static void main(String[] args) {

		Node<Integer> root = makeTree();

		BST<Integer> bst = new BST<Integer>(root);

		TreePrinter.printNode(root);

		// Insert
		// Integer i = 4;
		// bst.insert(i);

		// Search
		// Integer j = 13;
		// root = bst.search(j);

		// Min
		// root = bst.getMin();

		// Max
		// root = bst.getMax();
		
		// Delete Min
		//bst.deleteMin();
		
		// Delete Max
		//bst.deleteMax();
		
		// Delete
		//bst.delete(5);

		// Depth
		//System.out.println("Depth: " + bst.getDepth());
		
		// Lowest Comon Ancestor
		root = bst.getLowestCommonAncestor(14, 15);

		TreePrinter.printNode(root);

	}
}
