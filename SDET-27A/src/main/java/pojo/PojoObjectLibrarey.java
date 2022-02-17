package pojo;

public class PojoObjectLibrarey {
	String empName;
	String empPnNo;
	Object spouse;
	public PojoObjectLibrarey(String empName, String empPnNo, Object spouse) {
		super();
		this.empName = empName;
		this.empPnNo = empPnNo;
		this.spouse = spouse;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPnNo() {
		return empPnNo;
	}
	public void setEmpPnNo(String empPnNo) {
		this.empPnNo = empPnNo;
	}
	public Object getSpouse() {
		return spouse;
	}
	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	

}
