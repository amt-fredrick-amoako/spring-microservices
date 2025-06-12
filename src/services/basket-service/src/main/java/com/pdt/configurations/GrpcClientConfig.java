package com.pdt.configurations;

import com.pdt.basket.grpc.DiscountProtoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcClientConfig {

//    @Value("${discount.service.host}")
//    private String host;
//
//    @Value("${discount.service.port}")
//    private int port;

    @Bean
    public ManagedChannel discountChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Bean
    public DiscountProtoServiceGrpc.DiscountProtoServiceBlockingStub discountStub(ManagedChannel channel) {
        return DiscountProtoServiceGrpc.newBlockingStub(channel);
    }
}


