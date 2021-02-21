/**
 * @author: Gia
 * 
 * Proposito: Mostrar los requisitos para la renovación de la licencia y 
 * validar con los datos del usuario si este puede realizar el tramite
 
 */

package IntroProgram.Tareas;

import java.io.*;

public class GianinaMontero_Tarea2 {
    static final String OPCION_SI = "si";
    static final String MSG_RECHAZO = "Usuario no puede renovar licencia";
    static final String MSG_COSTO = "Usuario tiene que pagar:";
    static final String MSG_VIGENCIA= "Licencia tendra una vigencia de:";
    static final String MSG_SALIDA= "Gracias por su tramite";
    static final Integer limPuntosAcum = 12;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        /**Menu Inicial**/
        System.out.println(ANSI_CYAN + "--------------------------------------------------------------------");
        System.out.println("------------------PROCESO DE RENOVACION DE LICENCIA-----------------");
        System.out.println("--------------------------------------------------------------------" + ANSI_RESET);
        System.out.println("\nLos requisitos a ocupar son: ");
        System.out.println("\n1. Tener menos de 12 puntos acumulados por infraccion de transito ");
        System.out.println("2. Identificacion en buen estado y al dia  ");
        System.out.println("3. Dictamen medico digital vigente");
        System.out.println("4. Tener multas pagas todas las multas ");
        System.out.println(ANSI_CYAN  +"\n --------------------------------------------------------------------");
        System.out.println( "Iniciamos con el proceso ");
        System.out.println("--------------------------------------------------------------------"+ ANSI_RESET);
        

        Integer numLicencia;
        Integer puntosAcumulados;
        String respuestaNo1;
        String respuestaNo2;
        Integer sobreCargo;
        Integer montoTotal;

        /*Inicio de ingreso de datos*/ 
        System.out.print("\n Ingrese numero de licencia (sin guiones): ");
        numLicencia = Integer.parseInt(in.readLine());   /*-----> Aqui asumimos que licencias estan compuestas de solo numeros*/

            System.out.print(" \nValidando estatos del usuario " + ANSI_BLUE + numLicencia + ANSI_RESET + ": licencia activa o suspendida");
            System.out.print("\n 1.Ingrese los puntos acumulados por infracciones de transito: ");
            puntosAcumulados = Integer.parseInt(in.readLine()); 
            
            if (puntosAcumulados < limPuntosAcum ) {
                System.out.print(ANSI_GREEN + "\n Usuario tiene licencia activa." + ANSI_RESET +"\n Puntos acumulados por infraciones es menor a 12 puntos. \n \n Puede continuar con la validacion de requiremientos.");
                System.out.println(ANSI_CYAN + "\n--------------------------------------------------------------------"+ ANSI_RESET);
                System.out.print("\n 2. El usuario requiere renovar la licencia: (Si / No)");
                respuestaNo1 = in.readLine().toLowerCase();

                if (respuestaNo1.contains(OPCION_SI)) {
                    System.out.print("\n 3.a. Validar si identificacion esta al dia? (Si / No) ");
                    respuestaNo1 = in.readLine().toLowerCase();
                    System.out.print("\n 3.b. Validar si identificacion esta en buen estado?(Si / No) ");
                    respuestaNo2 = in.readLine().toLowerCase();

                    if (respuestaNo1.contains(OPCION_SI) && respuestaNo2.contains(OPCION_SI)) {
                        System.out.print("\n 4. Validar si usuario tiene dictamen medico digital? (Si / No)");
                        respuestaNo1 = in.readLine().toLowerCase();
                        if (respuestaNo1.contains(OPCION_SI)) {
                            System.out.print("\n 4. Validar si tiene pago todas las multas pendientes? (Si / No) ");
                            respuestaNo1 = in.readLine().toLowerCase();

                            if (respuestaNo1.contains(OPCION_SI)) {
                                System.out.println(ANSI_GREEN
                                        + "\n--------------------------------------------------------------------");
                                System.out.print(" Usuario cumple con todos los requisitos ");
                                System.out.println(
                                        "\n--------------------------------------------------------------------"
                                                + ANSI_RESET);
                                System.out.print(" \n Va realizar la renovacion en el BCR? (Si / No) ");
                                respuestaNo1 = in.readLine().toLowerCase();
                                if (respuestaNo1.contains(OPCION_SI)) {
                                    sobreCargo = 4200;
                                }
                                else {
                                    sobreCargo = 0;
                                }
                                if (puntosAcumulados <= 4) {
                                    montoTotal = 5000 + sobreCargo;
                                    System.out.print("\n"+ MSG_COSTO+ " 5000 colones mas "+ sobreCargo+ " por tramite del banco.\n");
                                    System.out.print( "Para un total de : "+ montoTotal + " colones \n");
                                    System.out.print( MSG_VIGENCIA +" 6 annos.\n");
                                    System.out.println("\n--------------------------------------------------------------------");
                                    System.out.print( MSG_SALIDA);
                                    System.out.println("\n--------------------------------------------------------------------");
                                }
                                else if  ((puntosAcumulados >= 5) && (puntosAcumulados <= 8)) {
                                    montoTotal = 10000 + sobreCargo;
                                    System.out.print("\n"+ MSG_COSTO+ " 10000 colones mas "+ sobreCargo+ " por tramite del banco.\n");
                                    System.out.print( "Para un total de : "+ montoTotal + " colones \n");
                                    System.out.print( MSG_VIGENCIA +" 4 annos.");
                                    System.out.println("\n--------------------------------------------------------------------");
                                    System.out.print( MSG_SALIDA);
                                    System.out.println("\n--------------------------------------------------------------------");
                                }
                                else {
                                    montoTotal = 10000 + sobreCargo;
                                    System.out.print("\n"+ MSG_COSTO+ " 10000 colones mas "+ sobreCargo+ " por tramite del banco.\n");
                                    System.out.print( "Para un total de : "+ montoTotal + " colones \n");
                                    System.out.print( MSG_VIGENCIA +" 3 annos.\n");
                                    System.out.println("\n--------------------------------------------------------------------");
                                    System.out.print( MSG_SALIDA);
                                    System.out.println("\n--------------------------------------------------------------------");
                                }
                            }
                            else {
                                System.out.print(ANSI_RED +  MSG_RECHAZO + ANSI_RESET + "\n Usuario requiere tener pago las multas pendientes.\n ");  
                            }
                        }
                        else {
                            System.out.print(ANSI_RED +  MSG_RECHAZO + ANSI_RESET + "\n Usuario requiere dictamen medico digital.\n ");
                        }
                    } 
                    else {
                        System.out.print(ANSI_RED +  MSG_RECHAZO + ANSI_RESET + "\n Usuario requiere tener documentacion al dia y en buen estado.\n ");
                    }   

                }
                else {
                    System.out.print(ANSI_GREEN + "\n Usuario no requiere renovar la licencia.\n "+ANSI_RESET);
                    System.out.print( "-----------------------------------------------\n");
                    System.out.println( MSG_SALIDA );
                    System.out.print( "-----------------------------------------------\n");
                    return;
        
                }
                 
            }
            else {
                System.out.print(ANSI_RED + "\n Usuario tiene licencia suspendida." + ANSI_RESET+ "\n Puntos acumulados por infraciones es mayor a 12 puntos.\n ");
                System.out.println(MSG_RECHAZO );
            }

    }
}
