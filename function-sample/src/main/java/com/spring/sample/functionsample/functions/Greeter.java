package com.spring.sample.functionsample.functions;

import java.util.function.Function;

/**
 * @author Mark Fisher
 */
public class Greeter implements Function<String, String> {

	@Override
	public String apply(String name) {
		return "Hello " + name;
	}

}
