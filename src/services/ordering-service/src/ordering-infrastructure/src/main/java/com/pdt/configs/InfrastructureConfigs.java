package com.pdt.configs;

import com.pdt.annotations.ApplicationService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(
        basePackages = "com.pdt.annotations",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ApplicationService.class})}
)
public class InfrastructureConfigs {
}
