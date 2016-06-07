/*
*  Kayla M Siemon
*  May 12th, 2016
*  Backpack.java
*  EXTRA CREDIT WAS ATTEMPTED!
*/

import java.io.*;
import java.util.*;

public class backpack {

   public static void maxBenefit(int maxWeight, int Provisions, int[] wt, int[] ben) {
    
   
      int[][] dorasBackpack = new int[Provisions+1][maxWeight+1];
      int[][] changes = new int[Provisions+1][maxWeight+1];
   
      for(int w = 0; w <= maxWeight; w++) {
         dorasBackpack[0][w] = 0;
      }
      for (int i = 0; i <= Provisions; i++) 
      {
         for (int w = 0; w <= maxWeight; w++) 
         {
            if (i==0 || w==0)
               changes[i][w] = 0;
            else if (wt[i-1] <= w)
            {
               int benefit = ben[i-1];
               int weightBen = dorasBackpack[i-1][w-wt[i-1]];
               int weightBefore = dorasBackpack[i-1][w];
               dorasBackpack[i][w] = (benefit + weightBen > weightBefore)? (benefit + weightBen) : weightBefore;
               changes[i][w] = 1;
            } 
            else{
               dorasBackpack[i][w] = dorasBackpack[i-1][w];
               changes[i][w] = 0;
            }
         
         }
      }
      ArrayList<Integer> itemsInPack = new ArrayList<Integer>();
      int tW = maxWeight;
      for(int item = Provisions; item >= 0; item--) {
         if ((changes[item][tW] == 1) && (dorasBackpack[item-1][tW] != dorasBackpack[item][tW]))
         {           
            tW -= wt[item - 1];
            itemsInPack.add(item);
         }
      }
      
      System.out.println("Dora's Backpack Contains:");
      System.out.println("Backpack Maximum Weight: " + maxWeight);
      int weightOfItem = 0, benefitOfItem = 0;
      for(Integer a : itemsInPack) {
         weightOfItem += wt[a-1];
         benefitOfItem += ben[a-1];
         System.out.println("Weight: " + wt[a-1] + " \t\tBenefit: " + ben[a-1]);
      }
      System.out.println("Loaded weight: " + weightOfItem + "\tTotal Benefit: " + benefitOfItem + "\n");
   }
      
   public static void main(String [] args) {
   
      Scanner fileIn;
      int[] oWeight = null, oBenefit = null;
      int datasets = 0, weight = 0, provisions = 0, benefit = 0;
         
      try
      {
         if(args.length == 0)
            fileIn = new Scanner(new File("backpack.in"));
         else
            fileIn = new Scanner(new File(args[0]));
      
         while(fileIn.hasNext())
         {
            datasets = fileIn.nextInt();
         
            if(!(datasets > 0))
               throw new InputMismatchException("First number (Dataset) given must be greater than 0.");
         
            for(int x = 0; x < datasets; x++)
            {
               weight = fileIn.nextInt();
               provisions = fileIn.nextInt();
            
               if(!(provisions > 0))
                  throw new InputMismatchException("Second nmumber (Provisions) given must be greater than 0.");
            
               oWeight = new int[provisions];
               oBenefit = new int[provisions];
            
               for(int i = 0; i < provisions; i++)
               {
                  oWeight[i] = fileIn.nextInt();
                  oBenefit[i] = fileIn.nextInt();
               }
               maxBenefit(weight, provisions, oWeight, oBenefit);
            }
         }
         fileIn.close();
      
      }
      catch (FileNotFoundException a) {
         System.out.print("I'm sorry but that file was not found.\nPlease edit file input.");
      }
   
   }
}