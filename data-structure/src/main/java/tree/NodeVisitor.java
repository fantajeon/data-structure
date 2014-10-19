package tree;



public class NodeVisitor {

	public static <T> void preorderPrintTree(BinaryTreeNode<T> node) {
		
		if( node == null ){
			return;
		}
		
		System.out.println(String.format("\t%s", node.getValue()));
		preorderPrintTree(node.getLeft());
		preorderPrintTree(node.getRight());
		
	}
	
	public static <T> void inorderPrintTree(BinaryTreeNode<T> node) {
		
		if( node == null ){
			return;
		}

		inorderPrintTree(node.getLeft());
		System.out.println(String.format("\t%s", node.getValue()));
		inorderPrintTree(node.getRight());
		
	}
	
	public static <T> void postPrintTree(BinaryTreeNode<T> node){
		
		if( node == null ){
			return;
		}

		postPrintTree(node.getLeft());
		postPrintTree(node.getRight());
		System.out.println(String.format("\t%s", node.getValue()));
		
	}	
	
}
