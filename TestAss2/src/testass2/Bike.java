
package testass2;

public class Bike implements Comparable
{
   private String bikeType, bikeMake, phone;
   private int numOfGears, wheelSize;
   double bikePrice;

    
   // Constructor for Bike passing all the variables from MySorts
   public Bike (String type, String make,  int nOfg, int wheelS, double bp)
   {
      bikeType = type;
      bikeMake = make;
      numOfGears = nOfg;
      wheelSize = wheelS;
      bikePrice = bp;

   }

    public int getBikeGear() {
        return numOfGears;
    }


    public int getWheelSize() {
        return wheelSize;
    }

    public String getType(){
        return bikeType;
    }

    public String getMake()
    {
        return bikeMake;
    }

    public double getPrice()
    {
        return bikePrice;
    }

    void setGears(int n)
    {
        numOfGears = n;
    }

    void setMake(String make)
    {
        bikeMake = make;
    }

    void setType(String type)
    {
        bikeType = type;
    }

    void setPrice(double bp)
    {
        bikePrice = bp;
    }

    void setWheelSize(int wheelS)
    {
        wheelSize = wheelS;
    }
    
    @Override
   public String toString ()
   {
      // Returns output showing info about the Bike to be printed.
      return bikeMake + ", " + bikeType + "\t" + " " + "£" + bikePrice +
              "\t" + "With" + " " + numOfGears + " " + "Gears and a wheel size of"
                + " " + wheelSize + " Inches";
   }

   public int compareTo (Object other)
   {

      // Compares the makes of the bike.
      int result;
      if (bikeMake.equals(((Bike)other).bikeMake))
         result = bikeType.compareTo(((Bike)other).bikeType);
      else
         result = bikeMake.compareTo(((Bike)other).bikeMake);

      return result;
   }

  
}
