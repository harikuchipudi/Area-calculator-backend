package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.models.Circle;

public interface CircleRepository extends JpaRepository<Circle, Long> {
	
}