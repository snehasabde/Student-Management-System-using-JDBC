import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;


public class Start {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
System.out.println("Welcome to Student Management App");

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int choice = 0;
 do{
	
	   System.out.println("PRESS 1 TO ADD STUDENT DATA");
	   System.out.println("PRESS 2 TO DELETE STUDENT DATA");
	   System.out.println("PRESS 3 TO DISPLAY STUDENT DATA");
	   System.out.println("PRESS 4 TO UPDATE THE STUDENT DATA");
	   System.out.println("PRESS 5 TO EXIT  FROM STUDENT DATA APPLICATION...");
	   
	   choice = Integer.parseInt(br.readLine());
	   //parseInt is used to convert string into integer
	   
	   switch(choice) {
	   
	   case 1 :
		   //add student
		   System.out.println("Enter Student Name :");
		   String name = br.readLine();
		   
		   System.out.println("Enter user Phone Number :");
		   String phone = br.readLine();
		   
		   System.out.println("Enter Student City :");
		   String city = br.readLine();
		   
		  //create studeninsertStudentToDB()t class object to store students data
		   Student st = new Student (name , phone , city);
		  boolean answer =  StudentDao.insertStudentToDB(st);
		  if(answer){
			  System.out.println("Student Data is added Successfully...");
		  }
		  else {
			  System.out.println("Something went wrong..");
		  }
		   System.out.println(st);
		break; 
		
		
	   case 2 : 
		   //delete student
	System.out.println("Enter the student id to delete :");
	int userId = Integer.parseInt(br.readLine());
	boolean ans = StudentDao.deleteStudent(userId);
	if(ans) {
	  System.out.println("Student Data is Deleted Successfully...");
		  }
		  else {
			  System.out.println("Something went wrong..");
		  }
		   break;
		 
		   
	   case 3: 
		   // display student
		   StudentDao.showAllStudentData();
		   break;
	   case 4 :
		   //update the students data
		   System.out.println("Enter the ID of the student you want to update:");
		    int id = Integer.parseInt(br.readLine());

		    System.out.println("Enter new name:");
		    String newName = br.readLine();

		    System.out.println("Enter new phone:");
		    String newPhone = br.readLine();

		    System.out.println("Enter new city:");
		    String newCity = br.readLine();

		    // Create and set Student object
		    Student updateStudent = new Student();
		    updateStudent.setStudentId(id);
		    updateStudent.setStudentName(newName);
		    updateStudent.setStudentPhone(newPhone);
		    updateStudent.setStudentCity(newCity);

		  boolean UpdatedResultAns = StudentDao.updateStudentData(updateStudent );
		  if (UpdatedResultAns) {
		        System.out.println("Student data updated successfully.");
		    } else {
		        System.out.println("Update failed. Please check if the student ID exists.");
		    }
		  
		   break;
		   
	   case 5 :
		   //exit student
		  break;
		
	   }
	   System.out.println("THANK YOU FOR USING MY APPLICATION...");
	   System.out.println("SEE YOU SOON...");   
	   
   } while(choice != 5);
	}

}
