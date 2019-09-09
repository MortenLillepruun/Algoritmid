package ee.ttu.algoritmid.labyrinth;

public class Direction {
	public int weight;
	public String direction;
	public String back;
	
	public Direction(int w, String d, String b) {
		this.weight = w;
		this.direction = d;
		this.back = b;
	}
}
