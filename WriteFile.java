//Kirk Hoey
//Writes data to file from input from user
import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;

public class WriteFile
{
   int id;
   String idString;
   String delimiter = ",";
   String record;
   FileChannel fcIn = null;
   
   //Count the lines of a file
   public static int countLines(String fileName)
   {
      int lines = 0;
      try
      {
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         while (reader.readLine() != null) lines++;
         reader.close();
      }
      catch(IOException e)
      {
         System.out.println(e.getMessage());
      }
      return lines;
   }
   
   //Constructor to append to a file or create a new one if none exists. Accepts string array of inputs and relative path
   public WriteFile(String[] inputs, String relativeFilePath)
   {
      id = countLines(relativeFilePath) + 1;
      idString = String.format("%05d", id);
      record = idString + delimiter;
      
      //Build string for record in file
      for(int i = 0; i < inputs.length; ++i)
      {
         if(i != (inputs.length - 1))
            record += inputs[i] + delimiter;
         else
            record += inputs[i] + System.getProperty("line.separator");
      }
      
      //Write record to file
      try
      {
         Path customersFile = Paths.get(relativeFilePath);
         fcIn = (FileChannel)Files.newByteChannel(customersFile, CREATE, APPEND);
          
         byte data[] = record.getBytes();
         ByteBuffer buffer = ByteBuffer.wrap(data);
         
         fcIn.write(buffer);      
         fcIn.close();
      }
      catch(IOException e)
      {
         System.out.println("Error message: " + e);
      }
      
   }
}