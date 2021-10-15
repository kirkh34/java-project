//Kirk Hoey
//Creates the window of inputs to be able to add a customer, employee, or order
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateInputGui extends JFrame implements ActionListener
{  
   private String[] inputStrings;
   private JTextField[] textFieldArray;
   private String[] inputArray;
   private JButton addBtn;
   private String file;
   
   //Constructor creats window for input GUI, accepts parameters to customize button text, labels, size of fields, size of labels, and width/height
   public CreateInputGui(String windowTitle, String buttonTitle, String file, String[] inputStrings, int fieldLength, int stringLength, int frameW, int frameH){
      super(windowTitle);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLayout(new FlowLayout(FlowLayout.TRAILING));
      
      //Make Labels all the same length so the labels align nicely
      this.file = file;
      inputStrings = fixedLengthString(inputStrings, stringLength);
      textFieldArray = new JTextField[inputStrings.length];
      inputArray = new String[inputStrings.length];
      addBtn = new JButton(buttonTitle);
      
      //Build the window of textFields and labels
      //Also build an array of textFields to use in listener to get text entered with getText()
      for(int i=0; i < inputStrings.length; ++i)
      {
         textFieldArray[i] = new JTextField(fieldLength);
         add(new JLabel(inputStrings[i]));
         add(textFieldArray[i]);
      }
      
      add(addBtn);
      //Exapnd button size of screen
      addBtn.setPreferredSize(new Dimension((frameW - 10), 35));
      addBtn.addActionListener(this);
      this.setSize(frameW, frameH);
      this.setVisible(true);
   }
      
   @Override
   public void actionPerformed(ActionEvent event)
   {
      //Build array of strings containing all text that was input
      for(int i=0; i < textFieldArray.length; ++i)
      {
         inputArray[i] = textFieldArray[i].getText();
      }
            
   //If add button was clicked, take array above and write to file in CreateFile class                          
   Object source = event.getSource();
      if (source == addBtn)
      {
         new WriteFile(inputArray, file);
         this.setVisible(false);
         this.dispose();
         JOptionPane.showMessageDialog(null, "The record has been added to " + file);
      }
   }
   
   //Function that makes all labels the same length for sytling reasons
   public String[] fixedLengthString(String[] string, int length) {
   
      String[] newStrings = new String[string.length];
      
      for(int i = 0; i < string.length; ++i)
      {
         newStrings[i] = String.format("%1$"+length+ "s", string[i]);
      }
    return newStrings;
   }
}