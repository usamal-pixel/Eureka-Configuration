package in.samal.orderservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.samal.orderservice.api.common.Payment;
import in.samal.orderservice.api.common.TransactionRequest;
import in.samal.orderservice.api.common.TransactionResponse;
import in.samal.orderservice.api.entity.Order;
import in.samal.orderservice.api.repository.OrderRepository;


@Service
@RefreshScope
public class OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	
    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;
	
	
	public TransactionResponse saveOrder(TransactionRequest request){
		
		String response="";
		
		Order order = request.getOrder();
		Payment payment= request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);
		
		response = paymentResponse.getPaymentStatus().equals("success")?"Payment processing successfulland order placed":"There is afailure in payment api, order added to cart ";
		
		 orderRepository.save(order);
		 return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
		
		
	}
}
