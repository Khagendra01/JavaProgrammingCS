/**
 * 
 * @author Khagendra Khatri
 * @ John Agar
 * CS 219
 * OCT 19
 *This code contain the class of the die
 */
import java.util.Random;

public class DieSimulator {

	public int side;//the side where the die is facing
	public int value;//the total value got by the player
	
	/**
	 * Constructor to roll the die
	 */
	public DieSimulator() {
		roll();
	}
	
	/**
	 * The method to roll the die
	 */
	public void roll() {		
		Random newRandom = new Random();
		int side = newRandom.nextInt(6) + 1;		
		value += side;		
	}
	
	/**
	 * 
	 * @return the total value of fish caught by the user
	 */
	public int getValue() {
		return value;
	}

}
