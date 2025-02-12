
package labunoprogramacionavanzada2022;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

/**
 *
 * @author Adriana
 */
public class PrestamoLibro {
    
    //Atributos
    private int idUsuario;
    private int idLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimiteDevol;
    private LocalDate fechaDevol;
    private long sancion;//guardar operación matematica con las fechas 
    private boolean finalizado;//    
    
//Constructor 
    public PrestamoLibro(){
        
    }

    public PrestamoLibro(int idUsuarioArg, int idLibroArg, LocalDate fechaPrestamoArg, LocalDate fechaLimiteDevolArg) {
        this.idUsuario = idUsuarioArg;
        this.idLibro = idLibroArg;
        this.fechaPrestamo = fechaPrestamoArg;
        this.fechaLimiteDevol = fechaLimiteDevolArg;
        //this.fechaDevol = fechaLimiteDevolArg;
        this.finalizado = false;
        this.sancion = 0;
    } 
    
    //Métodos
    public void guardarPrestamos(Set<PrestamoLibro> listaPrestamo, PrestamoLibro prestamo){
        listaPrestamo.add(prestamo);

    }
    
    
    public long calculoDeSancion(LocalDate fechaLimiteDevolArg, LocalDate devolucionArg ){
        sancion =  (int) (Period.between(fechaLimiteDevolArg, devolucionArg).getYears() * 365.25 + 
                          Period.between(fechaLimiteDevolArg, devolucionArg).getMonths() * 30.5 + 
                          Period.between(fechaLimiteDevolArg, devolucionArg).getDays());
        if (sancion>0) {
          sancion = sancion * 2;
            //System.out.println("Esta sancionado por " + sancion + " días ");
          
        } else {
          sancion = 0; 
            //System.out.println("No tiene sanción");
        }
        return sancion;
    }
    
    public int diasPtesSancion(LocalDate fechaConsulta){
        int diasPtes = 0;
        int diasEnSancion =  (int) (Period.between(fechaLimiteDevol, fechaConsulta).getYears() * 365.25 + 
                                   Period.between(fechaLimiteDevol, fechaConsulta).getMonths() * 30.5 + 
                                   Period.between(fechaLimiteDevol, fechaConsulta).getDays());
            
        if ( diasEnSancion <= 0){            
            diasPtes = diasEnSancion;
            sancion = 0;
        } else {    
            diasPtes = (int) sancion - diasEnSancion;
            if ( diasPtes <= 0 ) {
                sancion = 0;
            }
        }
        return diasPtes;
      
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuarioArg) {
        this.idUsuario = idUsuarioArg;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibroArg) {
        this.idLibro = idLibroArg;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamoArg) {
        this.fechaPrestamo = fechaPrestamoArg;
    }

    public LocalDate getFechaLimiteDevol() {
        return fechaLimiteDevol;
    }

    public void setFechaLimiteDevol(LocalDate fechaLimiteDevolArg) {
        this.fechaLimiteDevol = fechaLimiteDevolArg;
    }

    public LocalDate getFechaDevol() {
        return fechaDevol;
    }

    public void setFechaDevol(LocalDate fechaDevol) {
        this.fechaDevol = fechaDevol;
    }

    public long getSancion() {
        return sancion;
    }

    public void setSancion(long sancion) {
        this.sancion = sancion;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "PrestamoLibro{" + "idUsuario=" + idUsuario + ", idLibro=" + idLibro + ", fechaPrestamo=" + fechaPrestamo + ", fechaLimiteDevol=" + fechaLimiteDevol + ", fechaDevol=" + fechaDevol + ", sancion=" + sancion + ", finalizado=" + finalizado + '}';
    }




    
    
    
}
