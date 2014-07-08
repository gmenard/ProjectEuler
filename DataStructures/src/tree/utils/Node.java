package tree.utils;

public class Node<T extends Comparable<T>> {

	public Node<T> left, right;

	public T data;

	public Node(T data) {
		this.data = data;
	}
}
