package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.PojoLibrary;

public class Deserialization {
	@Test
	public void deser() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PojoLibrary pObj = mapper.readValue(new File("./jsondata.json"), PojoLibrary.class);
		System.out.println(pObj.emailId);
		System.out.println(pObj.id);
		System.out.println(pObj.name);
		System.out.println(pObj.phno);
		
	}

}
