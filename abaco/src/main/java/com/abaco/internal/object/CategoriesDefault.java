package com.abaco.internal.object;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.abaco.dto.CategoryDTO;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "categories-default")
@Data
public class CategoriesDefault {

	private List<CategoryDTO> properties;

}
