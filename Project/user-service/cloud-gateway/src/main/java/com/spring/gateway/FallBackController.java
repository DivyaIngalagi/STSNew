package com.spring.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/orderFallback")
	public Mono<String> orderServiceFallback()
	{
		return Mono.just("Order service is  taking too much time to start" );
	}
	

	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallback()
	{
		return Mono.just("Payment service is down and taking too much time to start" );
	}
	
}
