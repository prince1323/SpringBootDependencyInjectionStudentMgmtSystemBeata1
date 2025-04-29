package com.prince;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;

import com.prince.controller.StudentOperationsMgmt;

@SpringBootApplication
public class StudentManagmentSystemBootProjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StudentManagmentSystemBootProjApplication.class, args);
		StudentOperationsMgmt bean = ctx.getBean("controllerBean", StudentOperationsMgmt.class);

		Scanner sc = new Scanner(System.in);

		System.out.println("\n*******Student Managment System*******\n");
		System.out.println(
				" \t1) Add Student\n \t2) Display All Students\n \t3) Display Students By Id\n \t4) Delete Students By Id\n \t5) Update Students By Id\n ");

		System.out.print("Enter you choice here : ");
		Integer choice = sc.nextInt();

		switch (choice) {
		case 1: {
			bean.addStudent();
			break;
		}
		case 2: {
			bean.displayAllStudents();
			break;
		}
		case 3: {
			bean.displayStudentsById();
			break;
		}
		case 4: {
			bean.deleteStudentById();
			break;
		}
		case 5: {
			
			break;
		}
		default:
			sc.close();
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

		sc.close();
	}

}
