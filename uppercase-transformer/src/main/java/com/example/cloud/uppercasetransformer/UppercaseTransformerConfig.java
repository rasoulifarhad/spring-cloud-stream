package com.example.cloud.uppercasetransformer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UppercaseTransformerConfig {
    

	@Bean
	public Function<String, String> transform() {
		return payload -> payload.toUpperCase();
	}

	//Following source is used as a test producer.
	static class TestSource {

		private AtomicBoolean semaphore = new AtomicBoolean(true);

		@Bean
		public Supplier<String> sendTestData() {
			return () -> this.semaphore.getAndSet(!this.semaphore.get()) ? "foo" : "bar";

		}
	}

	//Following sink is used as a test consumer.
	static class TestSink {

		@Bean
		public Consumer<String> receive() {
			return payload -> log.info("Data received: " + payload);
		}
	}
 

}
