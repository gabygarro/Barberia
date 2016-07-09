package barberia;
import Exceptions.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;


public class Barberia {
    private String nombre;
    private String telefono;
    private String correo;
    private String contrasenaCorreo;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> listaDeEspera;
    private ArrayList<Servicio> servicios;
    private Agenda agenda;
    private HorarioAtencion horarioAtencion;
    
    
    
    public Barberia(String nombre, String telefono, String correo)
    {
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo = correo;
        this.clientes = new ArrayList<>();
        this.listaDeEspera = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.agenda = new Agenda(this);
        this.horarioAtencion = new HorarioAtencion();
        
    }
    
    
    public void crearCliente(String nombre, String correo, String telefono) throws ExistingClientException, InvalidPhoneException, InvalidNameException, InvalidEmailException{        
        for (Cliente cliente : clientes){
            
            if (cliente.getCorreo().equals(correo)){
                throw new ExistingClientException("Este cliente (" + cliente.getCorreo() + ") ya existe.");
            }
        }
        clientes.add(new Cliente(nombre, correo, telefono));
  
    }
    
    
    public Servicio crearServicio(String nombre){
        Servicio servicio = new Servicio(nombre);
        servicios.add(servicio);
        return servicio;
    }
    
    public void agregarCita(Calendar calendario,Cliente cliente, ArrayList<Servicio> servicios, String detalle ) throws BusyHourException, CreatedAppointmentThrowable, DateOutOfScheduleException{
        agenda.agregarCita(cliente,calendario,servicios, detalle);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="gets&sets">
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public ArrayList<Cliente> getListaDeEspera() {
        return listaDeEspera;
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public Agenda getAgenda() {
        return agenda;
    }
    public String getCorreo(){
        return this.correo;
    }
    public String getTelefono(){
       return this.telefono;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getContrasenaCorreo(){
        return contrasenaCorreo;
    }
    public HorarioAtencion getHorarioAtencion(){
        return horarioAtencion;
    }
    public ArrayList<Cita> getCitas(){
        return this.agenda.getCitas();
    }
    
    public void setHorarioAtencion(int diaInicio, int diaFin,LocalTime inicio, LocalTime salidaAlmuerzo, LocalTime entradaAlmuerzo, LocalTime fin) throws ScheduleTimingException{
        this.horarioAtencion.setHorarioAtencion(diaInicio, diaFin, inicio, salidaAlmuerzo, entradaAlmuerzo, fin);
        agenda.setHorario(horarioAtencion);
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setNombre(String nombre){
       this.nombre=nombre;
    }
    public void setContrasenaCorreo(String contrasenaCorreo){
        this.contrasenaCorreo=contrasenaCorreo;
    }


    // </editor-fold>
}    
