package com.example.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.project.models.Circle;
import com.example.project.models.Rectangle;
import com.example.project.models.Square;
import com.example.project.models.Trapezoid;
import com.example.project.models.Triangle;
import com.example.project.repository.CircleRepository;
import com.example.project.repository.RectangleRepository;
import com.example.project.repository.SquareRepository;
import com.example.project.repository.TrapezoidRepository;
import com.example.project.repository.TriangleRepository;

import lombok.RequiredArgsConstructor;

@Service
@Profile("!docker")
public class ShapeService {
	
	
	private TriangleRepository triangleRepository;
	private SquareRepository squareRepository;
	private RectangleRepository rectangleRepository;
	private TrapezoidRepository trapezoidRepository;
	private CircleRepository circleRepository;
	
	public ShapeService (TriangleRepository triangleRepository,SquareRepository squareRepository,RectangleRepository rectangleRepository,
			TrapezoidRepository trapezoidRepository,CircleRepository circleRepository	) {
		this.triangleRepository = triangleRepository;
		this.squareRepository = squareRepository;
		this.rectangleRepository = rectangleRepository;
		this.trapezoidRepository = trapezoidRepository;
		this.circleRepository = circleRepository;
	}
	
	
	public double saveTriangle(Triangle triangle) {
		triangleRepository.save(triangle);
		
		return triangle.getArea();
	}
	
	public double saveSquare(Square square) {
        squareRepository.save(square);
        return square.getArea();
    }
	
	public double saveRectangle(Rectangle rectangle) {
        rectangleRepository.save(rectangle);
        return rectangle.getArea();
    }
	
	public double saveTrapezoid(Trapezoid trapezoid) {
        trapezoidRepository.save(trapezoid);
        return trapezoid.getArea();
    }
	
	public double saveCircle(Circle circle) {
        circleRepository.save(circle);
        return circle.getArea();
    }
	
	
	public List<Triangle> getTriangles() {
		return triangleRepository.findAll();
	}
	
//	public double CalcAreaByBaseAndHeight(double base, double height) {
//		Triangle tri = triangleRepository.findByBaseAndHeight(base, height);
//		return tri.getArea();
//	}
//	
	 public List<Square> getSquares() {
	        return squareRepository.findAll();
	    }
	 public List<Rectangle> getRectangles() {
	        return rectangleRepository.findAll();
	    }
	 public List<Trapezoid> getTrapezoids() {
	        return trapezoidRepository.findAll();
	    }
	 public List<Circle> getCircles() {
	        return circleRepository.findAll();
	    }
	 
} 