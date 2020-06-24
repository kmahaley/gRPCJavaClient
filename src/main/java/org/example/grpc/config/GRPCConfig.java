package org.example.grpc.config;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.NMVnext.NMAPIBookServiceGrpc;
import org.example.grpc.properties.GRPCProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GRPCConfig {

    @Bean
    public NMAPIBookServiceGrpc.NMAPIBookServiceBlockingStub GRPCClientConfig(GRPCProperties properties) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(properties.getServerAddress(), properties.getServerPort())
                .usePlaintext()
                .build();

        NMAPIBookServiceGrpc.NMAPIBookServiceBlockingStub client = NMAPIBookServiceGrpc.newBlockingStub(channel);
        return client;
    }
}
