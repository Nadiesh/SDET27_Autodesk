package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.PojoLibrary;

public class EmployeDetails {
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		
		//create object for pobj class and pass the values
		PojoLibrary pobj=new PojoLibrary("Nadeesh", 12, 9177222, "nadeesh@gmail.com");
		
		//convert javaobject into json using object mapper class
         ObjectMapper mapper = new ObjectMapper();
         
         //print json value in the console
         System.out.println(mapper.writeValueAsString(pobj));
         
         //generate json file
         mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonData1.json"), pobj);
	}
 

}
