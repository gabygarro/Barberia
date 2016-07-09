package GUI.administracion;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;


public class SpinnerHora {
    
    private static JSpinner.DateEditor editor;
    
    private static JSpinner spinner;
    

public static JSpinner getInstancia(){
    
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendario.set(Calendar.MINUTE, 0);
        

        SpinnerDateModel modelo = new SpinnerDateModel();
        modelo.setValue(calendario.getTime());

        spinner = new JSpinner();
        spinner.setModel(modelo);

        editor = new JSpinner.DateEditor(spinner, "HH:mm");
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);

        spinner.setEditor(editor);
        return spinner;
        
    }
}
