//Kirk Hoey
//Creates window for viewing customers, employees, or orders
import javax.swing.*;
import java.awt.*;  
import java.util.*;

public class ViewData {    
        
    public ViewData(String[][] data, String[] columns, String windowTitle)
    {  
       //Create Frame, Create Table, Create ScrollPane
       //Builds a table in a scrollable window, accepts data, string array of column names, and a window title  
       JFrame frame = new JFrame(windowTitle);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
       JTable table = new JTable(data,columns);   
       table.setBounds(30,40,200,300);          
       JScrollPane scrollPane = new JScrollPane(table);    
       frame.add(scrollPane);          
       frame.setSize(1000,200);    
       frame.setVisible(true);  
       
   }     

}  