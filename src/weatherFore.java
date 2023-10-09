import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class weatherFore {
    String json = "NOT SET";
    int count = 0;

    private HttpResponse<String> getFore(String state) {
        System.out.println("HERE" + state);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.weather.gov/alerts/active?area=" + state))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
            return response;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        json = "ERROR";
        return response;
    }

    private ArrayList<String> alertsUSA(String state) {
        if (json.equals("NOT SET")) {
            json = getFore(state).body();
        }
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("event").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    private ArrayList<String> alertsDiscUSA(String state) {
        if (json.equals("NOT SET")) {
            json = getFore(state).body();
        }
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("description").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    private ArrayList<String> alertAreaDisc(String state) {
        if (json.equals("NOT SET")) {
            json = getFore(state).body();
        }
        String testing;
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("areaDesc").replace("\n", "").replace("\r", ""));
        }
        for (int i = 0; i < features.length(); i++) {
            testing = events.get(i);
            if (testing.contains(";")) {
                events.set(i, testing.substring(0, testing.indexOf(";")) + ", and surrounding areas.");
            }
        }
        return events;
    }

    private ArrayList<String> alertServerity(String state) {
        if (json.equals("NOT SET")) {
            json = getFore(state).body();
        }
        ArrayList<String> events = new ArrayList<>();
        JSONObject obj = new JSONObject(json);
        var features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            events.add(features.getJSONObject(i).getJSONObject("properties").getString("severity").replace("\n", "").replace("\r", ""));
        }
        return events;
    }

    public int getCount(String state) {
        ArrayList<String> wow;
        wow = alertsUSA(state);
        count = wow.size();
        return count;
    }

    public ArrayList<String> getAlert(String state, int select) {
        ArrayList<String> out = new ArrayList<>();
        ArrayList<ArrayList<String>> out2 = alertList(state);
        out = out2.get(select);
        return out;
    }

    private ArrayList<ArrayList<String>> alertList(String state) {
        ArrayList<ArrayList<String>> out = new ArrayList<>();
        System.out.println("WOW: " + state);
        for (int i = 0; i <= getCount(state); i++) {
            out.add(new ArrayList<>());
            out.get(i).add(state);
            try {
                out.get(i).add(unescapeJava(alertsUSA(state).get(i)));
                out.get(i).add(unescapeJava(alertsDiscUSA(state).get(i)));
                out.get(i).add(unescapeJava(alertAreaDisc(state).get(i)));
                out.get(i).add(unescapeJava(alertServerity(state).get(i)));
            } catch (IndexOutOfBoundsException e) {
                out.get(i).add("No alerts");
            }
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

    public static void updateFore() {
        System.out.println("Updating...");
    }
}
