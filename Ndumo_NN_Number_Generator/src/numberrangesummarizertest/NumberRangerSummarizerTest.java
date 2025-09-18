/**
 * 
 */
package numberrangesummarizertest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;


import numberrangesummarizer.NumberRangeSummerizerImplemantation;

/**
 * 
 */
class NumberRangerSummarizerTest {

	private  NumberRangeSummerizerImplemantation rangeSummerizer = new NumberRangeSummerizerImplemantation();
	String strSampleInput = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
	String strExpectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
	
	String strConsecutiveInput = "1,2,3,4,5,6,7,8,9,10,11";
	String strExpectedConsecutiveOutput = "1-11";
	
	String strScatteredInput = "5,10,15,20,25,30,35";
	String strExpectedScatteredOutput = "5, 10, 15, 20, 25, 30, 35";
	
	@Test
	void testSampleInput() {
		Collection<Integer> numberInput = rangeSummerizer.collect(strSampleInput);
		String strResult = rangeSummerizer.summarizeCollection(numberInput);
		assertEquals(strExpectedOutput, strResult);
	}
	
	@Test
	void testConsecutiveInput() {
		Collection<Integer> numberInput = rangeSummerizer.collect(strConsecutiveInput);
		String strResult = rangeSummerizer.summarizeCollection(numberInput);
		assertEquals(strExpectedConsecutiveOutput, strResult);
	}
	
	@Test
	void testScatteredInput() {
		Collection<Integer> numberInput = rangeSummerizer.collect(strScatteredInput);
		String strResult = rangeSummerizer.summarizeCollection(numberInput);
		assertEquals(strExpectedScatteredOutput, strResult);
	}

}
