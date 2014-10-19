package search.redblacktree;

public class RedBlackNode<T> {
	
	enum COLOR {
		RED, BLACK;
	}
	@SuppressWarnings("rawtypes")
	public static RedBlackNode Nil;
	static {
		Nil = new RedBlackNode<>(null);
		Nil.setColor(COLOR.BLACK);
	}
	protected T value;
	protected RedBlackNode<T> parent;
	protected RedBlackNode<T> left;
	protected RedBlackNode<T> right;
	protected COLOR color;
	
	public RedBlackNode(){
	}
	public RedBlackNode(T value){
		this.value = value;
		this.color = COLOR.BLACK;
	}
	public void replace(RedBlackNode<T> origin, RedBlackNode<T> replace) {
		if( origin == left ) {
			left = replace;
		}else if( origin == right ) {
			right = replace;
		}
	}
	public void replaceValue(RedBlackNode<T> origin, RedBlackNode<T> replace) {
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
	public RedBlackNode<T> getLeft() {
		return left;
	}
	public void setLeft(RedBlackNode<T> left) {
		this.left = left;
	}
	public RedBlackNode<T> getRight() {
		return right;
	}
	public void setRight(RedBlackNode<T> right) {
		this.right = right;
	}
	public RedBlackNode<T> getParent() {
		return parent;
	}
	public void setParent(RedBlackNode<T> parent) {
		this.parent = parent;
	}
	public COLOR getColor() {
		return color;
	}
	public void setColor(COLOR color) {
		this.color = color;
	}
	
}
