package barberia.mailer;


import Exceptions.InvalidEmailException;
import java.util.Properties;

import java.time.LocalDateTime;


import javax.mail.MessagingException;

import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import barberia.*;
import java.time.format.DateTimeFormatter;
import javax.mail.internet.AddressException;

 
public class Correo{
    private static final String host = "smtp.gmail.com";

    public static void validar(String email) throws InvalidEmailException {
        try {
            InternetAddress dir = new InternetAddress(email);
            dir.validate();
        } catch (AddressException e) {
            throw new InvalidEmailException("El email \"" + email + "\" no es v\u00e1lido. Inserte otro");
        }
    }
    private final String remitente;
    private final String contrasena;
    private String asunto;
    private String cuerpo;
    private String destinatario;
        
        
        
        @SuppressWarnings("empty-statement")
   
        
    public Correo(Cita cita, Barberia barberia){            
            LocalDateTime fecha= cita.getFecha();
            String correoCliente= cita.getCliente().getCorreo();
            
            this.remitente = barberia.getCorreo();
            this.contrasena = barberia.getContrasenaCorreo();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yy   HH:mm");
            this.destinatario=cita.getCliente().getCorreo();
            this.asunto = "Confirmación de cita HairCut Bros.";
            this.cuerpo= "Su cita en la barbería está agendada para las siguientes fecha y hora: \n"
                    +fecha.format(dateFormat)+ "\nPor favor póngase encontacto para confirmarla";
        }
       
    public void enviar(){
            try {
                Properties propiedades = System.getProperties();
                propiedades.put("mail.smtp.starttls.enable", "true");//protocolo de envío de correo
                propiedades.put("mail.debug", "true");//debugger; no es necesario. solo para estar probando. Se puede quitar

                Session sesion= Session.getDefaultInstance(propiedades, null);

                MimeMessage mensaje = new MimeMessage(sesion);
                mensaje.setSubject(asunto);
                mensaje.setText(cuerpo);
                
                Transport transport = sesion.getTransport("smtp");
                transport.connect("smtp.gmail.com", "barberiahaircutbros@gmail.com", "Lucky Charms"); //autenticacion
                
                InternetAddress [] destinatario = {new InternetAddress (this.destinatario)};
                transport.sendMessage(mensaje,destinatario); //envía mensaje. rezar.
                transport.close();

            }catch(MessagingException ex){     
                //System.err.println("ERROR: " + ex);
            }
        }
}
