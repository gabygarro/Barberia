package barberia;
import Exceptions.BusyHourException;
import Exceptions.CreatedAppointmentThrowable;
import Exceptions.DateOutOfScheduleException;
import GUI.funciones.funciones;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Daniel
 */
public class Agenda {
    private ArrayList<Cita> citas;
    private final Barberia barberia;
    private HorarioAtencion horario;
    
    
    
    public Agenda(Barberia barberia){
        this.barberia = barberia;
        this.citas = new ArrayList<>();
    }
    
    public ArrayList<Cita> getCitas(){
        return this.citas;
    }
    
    public void setHorario(HorarioAtencion horario){
        this.horario = horario;
    }
    
    public ArrayList<Cita> getCitasDia(){ //devuelve las citas del día siguiente
        LocalDateTime fecha = LocalDateTime.now();
        LocalDateTime fechaFinal = fecha.plusDays(1);
        ArrayList<Cita> citasDia = new ArrayList<>();
        
        for (Cita cita : citas){
            if (((cita.getFecha().isAfter(fecha))||cita.getFecha().equals(fecha)) && (cita.getFecha().isBefore(fechaFinal)||(cita.getFecha().isEqual(fechaFinal)))){
                citasDia.add(cita);
                System.out.println("Tamano : " + citasDia.size());
            }
        }
        return citasDia;
    }
    
        
    
    public ArrayList<Cita> getCitasSemana(LocalDateTime fecha){ //devuelve las citas de la semana   
        ArrayList<Cita> citasSemana =  new ArrayList<>();;      //despues de la fecha pasada por parametro
        LocalDateTime fechaFinal=fecha.plusWeeks(1);
        for (Cita cita : citas){
            if (((cita.getFecha().isAfter(fecha))||cita.getFecha().equals(fecha)) && (cita.getFecha().isBefore(fechaFinal)||(cita.getFecha().isEqual(fechaFinal)))){
                citasSemana.add(cita);
            }
        }
        return citasSemana;
    }
    public ArrayList<Cita> getCitasMes(LocalDateTime fecha){
        ArrayList<Cita> citasMes =  new ArrayList<>();;
        LocalDateTime fechaFinal = fecha.plusMonths(1);
        for(Cita cita : citas){
            if (((cita.getFecha().isAfter(fecha))||cita.getFecha().equals(fecha)) && (cita.getFecha().isBefore(fechaFinal)||(cita.getFecha().isEqual(fechaFinal)))){
                citasMes.add(cita);
                
            }
        }
        return citasMes;
    }
    public void reacomodar(Cita cita, LocalDateTime fechaHora) throws DateOutOfScheduleException, BusyHourException{
        citas.remove(cita);
        horario.validarEnHorario(fechaHora);
        if (citas.isEmpty()){
            citas.add(cita);
            cita.setFecha(fechaHora);
        }else{
            for (Cita c : citas){
                if (c.getFecha().equals(fechaHora)){//si hay una cita en el horario escogido
                    throw new BusyHourException("El espacio escogido para la cita ya está ocupado");
                }
                else if (c.getFecha().isAfter(fechaHora)){//así quedan acomodadas en orden
                    
                    cita.setFecha(fechaHora);
                    citas.add(citas.indexOf(c), cita);//antes de la que tiene 
                    System.out.println("cita reacomodada");
                    
                    break;//termina el ciclo para que no la inserte una cantidad infinita de veces
                }
                else {
                    cita.setFecha(fechaHora);
                    citas.add(citas.indexOf(c)+1, cita);//antes de la que tiene 
                    System.out.println("cita reacomodada");
                    
                    break;
                }
            }
            
        }
    }
    public void agregarCita(Cliente cliente, Calendar calendario, ArrayList<Servicio> servicios, String detalle) throws BusyHourException, CreatedAppointmentThrowable, DateOutOfScheduleException{
        LocalDateTime fechaHora = funciones.calToDate(calendario);
        
        horario.validarEnHorario(fechaHora);
        if (citas.isEmpty()){
            System.out.println("primera cita creada. EVER.");
            Cita cita = new Cita(cliente, fechaHora, servicios, detalle);
            citas.add(cita);
            cliente.agregarCita(cita);
            
        }else{
            for (Cita c : citas){
                if (c.getFecha().equals(fechaHora)){//si hay una cita en el horario escogido
                    throw new BusyHourException("El espacio escogido para la cita ya está ocupado");
                }
                else if (c.getFecha().isAfter(fechaHora)){//así quedan acomodadas en orden
                    System.out.println("cita creada");
                    Cita cita = new Cita(cliente,fechaHora, servicios, detalle);
                    citas.add(citas.indexOf(c), cita);//antes de la que tiene 
                    cliente.agregarCita(cita);
                    break;//termina el ciclo para que no la inserte una cantidad infinita de veces
                }
                else {
                    Cita cita = new Cita(cliente,fechaHora, servicios, detalle);
                    citas.add(citas.indexOf(c)+1, cita);//antes de la que tiene 
                    cliente.agregarCita(cita);
                    break;
                }
            }
        }
        throw new CreatedAppointmentThrowable("La cita se ha registrado de manera exitosa");
    }
}
                
                