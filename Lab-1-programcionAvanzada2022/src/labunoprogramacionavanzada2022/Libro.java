
package labunoprogramacionavanzada2022;

import java.util.Set;

/**
 *
 * @author Adriana
 */
public class Libro {
    
    //Atributos 
    private /*final*/ int idLibro;
    private int DNI;
    private String generoLiterario;
    private String editorial;
    private Autor autor;
    private int anio;
    private static int contadorIdLibro;
    private boolean libroDispo; 
    private String nombreLibro;
    
    //Constructor
    public Libro(){
        this.idLibro =++ contadorIdLibro;
        
    }

    public Libro(int DNI, String generoLiterario, String editorial, Autor autor, int anio, String nombreLibro) {
        this();
        this.DNI = DNI;
        this.generoLiterario = generoLiterario;
        this.editorial = editorial;
        this.autor = autor;
        this.anio = anio;
        this.libroDispo = true;
        this.nombreLibro = nombreLibro;
    }

    
    
    
    
    //Métodos
    public void guardarLibros(Libro libroArg, Set<Libro> listaLibrosArg){
        listaLibrosArg.add(libroArg);
        
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getDNI(){
        return DNI;
    }
    
    public void setDNI(int DNIArg){
        this.DNI = DNIArg;
    }
    
    public String getGeneroLiterario(){
        return generoLiterario;
    }
    
    public void setGeneroLiterario(String generoLiterarioArg){
        this.generoLiterario = generoLiterarioArg;
    }
    
    public String getEditorial(){
        return editorial;
    }
    
    public void setEditorial(String editorialArg){
        this.editorial = editorialArg;
    }
    
    public Autor getAutor(){
        return autor;
    }
    
    public void setAutor(Autor autorArg){
        this.autor = autorArg;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public void setAnio(int anioArg){
        this.anio = anioArg;
    }

    public boolean isLibroDispo() {
        return libroDispo;
    }

    public void setLibroDispo(boolean libroDispo) {
        this.libroDispo = libroDispo;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", DNI=" + DNI + ", generoLiterario=" + generoLiterario + ", editorial=" + editorial + ", autor=" + autor.toString() + ", anio=" + anio + ", libroDispo=" + libroDispo + ", nombreLibro=" + nombreLibro + '}';
    }
    
    

   
    
    
}
