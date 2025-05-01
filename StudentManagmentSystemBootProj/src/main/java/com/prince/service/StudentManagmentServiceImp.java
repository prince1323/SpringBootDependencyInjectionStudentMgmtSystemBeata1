package com.prince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prince.DAO.IStudentManagmentDAO;
import com.prince.DAO.StudentManagmentDAOImp;
import com.prince.model.StudentBean;


@Service
public class StudentManagmentServiceImp implements IStudentManagmentService 
{
	@Autowired
	@Qualifier("mysqlDB")
	IStudentManagmentDAO stdDao;
	
	@Override
	public Integer putStudent(StudentBean s) throws Exception {
		int res;
		
		try {
			res = stdDao.insertStudent(s);
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
		return res;
	}

	@Override
	public List<StudentBean> getAllStudents() throws Exception 
	{
		List<StudentBean> fetchedStudents = stdDao.fetchAllStudents();
		return fetchedStudents;
	}

	@Override
	public StudentBean getStudentById(Integer id) throws Exception {
		StudentBean fetchStudentById = stdDao.fetchStudentById(id);
		return fetchStudentById;
	}

	@Override
	public Integer removeStudentById(Integer id) throws Exception {
		Integer k = stdDao.deleteStudentById(id);
		return k;
	}

	@Override
	public StudentBean modifyStudentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
