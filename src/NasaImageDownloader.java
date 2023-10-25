import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NasaImageDownloader {
    public String getNASAdata(String requested) {
        String output = "NOT SET";
        if(requested.equals("saveIOTD")) {
            output = getIOTDdata().body();
        }
        return output;
    }
    private HttpResponse<String> getIOTDdata() {
        String url = null;
        System.out.println("PINGING NASA IOTD");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.nasa.gov/planetary/apod?api_key=5MgXfkkLNG1JUkTMwX4fVTLLGfBk8iBGXNHbiylo"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            url = response.body().substring(response.body().indexOf("\"url\":\"")+7);
            url = url.substring(0, url.indexOf("\""));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        };
        System.out.println("Downloading image...");
        String userHome = System.getProperty("user.home");
        String documentsPath = userHome + File.separator + "Documents";
        File directory = new File(documentsPath);
        File file = new File(directory, "image.jpg");
        String destinationFile = file.getAbsolutePath();
        System.out.println(destinationFile);
        try {
            saveImage(url, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    private static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[4096];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}