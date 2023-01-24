package com.example.cloud.reactive.kafka;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Configuration
public class ReactiveProcessorKafkaConfig {
    
    private AtomicBoolean semaphore = new AtomicBoolean(true);

	@Bean
	public Function<Flux<String>, Flux<String>> aggregate() {
		return inbound -> inbound.
				log()
				.window(Duration.ofSeconds(30), Duration.ofSeconds(5))
				.flatMap(w -> w.reduce("", (s1,s2)->s1+s2))
				.log();
	}

	@Bean
	public Supplier<String> testSource() {
		return () -> this.semaphore.getAndSet(!this.semaphore.get()) ? "foo" : "bar";

	}

	@Bean
	public Consumer<String>  testSink() {
		return payload -> log.info("Data received: " + payload);

	}
}
