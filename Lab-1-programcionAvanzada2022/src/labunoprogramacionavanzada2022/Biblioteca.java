
package labunoprogramacionavanzada2022;

/**
 *
 * @author Adriana
 */
public class Biblioteca {
    
    //Atributos
    private int cantidadLibros;
    private String generosLieterarios;
    private int Usuarios;
    
    
    //Constructor vacio
    public Biblioteca() {
    }
    
    //Métodos

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibrosArg) {
        this.cantidadLibros = cantidadLibrosArg;
    }

    public String getGenerosLieterarios() {
        return generosLieterarios;
    }

    public void setGenerosLieterarios(String generosLieterariosArg) {
        this.generosLieterarios = generosLieterariosArg;
    }

    public int getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(int UsuariosArg) {
        this.Usuarios = UsuariosArg;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "cantidadLibros=" + cantidadLibros + ", generosLieterarios=" + generosLieterarios + ", Usuarios=" + Usuarios + '}';
    }

    
    
    
    
    
}
