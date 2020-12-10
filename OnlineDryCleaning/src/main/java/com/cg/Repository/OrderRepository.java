package com.cg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
