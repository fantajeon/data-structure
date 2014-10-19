package search.binary.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tree.BinaryTreeNode;
import tree.NodeVisitor;


public class BinaryTreeTest {

	private List<Integer> list = Arrays.asList(23, 139, 11, 1, 16, 13, 67, 20, 15);
	private BinaryTreeNode<Integer> setNode;
	
	@Before
	public void before() {

		System.out.println(list);
		setNode = setNode(list);

	}
	
	public static BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> target) {

		if( tree.getValue().equals(target.getValue()) ) {
			return tree;
		}
		if( tree.getValue() > target.getValue() ) {
			return search(tree.getLeft(), target);
		}
		return search(tree.getRight(), target);
		
	}
	
	public static void insert(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> child) {
		
		if( tree.getValue() == child.getValue() ) {
			return;
		}
		if( child.getValue() < tree.getValue() ) {
			if( tree.getLeft() == null ) {
				tree.setLeft(child);
				return;
			}
			insert(tree.getLeft(), child);
			return;
		}
		if( tree.getRight() == null ) {
			tree.setRight(child);
			return;
		}
		insert(tree.getRight(), child);
		
	}
	public static void remove(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> target) {
		remove(node, null, target);
	}
	
	private static void remove(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent, BinaryTreeNode<Integer> target) {

		if( node.getValue() > target.getValue() ) {
			remove(node.getLeft(), node, target);
			return;
		} else if( node.getValue() < target.getValue() ) {
			remove(node.getRight(), node, target);
			return;
		} else if( !node.getValue().equals(target.getValue()) ) {
			return;
		}
		
		// 자식 노드가 없는경우
		if( node.getLeft() == null && node.getRight() == null ) {
			parent.replace(node, null);
			return;
		}
		// left 자식 노드만 있는 경우
		if( node.getRight() == null ) {
			parent.replace(node, node.getLeft());
			return;
		}
		// right 자식 노드만 있는 경우
		if( node.getLeft() == null ) {
			parent.replace(node, node.getRight());
			return;
		}
		// left, right 둘 다 있는 경우
		BinaryTreeNode<Integer> min = getMin(node.getRight(), node);
		parent.replaceValue(node, min);
		
	}

	private static BinaryTreeNode<Integer> getMin(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> parent) {
		if( tree.getLeft() == null ) {
			if( tree.getRight() != null ) {
				parent.setLeft(tree.getRight());
			}
			return tree;
		}
		return getMin(tree.getLeft(), tree);
	}

	@Test
	public void test() {
		
		remove(setNode, new BinaryTreeNode<Integer>(13));
		NodeVisitor.inorderPrintTree(setNode);
		
	}
	
	public static BinaryTreeNode<Integer> setNode(List<Integer> list) {
		
		Iterator<Integer> iterator = list.iterator();
		BinaryTreeNode<Integer> head = new BinaryTreeNode<Integer>(iterator.next());
		
		while( iterator.hasNext() ) {
			insert(head, new BinaryTreeNode<Integer>(iterator.next()));
		}
		return head;
		
	}
}
