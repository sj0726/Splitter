import java.util.Scanner;

public class resCalc
{
    public static boolean calc()
    {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Grand Total (Meal, Tax, Tip): ");
        double grandTotal = s.nextDouble();
        
        System.out.print("Tax: ");
        double tax = s.nextDouble();
        
        System.out.print("Tip: ");
        double tip = s.nextDouble();
        
        double subTotal = grandTotal - tax - tip;
        
        System.out.print("How many people?: ");
        int numPeople = s.nextInt();
        
        double[] indPrice = new double[numPeople];
        String[] names = new String[numPeople];
        Double sharedFoods = 0.0;
        
        while (true)
        {
            Scanner y = new Scanner(System.in);
            System.out.print("Price of the Shared Foods (Type -1.0 to stop): ");
            Double currentSharedFoods = y.nextDouble();
            if (currentSharedFoods == -1.0)
            {
                break;
            }
            else
            {
                sharedFoods += currentSharedFoods;
            }
        }
        
        sharedFoods /= numPeople;
        
        for (int i = 0; i < numPeople; i++)
        {
            Scanner x = new Scanner(System.in);
            System.out.print("Name: ");
            String n = x.nextLine();
            names[i] = n;
            indPrice[i] += sharedFoods;
            while(true)
            {
                System.out.print("Price (Type -1.0 to stop): ");
                double currentPrice = s.nextDouble();
                if (currentPrice == -1.0)
                {
                    break;
                }
                else
                {
                    indPrice[i] += currentPrice;
                }
            }
        }
        
        System.out.println();
        
        double calcTotal = 0.0;
        for (int i = 0; i < numPeople; i++)
        {
            double indPortion = indPrice[i] / subTotal;
            double indTax = indPortion * tax;
            double indTip = indPortion * tip;
            indPrice[i] += indTax;
            indPrice[i] += indTip;
            calcTotal += indPrice[i];
            System.out.println(names[i] + ": " + indPrice[i]);
        }
        
        System.out.println("----------------");
        System.out.println("Total: " + calcTotal);
        
        if (calcTotal == grandTotal)
        {
            System.out.println("Math works out!");
            return true;
        }
        else
        {
            System.out.println("Uh oh... Math isn't checking out!");
            return false;
        }
    }
}