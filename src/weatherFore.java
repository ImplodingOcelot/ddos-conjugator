import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class weatherFore {
    String json;
    int count;

    private HttpResponse<String> getFore(String state) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.weather.gov/alerts/active?area=" + state))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        json = response.body();
        return response;
    }

    private ArrayList<String> alertsUSA(String state) throws IOException, InterruptedException {
        json = getFore(state).body();
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("event").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    private ArrayList<String> alertsDiscUSA(String state) throws IOException, InterruptedException {
        json = getFore(state).body();
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("description").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    private ArrayList<String> alertAreaDisc(String state) throws IOException, InterruptedException {
        json = getFore(state).body();
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("areaDesc").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    private ArrayList<String> alertServerity(String state) throws IOException, InterruptedException {
        json = getFore(state).body();
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("severity").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    public int getCount(String state) throws IOException, InterruptedException {
        ArrayList<String> wow;
        wow = alertsUSA(state);
        count = wow.size();
        return count;
    }

    public ArrayList<String> getAlert(String state, int select) throws IOException, InterruptedException {
        ArrayList<String> out = new ArrayList<>();
        out.add(state);
        try {
            out.add(unescapeJava(alertsUSA(state).get(select)));
            out.add(unescapeJava(alertsDiscUSA(state).get(select)));
            out.add(unescapeJava(alertAreaDisc(state).get(select)));
            out.add(unescapeJava(alertServerity(state).get(select)));
        } catch (IndexOutOfBoundsException e) {
            out.add("No alerts");
        }
        return out;
    }

    private static String unescapeJava(String escaped) {
        if (escaped.indexOf("\\u") == -1)
            return escaped;

        String processed = "";

        int position = escaped.indexOf("\\u");
        while (position != -1) {
            if (position != 0)
                processed += escaped.substring(0, position);
            String token = escaped.substring(position + 2, position + 6);
            escaped = escaped.substring(position + 6);
            processed += (char) Integer.parseInt(token, 16);
            position = escaped.indexOf("\\u");
        }
        processed += escaped;

        return processed;
    }
}
