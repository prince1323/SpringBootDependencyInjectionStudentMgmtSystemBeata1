package com.prince.DAO;
import java.util.*;
import com.prince.model.StudentBean;

public interface IStudentManagmentDAO {
	public Integer insertStudent(StudentBean s) throws Exception;
	public List<StudentBean> fetchAllStudents() throws Exception;
	public StudentBean fetchStudentById (Integer id) throws Exception;
	public Integer deleteStudentById (Integer id) throws Exception;
	public StudentBean updateStudentById (Integer id) throws Exception;
}
