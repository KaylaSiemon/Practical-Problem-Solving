/*
*  Kayla M Siemon
*  Assignment 3
*  Didn't achieve the extra credit
*  Successfully 
*/

import java.io.*;
import java.util.*;

public class CountofCode
{
   public static void main(String[] args) throws Exception 
   {
      Console kb = System.console();
      String path = kb.readLine("Welcome!\nPlease enter the path (/Users/username/documents/etc): ");
      String ext = kb.readLine("Please input the extension of the source files (java for Java files, cs for C# files, etc.): ");
      File[] fileList = getFileList(path, ext);
      int count = 0;
      int lines = 0;
      String[] fileArray;
      fileArray = new String[fileList.length];
      for(int i = 0; i < fileList.length; ++i)
      {
         fileArray[i] = fileList[i].getName();
      }
      for(File file : fileList) {
         count++;
      }   
      for(int i = 0; i < count; i++)
      {
         lines += countLines(fileArray[i], path);
      }
      System.out.println("Number of source files processed: " + count);
      System.out.println("The total number of lines of code in all the source files: " + lines);
   
   }

   private static File[] getFileList(String dirPath, String ext) {
      File dir = new File(dirPath);   
      File[] files = dir.listFiles();
      File[] fileList = dir.listFiles(
         new FilenameFilter() 
         {
            public boolean accept(File dir, String name) {
               return name.endsWith(ext);
            }
         });

      return fileList;
   }
   
   public static int countLines(String file, String path) throws FileNotFoundException{  
      FileInputStream fis = new FileInputStream(path + "/" + file);
      LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(fis));
   
      String nextLine = null;
      int ignoredLines = 0;
      try {
         while ((nextLine = lineCounter.readLine()) != null) {
            if (nextLine.startsWith("/*") || nextLine.startsWith("*/") || nextLine.startsWith("*") || nextLine.trim().matches("//*") || (nextLine.trim().matches("")))
            {
               ignoredLines++;
               continue;
            }
         }
      } 
      catch (Exception done) {
         done.printStackTrace();
      
      }
      int lines = lineCounter.getLineNumber();
      int fcounter = lines - ignoredLines ;
   
      return (fcounter);
   }
}