package com.epa.inventarioLog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigurationPrinter {
    public ConfigurationPrinter(
            @Value("${mongo.uri}") String mongoUri,
            @Value("${rabbit.uri}") String rabbitUri
    ) {
        Logger logger = LoggerFactory.getLogger(ConfigurationPrinter.class);
        logger.info("*** CONFIGURACION ***");
        logger.info("Mongo URI: " + mongoUri);
        logger.info("RabbitMQ URI: " + rabbitUri);
        logger.info("*** CONFIGURACION ***");
    }
}
