package com.prince.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.prince.model.StudentBean;
import com.prince.service.StudentManagmentServiceImp;

@Controller("controllerBean")
public class StudentOperationsMgmt {

	@Autowired
    private StudentManagmentServiceImp stdService;
	
    private static final Scanner sc = new Scanner(System.in); // single shared Scanner


    public void addStudent() {
        try {
            System.out.print("Enter Student name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student's total marks: ");
            Integer marks = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            Float percentage = (((float) marks / 300) * 100);
            String result = percentage > 33.0 ? "Pass" : "Fail";

            StudentBean s = new StudentBean();
            s.setName(name);
            s.setTotalMarks(marks);
            s.setPercentage(percentage);
            s.setResult(result);

            Integer k = stdService.putStudent(s);
            if (k > 0)
                System.out.println("Student added successfully.");
            else
                System.out.println("Adding student operation failed.");

        } catch (InputMismatchException ime) {
            System.out.println("Invalid input! Please enter numeric values for marks.");
            sc.nextLine(); // clear the wrong input
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while adding a student.");
            e.printStackTrace();
        }
    }

    public void displayAllStudents() {
        try {
            List<StudentBean> stdList = stdService.getAllStudents();
            if (stdList.isEmpty()) {
                System.out.println("No students found.");
            } else {
                for (StudentBean s : stdList) {
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching students list.");
            e.printStackTrace();
        }
    }

    public void displayStudentsById() {
        try {
            System.out.print("Enter the ID of the student you want to see: ");
            Integer id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            StudentBean s = stdService.getStudentById(id);
            if (s != null) {
                System.out.println(s);
            } else {
                System.out.println("Student not found with ID: " + id);
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input! Please enter a valid numeric ID.");
            sc.nextLine(); // clear the wrong input
        } catch (Exception e) {
            System.out.println("An error occurred while fetching student details.");
            e.printStackTrace();
        }
    }

    public void deleteStudentById() {
        try {
            System.out.print("Enter the ID of the student you want to delete: ");
            Integer id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            Integer k = stdService.removeStudentById(id);
            if (k > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found. Deletion failed.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input! Please enter a valid numeric ID.");
            sc.nextLine(); // clear the wrong input
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the student.");
            e.printStackTrace();
        }
    }
}
