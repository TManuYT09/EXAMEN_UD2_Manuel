package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public static void ejercicio1(){
        Random random=new Random();
        Scanner entrada=new Scanner(System.in);
        int puntjug=0;
        int puntcom=0;
        int ronda=0;
        while (puntcom<3&&puntjug<3&&ronda!=3){
            ronda++;
            /*Eleccion de la maquina*/
            int num= random.nextInt(3)+1;
            String com="";
            switch (num){
                case 1:com="p";break;
                case 2:com="a";break;
                case 3:com="t";break;
            }
            System.out.println("Ronda "+ronda);

            /*Eleccion del jugador*/
            System.out.println("¿Piedra, papel o tijera? (p/a/t)");
            String jug=entrada.next();
            jug=jug.toLowerCase();
            jug=jug.trim();

            /*Comprobando resultado*/
            if (jug.equals("p")||jug.equals("a")||jug.equals("t")){
                switch (com){
                    case "p":
                        System.out.println("El ordenador ha elegido piedra.");
                        if (jug.equals("a")){
                            puntjug++;
                            System.out.println("¡Has ganado!");
                        }
                        if (jug.equals("t")){
                            puntcom++;
                            System.out.println("¡Has perdido!");
                        }
                        if (jug.equals("p")){
                            System.out.println("Empate");
                        }
                        break;
                    case "a":
                        System.out.println("El ordenador ha elegido papel.");
                        if (jug.equals("p")){
                            puntcom++;
                            System.out.println("¡Has perdido!");
                        }
                        if (jug.equals("t")){
                            puntjug++;
                            System.out.println("¡Has ganado!");
                        }
                        if (jug.equals("a")){
                            System.out.println("Empate");
                        }
                        break;
                    case "t":
                        System.out.println("El ordenador ha elegido tijeras");
                        if (jug.equals("p")){
                            puntjug++;
                            System.out.println("¡Has ganado!");
                        }
                        if (jug.equals("a")){
                            puntcom++;
                            System.out.println("¡Has perdido!");
                        }
                        if (jug.equals("t")){
                            System.out.println("Empate");
                        }
                        break;
                }
            }else {
                System.out.println("La opción elegida ("+jug+") no existe, se repite la ronda");
                ronda--;
            }

            System.out.println("Marcador actual (PC-usuario): "+puntcom+"-"+puntjug);
            if (ronda==3&&puntjug==puntcom){
                ronda--;
            }
        }
        System.out.println(" ");
        if (puntjug>puntcom){
            System.out.println("¡GANA EL USUARIO!");
        }else {
            System.out.println("¡GANA EL PC!");
        }
    }
    public static void ejercicio2(){
        Scanner entrada=new Scanner(System.in);
        LocalDateTime hoy = LocalDateTime.now();
        System.out.println("Dame tu año de nacimiento: ");
        boolean comp;
        int ano=0;
        int anyo_hoy=hoy.getYear();
        do {
            try{
                ano=entrada.nextInt();

                if (ano<1900||ano>=anyo_hoy){
                    System.out.println("El año "+ano+" no es valido");
                    comp=true;
                }else {
                    comp=false;
                }
            }catch (InputMismatchException err){
                System.out.println("ERROR. El valor introducido no es un numero.");
                System.out.println("Intentalo de nuevo.");
                comp=true;
                entrada.nextLine();
            }
        }while(comp);

        int anyo=ano;
        for (int i=0;i!=((anyo_hoy+1)-ano);i++){
            System.out.println(anyo+" - edad: "+i);
            anyo++;
        }

    }
}
