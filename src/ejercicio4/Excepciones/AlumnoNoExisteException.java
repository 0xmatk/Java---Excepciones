package ejercicio4.Excepciones;

public class AlumnoNoExisteException extends Exception{
    public AlumnoNoExisteException(String mensaje){
        super(mensaje);
    }
}
