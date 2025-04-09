package com.example.project.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Square implements Shape {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private double side;
    private double area;
    
    @Override
    public double calculateArea() {
        return side * side;
    }
    
    public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}
