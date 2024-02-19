import java.util.Scanner;

/** 
  @author KGen
  Main class
  **/

public class Main 
{
  public static void main(String[] args) 
	{
    
    Pizza myPizza = new Pizza();
    Scanner scanner = new Scanner(System.in);

    int qty, typeChoice, sizeChoice;
    
    System.out.println("Choose the type of pizza:");
    System.out.println("Press 0 for MARGHERITA");
    System.out.println("Press 1 for PEPPERONI");
    System.out.println("Press 2 for VEGGIE");
    
    typeChoice = scanner.nextInt();
    myPizza.setType(typeChoice);

    System.out.println("Choose the size of pizza:");
    System.out.println("Press 0 for SMALL");
    System.out.println("Press 1 for MEDIUM");
    System.out.println("Press 2 for LARGE");
    
    sizeChoice = scanner.nextInt();
    myPizza.setSize(sizeChoice);

    System.out.println("Enter the number of quantity you want to order:");
    qty = scanner.nextInt();
    myPizza.setQty(qty);

    myPizza.calculateCost();

    System.out.println(myPizza);

    scanner.close();
  }
}