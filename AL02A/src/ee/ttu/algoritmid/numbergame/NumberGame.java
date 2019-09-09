package ee.ttu.algoritmid.numbergame;

import java.util.Arrays;

public class NumberGame {
	Oracle oracle;
    public NumberGame(Oracle oracle) {
       this.oracle = oracle;
    }
    public int play(int[] array) {
        Arrays.sort(array);
        int middleIndex = array.length / 2; 
        int middleInt = array[middleIndex];
        int oraakel = oracle.isIt(middleInt);
        
        if (oraakel == 1) {
        	return play(Arrays.copyOfRange(array, array.length/2 + 1, array.length));
        }
        
        else if (oraakel == -1) {
        	return play(Arrays.copyOfRange(array, 0, array.length/2));
        }
        
        else {
        	return middleInt;
        }
    }
    
    public static void main(String[] args) {
    	System.out.println(new NumberGame(new Oracle(8)).play(new int[]{3,5,7,2,0,8,15,11}));
    }
}
