package ejercicio3;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Juego {
    private int numeroDeIntentos;
    private int numeroGenerado;

    public Juego() {
        this.numeroGenerado = generarNumero();
    }

    public int generarNumero(){
        Random rand = new Random();
        return rand.nextInt(500) + 1; // numero entre 1 a 500
    }
    public void juegoAdivinar(){
        Scanner sc = new Scanner(System.in);

        int numero = 0;

        while(true){
            System.out.println("Introduzca el numero: ");
            try{
                numero = sc.nextInt();

                numeroDeIntentos++;
            }catch(InputMismatchException e){
                System.out.println("Entrada inválida. Ingrese un número entero.");
                sc.nextLine();
                numeroDeIntentos++;
            }

            if(numero > numeroGenerado){
                System.out.println("Menor");
            }else if(numero < numeroGenerado){
                System.out.println("Mayor");
            }else{
                System.out.printf("Adivinado en %d intentos", numeroDeIntentos);
                break;
            }
        }


        sc.close();
    }

    public int getNumeroGenerado() {
        return numeroGenerado;
    }

    public int getNumeroDeIntentos() {
        return numeroDeIntentos;
    }


}
