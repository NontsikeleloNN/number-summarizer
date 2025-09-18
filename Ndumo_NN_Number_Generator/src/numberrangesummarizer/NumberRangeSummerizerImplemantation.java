package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberRangeSummerizerImplemantation implements NumberRangeSummarizer {

	/**
	 * Takes in string input and brings back a sorted collection of integers
	 * @param input the string input
	 */
	@Override
	public Collection<Integer> collect(String input) {
		String[] strNumbers = input.split(",");
		List<Integer> numbersList = new ArrayList<>();

		for (String strNumber : strNumbers) {
			numbersList.add(Integer.valueOf(strNumber));
		}

		Collections.sort(numbersList);
		return numbersList;
	}

	/***
	 * Takes in a collection of integers, brings back summarised sequence in string 
	 * @param input collection of sorted integers
	 */
	@Override
	public String summarizeCollection(Collection<Integer> input) {
		Integer[] arrNumbers = input.toArray(new Integer[0]);
		StringBuilder strResults = new StringBuilder();
		int index = 0;

		while (index < arrNumbers.length) {
			int intFirstNumber = arrNumbers[index];
			int intLastNumber = intFirstNumber;
			while ((index + 1 < arrNumbers.length) && (arrNumbers[index + 1] == intLastNumber + 1)) { // shift over all sequentially ordered numbers
				index++;
				intLastNumber = arrNumbers[index];
			}

			if (intFirstNumber == intLastNumber) { // if there is no gap between the current number and the last number, seperate by comma
				strResults.append(intFirstNumber).append(", ");
			} else { // otherwise, cluster the first number and the last number following in sequential order
				strResults.append(intFirstNumber).append("-").append(intLastNumber).append(", ");
			}
			index++;
		}

		if (strResults.length() >= 2) {
			strResults.setLength(strResults.length() - 2); // remove trailing comma and space
		}

		return strResults.toString();
	}

}
