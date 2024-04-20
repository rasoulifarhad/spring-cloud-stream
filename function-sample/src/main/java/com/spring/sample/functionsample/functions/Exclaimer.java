package com.spring.sample.functionsample.functions;

import java.util.function.Function;

import reactor.core.publisher.Flux;

/**
 * @author Mark Fisher
 */
public class Exclaimer implements Function<Flux<String>, Flux<String>> {

	@Override
	public Flux<String> apply(Flux<String> words) {
		return words.map(word -> word + "!!!");
	}

}
