import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.json.JSONArray;

public class GenericGet {
    @Step("Retrieve the latest post details from the <endpoint> endpoint")
    public void GetEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<JsonNode> httpResponse;
        String url = "http://192.168.99.100:3000/" + endpoint;
        try {
            httpResponse = Unirest.get(url)
                    .header("content-type", "application/json")
                    .header("Accept", "*/*")
                    .asJson();
            dataStore.put("httpResponse", httpResponse);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            Gauge.writeMessage(httpResponseStatusText);
            Gauge.writeMessage(httpResponse.getBody().toString());
            JSONArray responseBody = httpResponse
                    .getBody()
                    .getObject()
                    .getJSONArray(endpoint.replace("/last", ""));

            String updatedTime = responseBody.getJSONObject(0).get("lastUpdated").toString();
            dataStore.put("updatedTime", updatedTime);
            String mediaTypeUsed = responseBody.getJSONObject(1).get("mediaTypeUsed").toString();
            dataStore.put("mediaTypeUsed", mediaTypeUsed);
            String bodyReceived = responseBody.getJSONObject(1).get("bodyReceived").toString();
            dataStore.put("bodyReceived", bodyReceived);
        }
        catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    //Get to the "unauthorized" endpoint
    @Step("Get to the <endpoint> endpoint")
    public void justGetEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "http://192.168.99.100:3000/" + endpoint;
        Gauge.writeMessage(url);
        try {
            httpResponse = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            Gauge.writeMessage(httpResponse.getBody());
            Gauge.writeMessage(httpResponseStatusText);

        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
    }

}
