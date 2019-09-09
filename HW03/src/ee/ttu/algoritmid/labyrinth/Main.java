package ee.ttu.algoritmid.labyrinth;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		HW03 m = new HW03("maze.txt");
		System.out.println(m.solve());

	}

}
