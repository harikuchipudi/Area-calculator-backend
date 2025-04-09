package com.example.project.models;
import java.util.*;


public class Polygon {
	List<double[]> coordinates = new ArrayList<>();
	
	 private static final double EARTH_RADIUS = 6371.0;
	
	public void addCoordinates(List<double[]> coordinatesArray) {
		System.out.println("Coordinates Array : " + coordinatesArray.size());
		coordinates.addAll(coordinatesArray);
		System.out.println("After adding: " + coordinates.size());
	}
	
	public void addVertex(double x, double y) {
		coordinates.add(new double[] {x, y});
	}
	
    public static double findAreaOfMapPlot(List<double[]> mapCoordinates) {
        // Convert latitude and longitude coordinates to Cartesian coordinates
        List<double[]> cartesianCoordinates = find2dCoordinates(mapCoordinates);

        //  Shoelace formula 
        double area = calculateShoelaceArea(cartesianCoordinates);

        return area;
    }
    
    public static double calculateShoelaceArea(List<double[]> coordinates) {
        int numPoints = coordinates.size();
        double sum1 = 0.0;
        double sum2 = 0.0;

        for (int i = 0; i < numPoints; i++) {
            double x1 = coordinates.get(i)[0];
            double y1 = coordinates.get(i)[1];
            double x2 = coordinates.get((i + 1) % numPoints)[0];
            double y2 = coordinates.get((i + 1) % numPoints)[1];

            sum1 += x1 * y2;
            sum2 += y1 * x2;
        }

        return Math.abs(sum1 - sum2) / 2.0;
    }
	
    public static List<double[]> find2dCoordinates(List<double[]> mapCoordinates) {
        List<double[]> cartesianCoordinates = new ArrayList<>();

        for (double[] latLon : mapCoordinates) {
            double latitudeRad = Math.toRadians(latLon[0]);
            double longitudeRad = Math.toRadians(latLon[1]);

            // Calculate Cartesian coordinates
            double x = EARTH_RADIUS * longitudeRad;
            double y = EARTH_RADIUS * Math.log(Math.tan(Math.PI / 4 + latitudeRad / 2));

            cartesianCoordinates.add(new double[]{x, y});
        }

        return cartesianCoordinates;
    }
	
	public double findArea() {
		int no_of_sides = coordinates.size();
		
		//using the shoe-lace method to find the area of the polygon
		double left_sum = 0;
		double right_sum = 0;
		for(int i=0; i<no_of_sides-1; i++) {
			left_sum +=  coordinates.get(i)[0] * coordinates.get(i+1)[1];
			right_sum += coordinates.get(i)[1] * coordinates.get(i+1)[0];
		}
		
		left_sum += coordinates.get(no_of_sides-1)[0] * coordinates.get(0)[1];
		right_sum += coordinates.get(no_of_sides-1)[1] * coordinates.get(0)[0];
		
		double res = Math.abs(left_sum - right_sum)/2;
		return res;
	}
	
}

