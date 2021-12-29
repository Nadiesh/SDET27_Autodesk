package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
	//step 1:Register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			//step 2:get connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		//step 3:issue create statement
			Statement state = con.createStatement();
			//step 4:execute aquery
			int result = state.executeUpdate("insert into employeeinfo values(4,'deepak','london')");
			if(result==1)
			{
				System.out.println("data added successfully");
			}
			else {
				System.out.println("error");
			}
		
			con.close();
		

	}

}
