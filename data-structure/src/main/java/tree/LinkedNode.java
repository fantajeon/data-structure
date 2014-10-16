package tree;

public class LinkedNode {
	
	private LinkedNode node;
	private final int value;
	
	public LinkedNode(int value){
		this.value = value;
	}

	public LinkedNode getNode() {
		return node;
	}

	public void setNode(LinkedNode node) {
		this.node = node;
	}

	public int getValue() {
		return value;
	}

}
