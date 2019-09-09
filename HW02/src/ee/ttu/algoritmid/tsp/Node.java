package ee.ttu.algoritmid.tsp;

import java.util.Arrays;

public class Node {
	
	int[] route;
	int depth = 0;
	int distance = Integer.MAX_VALUE;
	int potentialBest = 0;
	
	public Node(int root) {
		this.depth = 1;
		this.distance = 0;
		this.route = new int[]{root};
		this.potentialBest = findBestOutcome();
	}
	
	public Node(Node parent, int newRouteElement) {
		this.depth = parent.depth + 1;
		this.route = newRoute(newRouteElement, parent.route);
		if (depth < TSP.citiesCount) {
			this.distance = calculateDistance();
			this.potentialBest = findBestOutcome();
		} else {
			this.route = newRoute(route[0], route);
			this.distance = calculateDistance();
			this.potentialBest = distance;
		}
	}
	
	public int[] newRoute(int element, int[] route) {
		int[]  newRoute =  Arrays.copyOf(route, route.length + 1);
		newRoute[route.length] = element;
		return newRoute;
	}
	
	public int calculateDistance() {
		int distance = 0;
		for (int i = 0; i < route.length-1; i++)
			distance += TSP.adjacencyMatrix[route[i]][route[i+1]];
		return distance;
	}
	
	public int findBestOutcome() {
		int distance = this.distance;
		distance += TSP.findMin(TSP.adjacencyMatrix[route[route.length - 1]]);
		
		for (int i = 0; i < TSP.adjacencyMatrix.length; i++) {
			if (TSP.checkIfNotVisited(i, route)) {
				distance += TSP.findMin(TSP.adjacencyMatrix[i]);
			} 
		}
		return distance;
	}
	
	public String toString() {
		String route = "";
		for (int i : this.route) {
			route += " " + i;
		}
		return ("route:" + route + "\n" + 
				"depth: " + depth + "\n" + 
				"distance: " + distance + "\n" + 
				"prediction: " + potentialBest + "\n");
	}
	
}