import java.util.Scanner;

public class AreaCalculator {

	public static void main(String[] args) {
		
		double length = getLength();
		double breadth = getBreadth();
		double area = calculateArea(length, breadth);
		
		System.out.println("The area is " + area);
	}

	public static double getLength(){
		Scanner inpLength = new Scanner(System.in);
		System.out.println("Enter the length of the field");
		double length = inpLength.nextInt();		
		return length;
	}
	
	public static double getBreadth(){
		Scanner inpBreadth = new Scanner(System.in);
		System.out.println("Enter the breadth of the field");
		double breadth = inpBreadth.nextInt();	
		return breadth;
	}
	
	public static double calculateArea(double setLength, double setBreadth) {
		double calcArea = setLength * setBreadth;
		return calcArea;
	}
}
