import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

public class GenericPost {

    @Step("Post to the <endpoint> endpoint")
    public void PostEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "http://192.168.99.100:3000/" + endpoint;
        Gauge.writeMessage(url);
        try {
            httpResponse = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body("{\"test\": 123}")
                    .asString();
            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            String httpResponseDate = httpResponse.getHeaders().get("Date").get(0);
            dataStore.put("httpResponseDate", httpResponseDate);
            if (httpResponse.getBody() != null)
                Gauge.writeMessage(httpResponse.getBody());
            Gauge.writeMessage(httpResponseStatusText);

        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Step("Post to the <endpoint> endpoint with <text>")
    public void PostEndPointWithParameters(String endpoint, String text) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "http://192.168.99.100:3000/" + endpoint;
        Gauge.writeMessage(url);
        try {
            httpResponse = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body(String.format("%s", text))
                    .asString();
            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            String httpResponseDate = httpResponse.getHeaders().get("Date").get(0);
            dataStore.put("httpResponseDate", httpResponseDate);
            if (httpResponse.getBody() != null)
                Gauge.writeMessage(httpResponse.getBody());
            Gauge.writeMessage(httpResponseStatusText);

        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
