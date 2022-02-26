package com.example.domains.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
