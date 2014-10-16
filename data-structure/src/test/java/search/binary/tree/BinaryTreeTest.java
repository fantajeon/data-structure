package search.binary.tree;

import org.junit.Before;
import org.junit.Test;

import tree.NodeVisitor;


public class BinaryTreeTest {
	
	@Before
	public void before() {

		IntegerNode node = new IntegerNode(Integer.valueOf(53));
		for( int i=0; i < 15; i++ ) {
			insert(node, new IntegerNode((int) Math.random()));
		}
		NodeVisitor.preorderPrintTree(node);

	}
	
	public static int search(IntegerNode tree, IntegerNode target) {

		if( tree.getValue() == target.getValue() ) {
			return tree.getValue();
		}
		if( tree.getValue() > target.getValue() ) {
			return search(tree.getLeft(), target);
		}
		return search(tree.getRight(), target);
		
	}
	
	public static void insert(IntegerNode tree, IntegerNode child) {
		
		if( tree.getValue() == child.getValue() ) {
			return;
		}
		if( child.getValue() < tree.getValue() ) {
			if( tree.getLeft() == null ) {
				tree.setLeft(child);
				return;
			}
			insert(tree.getLeft(), child);
		}
		if( tree.getRight() == null ) {
			tree.setRight(child);
			return;
		}
		insert(tree.getRight(), child);
		
	}

	@Test
	public void test() {
	}

}
