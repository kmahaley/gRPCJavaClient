package org.example.grpc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix= "grpc")
@Data
public class GRPCProperties {
    private String serverAddress;

    private int serverPort;
}
