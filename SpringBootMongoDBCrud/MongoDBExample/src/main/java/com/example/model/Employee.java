package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee {

	@Id
	private String empId;
	private String name;
	private int age;
	private double salary;
}
