package demo.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoRequestApi {

    private static String urlGet = "https://reqres.in/api/users/";

    private static String urlPost = "https://reqres.in/api/users";

    public static void get() {
        try {
            // Tạo request với phương thức Get và url là UrlGetApi
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlGet)).build();
            // Send request
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            // Lấy body của response trả về
            System.out.println("response " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void post() {
        // Tạo Map với dữ liệu demo
        Map<String, String> demoPostApi = new HashMap<String, String>();
        demoPostApi.put("name", "test");
        demoPostApi.put("job", "test");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert Map -> json để request
            String param = objectMapper.writeValueAsString(demoPostApi);
            // Tạo request với phương thức POST và url là UrlPostApi
            HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(param))
                    .uri(URI.create(urlPost)).build();
            // Send request
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            // Lấy body của response trả về
            System.out.println("response " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        get();
    }

}
