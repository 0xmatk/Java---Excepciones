package ejercicio4;

import ejercicio4.Excepciones.AlumnoNoExisteException;
import ejercicio4.Excepciones.AlumnoVacioException;

import java.util.*;

public class Colegio {
    private List<Alumno> alumnos;

    public Colegio (){
        this.alumnos = new ArrayList<Alumno>();
    }

    public boolean agregarAlumno(Alumno nuevoAlumno){
        try{
            if(nuevoAlumno.getNombre() == null || nuevoAlumno.getNacionalidad() == null){
                throw new AlumnoVacioException("Campos vacios");
            }
        }catch (AlumnoVacioException e){
                System.out.println(e.getMessage());

        }

        for(Alumno index : alumnos){
            if(index.getNombre().equals(nuevoAlumno.getNombre())){
                this.alumnos.add(nuevoAlumno);
                return true;
            }
        }

        return false;
    }

    public void verNacionalidad(String nacionalidad){
        int cantNacionalidad = 0;
        for(Alumno index : alumnos){
            if(index.getNacionalidad().equals(nacionalidad)){
                System.out.println("La cantidad de alumnos con la nacionalidad " + nacionalidad + " es " + cantNacionalidad);
            }
        }
    }

    public int cuantos(){
        Set<String> nacionalidades = new HashSet<>();

        for(Alumno index : alumnos){
            nacionalidades.add(index.getNacionalidad());
        }

        return nacionalidades.size();
    }

    public boolean borrarAlumno(Alumno alumnoBorrar){

        for(Alumno index : alumnos){
            if(index.getNombre().equals(alumnoBorrar.getNombre())){
                this.alumnos.remove(alumnoBorrar);
            }
        }

        try {
            throw new AlumnoVacioException("El alumno que quiere borrar no existe");
        } catch (AlumnoVacioException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public Map<String, Integer> contarNacionalidades(List<Alumno> alumnos){
        Map<String, Integer> conteoNacionalidades = new HashMap<>();
        for(Alumno index : alumnos){
            String nacionalidad = index.getNacionalidad();

            if(conteoNacionalidades.containsKey(nacionalidad)){
                conteoNacionalidades.put(nacionalidad, conteoNacionalidades.get(nacionalidad)+1);
            }else{
                conteoNacionalidades.put(nacionalidad, 1);
            }

        }

        return conteoNacionalidades;
    }

    public void verTodos(Map<String, Integer> conteoNacionalidades){
        for (Map.Entry<String, Integer> entry : conteoNacionalidades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " alumno(s)");
        }
    }


}
