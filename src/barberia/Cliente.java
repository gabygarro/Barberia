package barberia;

import Exceptions.*;
import barberia.mailer.Correo;
import java.util.ArrayList;
import java.time.LocalDateTime;
import javax.mail.internet.AddressException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

    public static void validar(String telefono) throws InvalidPhoneException {
        Pattern patron = Pattern.compile("(^\\(?(\\d{3})\\)?)?[- ]?(\\d{4})[- ]?(\\d{4})$");
        Matcher m = patron.matcher(telefono);
        if (!m.matches()) {
            throw new InvalidPhoneException("El n\u00famero de tel\u00e9fono " + telefono + " no es v\u00e1lido." + "\nIngrese otro.");
        }
    }
    private String nombre;
    private String correo;
    private String telefono;
    private ArrayList<Cita> citas;
    
    
    public Cliente(String nombre, String correo, String telefono)  throws InvalidNameException, InvalidPhoneException, InvalidEmailException{
        super();
        if (nombre!=""){
            this.nombre=nombre;
        }else{
            throw new InvalidNameException("Por favor, ingrese un nombre"); //el nombre es obligatorio
        }
        
        Correo.validar(correo);
        this.correo=correo;
        validar(telefono);
        this.telefono=telefono;
        this.citas= new ArrayList<>();
    }
    
    public void agregarCita(Cita cita){
        citas.add(cita);
    }
    
    
    public ArrayList<Cita> getCitas(){
        return citas;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getCorreo() {
        return correo;
    }

    
    public void setCorreo(String correo) throws InvalidEmailException {
        Correo.validar(correo);
        this.correo = correo;
    }

    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws InvalidPhoneException {
        validar(telefono);
        this.telefono = telefono;
    }

}
