
package labunoprogramacionavanzada2022;

/**
 *
 * @author Adriana
 */
public class CopiaLibro {
    
    //Atributos
    private final int idCopiaLibro;
    private int idLibro;
    private boolean estadoLibro;
    private static int contadorIdCopiaLibro;
    
    //Constructor
    public CopiaLibro() {
        this.idCopiaLibro = ++ contadorIdCopiaLibro;  //Por cada objeto que se cree vamos 
                                                      //a tener un nuevo indentificador 
                                                      //el cual va incrementando con el contadorIdCopiaLibro
    }

    public CopiaLibro(int idCopiaLibro, int idLibro, boolean estadoLibro) {
        this.idCopiaLibro = idCopiaLibro;
        this.idLibro = idLibro;
        this.estadoLibro = estadoLibro;
    }
    
    
    
    //Métodos
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibroArg) {
        this.idLibro = idLibroArg;
    }

    public boolean isEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(boolean estadoLibroArg) {
        this.estadoLibro = estadoLibroArg;
    }

    @Override
    public String toString() {
        return "CopiaLibro{" + "idCopiaLibro=" + idCopiaLibro + ", idLibro=" + idLibro + ", estadoLibro=" + estadoLibro + '}';
    }
    
    

    
    
    
}
