package com.ijse.cmjdfinal.backend.repository;

import com.ijse.cmjdfinal.backend.entity.OrderedItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemDetailsRepository extends JpaRepository<OrderedItemDetails, Long> {
}
