package ee.ttu.algoritmid.tsp;

public class Main {

	public static void main(String[] args) {
		TSP t = new TSP();
		
		int[][] matrix = {
				{0,14,4,10,20},
				{14,0,7,8,7},
				{4,5,0,7,16},
				{11,7,9,0,2},
				{18,7,17,4,0}
		};
		
		int[][] matrix2 = { 
			{0,2,7,3},
			{5,0,3,4},
			{3,4,0,8},
			{6,8,9,0}
		};
		
		System.out.println(t.bestFirst(matrix));
		System.out.println(t.getLastCheckedNodesCount());

	}

}
