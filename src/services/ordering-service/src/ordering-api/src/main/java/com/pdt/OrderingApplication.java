package com.pdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {
        "com.pdt.configurations",
})
//@EnableJpaRepositories(basePackages = {"com.pdt.repositories", "com.pdt.data"})
//@ComponentScan(basePackages = {
//        "com.pdt",
//        "com.pdt.persistence",
//        "com.pdt.data",
//        "com.pdt.repositories",
//        "com.pdt.configs",
//        "com.pdt.services",
//        "com.pdt.mail",
//        "com.pdt.mappings"
//})
public class OrderingApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderingApplication.class, args);
    }
}
