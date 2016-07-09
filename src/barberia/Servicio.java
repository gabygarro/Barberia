
package barberia;

/**
 *
 * @author Daniel
 */
public class Servicio {
    private String nombre;
    private String descripcion;
    private double precio;
    
    public Servicio(String pNombre){
        nombre=pNombre;
        this.descripcion = "No disponible";
        this.precio = 5000;
    }
   
    public String toString(){
        String texto="Nombre: "+getNombre();
        texto+="\nDescripcion: "+getDescripcion();
        texto+="\nPrecio: "+getPrecio();
        
        return texto;
    }
    
    // <editor-fold defaultstate="collapsed" desc="getters/setters">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

  
}
