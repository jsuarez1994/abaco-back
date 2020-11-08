package com.abaco.internal.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abaco.repository.CategoryRepository;

@Component
public class CategoryValidation {

	@Autowired
	CategoryRepository categoryRepository;

}
