package org.example.jni.config;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.NMVnext.NMAPIBookServiceGrpc;
import org.example.jni.properties.GRPCProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
