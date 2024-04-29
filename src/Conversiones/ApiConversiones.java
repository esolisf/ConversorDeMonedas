package Conversiones;

import Principal.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiConversiones {

    public void Api() throws IOException, InterruptedException {

        System.out.println("Digite el código de divisa inicial:");
        Scanner lectura1 = new Scanner(System.in);
        var dato1 = lectura1.nextLine();
        System.out.println("Digite el código de divisa a convertir:");
        Scanner lectura2 = new Scanner(System.in);
        var dato2 = lectura2.nextLine();
        System.out.println("Digite el monto:");
        Scanner lectura3 = new Scanner(System.in);
        var dato3 = lectura3.nextLine();


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1876b02ed6f5d1f8248aba8b/pair/"+dato1+"/"+dato2+"/"+dato3);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        HttpResponse respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = (String) respuesta.body();


        Gson gson = new Gson();
        Moneda monedaRecord = gson.fromJson(json, Moneda.class);
        System.out.println("---------------------------------------");
        System.out.println("Datos obtenidos");
        System.out.println("Fecha de actual de operación: "+monedaRecord.time_last_update_utc().substring(0,25));
        System.out.println("Divisa inicial: "+monedaRecord.base_code());
        System.out.println("Divisa a convertir: "+monedaRecord.target_code());
        System.out.println("Monto a convertir: "+dato3+" "+dato1.toUpperCase());
        System.out.println("Tasa de conversión: "+monedaRecord.conversion_rate());
        System.out.println("Resultado final de la conversión: "+monedaRecord.conversion_result()+" "+dato2.toUpperCase());
        System.out.println("--------------------------------------");


    }

}