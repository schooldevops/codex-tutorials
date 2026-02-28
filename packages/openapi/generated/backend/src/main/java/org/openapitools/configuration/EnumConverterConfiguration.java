package org.openapitools.configuration;

import org.openapitools.model.TimeBoxPriority;
import org.openapitools.model.TimeBoxStatus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration(value = "org.openapitools.configuration.enumConverterConfiguration")
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.timeBoxPriorityConverter")
    Converter<String, TimeBoxPriority> timeBoxPriorityConverter() {
        return new Converter<String, TimeBoxPriority>() {
            @Override
            public TimeBoxPriority convert(String source) {
                return TimeBoxPriority.fromValue(source);
            }
        };
    }
    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.timeBoxStatusConverter")
    Converter<String, TimeBoxStatus> timeBoxStatusConverter() {
        return new Converter<String, TimeBoxStatus>() {
            @Override
            public TimeBoxStatus convert(String source) {
                return TimeBoxStatus.fromValue(source);
            }
        };
    }

}
