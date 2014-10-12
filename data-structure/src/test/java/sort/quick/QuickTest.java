package sort.quick;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickTest {
	
	private static int loop = 0;
	
	@Before
	public void before() {
		loop = 0;
	}
	
	@After
	public void after() {
		System.out.println(String.format("total count : %d", loop));
	}
	
	public static void sort(int dataSet[], int left, int right) {
		if( left < right ){
			int index = partition(dataSet, left, right);
			sort(dataSet, left, index - 1);
			sort(dataSet, index + 1, right);
		}
	}

	private static int partition(int dataSet[], int left, int right) {
		
		int first = left;
		int pivot = dataSet[first];
		
		++left;
		
		while( left <= right ){
			while( dataSet[left] <= pivot && left < right ){
				++left;
			}
			while( dataSet[right] > pivot && left <= right ){
				++right;
			}
			if( left < right ){
				swap(dataSet, left, right);
			}else{
				break;
			}
		}
		return right;
		
	}

	private static void swap(int[] dataSet, int left, int right) {
		int temp = dataSet[right];
		dataSet[right] = dataSet[left];
		dataSet[left] = temp;
	}

	@Test
	public void test() {
		int[] dataSet = {8, 4, 7, 3, 1, 5};
		
		sort(dataSet, 0, dataSet.length - 1);
		System.out.println(Arrays.toString(dataSet));
	}

}
