package pojo;

public class PojoArrayLibrary {
	String Name;
	String EmailId;
	int phno;
	public PojoArrayLibrary(String name, String emailId, int[] arr) {
		super();
		Name = name;
		EmailId = emailId;
		this.phno = phno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	

}
