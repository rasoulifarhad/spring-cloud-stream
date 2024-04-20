package com.spring.sample.functionsample.fn;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import reactor.core.publisher.Flux;

@Configuration
public class FnConfiguration {
    

    @Bean
	public Function<String, String> uppercaseFunction() {
		return value -> value.toUpperCase();
	}

	@Bean
	public Function<Message<String>, Integer> uppercaseMessageFunction() {
		return value -> value.getPayload().toUpperCase().length();
	}

	@Bean
	public Function<Flux<String>, Flux<String>> lowercaseFluxFunction() {
		return flux -> flux.map(value -> value.toLowerCase());
	}

	@Bean
	public Supplier<String> helloSupplier() {
		return () -> "hello";
	}

	@Bean
	public Supplier<Flux<String>> infiniteStringFluxSupplier() {
	    return () -> Flux
	            .interval(Duration.ofSeconds(1))
	            .log()
	            .map(counter -> String.format("Counter: %s", counter));
	}
}
