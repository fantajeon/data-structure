package tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CalculatorTree {
	
	public static BinaryTreeNode<String> buildExpressionTree(Iterator<String> iterator, BinaryTreeNode<String> node) {
		
		if( !iterator.hasNext() ){
			return node;
		}
		
		String str = iterator.next();
		
		if( isExpression(str) ){
			node.setLeft(buildExpressionTree(iterator, new BinaryTreeNode<String>()));
			node.setRight(buildExpressionTree(iterator, new BinaryTreeNode<String>()));
		}
		
		node.setValue(str);
		return node;
	}
	
	private static boolean isExpression(String str) {
		switch(str){
			case "+" :
			case "-" :
			case "/" :
			case "*" :
				return true;
		}
		return false;
	}
	
	private static long calculateExpression(String str, long left, long right) {
		switch(str){
			case "+" :
				return left + right;
			case "-" :
				return left - right;
			case "/" :
				return left / right;
			case "*" :
				return left * right;
		}
		return 0;
	}	
	
	public static long calculate(BinaryTreeNode<String> node) {
		
		long left = 0;
		long right = 0;
		
		if( isExpression(node.getValue()) ) {
			left = calculate((BinaryTreeNode<String>) node.getLeft());
			right = calculate((BinaryTreeNode<String>) node.getRight());
			return calculateExpression(node.getValue(), left, right);
		}
		
		return Long.valueOf(node.getValue());
		
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1 2 * 7 8 * +".split(" "));
		Collections.reverse(list);
		System.out.println(list);
		BinaryTreeNode<String> root = new BinaryTreeNode<String>();
		CalculatorTree.buildExpressionTree(list.iterator(), root);
		long calculate = CalculatorTree.calculate(root);
		System.out.println(calculate);
	}
	
}
