package com.ijse.cmjdfinal.backend.repository;

import com.ijse.cmjdfinal.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
