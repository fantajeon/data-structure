package tree;

public class BinaryTreeNode<T> {
	
	protected T value;
	protected BinaryTreeNode<T> left;
	protected BinaryTreeNode<T> right;
	
	public BinaryTreeNode(){
	}
	public BinaryTreeNode(T value){
		this.value = value;
	}
	public void replace(BinaryTreeNode<T> origin, BinaryTreeNode<T> replace) {
		if( origin == left ) {
			left = replace;
		}else if( origin == right ) {
			right = replace;
		}
	}
	public void replaceValue(BinaryTreeNode<T> origin, BinaryTreeNode<T> replace) {
		if( origin == left ) {
			left.setValue(replace.getValue());
		}else if( origin == right ) {
			right.setValue(replace.getValue());
		}
	}
	public void setValue(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
}
