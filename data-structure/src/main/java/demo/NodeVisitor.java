package demo;


public class NodeVisitor {

	public static void preorderPrintTree(Node node) {
		
		if( node == null ){
			return;
		}
		
		System.out.println(String.format("\t%s", node.getValue()));
		preorderPrintTree(node.getLeft());
		preorderPrintTree(node.getRight());
		
	}
	
	public static void inorderPrintTree(Node node) {
		
		if( node == null ){
			return;
		}

		inorderPrintTree(node.getLeft());
		System.out.println(String.format("\t%s", node.getValue()));
		inorderPrintTree(node.getRight());
		
	}
	
	public static void postPrintTree(Node node){
		
		if( node == null ){
			return;
		}

		postPrintTree(node.getLeft());
		postPrintTree(node.getRight());
		System.out.println(String.format("\t%s", node.getValue()));
		
	}	
	
}
