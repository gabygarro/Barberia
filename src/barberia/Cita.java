
package barberia;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cita {
    private Cliente cliente;
    private LocalDateTime fecha;
    private String detalle;
    private ArrayList<Servicio> servicios;
    private double monto;
    private boolean notificada;
    private boolean confirmada;
    
    
    
            
    public Cita(Cliente cliente, LocalDateTime fecha, ArrayList<Servicio> servicios, String detalle){
        this.cliente=cliente;
        this.fecha=fecha;
        this.detalle = detalle;
        this.servicios = servicios;
        this.confirmada = false;
        this.notificada = false;
    }
    
    public void confirmar(){
        this.confirmada = true;
    }
    
    public void notificacionEnviada(){
        this.notificada = true;
    }
    
    public boolean estaNotificada(){
        return this.notificada;
    }
    
    public void agregarServicio(Servicio servicio){
        this.getServicios().add(servicio);
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public LocalDateTime getFecha(){
        return this.fecha;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }


    public double calcularMonto() {
        this.monto = 0;
        for(Servicio s : this.getServicios()){
            this.monto += s.getPrecio();
        }
        return this.monto;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public boolean estaConfirmada(){
        return this.confirmada;
    }

   
}
