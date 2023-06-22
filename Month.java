/**
 * Author: Khagendra Khatri
 * CS 196
 * Month Class Assignments
 */


public class Month {
	//private variable
	private int monthNumber;
	//constructor with no parameter
	public Month() {
		this(1);
	}
	//constructor to set month number with monthnumber which calls the another method call setmonth number
	public Month(int monthNumber) {
		setMonthNumber(monthNumber);
	}
	//constructor to set month number with month name
	public Month(String monthName) {
		for(int x=1; x<13; x++) {
			if(Emonth.values()[x].name() == monthName) {
				monthNumber = x;
				break;
			}
		}
	}
	// enum to store month where the first ordinal of enum is assigned for arbitary value months which is not usuable but related to context
	public enum Emonth{
		months, January, February, March, April, May, June, July, August, September, October, November, December
	}
	//method to set the month number
	public void setMonthNumber(int monthNumber) {
		if(monthNumber < 13 && monthNumber > 0) {
			this.monthNumber = monthNumber;
		}else {
			this.monthNumber = 1;
		}
	}
	//encapsulated way to get number
	public int getMonthNumber() {		
		return monthNumber;
	}
	//encapsulated way to set number
	public String getMonthName() {
		return Emonth.values()[monthNumber].name();
	}
	//over rided function of tostring to get the string
	@Override
	public String toString() {
		return getMonthName();
	}
	//check if the instance month is equal to the argument month
	public boolean equals(Month myMonth) {
		if(monthNumber == myMonth.getMonthNumber()) {
			return true;
		}else {
			return false;
		}
	}
	//check if the instance month is greater than the argument month
	public boolean greaterThan(Month myMonth) {
		if(monthNumber > myMonth.getMonthNumber()) {
			return true;
		}else {
			return false;
		}		
	}
	//check if the instance month is less than the argument month
	public boolean lessThan(Month myMonth) {
		if(monthNumber < myMonth.getMonthNumber()) {
			return true;
		}else {
			return false;
		}		
	}
		
	
}
