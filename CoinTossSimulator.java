/**
 * 
 * @author Khagendra Khatri
 * @ John Agar
 * CS 219
 * OCT 19
 *This code include the coin class
 */
import java.util.Random;

public class CoinTossSimulator {
	
	private String sideUp;// variable to hold the side up
	
	/**
	 * Constructor to toss the coin
	 */
	public CoinTossSimulator() {
		toss();
	}
	
	/**
	 * This function toss the coin with random class
	 */
	public void toss() {
		Random newRandom = new Random();
		int randomNumber = newRandom.nextInt(2);
		sideUp = getStringVersion(randomNumber);
	}
	
	/**
	 * 
	 * @param x is either 0 which is head or 1 which is tail
	 * @return string heads or tails according to the paramter
	 */
	public String getStringVersion(int x) {
		if( x == 0 ) return "heads";
		return "tails";
	}
	
	/**
	 * 
	 * @return string the side where the coin is facing into
	 */
	public String getSideUp() {
		return sideUp;
	}

}
