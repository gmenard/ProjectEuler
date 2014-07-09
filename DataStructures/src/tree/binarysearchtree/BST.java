package tree.binarysearchtree;

import tree.utils.Node;

/**
 * This class implements operations of a Binary Search Tree.
 * 
 * @author Guillaume Menard
 */
public class BST<T extends Comparable<T>> {

	private Node<T> root;

	public BST(Node<T> root) {
		this.root = root;
	}

	public Node<T> getRoot() {
		return this.root;
	}

	public void insert(T data) {
		this.root = insert(this.root, data);
	}

	private Node<T> insert(Node<T> currentNode, T data) {
		if (currentNode == null)
			return new Node<T>(data);

		int i = data.compareTo(currentNode.data);

		if (i < 0) {
			currentNode.left = insert(currentNode.left, data);
		} else if (i > 0) {
			currentNode.right = insert(currentNode.right, data);
		}

		return currentNode;
	}

	public int getDepth() {
		return getDepth(root);
	}

	private int getDepth(Node<T> currentNode) {

		int depthLeft = 0;
		int depthRight = 0;

		if (null != currentNode.left) {
			depthLeft = getDepth(currentNode.left);
		}
		if (null != currentNode.right) {
			depthRight = getDepth(currentNode.right);
		}

		return Math.max(depthLeft, depthRight) + 1;
	}

	public Node<T> getMin() {
		return getMin(root);
	}

	private Node<T> getMin(Node<T> currentNode) {
		if (null != currentNode.left) {
			return getMin(currentNode.left);
		} else {
			return currentNode;
		}
	}

	public Node<T> getMax() {
		return getMax(root);
	}

	private Node<T> getMax(Node<T> currentNode) {
		if (null != currentNode.right) {
			return getMax(currentNode.right);
		} else {
			return currentNode;
		}
	}

	public Node<T> search(T data) {
		if (data == null)
			return null;

		return search(root, data);
	}

	private Node<T> search(Node<T> currentNode, T data) {
		if (currentNode == null)
			return null;

		int i = data.compareTo(currentNode.data);

		if (i < 0) {
			return search(currentNode.left, data);
		} else if (i > 0) {
			return search(currentNode.right, data);
		} else {
			return currentNode;
		}
	}

	public void delete(T data) {
		this.root = delete(root, data);
	}

	private Node<T> delete(Node<T> node, T data) {

		if (null == node)
			return null;

		int i = data.compareTo(node.data);
		if (i < 0) {
			node.left = delete(node.left, data);
		} else if (i > 0) {
			node.right = delete(node.right, data);
		} else {
			if (null == node.right)
				return node.left;
			else if (null == node.left)
				return node.right;
			else {
				Node<T> tmp = node;
				node = this.getMin(tmp.right);
				node.right = this.deleteMin(tmp.right);
				node.left = tmp.left;
			}
		}
		return node;
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node<T> deleteMin(Node<T> node) {

		if (null == node.left)
			return node.right;

		node.left = deleteMin(node.left);

		return node;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node<T> deleteMax(Node<T> node) {

		if (null == node.right)
			return node.left;

		node.right = deleteMax(node.right);

		return node;
	}

	public Node<T> getLowestCommonAncestor(T data1, T data2) {
		return getLowestCommonAncestor(root, data1, data2);
	}

	private Node<T> getLowestCommonAncestor(Node<T> node, T data1, T data2) {

		if (null == node)
			return null;

		int i = data1.compareTo(node.data);
		int j = data2.compareTo(node.data);

		if (i < 0 && j < 0)
			return getLowestCommonAncestor(node.left, data1, data2);
		else if (i > 0 && j > 0)
			return getLowestCommonAncestor(node.right, data1, data2);

		return node;
	}
}
