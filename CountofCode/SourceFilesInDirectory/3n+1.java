import java.util.*;
import java.math.*;
import java.io.*;

public class 3nplus1 {
   public static void main(String[] args) throws Exception {
      Scanner input = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out, true);
      
      String filenameInput = "input.txt";
      long i, j, start = 0, end = 0, max = 0;
      if(args.length == 1)
      {
         filenameInput = args[0];
      }
      
      input = openFile(filenameInput);
   
      while (input.hasNextInt()) {
         i = input.nextInt();
         j = input.nextInt();
         start = Math.min(i, j);
         end = Math.max(i, j);
         max = 0;
      
         for (long n = start; n <= end; n++) {
            max = Math.max(max, cycleLength(n));
         }
      
         out.printf("%d %d %d\n", i, j, max);
      }
   }

   public static long next(long n) 
   {
      if (n % 2 == 0)
         return n / 2;       
      else
         return 3 * n + 1;   
   }

   public static long cycleLength(long n) {
      if (n == 1) {
         return 1;
      }
   	
      long cl = 1 + cycleLength(next(n));
   	
      return cl;
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
         System.out.print("No file found. (Type 'exit' to end)\nEnter input numbers: ");
         fileScanner = new Scanner(System.in);
         if (fileScanner.equals("exit"))
            System.exit(0);
      }
   
      return fileScanner;
   }
}