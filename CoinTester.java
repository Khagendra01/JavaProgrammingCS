/**
 * 
 * @author Khagendra Khatri
 * @ John Agar
 * CS 219
 * OCT 19
 *This code demonstrate the coin tester
 */
public class CoinTester {

	public static void main(String[] args) {
		partFTester();
		partSTester();
	}
	/**
	 * This function runs the first part of the module
	 */
	public static void partFTester() {
		int nHead = 0;
		CoinTossSimulator newSimulator = new CoinTossSimulator();
		System.out.println(newSimulator.getSideUp());
		for(int i = 0; i < 20 ; i++) {
			newSimulator.toss();
			System.out.println(newSimulator.getSideUp());
			if ( newSimulator.getSideUp() == "heads" ) {
				nHead++;
			}
		}
		
		System.out.println("The number of heads is " + nHead);
		System.out.println("The number of tails is " + (20 - nHead) );
	}
	
	/**
	 * This function runs the second part of the module
	 */
	public static void partSTester() {
		int myMoneyCents = 0;
		CoinTossSimulator coinQuarter = new CoinTossSimulator();//instance as a quarter
		CoinTossSimulator coinDime = new CoinTossSimulator();//instance as a dime
		CoinTossSimulator coinNickel = new CoinTossSimulator();//instance as a nickel
		while( myMoneyCents < 100 ) {
			if(coinQuarter.getSideUp() == "heads" ) {
				myMoneyCents += 25; 
			}
			if(coinDime.getSideUp() == "heads" ) {
				myMoneyCents += 10; 
			}
			if(coinNickel.getSideUp() == "heads" ) {
				myMoneyCents += 5; 
			}
			coinQuarter.toss();
			coinDime.toss();
			coinNickel.toss();
		}
		if(myMoneyCents == 100 ) {
			System.out.println("Congratulation, you win the game");
		}else {
			System.out.println("You Lose!!!!");
		}
	}
}
