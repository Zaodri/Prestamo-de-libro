
package labunoprogramacionavanzada2022;

import java.util.Set;

/**
 *
 * @author Adriana
 */
public class Bibliotecario {
    
    //Atributos
    private final int idBiblio; //Valor que no se prodra cambiar
    private String nombreBiblio;
    private String direccionBiblio;/**/
    private String telefono;
    private int edad;
    private static int contadorIdBiblio;
            
    
    //Contructor
    private Bibliotecario(){
        this.idBiblio = ++ contadorIdBiblio; //Por cada objeto que se cree vamos 
                                              //a tener un nuevo indentificador 
                                              //el cual va incrementando con el contadorIdBiblio
        
    }   

    public Bibliotecario(String nombreBiblioArg, int edadArg, String direccionBiblioArg, String telefonoArg) {
        this(); //llamado al contructor de tipo privado
        this.nombreBiblio = nombreBiblioArg;
        this.direccionBiblio = direccionBiblioArg;
        this.telefono = telefonoArg;
        this.edad = edadArg;
    }    

    //Métodos
    
    public void guardarBibliotecario(Set<Bibliotecario> listaBibliotecario, Bibliotecario bibliotecario){
        listaBibliotecario.add(bibliotecario);

    }    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getNombreBiblio() {
        return nombreBiblio;
    }

    public void setNombreBiblio(String nombreBiblio) {
        this.nombreBiblio = nombreBiblio;
    }

    public String getDireccionBiblio() {
        return direccionBiblio;
    }

    public void setDireccionBiblio(String direccionBiblio) {
        this.direccionBiblio = direccionBiblio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "idBiblio=" + idBiblio + ", nombreBiblio=" + nombreBiblio + ", direccionBiblio=" + direccionBiblio + ", telefono=" + telefono + ", edad=" + edad + '}';
    }
    



    
    
}
