package tree;

public abstract class BinaryTreeNode<T> {
	
	private T value;
	private StringNode left;
	private StringNode right;
	
	public BinaryTreeNode(){
	}
	public BinaryTreeNode(T value){
		this.value = value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public StringNode getLeft() {
		return left;
	}
	public void setLeft(StringNode left) {
		this.left = left;
	}
	public StringNode getRight() {
		return right;
	}
	public void setRight(StringNode right) {
		this.right = right;
	}
	
}
