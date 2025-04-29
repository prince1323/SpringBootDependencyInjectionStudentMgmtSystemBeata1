package com.prince.service;

import java.util.List;

import com.prince.model.StudentBean;

public interface IStudentManagmentService 
{
	public Integer putStudent(StudentBean s) throws Exception;
	public List<StudentBean> getAllStudents() throws Exception;
	public StudentBean getStudentById (Integer id) throws Exception;
	public Integer removeStudentById (Integer id) throws Exception;
	public StudentBean modifyStudentById (Integer id) throws Exception;
}
