package in.samal.paymentservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.samal.paymentservice.api.entity.Payment;
import in.samal.paymentservice.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment){
		
		
		return paymentService.doPayment(payment);
	}
	
	@GetMapping("/{orderId}")
	public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
		
		return paymentService.findPaymentHistoryByOrderId(orderId);
		
	}
	
}
