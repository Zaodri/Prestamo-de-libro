
package labunoprogramacionavanzada2022;

import java.util.Set;

/**
 *
 * @author Adriana
 */
public class Usuarios {
    
    //Atributos
    private /*final*/ int idUsuario; //Valor que no se prodra cambiar
    private String nombreUsu;
    private String direccion;
    private String telefono;
    private static int contadorIdUsuario;
    
    //Constructor
    public Usuarios(){
         this.idUsuario =++ contadorIdUsuario; //Por cada objeto que se cree vamos 
                                              //a tener un nuevo indentificador 
                                              //el cual va incrementando con el contadorIdUsuario
    }

    public Usuarios(String nombreUsuArg, String direccionArg, String telefonoArg) {  
        this();
        this.nombreUsu = nombreUsuArg;
        this.direccion = direccionArg;
        this.telefono = telefonoArg;
    }    
    


    //Métodos
    public int getIdUsuario(){
        return idUsuario;        
    }

    public void guardarUsuarios(Usuarios usuarioArg, Set<Usuarios> listaUsuariosArg) {
        listaUsuariosArg.add(usuarioArg);
    }
    
    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsuArg) {
        this.nombreUsu = nombreUsuArg;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccionArg) {
        this.direccion = direccionArg;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefonoArg) {
        this.telefono = telefonoArg;
    }

    @Override
    public String toString() {
        return "Identificador Usuario: " + idUsuario + ", Nombre=" + nombreUsu + ", Direccion=" + direccion + ", Telefono=" + telefono ;
    }
    
    
}
