import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ConversorDivisas {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el código de la divisa base (por ejemplo, HNL):");
        String codigoDivisa = lectura.nextLine().toUpperCase();

        while(true) {
            try {
                HttpResponse<String> response = getStringHttpResponse(codigoDivisa);
                Gson gson = new Gson();
                Divisa divisa = (Divisa)gson.fromJson((String)response.body(), Divisa.class);
                Map<String, Double> rates = divisa.getConversion_rates();
                System.out.println("\n=== Menú ===");
                System.out.println("1. Mostrar todas las tasas de conversión");
                System.out.println("2. Cambiar la divisa base");
                System.out.println("3. Información general de la divisa base");
                System.out.println("4. Mostrar conversiones específicas de varias divisas");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = lectura.nextInt();
                lectura.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("\nTasas de conversión para la divisa base: " + divisa.getBase_code());
                        mostrarTasas(rates);
                        break;
                    case 2:
                        System.out.println("\nIngrese el nuevo código de divisa base (por ejemplo, EUR):");
                        codigoDivisa = lectura.nextLine().toUpperCase();
                        break;
                    case 3:
                        System.out.println("\nDivisa base: " + divisa.getBase_code());
                        System.out.println("Última actualización: " + divisa.getTime_last_update_utc());
                        break;
                    case 4:
                        System.out.println("\nIngrese los códigos de las divisas a consultar (separados por comas):");
                        String divisasSeleccionadas = lectura.nextLine().toUpperCase();
                        mostrarConversionesEspecificas(rates, divisasSeleccionadas);
                        break;
                    case 5:
                        System.out.println("¡Gracias por usar el conversor de divisas!");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InterruptedException | IOException var9) {
                System.out.println("Error al obtener datos de la API. Por favor, intente nuevamente.");
                return;
            }
        }
    }
    // Aqui voy a poner esta función que servirá para conectarse a la API
        private static HttpResponse<String> getStringHttpResponse(String codigoDivisa) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            String apiKey = ConfigManager.getApiKey();
            String apiURL = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + codigoDivisa;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiURL)).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
    private static void mostrarTasas(Map<String, Double> rates) {
        int columnCount = 0;
        int totalColumns = 5;
        Iterator var3 = rates.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, Double> rate = (Map.Entry)var3.next();
            System.out.printf("%s: %.2f\t", rate.getKey(), rate.getValue());
            ++columnCount;
            if (columnCount == totalColumns) {
                System.out.println();
                columnCount = 0;
            }
        }

        System.out.println();
    }

    private static void mostrarConversionesEspecificas(Map<String, Double> rates, String divisasSeleccionadas) {
        String[] divisas = divisasSeleccionadas.split(",");
        System.out.println("\nTasas específicas:");
        String[] var3 = divisas;
        int var4 = divisas.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String divisa = var3[var5];
            divisa = divisa.trim();
            if (rates.containsKey(divisa)) {
                System.out.printf("%s: %.2f\n", divisa, rates.get(divisa));
            } else {
                System.out.printf("La divisa '%s' no está disponible.\n", divisa);
            }
        }
    }
}
