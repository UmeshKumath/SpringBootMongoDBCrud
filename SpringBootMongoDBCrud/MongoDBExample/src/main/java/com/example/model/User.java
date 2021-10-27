package com.example.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
	@Id
	private String userId;
	private String name;
	private LocalDate creationDate = LocalDate.now();
	private Map<String, String> userSettings = new HashMap<>();
}
