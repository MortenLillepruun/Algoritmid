package ee.ttu.algoritmid.crypto;

public class AL08A {
    private Integer p = null;
    private Integer g = null;

    /**
     * Constructor.
     * See https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange for information.
     * @param p   the p value
     * @param g   the g value
     */
    public AL08A(Integer p, Integer g) {
        this.p = p;
        this.g = g;
    }

    /**
     * Crack the Alice secret key (a) using both A and B message.
     *
     * @param A   the A message from Alice
     * @param B   the B message from Bob
     * @return the value of a (the secret integer of Alice)
     */
    public Integer crack(Integer A, Integer B) {
    	Double B2 = Math.pow((double) g, 15) % p; 
    	//Integer sb = (int) (Math.pow((double) A, 15) % p);
    	//System.out.println(B2);
    	//System.out.println(sb + " - sb");
    	for (int i = 0; i < p; i++) {
    		Integer sa = (int) (Math.pow(B, (double) i) % p);
    		Integer testA = (int) (Math.pow((double) g, (double) i) % p);
    		//System.out.println(sa + " - sa, i = " +i);
    		if (A == testA) {
    			return i;
    		}
    	}
        return null;
    }

    /**
     * Crack the Alice secret key (a) using only message A.
     *
     * @param A   the A message from Alice
     * @return the value of a (the secret integer of Alice)
     */
    public Integer crackHarder(Integer A) {
    	Double B2 = Math.pow((double) g, 15) % p; 
    	Integer sb = (int) (Math.pow((double) A, 15) % p);
    	System.out.println(B2);
    	System.out.println(sb + " - sb");
    	for (int i = 0; i < p; i++) {
    		Integer sa = (int) (Math.pow(B2, (double) i) % p);
    		System.out.println(sa + " - sa, i = " +i);
    		if (sa == sb) {
    			return i;
    		}
    	}
    	return null;
    }
}