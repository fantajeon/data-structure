package sort.insert;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InsertTest {
	
	private static int loop = 0;
	
	@Before
	public void before() {
		loop = 0;
	}
	
	@After
	public void after() {
		System.out.println(String.format("total count : %d", loop));
	}
	
	public static int sort(int dataSet[]){
		int value = 0;
		
		for( int count = 1; count < dataSet.length ; count++ ) {
			value = dataSet[count];
			for( int idx = count - 1; idx >= 0; idx-- ){
				loop++;
				System.out.println(String.format("count[%d] idx[%d] : value[%d] , compare[%d]", count, idx, value, dataSet[idx]));
				if( dataSet[idx] <= dataSet[idx + 1] ){
					break;
				}
				dataSet[idx + 1] = dataSet[idx];
				dataSet[idx] = value;
			}
			System.out.println("=======================================");
		}
		
		return dataSet[dataSet.length - 1];
	}

	@Test
	public void test() {
		int[] dataSet = {8, 4, 7, 3, 1, 5};
		
		sort(dataSet);
		System.out.println(Arrays.toString(dataSet));
	}

}
