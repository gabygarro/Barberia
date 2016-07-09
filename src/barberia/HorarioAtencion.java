

package barberia;
import Exceptions.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;





public class HorarioAtencion {
    private LocalTime inicio;//incio de jornada laboral
    private LocalTime salida;//salida al almuerzo
    private LocalTime entrada;//entrada del almuerzo
    private LocalTime fin;//fin jornada laboral
    private int diaInicio;
    private int diaFinal;
    
    public HorarioAtencion(){
    }
    
    public HorarioAtencion(int diaInicio, int diaFinal, LocalTime inicio, 
            LocalTime salidaAlmuerzo, LocalTime entradaAlmuerzo, LocalTime fin) 
            throws ScheduleTimingException{
        
        if (    //si los intervalos de horas tienen sentido
                (inicio.isBefore(salidaAlmuerzo))
                &&
                ((salidaAlmuerzo.isBefore(entradaAlmuerzo))||salidaAlmuerzo.equals(entradaAlmuerzo))
                &&
                ((entradaAlmuerzo.isBefore(fin))||entradaAlmuerzo.equals(fin))
            ){
            this.inicio=inicio;
            this.salida=salidaAlmuerzo;
            this.entrada=entradaAlmuerzo;
            this.fin=fin;
        }else{
            throw  new ScheduleTimingException("El horario no es válido");
        }
        if (diaInicio<=diaFinal){
        this.diaInicio = diaInicio;
        this.diaFinal = diaFinal;
        }else{
            throw  new ScheduleTimingException("El horario no es válido");
        }
    }

    public void setHorarioAtencion(int diaIni, int diaFin,LocalTime inicio, 
            LocalTime salidaAlmuerzo, LocalTime entradaAlmuerzo, LocalTime fin) 
            throws ScheduleTimingException{
        //System.out.println("ini "+diaIni + " fin "+ diaFin);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("inicia");
        if (inicio.isBefore(salidaAlmuerzo)||inicio.equals(salidaAlmuerzo)){
            System.out.println("1");
            if (salidaAlmuerzo.isBefore(entradaAlmuerzo)||salidaAlmuerzo.equals(entradaAlmuerzo)){
                System.out.println("2");
                if (entradaAlmuerzo.isBefore(fin)||entradaAlmuerzo.equals(fin)){
                    this.fin=fin;
                    this.inicio=inicio;
                    this.salida=salidaAlmuerzo;
                    this.entrada=entradaAlmuerzo;
                    System.out.println("colocado");

                }else{
                    throw  new ScheduleTimingException("El horario no es válido");
                }
            }else{
                throw  new ScheduleTimingException("El horario no es válido");
        }
        }else{
            throw  new ScheduleTimingException("El horario no es válido");
        }
        
        
        if (diaIni<=diaFin){
            this.diaInicio = diaIni;
            this.diaFinal = diaFin;
            
        }else{
            throw  new ScheduleTimingException("El horario no es válido");
            
        }

    }
    
    public LocalTime getInicio() {
        return inicio;
    }
    public LocalTime getSalida() {
        return salida;
    }
    public LocalTime getEntranda() {
        return getEntrada();
    }
    public LocalTime getFin() {
        return fin;
    }
    
    public void validarEnHorario(LocalDateTime fechaHora) throws DateOutOfScheduleException{
        /*horas inválidas*/
        int dia = fechaHora.getDayOfWeek().getValue();
        
        LocalTime hora = fechaHora.toLocalTime();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("hora cita" +hora.format(df));
        //System.out.println("fin" +fin.format(df));
        if(dia<this.getDiaInicio() || dia>this.getDiaFinal()){
            throw new DateOutOfScheduleException("El día escogido no se encuentra dentro del horario de atención actual.");     
        }else if (hora.isBefore(this.getInicio())){
            throw new DateOutOfScheduleException("La hora escogida es muy temprano para la cita.");
        }else if (hora.isAfter(this.getSalida()) && hora.isBefore(this.getEntrada()) ){
            throw new DateOutOfScheduleException("La hora escogida choca con el receso");
        }else if (hora.isAfter(this.getFin())){
            throw new DateOutOfScheduleException("La hora escogida es muy tarde para la cita.");    
        }
        /*horas inválidas-termina*/
        
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getDiaFinal() {
        return diaFinal;
    }
    
    @Override
    public String toString(){
       char [] dias= new char[]{'L','K','M','J','V','S','D'};
       DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        
       String res="<html>"+
               dias[getDiaInicio()-1] + "-" 
               + dias[getDiaFinal()-1] +"<br/>"
                + getInicio().format(df) + "-" 
               +  getSalida().format(df) +"<br/>"
                + getEntrada().format(df) + "-" 
               +  getFin().format(df)
               +"<html>";
        System.out.println(res);
       return res;
       
    }
        
}