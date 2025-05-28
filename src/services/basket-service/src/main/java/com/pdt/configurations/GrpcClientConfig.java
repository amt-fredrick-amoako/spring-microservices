package com.pdt.configurations;

import com.pdt.basket.grpc.DiscountProtoServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcClientConfig {
    @Bean
    public DiscountProtoServiceGrpc.DiscountProtoServiceBlockingStub discountProtoStub(GrpcChannelFactory channels) {
        return DiscountProtoServiceGrpc.newBlockingStub(channels.createChannel("local"));
    }
}

