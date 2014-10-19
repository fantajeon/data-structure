package search.redblacktree;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import search.redblacktree.RedBlackNode.COLOR;

public class RedBlackTest {
	
	
	@Before
	public void before() {
	}
	
	public static void rebuildAfterRemove(RedBlackNode<Integer> root, RedBlackNode<Integer> successor) {
		RedBlackNode<Integer> sibling = null;
		
		while( successor.getParent() != null && successor.getColor() == COLOR.BLACK ) {
			if( successor == successor.getParent().getLeft() ) {
				sibling = successor.getParent().getRight();
				if( sibling.getColor() == COLOR.RED ) {
					sibling.setColor(COLOR.BLACK);
					successor.getParent().setColor(COLOR.RED);
					root = rotateLeft(root, successor.getParent());
				} else {
					if( sibling.getLeft().getColor() == COLOR.BLACK && sibling.getRight().getColor() == COLOR.BLACK ) {
						sibling.setColor(COLOR.RED);
						successor = successor.getParent();
					} else {
						if( sibling.getLeft().getColor() == COLOR.RED ) {
							sibling.getLeft().setColor(COLOR.BLACK);
							sibling.setColor(COLOR.RED);
							
							root = rotateRight(root, sibling);
							sibling.setColor(successor.getParent().getColor());
							successor.getParent().setColor(COLOR.BLACK);
							sibling.getRight().setColor(COLOR.BLACK);
							root = rotateLeft(root, successor.getParent());
							successor = root;
						}
					}
				}
			} else {
				sibling = successor.getParent().getLeft();
				if( sibling.getColor() == COLOR.RED ) {
					sibling.setColor(COLOR.BLACK);
					successor.getParent().setColor(COLOR.RED);
					root = rotateRight(root, successor.getParent());
				} else {
					if( sibling.getRight().getColor() == COLOR.BLACK && sibling.getLeft().getColor() == COLOR.BLACK ) {
						sibling.setColor(COLOR.RED);
						successor = successor.getParent();
					} else {
						if( sibling.getRight().getColor() == COLOR.RED ) {
							sibling.getRight().setColor(COLOR.BLACK);
							sibling.setColor(COLOR.RED);
							root = rotateLeft(root, sibling);
							sibling = successor.getParent().getLeft();
						}
						sibling.setColor(successor.getParent().getColor());
						successor.getParent().setColor(COLOR.BLACK);
						sibling.getLeft().setColor(COLOR.BLACK);
						root = rotateRight(root, successor.getParent());
						successor = root;
					}
				}
			}
		}
		successor.setColor(COLOR.BLACK);
	}
	
	public static void printTree(RedBlackNode<Integer> node, int depth, int blackCount) {
		char c = 'X';
		int v = -1;
		char[] cnt = new char[100];
		
		if( node == null || node == RedBlackNode.Nil ) {
			return;
		}
		
		if( node.getColor() == COLOR.BLACK ) {
			blackCount++;
		}
		
		if( node.getParent() != null ) {
			v = node.getParent().getValue();
			
			if( node.getParent().getLeft() == node ) {
				c = 'L';
			} else {
				c = 'R';
			}
		}
		
		if( node.getLeft() == RedBlackNode.Nil && node.getRight() == RedBlackNode.Nil ) {
			System.out.println(String.format(cnt + "-------- %d", blackCount));
		} else {
			System.out.println(cnt);
		}
		
		for(int i=0; i<depth; i++) {
			System.out.print("  ");
		}
		
		System.out.format(" %d %s {%c, %d} %s\n", node.getValue(), node.getColor(), c, v, cnt);
		printTree(node.getLeft(), depth + 1, blackCount);
		printTree(node.getRight(), depth + 1, blackCount);
		
	}
	
	public static RedBlackNode<Integer> searchNode(RedBlackNode<Integer> tree, RedBlackNode<Integer> target) {
		if( tree == RedBlackNode.Nil ) {
			return null;
		}
		
		if( tree.getValue() > target.getValue() ) {
			return searchNode(tree.getLeft(), target);
		}
		if( tree.getValue() < target.getValue() ) {
			return searchNode(tree.getRight(), target);
		}
		return tree;
	}
	
	public static void insertNode(RedBlackNode<Integer> tree, RedBlackNode<Integer> newNode) {
		insertNodeHelper(tree, newNode);
		newNode.setColor(COLOR.RED);
		newNode.setLeft(RedBlackNode.Nil);
		newNode.setRight(RedBlackNode.Nil);
		rebuildAfterInsert(tree, newNode);
	}
	
	private static void rebuildAfterInsert(RedBlackNode<Integer> root, RedBlackNode<Integer> x) {
		while( x != root && x.getParent().getColor() == COLOR.RED ) {
			if( x.getParent() == x.getParent().getParent().getLeft() ) {
				RedBlackNode<Integer> uncle = x.getParent().getParent().getRight();
				if( uncle.getColor() == COLOR.RED ) {
					x.getParent().setColor(COLOR.BLACK);
					uncle.setColor(COLOR.BLACK);
					x.getParent().getParent().setColor(COLOR.RED);
				} else {
					if( x == x.getParent().getRight() ) {
						x = x.getParent();
						root = rotateLeft(root, x);
					}
					x.getParent().setColor(COLOR.BLACK);
					x.getParent().getParent().setColor(COLOR.RED);
					root = rotateRight(root, x.getParent().getParent());
				}
			} else {
				RedBlackNode<Integer> uncle = x.getParent().getParent().getLeft();
				if( uncle.getColor() == COLOR.RED ) {
					x.getParent().setColor(COLOR.BLACK);
					uncle.setColor(COLOR.BLACK);
					x.getParent().getParent().setColor(COLOR.RED);
					x = x.getParent().getParent();
				} else {
					if( x == x.getParent().getLeft() ) {
						x = x.getParent();
						root = rotateRight(root, x);
					}
					x.getParent().setColor(COLOR.BLACK);
					x.getParent().getParent().setColor(COLOR.RED);
					root = rotateLeft(root, x.getParent().getParent());
				}
			}
		}
		root.setColor(COLOR.BLACK);
	}

	private static void insertNodeHelper(RedBlackNode<Integer> tree, RedBlackNode<Integer> newNode) {
		if( tree == null )
			tree = newNode;
		
		if( tree.getValue() < newNode.getValue() ) {
			if( tree.getRight() == RedBlackNode.Nil ) {
				tree.setRight(newNode);
				newNode.setParent(tree);
				return;
			}
			insertNodeHelper(tree.getRight(), newNode);
			return;
		}
		if( tree.getValue() > newNode.getValue() ) {
			if( tree.getLeft() == RedBlackNode.Nil ){
				tree.setLeft(newNode);
				newNode.setParent(tree);
				return;
			}
			insertNodeHelper(tree.getLeft(), newNode);
			return;
		}
	}
	
	private static RedBlackNode<Integer> rotateRight(RedBlackNode<Integer> root, RedBlackNode<Integer> parent) {
		
		RedBlackNode<Integer> leftChild = parent.getLeft();
		parent.setLeft(leftChild.getRight());
		
		if( leftChild.getRight() != RedBlackNode.Nil ) {
			leftChild.getRight().setParent(parent);
		}
		
		leftChild.setParent(parent.getParent());
		
		if( parent.getParent() == null ) {
			root = leftChild;
		}
		// 부모의 부모 개체 아래 트리에 연결
		if( parent == parent.getParent().getLeft() ) {
			parent.getParent().setLeft(leftChild);
		} else {
			parent.getParent().setRight(leftChild);
		}
		leftChild.setRight(parent);
		parent.setParent(leftChild);
		
		return root;
		
	}

	private static RedBlackNode<Integer> rotateLeft(RedBlackNode<Integer> root, RedBlackNode<Integer> parent) {
		RedBlackNode<Integer> rightChild = parent.getRight();
		parent.setRight(rightChild.getLeft());
		
		if( rightChild.getLeft() != RedBlackNode.Nil ) {
			rightChild.getLeft().setParent(parent);
		}
		
		rightChild.setParent(parent.getParent());
		
		if( parent.getParent() == null ) {
			root = rightChild;
		}
		// 부모의 부모 개체 아래 트리에 연결
		if( parent == parent.getParent().getLeft() ) {
			parent.getParent().setLeft(rightChild);
		} else {
			parent.getParent().setRight(rightChild);
		}
		rightChild.setRight(parent);
		parent.setParent(rightChild);
		
		return root;
		
	}
	
	public static RedBlackNode<Integer> removeNode(RedBlackNode<Integer> root, RedBlackNode<Integer> data) {
		RedBlackNode<Integer> removed;
		RedBlackNode<Integer> successor;
		RedBlackNode<Integer> target = searchNode(root, data);
		
		if( target == null ) {
			return null;
		}
		
		if( target.getLeft() == null || target.getRight() == RedBlackNode.Nil ) {
			removed = target;
		} else {
			removed = searchMinNode(target.getRight());
			target.setValue(removed.getValue());
		}
		
		if( removed.getLeft() != RedBlackNode.Nil ) {
			successor = removed.getLeft();
		} else {
			successor = removed.getRight();
		}
		
		successor.setParent(removed.getParent());
		
		if( removed.getParent() == null ) {
			root = successor;
		} else {
			if( removed == removed.getParent().getLeft() ) {
				removed.getParent().setLeft(successor);
			} else {
				removed.getParent().setRight(successor);
			}
		}
		
		if( removed.getColor() == COLOR.BLACK ) {
			rebuildAfterRemove(root, successor);
		}
		
		return removed;
	}

	private static RedBlackNode<Integer> searchMinNode(RedBlackNode<Integer> tree) {
		if( tree == RedBlackNode.Nil ) {
			return RedBlackNode.Nil;
		}
		if( tree.getLeft() == RedBlackNode.Nil ) {
			return tree;
		}
		return searchMinNode(tree.getLeft());
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
