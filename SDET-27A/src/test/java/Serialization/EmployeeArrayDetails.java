package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.PojoArrayLibrary;

public class EmployeeArrayDetails {
	@Test
	public void serialization () throws JsonGenerationException, JsonMappingException, IOException {
		int[] arr= {9999,8888,7777};
		PojoArrayLibrary pobj = new PojoArrayLibrary("nadeesh", "nadesh@gmail.com", arr);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./arrayjsonData.json"), pobj);
		
	}

}
