package search.binary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTest {
	
	private static int loop = 0;
	
	@Before
	public void before() {
		loop = 0;
	}
	
	@After
	public void after() {
		System.out.println(String.format("total count : %d", loop));
	}
	
	public static int binary(int[] dataSet, int target) {
		
		int start = 0; 
		int end = dataSet.length - 1;
		
		while( start <= end ){

			loop++;
			int median = (int) Math.floor( (start + end) / 2 );
			if( dataSet[median] == target ){
				return dataSet[median];
			}
			if( dataSet[median] < target ){
				start = median - 1;
			}else{
				end = median + 1;
			}
		}
		
		return -1;
		
	}
	
	@Test
	public void testCase() throws Exception {
		
		int[] dataSet = {1, 3, 5, 7, 9, 11, 13, 15, 36, 66, 67, 88, 245, 444, 634, 866};
		int binary = binary(dataSet, 88);
		System.out.println(binary);
	}

}
