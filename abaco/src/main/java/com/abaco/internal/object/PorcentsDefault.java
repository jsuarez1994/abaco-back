package com.abaco.internal.object;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "porcent-payment")
@Data
public class PorcentsDefault {

	private Integer permanent;

	private Integer personal;

	private Integer saving;

}
