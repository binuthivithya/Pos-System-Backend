package com.ijse.cmjdfinal.backend.repository;

import com.ijse.cmjdfinal.backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
