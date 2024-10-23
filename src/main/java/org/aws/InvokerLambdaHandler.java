package org.aws;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;

public class InvokerLambdaHandler implements RequestHandler<ScheduledEvent, String> {
    private final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    private final DynamoDB dynamoDB = new DynamoDB(client);
    private final String tableName = "WeatherData";
    private final String apiEndpoint = "https://api.openweathermap.org/data/2.5/weather?q={city}&APPID=450b8c32f08b8258baa0832a413eaf2d";

    @Override
    public String handleRequest(ScheduledEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        Table table = dynamoDB.getTable(tableName);
        ScanSpec scanSpec = new ScanSpec();

        try {
            Iterator<Item> iterator = table.scan(scanSpec).iterator();
            while (iterator.hasNext()) {
                String city = iterator.next().getString("name");
                invokeApi(city);
            }
        } catch (Exception e) {
            logger.log("Error: " + e.getMessage());
        }

        return "Invocation completed";
    }

    private void invokeApi(String city) throws Exception {
        String urlString = apiEndpoint.replace("{city}", city);
        URI uri = new URI(urlString);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.getResponseCode();
    }
}
