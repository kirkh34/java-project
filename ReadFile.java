import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.util.*;

public class ReadFile
{
   public static String s;
   public static String[] array;
   public static String delimiter = ",";
   public static String[][] data;
   public static int count = 0;
   public static InputStream iStream;
   public static BufferedReader reader;

   public static String[][] readFile(String fileName, int colNum)
   {
      try
      {
         int lines = WriteFile.countLines(fileName); //Count lines in file from CreateFile class to use to build 2d array
         array = new String[colNum];  
         Path file = Paths.get(fileName);
         iStream = new BufferedInputStream(Files.newInputStream(file));
         reader = new BufferedReader(new InputStreamReader(iStream));
         count = 0;
         data = new String[lines][array.length];
         s = reader.readLine();
         
         //Loop through reader and build 2d array
         while(s != null)
         {
            array = s.split(delimiter);
            if(!array[0].equals(null) && count != lines)
            {
               for(int i = 0; i < array.length; ++i)
               {
                  data[count][i] = array[i];
               }
            }
            s = reader.readLine();
            ++count;
         }
      reader.close();
      }
      catch(Exception e)
      {
         System.out.println("Message: " + e.getMessage());
         System.out.println("Line Number: " + e.getStackTrace()[0].getLineNumber());
      }
      //Return 2d array of data to be used in ViewData to build table
      return data;
   }
  
}