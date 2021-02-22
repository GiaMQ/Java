/**
 * @author: Sebantian Rudin / Gia Montero
 * 
 * 
 * Proposito: Mostrar una estimación de casos hospitalizados, casos fallecidos, 
 * porcentaje de casos activos y alerta de un país  específico con los datos de número 
 * de casos activos y porcentaje de ocupación de  las UCI

 */


package IntroProgram.Tareas;

import java.io.*;
import java.math.*;



public class Entregable1 {

    static final String MSG_SALIDA= "Error en el dato ingresado";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String pais;
        Integer casosActivos;
        Short porcentajeO;
        Double casosHospitalizados;
        Double casosSeveros;
        Double casosFallecidos;

        System.out.println("Ingrese el pais de CentroAmerica que desea analizar: ");
        pais = in.readLine();

        System.out.println("Ingrese casos activos en " + pais + ":");
        casosActivos = Integer.parseInt(in.readLine()); 

        System.out.println("Sin el simbolo (%), ingrese el monto de porcentaje de ocupacion de las UCI en " + pais + ":");
        porcentajeO = Short.parseShort(in.readLine());

        casosHospitalizados = (casosActivos * 0.014);
        casosHospitalizados = Math.round(casosHospitalizados* 100.00)/100.00;
       
        
        casosSeveros = (casosActivos * 0.008);
        casosSeveros = Math.round(casosSeveros* 100.00)/100.00;
       

        casosFallecidos = (casosActivos * 0.07);
        casosFallecidos = Math.round(casosFallecidos* 100.00)/100.00;
        
        // Imprimir datos
        System.out.println("El numero estimado de casos hospitalizados en este momento es: "+ casosHospitalizados);
        System.out.println("El numero estimado de casos severos(UCI) en este momento es: "+ casosSeveros);
        System.out.println("El numero estimado de casos fallecidos acumulados es: "+ casosFallecidos);
        
        System.out.println("\nLa alerta emitida es: ");
        if(porcentajeO >= 1 && porcentajeO <25)  {
            System.out.println("No hay alerta declarada en el "+ pais+".\n");
        } else if(porcentajeO >= 25 && porcentajeO <50)  {
            System.out.println("Se declara alerta amarilla en "+ pais+".\n");
        } else if(porcentajeO >= 50 && porcentajeO <75) {
            System.out.println("Se declara alerta naranja en "+ pais+".\n");
        } else if(porcentajeO >= 75 && porcentajeO <90) {
            System.out.println("Se declara alerta roja en "+ pais+".\n");
        } else if(porcentajeO >= 90 && porcentajeO <100) {
            System.out.println("Se declara estado de calamidad en el "+ pais+".\n");
        } else {
            System.out.println(MSG_SALIDA);
        }
    }
}      


