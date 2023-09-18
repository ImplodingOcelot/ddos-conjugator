import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class inspirationAPI {
    // god i have no clue how the fuck this works LMAO
    String quote;
    String quoteBy;
    String authorDisc;

    public void inspirationAPImain() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://quotes15.p.rapidapi.com/quotes/random/"))
                .header("X-RapidAPI-Key", "22dd56d182msh7622a33f87a04a3p10842fjsn97f8c4104196")
                .header("X-RapidAPI-Host", "quotes15.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String response2 = response.body();
        response2 = response2.substring(response2.indexOf("content"));
        quote = response2.substring(10, response2.indexOf("url") - 3);
        String response3 = response.body();
        response3 = response3.substring(response3.indexOf("name"));
        quoteBy = response3.substring(7, response3.indexOf("url") - 3);
        String response4 = response.body();
        response4 = response4.substring(response4.indexOf("description"));
        authorDisc = response4.substring(14, response4.indexOf("master_id") - 3);
        authorDisc = authorDisc.replace("  ", " ");
        if (authorDisc.isEmpty()) {
            authorDisc = "No description available";
        }
        System.out.println("quote:" + quote + "\n" + "quoteBy:" + quoteBy + "\n" + "authorDisc:" + authorDisc);
    }

    public String getQuote() {
        return quote;
    }

    public String getQuoteBy() {
        return quoteBy;
    }

    public String getAuthorDisc() {
        return authorDisc;
    }
}
