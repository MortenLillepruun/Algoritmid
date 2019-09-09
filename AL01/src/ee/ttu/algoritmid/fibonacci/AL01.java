package ee.ttu.algoritmid.fibonacci;

public class AL01 {
	
	/**

    *

    * @param n The number of the sequence to return 

    * @return The n-th number in Fibonacci series

    */

    public static String f(int n) {
    	int a = 1, b = 1, c;
    	for (int i = 3; i <= n; i++) {
    		c = a + b;
    		a = b;
    		b = c;
    	}
    	String answer = Integer.toString(a);
    	return answer;

    }


    /**

* Find

    * @param precision The number of digits that have to correspond

    * @return The n-th Fibonacci number that fits the requirements

    */

    public static int findIndex(int precision) {
    	double c = (1 + Math.sqrt(5)) / 2;
    	double gold = Math.round(c * Math.pow(10, precision))/Math.pow(10, precision);
    	int i = 1;
    	
    	while (true) {
    		i++;
    		double d = Double.parseDouble(f(i)) / Double.parseDouble(f(i-1));
    		double answer = Math.round(d * Math.pow(10, precision))/Math.pow(10, precision);
    		if (answer == gold) {
    			break;
    		}
    	}
    	
    	return i;

    }

}
