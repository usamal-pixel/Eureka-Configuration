package in.samal.orderservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.samal.orderservice.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
