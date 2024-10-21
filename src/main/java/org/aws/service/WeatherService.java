package org.aws.service;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.aws.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherService {
    @Autowired
    public  DynamoDBMapper dynamoDBMapper;
    @Autowired
    public RestTemplate restTemplate;
    @Value("${open.weather.uri}")
    String weatherUri;
    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    public WeatherService() {
    }

    public WeatherData getWeatherAPIData(String city) throws JsonProcessingException {
        Map<String, String> params = Map.of("city", city);
        log.info("Sending request to OpenWeather API for ", city);
        WeatherData weatherData = (WeatherData)this.restTemplate.getForObject(this.weatherUri, WeatherData.class, params);
        this.dynamoDBMapper.save(weatherData);
        return weatherData;
    }
    public String deleteById(String id){
        dynamoDBMapper.delete(id);
        return "Successfully Deleted";

    }
}




