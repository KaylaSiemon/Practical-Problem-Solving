import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ArithemicOperations {

   public static void main(String[] args)
   {
      DecimalFormat format = new DecimalFormat(); //Decimal Formatting for doubles
      format.setDecimalSeparatorAlwaysShown(false);
   
      Scanner fileIn;
      Scanner fileScanner;
      
      try
      {
         if(args.length == 0) //Checking if file exists
            fileIn = new Scanner(new File("input.txt"));
         else
            fileIn = new Scanner(new File(args[0]));
      
         while(fileIn.hasNext())
         {
            while (fileIn.hasNextInt()) 
            {
               int a = fileIn.nextInt(); //first number
               int b = fileIn.nextInt(); //second number
               
               System.out.println("P:   " + par(a, b)); //print P of the PEMDAS (PARENTHESIS)
               if(b < 0)
                  System.out.println("E:   " + format.format(exponent(a, b))); //if Second Number is negative
               else
                  System.out.println("E:   " + format.format((int)exponent(a, b))); //if Second Number is Positive
               System.out.println("M:   " + format.format(multiply(a, b))); //print M of the PEMDAS (MULTIPLY)
               if (b == 0) //checks if denominator is zero
                  System.out.println("D:   error"); //prints errror
               else
                  System.out.println("D:   " + format.format(divide(a, b))); //if denominator is not a zero. Prints D of the PEMDAS (DIVIDE)
               System.out.println("A:   " + format.format(add(a, b))); //print A of the PEMDAS (ADD)
               System.out.println("S:   " + format.format(subtract(a, b))); //prints S of the PEMDAS (SUBTRACT)
               System.out.println(); //blank line
            }
         
         }
      }
      catch(FileNotFoundException e) //if file is not found
      {
         System.out.print("No file found. (Type 'exit' to end)\nEnter input numbers: "); //request input from user
         fileScanner = new Scanner(System.in);
         if (fileScanner.equals("exit")) //exit to exit program
            System.exit(0);
      }
   
   }
   
   public static String par(int a, int b) //parenthesis method
   {
      return "(" + a + ", " + b + ")";
   }
   
   public static double exponent(double base, int exp) {
      if (exp > 0) // if exp is positive
         return (base * exponent(base, exp - 1)); //multiplies by that many times
      else if (exp < 0) // if exp is negative
         return (1/exponent(base, -exp)); //1 divided by the exps that many times
      else
         return 1; //else exp == 0, which is always 1
   }   
       
   public static int multiply(int a, int b) //multiply method
   {
      return a*b;
   }
   
   public static double divide(int a, int b) //divide method
   {
      if (b == 0) //checks if denominator is zero
         return 0; //returns 0 == "error"
      double c = (double)a/b; //divides a and b and converts to double.
      return c;
   }
   
   public static int add(int a, int b) //add method
   {
      return a+b;
   }

   public static int subtract(int a, int b) // subtract method
   {
      return a-b;
   }

}