package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.models.Triangle;

public interface TriangleRepository extends JpaRepository<Triangle, Long> {

	Triangle findByBaseAndHeight(double base, double height);
	
	
}
