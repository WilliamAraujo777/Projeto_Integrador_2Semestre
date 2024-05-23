
package util;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

public class Validador {
    

public JTextComponent validaTextField(JTextComponent  input) throws Exception{
   
    if(input instanceof JFormattedTextField){
        if(!((JFormattedTextField) input).isEditValid()){
          input.setBorder(new LineBorder(Color.RED, 2, true));
          throw new Exception("Por favot preencha o " + input.getName());  
        }
    }else{
       if(input.getText().equals("")){
        input.setBorder(new LineBorder(Color.RED, 2, true));
        throw new Exception("Por favor preencha o " + input.getName()); 
    } 
    }
    return input;
    
}

 public boolean isDateFimMenorQueInicio(JFormattedTextField fieldDtInicio, JFormattedTextField fieldDtFim) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Obter as datas dos campos
            Date dateInicio = dateFormat.parse(fieldDtInicio.getText());
            Date dateFim = dateFormat.parse(fieldDtFim.getText());

            return dateFim.before(dateInicio);
        } catch (ParseException e) {
            throw new ParseException("Data inválida", 0);   
        }
    }


   

    
    
}
