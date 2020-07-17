package in.samal.paymentservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.samal.paymentservice.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

	Payment findByOrderId(int orderId);

}
