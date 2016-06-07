/*
* Kayla M Siemon
* Assignment 2
* Programming Challenges: Hartals
*
* Numbers are passed in through either file input or (if that is unavailible) user input. The first number
* indicates the number of test cases, the next number is the number of days, the next number is the number
* of political parties to take into account and the final number is the number of hartal parameter which will
* never be a multiple of 7.
*
* The output is the number of working days that would be lost.
*
*/

import java.util.*;
import java.io.*;

public class hartals {
   public static void main(String []args){
      Scanner input = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out, true);

      String filenameInput = "input.txt";

      if(args.length == 1)
      {
         filenameInput = args[0];
      }
      input = openFile(filenameInput);

      boolean Days[] ;

      int testCases = input.nextInt(), //2
            numDays=0,
            numParties,
            hParameter,
            hartals,
            temp;

      while (testCases-- > 0)
      {
         hartals=0;
         numDays = input.nextInt(); //14
         Days = new boolean[numDays];
         hParameter = input.nextInt(); //3
         while (hParameter-- > 0) {
            temp = 0;
            numParties = input.nextInt();//3 //4 //8
            while (temp + numParties <= numDays) {
               if((temp + numParties)%7!=6 && (temp + numParties)%7!=0)
                  Days[(temp+numParties)-1] = true;
               temp += numParties;
            }
         }
         for (boolean s:Days)
            if (s) hartals++;
         System.out.println(hartals);
      }
   }

   private static Scanner openFile(String fileName)
   {
      Scanner fileScanner = null;
      try
      {
         File fileHandle = new File(fileName);
         fileScanner = new Scanner(fileHandle);
      }
      catch(FileNotFoundException e)
      {
         System.out.print("No file found. (Type 'exit' to end)\nEnter input numbers: \n");
         fileScanner = new Scanner(System.in);
         if (fileScanner.equals("exit"))
            System.exit(0);
      }
      return fileScanner;
   }
}
