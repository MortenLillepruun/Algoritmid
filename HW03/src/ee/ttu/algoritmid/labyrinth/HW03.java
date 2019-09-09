package ee.ttu.algoritmid.labyrinth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.io.IOException;
import java.net.URISyntaxException;

public class HW03 {
    private MazeRunner mazeRunner;
    
    public HW03(String fileName) throws IOException, URISyntaxException {
        mazeRunner = new MazeRunner(fileName);
    }

    public MazeRunner getMazeRunner() {
        return mazeRunner;
    }
    /**
     * Returns the list of steps to take to get from beginning ("B") to
     * the treasure ("T").
     * @return  return the steps taken as a list of strings (e.g., ["E", "E", "E"])
     *          return null if there is no path (there is no way to get to the treasure).
     */
    public List<String> solve() {
        Node n = new Node(mazeRunner);
        ArrayList<Node> routes = new ArrayList<Node>();
	     while (n != null) {   
        	while (!n.deadEnd()) {
	        	n = n.nextMove();
	        	System.out.println(n.getWeight());
	        	if (n.foundTreasure()) {
	        		routes.add(n);
	        	}
	        }
	        
	        while (n.deadEnd()) {
	        	mazeRunner.move(n.getPrevious());
	        	n = n.getParent();
	        	if (n == null) break;
	        }
    	}
        routes.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.getWeight() > o2.getWeight()) {
					return 1;
				} else {
					return -1;
				}
			}
        	
		});
        if (routes.isEmpty()) {
        	return null;
        } else {
        
        	return routes.get(0).getRoute();
        }
    }
}