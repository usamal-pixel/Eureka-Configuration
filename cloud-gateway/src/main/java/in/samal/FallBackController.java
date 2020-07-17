package in.samal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/orderFallBack")
	public Mono<String> orderServiceFallBack(){
		return Mono.just("Order service is taking too long time or is down!!");
	}
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentServiceFallBack(){
		return Mono.just("Payment service is taking too long time or is down!!");
	}

}
