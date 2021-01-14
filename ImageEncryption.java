import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageEncryption {

public static void operate(int key){
   
    //opening file chooser
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showOpenDialog(null);//to open dialog a center null is passed as parameter
    File file = fileChooser.getSelectedFile();//stored the selected file

    //we use FileInputStream to perform read/write to file
    try{
       FileInputStream fis = new FileInputStream(file);
       byte[] data = new byte[fis.available()];//your data read from the file is converted to numbers(in range -127 to 128)
       fis.read(data);
       int i=0;//used for encryption using XOR method
       for(byte b:data){
           System.out.println(b);
           data[i]=(byte)(b^key);//for decryption b=data[i]^key;,here b is the decrypted value and data[i] is encrypted value for each data inside file
           i++;
       }

       //writing encrypted data to file
       FileOutputStream fos = new FileOutputStream(file);
       fos.write(data);
       fos.close();
       fis.close();
       JOptionPane.showMessageDialog(null, "Done");
    }
    catch(Exception e){
        e.printStackTrace();//throwing exception
    }


}

    public static void main(String[] a){
      //creating GUI for image upload and key insertion
      JFrame f = new JFrame();
      f.setTitle("Image Encryption");
      f.setSize(500,500);
      f.setLocationRelativeTo(null);

      //creating button
      Font font = new Font("Roboto",Font.BOLD,20);
      JButton button = new JButton();
      button.setText("Open Image");
      button.setFont(font);

      //creating text field
      JTextField  textField = new JTextField(10);
      textField.setFont(font);

       //calling event when button is clicked
       button.addActionListener(e->{//addActionListener is an interface which 
        //accepts an object of addActionListener but as this is an interface we 
        //will create the object of childclass(which is implemented by us) of 
        //interface, & this is the use case of lambda functions i.e. to replace anonymous class
          System.out.println("button clicked");
          //getting the key value
          String text =textField.getText();
          int  temp = Integer.parseInt(text);
          operate(temp);
      });

      f.setLayout(new FlowLayout());

      f.add(button);
      f.add(textField);
      f.setVisible(true);

    }
    
}
