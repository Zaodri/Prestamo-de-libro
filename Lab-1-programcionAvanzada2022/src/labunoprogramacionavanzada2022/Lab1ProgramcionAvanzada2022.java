/*
 *Una biblioteca tiene copias de libros. Estos últimos se caracterizan por su nombre, tipo 
*(ingeniería,  literatura,  informática,  historia...),  editorial,  año  y  autor.  Los  autores  se 
*caracterizan  por  su  nombre,  nacionalidad  y  fecha  de  nacimiento.  Cada  copia  tiene  un 
*identificador, y puede estar en la biblioteca, prestada, con retraso o en reparación. Los 
*lectores  pueden  tener  un  máximo  de  3  libros  en  préstamo.  Cada  libro  se  presta  un 
*máximo  de  30  días,  y  por  cada  día  de  retraso,  se  impone  una  “multa”  de  dos  días  sin 
*posibilidad de coger un nuevo libro. Realiza un diagrama de clases y añade los métodos 
*necesarios para realizar el préstamo y devolución de libros. Realiza un diagrama de casos 
*de usos y la implementación en JAVA.
 */
package labunoprogramacionavanzada2022;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Adriana
 */
public class Lab1ProgramcionAvanzada2022 {
    

    
    public static void datosParaPrestamoNuevo(int idUsuario, LocalDate fechaActual, int idLibro, Set<PrestamoLibro> listaPrestamos){  
        

        LocalDate fechaPrestamo = fechaActual;
        LocalDate fechaLimiteDevol = fechaActual.plusDays(30);
        
        PrestamoLibro prestamo = new PrestamoLibro(idUsuario, idLibro, fechaPrestamo, fechaLimiteDevol);
        prestamo.guardarPrestamos(listaPrestamos, prestamo);

        
    }
    
    public static int esLibroDisponible(Set<Libro> listaLibros, String nombreLibro){
        
        Libro libroDispo = new Libro();
        int idLibro = 0;
        Iterator<Libro> itr=listaLibros.iterator();
        while(itr.hasNext()){
            libroDispo = itr.next();
            if (libroDispo.getNombreLibro().equalsIgnoreCase(nombreLibro) && libroDispo.isLibroDispo() ) {
                libroDispo.setLibroDispo(false);
                idLibro = libroDispo.getIdLibro();
            }
     
                 
        }
        return idLibro;
    }
    
    
    public static void datosParaLibroNuevo(int DNI, String generoLiterario, String editorial, Autor autor, int anio, String nombreLibro, Set<Libro> listaLibros){
        
        Libro libro = new Libro(DNI, generoLiterario, editorial, autor, anio, nombreLibro);
        libro.guardarLibros(libro, listaLibros);
        
    }
    
    public static void datosParaBibliotecarioNuevo(String Nombre, int edad, String direccion, String telefono, Set<Bibliotecario> listaBibliotecario){
        Bibliotecario bibliotecarioNuevo = new Bibliotecario(Nombre, edad, direccion, telefono);
        bibliotecarioNuevo.guardarBibliotecario(listaBibliotecario, bibliotecarioNuevo);        
    }
    
    public static LocalDate cargarFecha(){
        Scanner entradaInt = new Scanner(System.in);
        
        System.out.println("Ingrese año: ");
        int anio = entradaInt.nextInt();
        
        System.out.println("Ingrese mes: ");
        int mes = entradaInt.nextInt();
        
        System.out.println("Ingrese dia: ");
        int dia = entradaInt.nextInt();
        
        return LocalDate.of(anio, mes, dia);
    }
    
    public static int puedoPrestar(Set<PrestamoLibro> listaPrestamos, int idUsuario){
        
        int cantidadPresUsu = 0;
        PrestamoLibro presLibro = new PrestamoLibro();    
        Iterator<PrestamoLibro> itr=listaPrestamos.iterator();
        while(itr.hasNext()){
            presLibro = itr.next();
            if ( (presLibro.getIdUsuario() == idUsuario) && (!(presLibro.isFinalizado())) ){
                if (presLibro.getSancion() != 0) {
                    cantidadPresUsu = 4;
                    return cantidadPresUsu;
                }
                cantidadPresUsu+= 1; 
            }
                           
        } 
        return cantidadPresUsu;
    }
    
    public static boolean esUsuNuevo(Set<Usuarios> listaUsuarios, String nombreUsu){
        
        boolean esNuevo = true;
        Usuarios usuNuevo = new Usuarios();  
        Iterator<Usuarios> itr=listaUsuarios.iterator();
        while(itr.hasNext()){
            usuNuevo = itr.next();
            if ( (usuNuevo.getNombreUsu().toUpperCase().equals(nombreUsu.toUpperCase())) )
                esNuevo = false; 
        }
        return esNuevo;
    }
    
    public static void datosParaUsuNuevo(String nombreUsu, String telefonoUsu, String direccionUsu, Set<Usuarios> listaUsuarios){
        
        Usuarios usuNuevo = new Usuarios(nombreUsu, direccionUsu, telefonoUsu);
        usuNuevo.guardarUsuarios(usuNuevo, listaUsuarios);
        
    }
    
    public static void consultarUsuario (Set <Usuarios> listaUsuarios, Set <PrestamoLibro> listaPrestamos, String nombUsuario, LocalDate fechaActual){
        //BUSCAR EL ID DEL USUARIO CON SU NOMBRE
        Iterator<Usuarios> itrUsr=listaUsuarios.iterator();
        Usuarios usuarioConsulta = new Usuarios();
        int idUsuario = 0;
        while( (itrUsr.hasNext()) && (idUsuario == 0) ){
            usuarioConsulta = itrUsr.next();
            if ( usuarioConsulta.getNombreUsu().equalsIgnoreCase(nombUsuario) )
                idUsuario = usuarioConsulta.getIdUsuario();
        }
        if ( idUsuario != 0 ) {
            Iterator<PrestamoLibro> itrPres=listaPrestamos.iterator();
            PrestamoLibro presLibroConsulta = new PrestamoLibro();
            int diasPendientes = 0;
            while(itrPres.hasNext()){
                presLibroConsulta = itrPres.next();
                if ( (presLibroConsulta.getIdUsuario() == idUsuario) && (!(presLibroConsulta.isFinalizado())) ){
                    System.out.println(presLibroConsulta.toString());
                    if ( presLibroConsulta.getFechaDevol() == null ) {
                        diasPendientes = presLibroConsulta.diasPtesSancion(fechaActual);
                    }
                    else {
                        diasPendientes = presLibroConsulta.diasPtesSancion(presLibroConsulta.getFechaDevol());
                    }
                    if ( diasPendientes < 0 )
                        diasPendientes = 0;
                    System.out.println("Dias pendientes de sancion: " + diasPendientes + " dias.");
                }
            }
        }
   
    }
    
    public static boolean esEsteLibro (Set<Libro> listaLibroEntrega, int IdLibroEntrega, String nombLibroEntrega){
        Libro libroEntrega = new Libro();
        boolean libroAEntregar = false;
        Iterator<Libro> itrEntrega=listaLibroEntrega.iterator();
        while(itrEntrega.hasNext()){
            libroEntrega = itrEntrega.next();
            if ( libroEntrega.getIdLibro() == IdLibroEntrega && libroEntrega.getNombreLibro().equalsIgnoreCase(nombLibroEntrega) ) {
                libroAEntregar = true;
            }
        }
        return libroAEntregar;
    }
    
    public static void entregaLibro (Set<Usuarios> listaUsuarios, Set<PrestamoLibro> listaPrestamos, Set<Libro> listaLibroEntrega, String nombUsuario, String nombLibro, LocalDate fechaActual) {
        //BUSCAR EL ID DEL USUARIO CON SU NOMBRE
        Iterator<Usuarios> itrUsr=listaUsuarios.iterator();
        Usuarios usuarioConsulta = new Usuarios();
        int idUsuario = 0;
        while( (itrUsr.hasNext()) && (idUsuario == 0) ){
            usuarioConsulta = itrUsr.next();
            if ( usuarioConsulta.getNombreUsu().equalsIgnoreCase(nombUsuario) )
                idUsuario = usuarioConsulta.getIdUsuario();
        }
        if ( idUsuario != 0 ) {
            Iterator<PrestamoLibro> itrPres=listaPrestamos.iterator();
            PrestamoLibro presLibroEntrega = new PrestamoLibro();
            while(itrPres.hasNext()){
                presLibroEntrega = itrPres.next();
                if ( (presLibroEntrega.getIdUsuario() == idUsuario) && (!(presLibroEntrega.isFinalizado())) ){
                    if ( esEsteLibro ( listaLibroEntrega, presLibroEntrega.getIdLibro(), nombLibro ) ) {
                        presLibroEntrega.setFechaDevol(fechaActual);
                        if ( presLibroEntrega.getSancion() == 0 )
                            presLibroEntrega.setFinalizado(true);
                    }
                        
                }
            }
        }
   
    }

// FUNCIONES PARA LISTAR LA INFORMACION
    public static void listaUsuarios(Set<Usuarios> listaUsuarios){
        
        Iterator<Usuarios> itr=listaUsuarios.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().toString());            
        }
    }
    
    public static void listaLibros(Set<Libro> listaLibros){
        
        Iterator<Libro> itr=listaLibros.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().toString());            
        }
    }

    public static void listaPrestamos(Set<PrestamoLibro> listaPrestamos){
        
        Iterator<PrestamoLibro> itr=listaPrestamos.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().toString());            
        }
    }

    public static void menuDeOpciones(LocalDate fechaActual, Set<Usuarios> listaUsuarios, Set<Bibliotecario> listaBibliotecarios, Set<PrestamoLibro> listaPrestamos, Set<Libro> listaLibros){
        //Listas para guardar informacion

        //calculo de sanciones para todos los prestamos activos
        Iterator<PrestamoLibro> itr=listaPrestamos.iterator();
        PrestamoLibro prestamoRevisionSancion = new PrestamoLibro();
        while(itr.hasNext()){
            prestamoRevisionSancion = itr.next();
            if ( !prestamoRevisionSancion.isFinalizado() ) {
                if ( prestamoRevisionSancion.getFechaDevol() == null )
                    prestamoRevisionSancion.setSancion(prestamoRevisionSancion.calculoDeSancion(prestamoRevisionSancion.getFechaLimiteDevol(), fechaActual));
                else
                    prestamoRevisionSancion.setSancion(prestamoRevisionSancion.calculoDeSancion(prestamoRevisionSancion.getFechaLimiteDevol(), prestamoRevisionSancion.getFechaDevol()));
            }
        }

        //revisar las sanciones cumplidas
        Iterator<PrestamoLibro> itrSancionYaNo=listaPrestamos.iterator();
        PrestamoLibro prestamoSancionYaNo = new PrestamoLibro();
        while(itrSancionYaNo.hasNext()){
            prestamoSancionYaNo = itrSancionYaNo.next();
            if ( !prestamoSancionYaNo.isFinalizado() )
                prestamoSancionYaNo.setFinalizado( prestamoRevisionSancion.diasPtesSancion(fechaActual) == 0 );
            //else
                //prestamoSancionYaNo.setFinalizado( prestamoRevisionSancion.diasPtesSancion(prestamoRevisionSancion.getFechaDevol()) == 0 );
            //if ( prestamoRevisionSancion.isFinalizado() )
               //prestamoRevisionSancion.setSancion(0);
        }
        
        
        Scanner entradaInt = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
       
       
        System.out.println("=====   SISTEMA DE INFORMACION DE BIBLIOTECA   =====");
        System.out.println("1: Crear usuario ");
        System.out.println("2: Crear Libro ");
        System.out.println("3: Crear Bibliotecario ");
        System.out.println("4: Solicitar libro en prestamo ");
        System.out.println("5: Entregar libro en prestamo ");
        System.out.println("6: Listado de usuarios ");
        System.out.println("7: Listado de Libros ");
        System.out.println("8: Listado de Prestamos ");
        System.out.println("9: Configurar fecha actual ");
        System.out.println("10: Consulta Usuario ");
        
       
        System.out.println("Seleccione una opcion: ");
        int prestamoLibro = entradaInt.nextInt();
        
        switch(prestamoLibro) {

            case 1:

                //Opcion crear usuarios

                System.out.println("Ingrese nombre del usuario: ");
                String nombreUsu = entrada.nextLine();

                System.out.println("Ingrese telefono del usuario: ");
                String telefonoUsu = entrada.nextLine();

                System.out.println("Ingrese direccion del usuario: ");
                String direccionUsu = entrada.nextLine();

                if (esUsuNuevo(listaUsuarios, nombreUsu)) {
                    datosParaUsuNuevo(nombreUsu, telefonoUsu, direccionUsu, listaUsuarios);
                }else{
                    System.out.println("Usuario ya existe! ");
                }
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;

            case 2:
                //Opcion crear libros                
                Autor autor = new Autor();
                System.out.println("Ingrese nombre de libro: ");
                String nombreLibro = entrada.nextLine();

                System.out.println("Ingrese DNI: ");
                int DNI = entradaInt.nextInt();

                System.out.println("Ingrese genero literario: ");
                String generoLiterario = entrada.nextLine();
                
                System.out.println("Ingrese editorial: ");
                String editorial = entrada.nextLine();
                
                System.out.println("Ingrese año: ");
                int anio = entradaInt.nextInt();
                
                System.out.println("Ingrese nombre autor: ");
                String nombreAutor = entrada.nextLine();
                
                System.out.println("Ingrese nacionalidad autor: ");
                String nacionalidadAutor = entrada.nextLine();
                
                System.out.println("Ingrese año de nacimiento autor: ");
                int nacAnioAutor = entradaInt.nextInt();
                
                System.out.println("Ingrese mes de nacimiento autor: ");
                int nacMesAutor = entradaInt.nextInt();

                System.out.println("Ingrese día de nacimiento autor: ");
                int nacDiaAutor = entradaInt.nextInt();                
                
                autor.setNombre(nombreAutor);
                autor.setNacionalidad(nacionalidadAutor);
                autor.setNacimiento(LocalDate.of(nacAnioAutor, nacMesAutor, nacDiaAutor));

                datosParaLibroNuevo(DNI, generoLiterario, editorial, autor, anio, nombreLibro, listaLibros);
                
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;

            case 3:
                //Opcion crear bibliotecarios
                System.out.println("Ingrese Nombre: ");
                String nombBibliotecario = entrada.nextLine();
                
                System.out.println("Ingrese edad: ");
                int edadBibliotecario = entradaInt.nextInt();
                
                System.out.println("Ingrese direccion: ");
                String direBibliotecario = entrada.nextLine();
                
                System.out.println("Ingrese telefono: ");
                String telefonoBibliotecario = entrada.nextLine();
                
                datosParaBibliotecarioNuevo(nombBibliotecario, edadBibliotecario, direBibliotecario, telefonoBibliotecario, listaBibliotecarios);
                
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;

            case 4:

                //Opcion de menu solicitar libro
                
                System.out.println("Ingrese código del usuario: ");
                int idUsuario = entradaInt.nextInt();
                System.out.println("Ingrese nombre libro: ");
                String nomLibro = entrada.nextLine();
                int rptPuedoPrestar = puedoPrestar(listaPrestamos, idUsuario);
                if ((rptPuedoPrestar < 3) ) {
                    int idLibroAPrestar = esLibroDisponible(listaLibros, nomLibro);
                    if ( idLibroAPrestar != 0 ) {
                       datosParaPrestamoNuevo(idUsuario, fechaActual, idLibroAPrestar, listaPrestamos); 
                    }
                    else{
                       System.out.println("Libro no se encuentra disponible "); 
                    }
                }
                else{
                    if (rptPuedoPrestar == 4) {
                       System.out.println("Usuario se encuentra sancionado "); 
                    }
                    System.out.println("Usuario ya tiene tres libros en prestamo ");
                }
                
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;
                
            case 5: //entrega de libros
                System.out.println("Ingrese nombre Usuario: ");
                String nomUsuEntrega = entrada.nextLine();
                System.out.println("Ingrese nombre libro: ");
                String nomLibroEntrega = entrada.nextLine();
                
                entregaLibro(listaUsuarios, listaPrestamos, listaLibros, nomUsuEntrega, nomLibroEntrega, fechaActual);
                
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;

            case 6: //listado de usuarios
                listaUsuarios(listaUsuarios);
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;
            case 7: //listado de libros
                listaLibros(listaLibros);
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;
            case 8: //listado de prestamos
                listaPrestamos(listaPrestamos);
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;
            case 9:
                fechaActual = cargarFecha();
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                break;
            case 10:
                //Consultar estado del usuario
                
                System.out.println("Ingrese nombre del usuario: ");
                String nombUsuario = entrada.nextLine();
                
                consultarUsuario(listaUsuarios, listaPrestamos, nombUsuario, fechaActual);
                        
                menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
                
                break;
            default:
               System.out.println("Opción de menu incorrecta ");
               //menuDeOpciones(fechaActual);
        }
        
    }
    
    //==========================main====================================//

    public static void main(String[] args) {
        
        LocalDate fechaActual;
        fechaActual = cargarFecha();

        Set<Usuarios> listaUsuarios = new HashSet();
        Set<Bibliotecario> listaBibliotecarios = new HashSet();
        Set<PrestamoLibro> listaPrestamos = new HashSet();
        Set<Libro> listaLibros = new HashSet();

        menuDeOpciones(fechaActual, listaUsuarios, listaBibliotecarios, listaPrestamos, listaLibros);
        
        
        //for (PrestamoLibro presEst : listaPrestamos) {
        //     System.out.println(presEst);
        //} 
       
       
       //datosParaUsuarioNuevo(fechaActual);
       
        //System.out.println("" );
        
        
//        Bibliotecario empleado = new Bibliotecario("Carlos Rojas", 21, "cll 45 c ", "313 385"); 
//        Bibliotecario empleadoUno = new Bibliotecario("Daniela Roa", 36, "cra 55 e ", "311 090"); 
//        Usuarios user = new Usuarios("Camilo Torres", "cll 127 89 i", "320 483");
//        Usuarios userUno = new Usuarios("Magdalena Ortega", "cra 127 89 a", "300 483");
//        Autor autor = new Autor("Julio Cortázar", "Argentino", "19/08/1979");
//        //Libro libro = new Libro(156, "Comedia", "Santillana", autor.toString());
//        
//        PrestamoLibro prestamo =new PrestamoLibro(2, 3, LocalDate.of(2022, Month.AUGUST, 31), LocalDate.of(2022, Month.AUGUST, 31).plusDays(5));
//        prestamo.guardarPrestamos(listaPrestamos, prestamo);
//        PrestamoLibro prestamoUno =new PrestamoLibro(2, 5, LocalDate.of(2022, Month.AUGUST, 31), LocalDate.of(2022, Month.AUGUST, 31).plusDays(5));
//        prestamo.guardarPrestamos(listaPrestamos, prestamoUno);
//        //Collection <PrestamoLibro> listaPrestamos;
//        
//        
//        
//        Scanner entrada = new Scanner(System.in);
//        Scanner entradaInt = new Scanner(System.in);
//        
//        System.out.println("Bibliotecarios " );
//        System.out.println("Información: " + empleado.toString());
//        System.out.println("Información: " + empleadoUno.toString());
//        
//        System.out.println("Usuarios " );
//        System.out.println("Información: " + user.toString());
//        System.out.println("Información: " + userUno.toString());
//        
//        System.out.println("Usuarios " );
//        System.out.println("Información: " + user.toString());
//        System.out.println("Información: " + userUno.toString());
//        
//        System.out.println("Prestamos " );
//        System.out.println("Prestamo: " + prestamo.toString());
//        //System.out.println("Información: " + userUno.toString());        
//        
//        System.out.println( "Fecha de mi cumpleaños: " + LocalDate.of(1972, Month.MAY, 23) );
//        
//        System.out.println("hola" + 
//               (int) (Period.between(LocalDate.of(2022, Month.AUGUST, 31).plusDays(500), LocalDate.now()).getYears() * 365.25 +
//                       Period.between(LocalDate.of(2022, Month.AUGUST, 31).plusDays(500), LocalDate.now()).getMonths() * 30.5 +
//                Period.between(LocalDate.of(2022, Month.AUGUST, 31).plusDays(500), LocalDate.now()).getDays())   );        
//        
//        //Lista para los estados de prestamos que tiene el ususario
//        
//        
//        listaPrestamos.add(prestamoUno);
////        estadoPres.add(prestamo.calculoDeSancion(LocalDate.MIN, LocalDate.MIN));
////        estadoPres.add("fresa");
////        estadoPres.add("naranja");
////        estadoPres.remove("pera");
//          
//        
//        
////        int idBiblioArg;
////        String nombreBiblioArg;
////        String direccionBiblioArg;
////        String telefonoArg;
////        int edad;
//// 
////       System.out.println("Ingrese código del bibliotecario: ");
////       idBiblioArg = entrada.nextInt();
////        
////        System.out.println("ingrese la edad");
////        edad = entradaInt.nextInt();
////        
////        System.out.println("Ingrese nombre de bibliotecario: ");
////        nombreBiblioArg = entrada.nextLine();
////       
////        System.out.println("Ingrese  dirección del bibliotecario: ");
////        direccionBiblioArg = entrada.nextLine(); //entradade char por teclado
////        
////        System.out.println("Ingrese teléfono de bibliotecario: ");
////        telefonoArg = entrada.nextLine();

        
        
        
        
        
    }
    
}
