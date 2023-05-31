/**
 * 
 * @author Khagendra Khatri
 * @ John Agar
 * CS 219
 * OCT 19
 *This code contain the class of television
 */
public class Television {

	public final String MANUFACTURER;//constant to hold the name  of the manufacturer
	public final int SCREEN_SIZE;// constatnt to hold the screen size
	public boolean powerOn;// boolean to hold the power of the tv
	public int channel;// channel value that is being displayed
	public int volume;// value of the volume

	/**
	 * 
	 * @param manufacturer is the name of manufacturer of the television
	 * @param size is the size of the television
	 */
	public Television(String manufacturer, int size) {
		MANUFACTURER = manufacturer;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel = 2;
	}

	/**
	 * 
	 * @return the volume of the Television
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * 
	 * @return the channel of the Television
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * 
	 * @return the name of the manufacturer of the Television
	 */
	public String getManufacturer() {
		return MANUFACTURER;
	}

	/**
	 * 
	 * @return the screen size of the Television
	 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}

	/**
	 * 
	 * @param newChannel is teh new channel to be set
	 */
	public void setChannel(int newChannel) {
		channel = newChannel;
	}

	/**
	 * toggle the power button of the television
	 */
	public void power() {
		powerOn = !powerOn;
	}

	/**
	 * increase the volume of the television
	 */
	public void increaseVolume() {
		volume++;
	}
	
	/**
	 * decrease the volume of the television
	 */
	public void decreaseVolume() {
		volume--;
	}
}
