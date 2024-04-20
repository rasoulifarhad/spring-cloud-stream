package com.spring.sample.functionsample.functions;

import java.util.function.Function;

/**
 * @author Mark Fisher
 */
public class CharCounter implements Function<String, Integer> {

	@Override
	public Integer apply(String word) {
		return word.length();
	}

}
