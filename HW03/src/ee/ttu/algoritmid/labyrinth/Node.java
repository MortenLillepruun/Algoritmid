package ee.ttu.algoritmid.labyrinth;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Node {
	
	private List<String> route = new ArrayList<String>();
	private MazeRunner mr;
	private Node parent;
	private String previous;
	private int weight = 0;
	private Stack<Direction> possibleWays = new Stack<Direction>();
	private String[] compass = {"N", "W", "E", "S"};
	private String[] flippedCompass = {"S", "E", "W", "N"};
	private List<SimpleEntry<Integer, Integer>> visited = new ArrayList<SimpleEntry<Integer,Integer>>();
	private SimpleEntry<Integer, Integer> position;
	public int currentWeight = 0;	

	public Node(MazeRunner mr) {
		this.mr = mr;
		this.parent = null;
		this.previous = "#";
		this.position = mr.getPosition();
		this.possibleWays = getDirections();
	}
	
	public Node(Node parent, Direction direction) {
		this.mr = parent.mr;
		this.currentWeight = direction.weight;
		this.weight = parent.getWeight() + direction.weight;
		this.previous = direction.back;
		this.parent = parent;
		this.route.addAll(parent.getRoute());
		this.visited.addAll(parent.getVisited());
		this.position = mr.getPosition();
		this.route.add(direction.direction);
		this.possibleWays = getDirections();
		this.visited.add(position);
	}

	private Stack<Direction> getDirections() {
		Stack<Direction> ways = new Stack<Direction>();
		List<List<Integer>> scan = mr.scan();
		int[] s = new int[4];
		s[0] = scan.get(0).get(1);
		s[1] = scan.get(1).get(0);
		s[2] = scan.get(1).get(2);
		s[3] = scan.get(2).get(1);
 		for (int i = 0; i < 4; i++) {
			if (s[i] == -2) {
				ways.push(new Direction(s[i], compass[i], flippedCompass[i]));
				i = 3;
			}
			if (s[i] != -1 && compass[i] != getPrevious() && notVisited(position)) {
				ways.push(new Direction(s[i], compass[i], flippedCompass[i]));
			}
		}
		return ways;
	}



	private boolean notVisited(SimpleEntry<Integer, Integer> pos) {
		if (visited.contains(pos)) {
			return false;
		} else {
			return true;
		}
	}

	public Node nextMove() {
		Direction next = possibleWays.pop();
		mr.move(next.direction);
		return new Node(this, next);
	}

	public boolean deadEnd() {
		return possibleWays.empty();
	}

	public boolean foundTreasure() {
		return currentWeight == -2;
	}

	public String getPrevious() {
		return previous;
	}

	public Node getParent() {
		return parent;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public List<String> getRoute() {
		return route;
	}
	
	public List<SimpleEntry<Integer, Integer>> getVisited() {
		return visited;
	}

}
