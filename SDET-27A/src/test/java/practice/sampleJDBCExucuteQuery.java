package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sampleJDBCExucuteQuery {

	public static void main(String[] args) throws SQLException {
		
		/*step 1:register the driver*/
		 Driver driver = new Driver();
		 /*step 2:get connect to database- provide db name*/
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		 /*step 3:issue create a statement*/
		Statement state = con.createStatement();
		/*step 4:execute a query-provide table name*/
		ResultSet result = state.executeQuery("select * from employeeinfo;");
		while(result.next())
		{
			System.out.println(result.getString(2)+" "+result.getString(3));
		}
		/*step 5:close db*/
		con.close();
		

	}

}
