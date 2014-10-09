package sort.bubble;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleTest {
	
	private static int loop = 0;
	
	@Before
	public void before() {
		loop = 0;
	}
	
	@After
	public void after() {
		System.out.println(String.format("total count : %d", loop));
	}
	
	static int sort(int dataSet[]){
		
		int temp = 0;
		
		for( int count = (dataSet.length - 1); count > 0 ; count-- ) {
			for( int idx=0; idx < count; idx++ ){
				System.out.println(String.format("count[%d] idx[%d] : %d , %d", count, idx, dataSet[idx], dataSet[idx + 1]));
				loop++;
				if( dataSet[idx] > dataSet[idx + 1] ){
					temp = dataSet[idx + 1];
					dataSet[idx + 1] = dataSet[idx];
					dataSet[idx] = temp;
				}
			}
			System.out.println("=======================");
		}
		
		return dataSet[dataSet.length - 1];
		
	}
	
	@Test
	public void test() throws Exception {
		
		int[] dataSet = {8, 4, 7, 3, 1, 5};
		
		sort(dataSet);
		System.out.println(Arrays.toString(dataSet));
		
	}

}
