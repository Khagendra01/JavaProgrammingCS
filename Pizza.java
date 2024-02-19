/** 
@author KGen
Pizza class
**/
public class Pizza
	{
		public enum type {
      MARGHERITA, PEPPERONI, VEGGIE
    }

    public enum size {
      SMALL, MEDIUM, LARGE
    }
    private type pizzaType;
    private size pizzaSize;
    private int qty;

    public void setType(int num)
    {
      pizzaType = type.values()[num];
    }

    public void setSize(int num)
    {
      pizzaSize = size.values()[num];
    }

    public String getType()
    {
      return pizzaType.toString();
    }

    public String getSize()
    {
      return pizzaSize.toString();
    }

    public void setQty(int num)
    {
      qty = num;
    }

    public int getQty()
    {
      return qty;
    }

    public int calculateCost()
    {
      int priceMovement = 0;

      // Define the base cost for each type of pizza
      switch (pizzaType) {
          case MARGHERITA:
              priceMovement = 14;
              break;
          case PEPPERONI:
              priceMovement = 16;
              break;
          case VEGGIE:
              priceMovement = 9;
              break;
      }

      // Adjust the cost based on the size
      switch (pizzaSize) {
          case SMALL:
              break;
          case MEDIUM:
              priceMovement += 4;
              break;
          case LARGE:
              priceMovement += 6;
              break;
          default:
              break;
      }
      return (priceMovement * qty);
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder();
      sb.append("Pizza Details:\n");
      sb.append("Type: ").append(getType()).append("\n");
      sb.append("Size: ").append(getSize()).append("\n");
      sb.append("Quantity: ").append(getQty()).append("\n");
      sb.append("Total Cost: $").append(calculateCost()).append("\n");
      return sb.toString();
    }

	}