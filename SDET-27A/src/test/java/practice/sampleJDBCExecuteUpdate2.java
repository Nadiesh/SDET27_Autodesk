package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sampleJDBCExecuteUpdate2 {
	public static void main(String[] args) throws SQLException {
		Connection con =null;
	
		try {
		//step 1:Register the driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				//step 2:get connection
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			//step 3:issue create statement
				Statement state = con.createStatement();
				//step 4:execute aquery
				int result = state.executeUpdate("insert into employee values(4,'deepak','london')");
				if(result==1)
				{
					System.out.println("data added successfully");
				}
				else {
					System.out.println("error");
				}
		}
		catch (Exception e) {
			//todo:handle exception
		}
		finally {
			//close db connection
			con.close();
			System.out.println("db close");
			
		}
	}
}
			
			
			
			
				
			

		


