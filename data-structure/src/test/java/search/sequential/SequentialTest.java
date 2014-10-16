package search.sequential;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import tree.LinkedNode;

public class SequentialTest {
	
	private LinkedNode head = setNode(Arrays.asList(1, 6, 7, 8, 22, 555, 64, 677, 4, 3, 553, 36, 66));
	
	public static LinkedNode moveToFront(LinkedNode head, int target) {
		
		LinkedNode current = head;
		LinkedNode previous = null;
		LinkedNode match = null;
		
		while( current != null ){

			if( current.getValue() == target ) {
				match = current;
				if( previous != null ) {
					previous.setNode(current.getNode());
					current.setNode(head);
					head =  current;
				}
				break;
			}
			previous = current;
			current = current.getNode();
			
		}
		
		return match;
		
	}
	
	public static LinkedNode transpose(LinkedNode head, int target) {
		
		LinkedNode current = head;
		LinkedNode match = null;
		LinkedNode previous = null;
		LinkedNode pprevious = null;
		
		while( current != null ){
			if( current.getValue() == target ) {
				match = current;
				if( previous != null && pprevious != null){
					previous.setNode(current.getNode());
					current.setNode(previous);
					pprevious.setNode(current);
				}
				break;
			}
			pprevious = previous;
			previous = current;
			current = current.getNode();
		}
		return match;
		
	}

	@Test
	public void testMoveToFront() {
		LinkedNode moveToFront = moveToFront(head, 64);
		printNode(moveToFront);
	}
	
	@Test
	public void testTranspose() throws Exception {
		printNode(head);
		LinkedNode transpose = transpose(head, 64);
		printNode(transpose);
	}
	
	private static void printNode(LinkedNode head) {
		LinkedNode prev = head;
		while( prev != null ) {
			System.out.print(String.format("\t%d", prev.getValue()));
			prev = prev.getNode();
		}
		System.out.println();
	}
	
	public static LinkedNode setNode(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		LinkedNode head = new LinkedNode(iterator.next());
		LinkedNode prev = head;
		
		while( iterator.hasNext() ) {
			LinkedNode node = new LinkedNode(iterator.next());
			prev.setNode(node);
			prev = node;
		}
		return head;
	}

}
