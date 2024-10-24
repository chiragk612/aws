package org.aws.config;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DynamoDBConfig {
    @Value("${aws.access.key}")
    private String awsAccessKey;
    @Value("${aws.access.secret-key}")
    private String awsSecretKey;
    @Value("${aws.dynamodb.endpoint}")
    private String awsDynamoDBEndPoint;
    @Value("${aws.region}")
    private String awsRegion;

    public DynamoDBConfig() {
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(this.awsAccessKey, this.awsSecretKey);
    }

    @Bean
    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(this.amazonAWSCredentials());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return (AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(this.awsDynamoDBEndPoint, this.awsRegion))).withCredentials(this.amazonAWSCredentialsProvider())).build();
    }

    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(this.amazonDynamoDB());
    }
}


