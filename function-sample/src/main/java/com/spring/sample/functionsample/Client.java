package com.spring.sample.functionsample;

import org.springframework.web.reactive.function.client.WebClient;

/**
 * Sample client to test infinite stream from function.
 *
 * @author Oleg Zhurakousky
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {
		WebClient client = WebClient.create();
		WebClient.ResponseSpec responseSpec = client.post()
			    .uri("http://localhost:8080/infinite")
			    .header("accept", "text/event-stream")
			    .retrieve();

		responseSpec.bodyToFlux(String.class).subscribe(v -> {
			System.out.println(v);
		});

		System.in.read();

	}

}
