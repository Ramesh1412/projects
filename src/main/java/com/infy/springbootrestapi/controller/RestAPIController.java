package com.infy.springbootrestapi.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springbootrestapi.exception.InvalidInputException;
import com.infy.springbootrestapi.service.RestAPIService;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	public RestAPIService restAPIService;

	@GetMapping("/Fibonacci")
	public ResponseEntity<Long> getNthFibonacciSeries(@RequestParam("n") String n) throws InvalidInputException {
		long num = 0;
		try {
			num = Integer.parseInt(n);
		} catch (Exception exception) {
			throw new InvalidInputException("Input parameter should be in number");
		}
		return new ResponseEntity<Long>(restAPIService.getNthFibonacciSeries(num), HttpStatus.OK);
	}

	@GetMapping("/ReverseWords")
	public ResponseEntity<String> getStringReverseWords(@RequestParam("sentence") String sentence) throws Exception {
		String result = "";
		if (!"".equalsIgnoreCase(sentence) && sentence != null) {
			result = restAPIService.getStringReverseWords(sentence);
		} else {
			return new ResponseEntity<String>("Sentence is empty", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@GetMapping("/TriangleType")
	public ResponseEntity<String> getTriangleType(@RequestParam("a") String a, @RequestParam("b") String b, @RequestParam("c") String c) throws InvalidInputException {
		int side1 = 0, side2 = 0, side3 = 0;
		try {
			side1 = Integer.parseInt(a);
			side2 = Integer.parseInt(b);
			side3 = Integer.parseInt(c);
		} catch (Exception exception) {
			throw new InvalidInputException("Input parameter(s) should be in number");
		}
		return new ResponseEntity<String>(restAPIService.getTriangleType(side1, side2, side3), HttpStatus.OK);
	}

	@PostMapping(value = "/makeonearray", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> makeOneArray(@RequestBody HashMap<String, Integer[]> hashMap) throws Exception {
		Collection<Integer[]> collection = hashMap.values();
		Set<Integer> result = restAPIService.makeOneArray(collection);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Array", result);
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
	}

}
