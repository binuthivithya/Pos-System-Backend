package com.ijse.cmjdfinal.backend.repository;

import com.ijse.cmjdfinal.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
