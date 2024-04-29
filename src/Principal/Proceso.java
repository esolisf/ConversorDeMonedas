package Principal;


import com.google.gson.Gson;
import Conversiones.ApiConversiones;
import java.io.IOException;
import java.util.Scanner;

public class Proceso {
    public void inicio() throws IOException, InterruptedException {
        int opcion = 0;

        System.out.println("****************************");
        System.out.println("Bienvenido al sistema de conversión de moneda");
        System.out.println("****************************");

        String mensaje = """
                
                ***************************************
                El sistema le permite realizar cualquier tipo de cambio, 
                debe ingresar el codigo de divisa que desea y luego 
                el codigo de divisa a la cual desea convertirlo, además del monto.                
                Ejemplos de código de divisa:(USD, MXN, BRL, ARS, CRC).  
                ****************************************           
                """;
        System.out.println(mensaje);
        System.out.println("Luego de la información, digite 1 para continuar.");
        Scanner teclado = new Scanner(System.in);
        opcion = teclado.nextInt();
        while (opcion != 2) {
            System.out.println(mensaje);
            System.out.println("Digite 1 para realizar conversión u 2 para salir.");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    ApiConversiones conversorMoneda = new ApiConversiones();
                    conversorMoneda.Api();
                    break;
                case 2:
                    System.out.println("Gracias por utilizar nuestro servicio");
                    break;
                default:
                    System.out.println("Opción no permitida");


            }

        }


    }
}
