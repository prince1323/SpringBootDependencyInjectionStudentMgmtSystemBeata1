package com.prince.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentBean implements Serializable
{
	private static final long serialVersionUID = 484388045685157785L;
	private int id;
	private String name;
	private int totalMarks;
	private float percentage;
	private String result;
}
