package ee.ttu.algoritmid.numbergame;

public class Oracle {
	private int correctNumber;
    public Oracle(int correctNumber) {
        this.correctNumber = correctNumber;
    }
    /**
     * @param guess - number you think is correct
     * @return
     *      1 if correct number is bigger than your guess
     *     -1 if correct number is smaller than your guess
     *      0 if your guess is correct
     */
    public int isIt(int guess) {
        if (correctNumber > guess) {
            return 1;
        } else if (correctNumber < guess) {
            return -1;
        }
        return 0;
    }
}
