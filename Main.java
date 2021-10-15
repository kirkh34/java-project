//Kirk Hoey
//Main class that creates the windows of action buttons
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener
{  
   //Buttons for Main Screen
   JButton viewOrdersBtn = new JButton("View Orders");
   JButton viewCustomersBtn = new JButton("View Customers");
   JButton viewEmployeesBtn = new JButton("View Employees");
   JButton createOrdersBtn = new JButton("Create Orders");
   JButton createCustomersBtn = new JButton("Create Customers");
   JButton createEmployeesBtn = new JButton("Create Employees");
   
   //Text for Labels on input windows
   public static String[] custInputStrings = new String[] {"First Name",
                                                          "Last Name",
                                                          "Company",
                                                          "Street",
                                                          "City",
                                                          "State",
                                                          "Zip",
                                                          "Phone",
                                                          "Email"};
                                                          
   public static String[] empInputStrings = new String[] {"First Name",
                                                          "Last Name",
                                                          "Street",
                                                          "City",
                                                          "State",
                                                          "Zip",
                                                          "Phone",
                                                          "Email",
                                                          "Salary",
                                                          "Hire Date",
                                                          "Position"};
                                                          
  public static String[] orderInputStrings = new String[] {"Customer",
                                                          "Order Date",
                                                          "Due Date",
                                                          "Garment Type",
                                                          "Print Area",
                                                          "Ink Colors",
                                                          "Quantity",
                                                          "Price",
                                                          "Notes"};
                                                       
   //Strings for header of table                                                    
   public static String custHeaders[]={"ID","FIRST","LAST","COMPANY","STREET","CITY","STATE","ZIP","PHONE","EMAIL"};         
   public static String empHeaders[]={"ID","FIRST","LAST","STREET","CITY","STATE","ZIP","PHONE","EMAIL","SALARY","HIRE DATE","POSITION"};         
   public static String orderHeaders[]={"ID","CUSTOMER","ORDER DATE","DUE DATE","GARMENT TYPE","PRINT AREA","INK COLORS","QUANTITY","PRICE","NOTES"};         

   public Main(){
      super("Order Management");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      
      //Add Buttons 
      add(createOrdersBtn);
      add(createCustomersBtn);
      add(createEmployeesBtn);
      
      add(viewOrdersBtn);
      add(viewCustomersBtn);
      add(viewEmployeesBtn);
      
      //Add ActionListeners for buttons
      createOrdersBtn.addActionListener(this);
      createCustomersBtn.addActionListener(this);
      createEmployeesBtn.addActionListener(this);
      
      viewOrdersBtn.addActionListener(this);
      viewCustomersBtn.addActionListener(this);
      viewEmployeesBtn.addActionListener(this);

   }
      
   public static void main(String[] args)
   {  
      //Create main window
      Main aFrame = new Main();
      final int WIDTH = 200;
      final int HEIGHT = 250;
      aFrame.setSize(WIDTH, HEIGHT);
      aFrame.setVisible(true);
   }
   
   @Override
   public void actionPerformed(ActionEvent event)
   {  
      //If button clicked, show window for that button
      //Create a new ViewData object which brings up a window that holds a table. It receives a data 2d array, the string array of headers, and window title
      //ReadFile.readFile is a call to a static method from the ReadFile class.  It takes a string for the file and the length of the header array so it knows how to build the 2d array
      Object source = event.getSource();
      if (source == viewOrdersBtn)
         new ViewData(ReadFile.readFile("Orders.txt", orderHeaders.length), orderHeaders, "View Orders");   
      else if (source == viewCustomersBtn)
         new ViewData(ReadFile.readFile("Customers.txt", custHeaders.length), custHeaders, "View Customers");
      else if (source == viewEmployeesBtn)
         new ViewData(ReadFile.readFile("Employees.txt", empHeaders.length), empHeaders, "View Employees");
      else if (source == createOrdersBtn)
         new CreateInputGui("Create Order", "Create Order", "Orders.txt", orderInputStrings, 15, 10, 300, 350);
      else if (source == createCustomersBtn)
         new CreateInputGui("Add Customer", "Add Customer", "Customers.txt", custInputStrings, 15, 10, 275, 350);
      else if (source == createEmployeesBtn)
         new CreateInputGui("Add Employee", "Add Employee", "Employees.txt", empInputStrings, 15, 10, 275, 415);
   }
}