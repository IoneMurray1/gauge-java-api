import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Assertions {



    @Step("The response code should be <response_code>")
    public void responseCodeShouldEqual(Integer response_code) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        Integer httpResponseCode = (Integer) dataStore.get("httpResponseCode");

        Assert.assertEquals(response_code, httpResponseCode);
    }

    @Step("The last updated time returned should be equal to the posted time")
    public void AssertLastUpdatedTime() {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        String updatedTime = (String) dataStore.get("updatedTime");
        String httpResponseDate = (String) dataStore.get("httpResponseDate");

        LocalDateTime dateTime = LocalDateTime.parse(httpResponseDate, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'"));
        httpResponseDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

        Assert.assertEquals(updatedTime, httpResponseDate);
    }

    @Step("The media type returned should be <mediaType>")
    public void AssertMediaTypeUsed(String mediaType)
    {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        String mediaTypeUsed = (String) dataStore.get("mediaTypeUsed");

        Assert.assertEquals(mediaType, mediaTypeUsed);
    }

    @Step("The body text returned should be <bodyText>")
    public void AssertBodyReceived(String bodyText)
    {
        Assert.fail("Undefined step");
    }
}
