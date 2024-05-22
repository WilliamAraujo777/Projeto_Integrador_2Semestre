
package util;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

public class Validador {
    

public JTextComponent validaTextField(JTextComponent  input) throws Exception{
   
    if(input instanceof JFormattedTextField){
        if(!((JFormattedTextField) input).isEditValid()){
          input.setBorder(new LineBorder(Color.RED, 2, true));
          throw new Exception();  
        }
    }else{
       if(input.getText().equals("")){
        input.setBorder(new LineBorder(Color.RED, 2, true));
        throw new Exception();
    } 
    }
    return input;
    
}
   

    
    
}
