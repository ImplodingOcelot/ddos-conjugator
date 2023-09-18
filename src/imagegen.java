import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class imagegen {
    public String imagegenmain(String prompt) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://arimagesynthesizer.p.rapidapi.com/generate"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Key", "22dd56d182msh7622a33f87a04a3p10842fjsn97f8c4104196")
                .header("X-RapidAPI-Host", "arimagesynthesizer.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("prompt=" + prompt + "&id=12345&width=768&height=768&inferenceSteps=50&guidanceScale=7.5&img2img_strength=0.75"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String response2 = response.body();
        response2 = response2.substring(9, 41);
        System.out.println(response2);
        String a = "wow";
        while (a.equals("wow")) {
            TimeUnit.SECONDS.sleep(2);
            try {
                a = testing(response2);
            } catch (Exception e) {
                a = "wow";
            }
        }
        return testing(response2);
    }

    private String testing(String hash) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://arimagesynthesizer.p.rapidapi.com/get?hash=" + hash + "&returnType=image"))
                .header("X-RapidAPI-Key", "22dd56d182msh7622a33f87a04a3p10842fjsn97f8c4104196")
                .header("X-RapidAPI-Host", "arimagesynthesizer.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

//        return request.uri().toURL().toString();
        HttpResponse<byte[]> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofByteArray());
//        System.out.println(response.body());

        // convert to base64 jpeg without javax.xml because it's dead
        String base64 = java.util.Base64.getEncoder().encodeToString(response.body());

        // convert to image
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(response.body()));

        // write to file
        ImageIO.write(image, "jpg", new File("C:\\Users\\ottzj\\Documents\\image.jpg"));

        return response.body().toString();
    }
}
