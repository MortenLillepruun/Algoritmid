package ee.ttu.algoritmid.tsp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TSP {
	
	public static int citiesCount;
	public static int[][] adjacencyMatrix;
	public static BigInteger viewedNodes;

        /* Best first search */
 	public List<Integer> bestFirst(int[][] matrix) {
 		if (matrix.length == 0) return Arrays.asList();
 		if (matrix.length == 1) return Arrays.asList(0);
 		citiesCount = matrix.length;
 		adjacencyMatrix = matrix;
		viewedNodes = BigInteger.valueOf(0);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(comparator);
		
		Node rootNode = new Node(0);
		viewedNodes = viewedNodes.add(BigInteger.valueOf(1));
		pq.offer(rootNode);
		while (rootNode.depth < citiesCount) {
			rootNode = pq.poll();
			pq.addAll(TSP.getRoutes(rootNode));
		}
		
		List<Integer> bestRoute = new ArrayList<Integer>();
		for (int i = 0; i < rootNode.route.length; i++) {
			bestRoute.add(rootNode.route[i]);
		}
      	return bestRoute;
   	}

	/* Nodes viewed in last matrix to find the solution */
	public BigInteger getLastCheckedNodesCount() {
		return viewedNodes;
	}
	
	public static Comparator<Node> comparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			if (o1.potentialBest > o2.potentialBest) return 1;
			if (o1.potentialBest < o2.potentialBest) return -1;
			return 0;
		}
	};
	
	
	public static Collection<Node> getRoutes(Node node) {
		Collection<Node> collection = new ArrayList<Node>();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			
			if (checkIfNotVisited(i, node.route)) {
				Node child = new Node(node, i);				
				if (child.depth < citiesCount) viewedNodes = viewedNodes.add(BigInteger.valueOf(1));
				collection.add(child);
				
			}
		} 
		return collection;
	}
	
	public static boolean checkIfNotVisited(int i, int[] route) {
		for (int n : route) {
			if (i == n) return false;
		}
		return true;
	}
	
	public static int findMin(int[] list) {
		int min = Integer.MAX_VALUE;
		for (int i : list)
			if (i != 0 && min > i)
				min = i;
		return min;
	}
}