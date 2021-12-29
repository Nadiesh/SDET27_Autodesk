package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteVerify {

	public static void main(String[] args) throws SQLException {
		boolean flag=false;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement state = con.createStatement();
		state.executeUpdate("insert into employeeinfo value(5,'suresh','hyd');");
		ResultSet result = state.executeQuery("select * from employeeinfo;");
		while(result.next())
		{
			if(result.getString(2).contains("suresh"))
			{
				flag=true;
				System.out.println("it contains given data");
				break;
			}
		}
		if(flag==false) {
			System.out.println("it not contains given data");
		}
		
		
		

	}

}
