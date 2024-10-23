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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString());
        String urlString = apiEndpoint.replace("{city}", encodedCity);
        URI uri = new URI(urlString);
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        
        // Log the response code
        System.out.println("Response Code: " + responseCode);
        
        // Read and log the response data
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        
        // Log the response content
        System.out.println("Response Content: " + content.toString());
    }
}
