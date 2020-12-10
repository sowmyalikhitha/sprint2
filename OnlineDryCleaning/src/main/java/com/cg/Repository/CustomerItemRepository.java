package com.cg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.CustomerItem;

public interface CustomerItemRepository extends JpaRepository<CustomerItem, Integer> {


}
