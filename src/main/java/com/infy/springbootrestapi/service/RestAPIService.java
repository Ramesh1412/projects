package com.infy.springbootrestapi.service;

import java.util.Collection;
import java.util.Set;

import com.infy.springbootrestapi.exception.InvalidInputException;

public interface RestAPIService {

	long getNthFibonacciSeries(long num) throws InvalidInputException;

	String getStringReverseWords(String sentence);

	String getTriangleType(int side1, int side2, int side3)  throws InvalidInputException;

	Set<Integer> makeOneArray(Collection<Integer[]> collection);

}
