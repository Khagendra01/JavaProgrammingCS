/**
 * 
 * @author Khagendra Khatri
 * @ John Agar
 * CS 219
 * OCT 19
 *This code demonstrate the die tester
 */
import java.util.Scanner;

public class DieTester {

	public static void main(String[] args) {
		DieSimulator playerOne = new DieSimulator();
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Do you wanna cach the fish, type 1 for yes and 2 for no");
		while(myScanner.nextInt() == 1) {
			playerOne.roll();
			System.out.println("Do you keep fishing, type 1 for yes and 2 for no");
		}
		System.out.println("Your fishing point is " + playerOne.getValue());


	}

}
