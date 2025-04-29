package com.prince.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prince.model.StudentBean;

@Repository
public class StudentManagmentDAOImp implements IStudentManagmentDAO 
{
	private static final String INSERT_Q = "insert into dummyStudent values (dummy_student_seq.nextval,?,?,?,?)";
	private static final String SELECT_Q = "select * from dummyStudent";
	private static final String SELECT_Q_BY_ID = "select * from dummyStudent where id = ?";
	private static final String Delete_Q_BY_ID = "delete from dummyStudent where id = ?";
	
	@Autowired
	DataSource ds;
	
	@Override
	public Integer insertStudent(StudentBean s) throws Exception {
		int k = 0;
		
		try(Connection con = ds.getConnection(); 
				PreparedStatement ps = con.prepareStatement(INSERT_Q))
		{
			ps.setString(1, s.getName());
			ps.setInt(2, s.getTotalMarks());
			ps.setFloat(3, s.getPercentage());
			ps.setString(4, s.getResult());
			
			k = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
		return k;
	}

	@Override
	public List<StudentBean> fetchAllStudents() throws Exception {
		List<StudentBean> ls = new ArrayList<StudentBean>();
		try(Connection con = ds.getConnection(); 
				PreparedStatement ps = con.prepareStatement(SELECT_Q))
		{
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentBean s = new StudentBean();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setTotalMarks(rs.getInt(3));
				s.setPercentage(rs.getFloat(4));
				s.setResult(rs.getString(5));
				
				ls.add(s);
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
		return ls;
	}

	@Override
	public StudentBean fetchStudentById(Integer id) throws Exception {
		StudentBean s = null;
		try(Connection con = ds.getConnection(); 
				PreparedStatement ps = con.prepareStatement(SELECT_Q_BY_ID))
		{
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				s = new StudentBean();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setTotalMarks(rs.getInt(3));
				s.setPercentage(rs.getFloat(4));
				s.setResult(rs.getString(5));
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
		return s;
	}

	@Override
	public Integer deleteStudentById(Integer id) throws Exception {
		Integer k;
		
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(Delete_Q_BY_ID))
		{
			ps.setInt(1, id);
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return k;
	}

	@Override
	public StudentBean updateStudentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
