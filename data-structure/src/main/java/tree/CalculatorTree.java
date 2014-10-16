package tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CalculatorTree {
	
	public static StringNode buildExpressionTree(Iterator<String> iterator, StringNode node) {
		
		if( !iterator.hasNext() ){
			return node;
		}
		
		String str = iterator.next();
		
		if( isExpression(str) ){
			node.setLeft(buildExpressionTree(iterator, new StringNode()));
			node.setRight(buildExpressionTree(iterator, new StringNode()));
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
	
	public static long calculate(StringNode node) {
		
		long left = 0;
		long right = 0;
		
		if( isExpression(node.getValue()) ) {
			left = calculate(node.getLeft());
			right = calculate(node.getRight());
			return calculateExpression(node.getValue(), left, right);
		}
		
		return Long.valueOf(node.getValue());
		
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1 2 * 7 8 * +".split(" "));
		Collections.reverse(list);
		System.out.println(list);
		StringNode root = new StringNode();
		CalculatorTree.buildExpressionTree(list.iterator(), root);
		long calculate = CalculatorTree.calculate(root);
		System.out.println(calculate);
	}
	
}
