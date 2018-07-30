package com.infy.springbootrestapi.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.infy.springbootrestapi.exception.InvalidInputException;

@Service
public class RestAPIServiceImpl implements RestAPIService {

	@Override
	public long getNthFibonacciSeries(long num) throws InvalidInputException {
		long num1 = 0;
		long num2 = 1;
		long sum = 0;
		for (int i = 2; i <= num; i++) {
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
		}
		return sum;
	}

	@Override
	public String getStringReverseWords(String sentence) {
		String words[] = sentence.split(" ");
		StringBuffer reverseString = new StringBuffer();
		for (String word : words) {
			String reverseWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}
			reverseString.append(reverseWord + " ");
		}
		return reverseString.toString();
	}

	@Override
	public String getTriangleType(int side1, int side2, int side3) throws InvalidInputException {
		String triangleType = "";
		if (side1 == side2 && side2 == side3) {
			triangleType = "Equilateral";
		} else if (side1 == side2 || side2 == side3 || side3 == side1) {
			triangleType = "Isosceles";
		} else if ((side1 != side2) & (side2 != side3)) {
			triangleType = "Scalane";
		} else {
			triangleType = "Not a Triangle";
		}
		return triangleType;
	}

	@Override
	public Set<Integer> makeOneArray(Collection<Integer[]> collection) {
		Set<Integer> set = new HashSet<Integer>();
		for (Integer[] intArray : collection) {
			set.addAll(Arrays.asList(intArray));
		}
		return set;
	}

}
