package com.example.project.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.AreaCalcApplication;
import com.example.project.models.Circle;
import com.example.project.models.Polygon;
import com.example.project.models.Rectangle;
import com.example.project.models.Square;
import com.example.project.models.Trapezoid;
import com.example.project.models.Triangle;
//import com.example.project.services.ShapeService;



@RestController
@RequestMapping("/api/shapes")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ShapeController {

//	public ShapeService shapeservice;

//	public ShapeController(ShapeService shapeService) {
//		this.shapeservice = shapeService;
//	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello world";
	}

	@PostMapping("/mapArea")
	public ResponseEntity<Map<String, Double>> findAreaOfPlot(@RequestBody List<double[]> coordinates) {
		Polygon polygon = new Polygon();
		Double area = polygon.findAreaOfMapPlot(coordinates);
		System.out.println("Coordinates received" + coordinates.size());
		Map<String, Double> map = new HashMap<>();
		map.put("area", area);
		return ResponseEntity.ok(map);
	}

	@PostMapping("/polygon")
	public ResponseEntity<Map<String, Double>> findAreaOfPolygon(@RequestBody List<double[]> coordinates) {
		Polygon polygon = new Polygon(); // Create a Polygon instance

		System.out.println("Received coordinates: " + coordinates); // Debugging log

		polygon.addCoordinates(coordinates); // Add the received coordinates to the polygon

		double areaOfPolygon = polygon.findArea(); // Calculate the area of the polygon

		Map<String, Double> response = new HashMap<>(); // Prepare the response map
		response.put("area", areaOfPolygon);

		return ResponseEntity.ok(response); // Return the response as a JSON object
	}


	@PostMapping(value = "/triangle", produces = "application/json")
	public ResponseEntity<Map<String, Double>> addTriangle(@RequestParam double base,
														   @RequestParam double height) {


//		    double areaFromDb = shapeservice.CalcAreaByBaseAndHeight(base,height);
//		    
//		    if(areaFromDb > 0) {
//		    	Map<String, Double> map = new HashMap<>();
//		    	map.put("area", areaFromDb);
//		    	map.put("from", (double) 1 );
//		    	return ResponseEntity.ok(map);
//		    }

		Triangle triangle = new Triangle();
		triangle.setBase(base);
		triangle.setHeight(height);
		double area = 0;
		area = triangle.calculateArea();
		triangle.setArea(area);
		System.out.println(area);
//		    shapeservice.saveTriangle(triangle);

		Map<String, Double> responseMap = new HashMap<>();
		responseMap.put("area", area);
//		    responseMap.put("from", (double) 2);
		return ResponseEntity.ok(responseMap);
	}

	@PostMapping(value = "/square", produces = "application/json")
	public ResponseEntity<Map<String, Double>> addSquare(@RequestParam double side) {
		Square square = new Square();
		square.setSide(side);
		double area = square.calculateArea();
		square.setArea(area);

		Map<String, Double> map = new HashMap<>();
		map.put("area", area);
//		shapeservice.saveSquare(square);
		return ResponseEntity.ok(map);
	}

	@PostMapping(value = "/rectangle", produces = "application/json")
	public ResponseEntity<Map<String, Double>> addRectangle(@RequestParam double length, @RequestParam double width) {
		Rectangle rectangle = new Rectangle();
		rectangle.setLength(length);
		rectangle.setWidth(width);
		double area = rectangle.calculateArea();
		rectangle.setArea(area);
//		shapeservice.saveRectangle(rectangle);

		Map<String, Double> map = new HashMap<>();
		map.put("area", area);
		return ResponseEntity.ok(map);
	}

	@PostMapping(value = "/trapezoid", produces = "application/json")
	public ResponseEntity<Map<String, Double>> addTrapezoid(@RequestParam double base1, @RequestParam double base2, @RequestParam double height) {
		Trapezoid trapezoid = new Trapezoid();
		trapezoid.setBase1(base1);
		trapezoid.setBase2(base2);
		trapezoid.setHeight(height);
		double area = trapezoid.calculateArea();
		trapezoid.setArea(area);
//		shapeservice.saveTrapezoid(trapezoid);

		Map<String, Double> map = new HashMap<>();
		map.put("area", area);

		return ResponseEntity.ok(map);
	}

	@PostMapping(value = "/circle", produces = "application/json")
	public ResponseEntity<Map<String, Double>> addCircle(@RequestParam double radius) {
		Circle circle = new Circle();
		circle.setRadius(radius);
		double area = circle.calculateArea();
		circle.setArea(area);
//		shapeservice.saveCircle(circle);

		Map<String, Double> map = new HashMap<>();
		map.put("area", area);

		return ResponseEntity.ok(map);
	}

//		@GetMapping(value = "/byBaseAndHeight", produces = "application/json")
//		public ResponseEntity<Map<String, Double>> getAreaByBaseAndHeight(@RequestParam double base,double height) {
//			double area = shapeservice.CalcAreaByBaseAndHeight(base,height);
//			Map<String, Double> map = new HashMap<>();
//		    map.put("area", area);
//			return ResponseEntity.ok(map);
//		}


//		@GetMapping("/all-triangles")
//		public List<Triangle> getAllTriangles() {
//			return shapeservice.getTriangles();
//		}
//
//		@GetMapping("/all-squares")
//		public List<Square> getAllSquares() {
//		    return shapeservice.getSquares();
//		}
//
//		@GetMapping("/all-rectangles")
//		public List<Rectangle> getAllRectangles() {
//		    return shapeservice.getRectangles();
//		}
//
//		@GetMapping("/all-trapezoids")
//		public List<Trapezoid> getAllTrapezoids() {
//		    return shapeservice.getTrapezoids();
//		}
//
//		@GetMapping("/all-circles")
//		public List<Circle> getAllCircles() {
//		    return shapeservice.getCircles();
//		}
}