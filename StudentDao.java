package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
//in this class we do datbase operation like query firing ,etc
	public static boolean insertStudentToDB(Student st)  {
	
		boolean flag = false;
		
		try {
			//here static is used beacause we dod not want to create object for this method access
			//jdbc code
			Connection con =ConnectionProvider.createConn();
			String query = "insert into studentsData(sname , sphone , scity) values (? , ? , ? )";
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the values of parameter
			pstmt.setString(1 , st.getStudentName());
			pstmt.setString(2 , st.getStudentPhone());
			pstmt.setString(3 , st.getStudentCity());
			
			//Execute...
			pstmt.executeUpdate();
			flag = true;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean deleteStudent(int userId) {
	boolean flag = false;
		
		try {
			//here static is used beacause we dod not want to create object for this method access
			//jdbc code
			Connection con =ConnectionProvider.createConn();
			String query = "delete from studentsData where sid = ? ";
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the values of parameter
			pstmt.setInt(1,userId);
			pstmt.executeUpdate();
			flag = true;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return flag;
		
	}

	public static void showAllStudentData() {
boolean flag = false;
		
		try {
			//here static is used beacause we dod not want to create object for this method access
			//jdbc code
			Connection con =ConnectionProvider.createConn();
			String query = "select * from studentsData; ";
		Statement stmt = con.createStatement();
		//
			ResultSet rs = stmt.executeQuery(query);
			
			//
			while(rs.next()) {
			int id = rs.getInt(1);	
			String name = rs.getString(2);
			String phone = rs.getString(3);
			String city =  rs.getString(4);
			
			System.out.println("ID    : "+id);
			System.out.println("NAME  : "+name);
			System.out.println("PHONE : "+phone);
			System.out.println("CITY  : "+city);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");		
			}
			flag = true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static boolean updateStudentData(Student updateStudent ) {
	boolean flag = false;
		
		try {
			// Ensure ID is valid
	        if (updateStudent .getStudentId() <= 0) {
	            System.out.println("Invalid student ID: " );
	            return false;
	        }
			//here static is used beacause we dod not want to create object for this method access
			//jdbc code
			Connection con =ConnectionProvider.createConn();
			String query = " UPDATE studentsData SET sname = ? , sphone = ? ,scity = ? WHERE sid = ?";
				
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the values of parameter
			pstmt.setString(1 , updateStudent .getStudentName());
			pstmt.setString(2 , updateStudent .getStudentPhone());
			pstmt.setString(3 , updateStudent .getStudentCity());
			pstmt.setInt(4, updateStudent .getStudentId());
			// Execute update
	        int rowsAffected = pstmt.executeUpdate();

	        if (rowsAffected > 0) {
	            flag = true;
	        }
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return flag;
		
	}

}
