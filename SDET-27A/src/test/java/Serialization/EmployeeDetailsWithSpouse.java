package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.PojoObjectLibrarey;
import pojo.PojoSpouseLibrarey;

public class EmployeeDetailsWithSpouse {
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		PojoSpouseLibrarey spouse = new PojoSpouseLibrarey("abc", 88798, "abc123");
		PojoObjectLibrarey pobj = new PojoObjectLibrarey("nadesh", "ty123", spouse);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./objectjsondata.json"), pobj);
	}

}
