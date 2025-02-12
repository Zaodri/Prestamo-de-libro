
package labunoprogramacionavanzada2022;

import java.time.LocalDate;

/**
 *
 * @author Adriana
 */
public class Autor {
    
    //Atributos
    private final int idAutor;
    private String nombre;
    private String nacionalidad;
    private LocalDate nacimiento;
    private static int contadorIdAutor;
    
    //Contructor vacio
    public Autor(){  
        this.idAutor =++ contadorIdAutor;
    }

    public Autor(String nombreArg, String nacionalidadArg, LocalDate nacimientoArg) {
        this();
        this.nombre = nombreArg;
        this.nacionalidad = nacionalidadArg;
        this.nacimiento = nacimientoArg;
    }  
    
    //Métodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreArg) {
        this.nombre = nombreArg;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidadArg) {
        this.nacionalidad = nacionalidadArg;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimientoArg) {
        this.nacimiento = nacimientoArg;
    }

    @Override
    public String toString() {
        return "Autor" + "idAutor: " + idAutor + "Nombre: " + nombre + ", Nacionalidaad: " + nacionalidad + ", Nacimiento: " + nacimiento;
    }
    
    
}
