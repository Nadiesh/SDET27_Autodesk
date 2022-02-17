package pojo;

public class PojoLibrary {
	public String name;
	public int id;
	public int phno;
	public String emailId;
	public  PojoLibrary()
	{
		
	}
	public PojoLibrary(String name, int id, int phno, String emailId) {
		super();
		this.name = name;
		this.id = id;
		this.phno = phno;
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
