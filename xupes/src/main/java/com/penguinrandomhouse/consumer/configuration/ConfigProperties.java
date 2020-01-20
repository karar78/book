package com.penguinrandomhouse.consumer.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * POJO representing configuration values in the application.properties file.
 *
 * @author Karar
 * @since 2020-01-20
 */
@Configuration
@ConfigurationProperties(prefix = "rest")
public class ConfigProperties {

    private String workUrl;

    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl;
    }
}
